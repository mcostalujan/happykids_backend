package com.happykids.backend.presentacion.controladores;

import com.happykids.backend.aplicacion.iServicios.iServicioAlumnoProgreso;
import com.happykids.backend.aplicacion.iServicios.iServicioHistorialRuntimeInformeAnualAlumno;
import com.happykids.backend.aplicacion.implServicios.utilitarios.AlumnoProgresoUtilityService;
import com.happykids.backend.aplicacion.implServicios.utilitarios.UtilityService;
import com.happykids.backend.dominio.dto.AlumnoProgresoDTO;
import com.happykids.backend.dominio.dto.ConsultasSQL.DetalleAlumnoPorClase;
import lombok.extern.slf4j.Slf4j;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.export.ooxml.JRDocxExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.OK;

@RequestMapping("/alumno/progreso")
@RestController
@Slf4j
public class AlumnoProgresoControlador {

    @Autowired
    private iServicioAlumnoProgreso iServicioAlumnoProgreso;

    @Autowired
    private AlumnoProgresoUtilityService alumnoProgresoUtilityService;

    @Autowired
    private UtilityService utilityService;

    @Autowired
    private iServicioHistorialRuntimeInformeAnualAlumno iServicioHistorialRuntimeInformeAnualAlumno;

    @PostMapping("/register")
    public ResponseEntity<AlumnoProgresoDTO> agregarAProgreso(@RequestBody AlumnoProgresoDTO alumnoProgresoDTO) {
        AlumnoProgresoDTO alumnoProgresoDTOSaved = (AlumnoProgresoDTO) alumnoProgresoUtilityService
                .convertEntityToDTO(iServicioAlumnoProgreso.addNewAlumnoProgreso(alumnoProgresoDTO));
        return new ResponseEntity<>(alumnoProgresoDTOSaved, OK);
    }


    @GetMapping("/find/id/{idAProgreso}")
    public ResponseEntity<Object> buscarAProgresoPorId(@PathVariable("idAProgreso") Long idAProgreso) {
        log.info("Entrando a {} - buscarAProgresoPorId", this.getClass().getName());
        AlumnoProgresoDTO alumnoProgresoDTO = (AlumnoProgresoDTO) alumnoProgresoUtilityService
                .convertEntityToDTO(iServicioAlumnoProgreso.findAlumnoProgresoById(idAProgreso));
        return new ResponseEntity<>(alumnoProgresoDTO, OK);
    }

    @GetMapping("/list/idAlumno/{idAlumno}")
    public ResponseEntity<List<Object>> buscarAProgresosPorIdAlumno(@PathVariable("idAlumno") Long idAlumno) {
        List<Object> notasDTO = iServicioAlumnoProgreso.getAlumnoProgresosByIdAlumno(idAlumno)
                .stream()
                .map(alumnoProgresoUtilityService::convertEntityToDTO)
                .collect(Collectors.toList());
        return new ResponseEntity<>(notasDTO, OK);
    }

    @GetMapping("/get/getAlumnosPorClase")
    public ResponseEntity<List<DetalleAlumnoPorClase>> getAlumnosPorClase(@ModelAttribute(value = "idClase") String idClase) {
        log.info("Entrando a {} - getAlumnosPorClase", this.getClass().getName());
        List<DetalleAlumnoPorClase> clasesDTO = iServicioAlumnoProgreso.getAlumnosPorClase(idClase);
        return new ResponseEntity<>(clasesDTO, OK);
    }

    @GetMapping("/get/getDetalleAlumnoByIdClaseAndIdAlumno")
    public ResponseEntity<DetalleAlumnoPorClase> getDetalleAlumnoByIdClaseAndIdAlumno(@ModelAttribute(value = "idClase") String idClase,
                                                                                      @ModelAttribute(value = "idAlumno") String idAlumno) {
        log.info("Entrando a {} - getDetalleAlumnoByIdClaseAndIdAlumno", this.getClass().getName());
        DetalleAlumnoPorClase detalleAlumnoClaseDTO = iServicioAlumnoProgreso.getDetalleAlumnoByIdClaseAndIdAlumno(idClase, idAlumno);
        return new ResponseEntity<>(detalleAlumnoClaseDTO, OK);
    }

    @GetMapping("/export/InformeAcademicoAlumno/{idAlum}/{year}")
    public ResponseEntity<byte[]> getReport(@PathVariable("idAlum") Long idAlum,
                                            @PathVariable("year") String year) {

        Date tiempoInicial = new Date();

        try {

            String filePath = ResourceUtils.getFile("classpath:reports/jrxml/InformeAcademicoAlumno.jrxml").getAbsolutePath();

            Map<String, Object> parameters = new HashMap<>();
            parameters.put("ID_ALUM", idAlum);
            parameters.put("YEAR", year);
            parameters.put("subReport_Areas", getSubReporteAreas());
            parameters.put("subReport_Areas_Compe", getSubReporteAreasCompe());

            JasperReport report = JasperCompileManager.compileReport(filePath);

            Connection conn;
            try {
                //LOCAL
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                conn = DriverManager
                        .getConnection("jdbc:sqlserver://DESKTOP-R88JMRB\\\\SQLEXPRESS;" +
                                        "databaseName=test;portNumber=1433;" +
                                        "trustServerCertificate=true;",
                                "testuser", "admin");

                //PUBLICADO
//                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//                conn = DriverManager
//                        .getConnection("jdbc:sqlserver://tesisdb2023.mssql.somee.com;" +
//                                        "databaseName=tesisdb2023;" +
//                                        "trustServerCertificate=true;",
//                                "tesisuser2023", "tesis2023");

            } catch (Exception ex) {
                ex.printStackTrace();
                conn = null;
            }

            JasperPrint print = JasperFillManager.fillReport(report, parameters, conn);


            ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
            SimpleOutputStreamExporterOutput output = new SimpleOutputStreamExporterOutput(byteArray);
            JRDocxExporter exporterWord = new JRDocxExporter();
            exporterWord.setExporterInput(new SimpleExporterInput(print));
            exporterWord.setExporterOutput(output);
            exporterWord.exportReport();
            output.close();
            byte[] byteArrayResponse = byteArray.toByteArray();


            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            headers.setContentDispositionFormData("filename", "InformeAcademicoAlumno.docx");


            Date tiempoFinal = new Date();

            long elapsedms = tiempoFinal.getTime() - tiempoInicial.getTime();
//            long diff = TimeUnit.SECONDS.convert(elapsedms, TimeUnit.MILLISECONDS);
            double diff = this.utilityService.roundDoubleXDecimals(
                    ((tiempoFinal.getTime() - tiempoInicial.getTime()) / 1000.00 / 60.00)
                    , 2);
            System.out.println("Tiempo Generación Reporte: " + diff + " minutos");

            this.iServicioHistorialRuntimeInformeAnualAlumno.registrarRuntime(idAlum, year, diff);

            return new ResponseEntity<>(byteArrayResponse, headers, HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception while creating report");
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


    public static JasperReport getSubReporteAreas() {
        String filePath = null;
        try {
            filePath = ResourceUtils.getFile("classpath:reports/jrxml/InformeAcademicoAlumno_Areas.jrxml").getAbsolutePath();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        JasperReport report = null;
        try {
            report = JasperCompileManager.compileReport(filePath);
            return report;
        } catch (JRException e) {
            e.printStackTrace();
            return null;
        }

    }

    public static JasperReport getSubReporteAreasCompe() {
        String filePath = null;
        try {
            filePath = ResourceUtils.getFile("classpath:reports/jrxml/InformeAcademicoAlumno_AreasCompe.jrxml").getAbsolutePath();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        JasperReport report = null;
        try {
            report = JasperCompileManager.compileReport(filePath);
            return report;
        } catch (JRException e) {
            e.printStackTrace();
            return null;
        }

    }


}
