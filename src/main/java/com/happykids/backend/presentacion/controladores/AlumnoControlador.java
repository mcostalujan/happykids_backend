package com.happykids.backend.presentacion.controladores;

import com.happykids.backend.aplicacion.iServicios.iServicioAlumno;
import com.happykids.backend.aplicacion.implServicios.utilitarios.AlumnoUtilityService;
import com.happykids.backend.dominio.dto.AlumnoDTO;
import com.happykids.backend.dominio.dto.ConsultasSQL.DetalleAlumnoReporteAnual;
import com.happykids.backend.dominio.dto.ConsultasSQL.GradoDisponible;
import com.happykids.backend.dominio.entidades.utilitarios.HttpResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.OK;

@RequestMapping("/alumno")
@RestController
@Slf4j
public class AlumnoControlador {
    public static final String ALUMNO_ELIMINADO_CORRECTAMENTE = "Alumno eliminado.";

    @Autowired
    private iServicioAlumno iServicioAlumno;

    @Autowired
    private AlumnoUtilityService alumnoUtilityService;

    @PostMapping("/register")
    public ResponseEntity<AlumnoDTO> agregarAlumno(@RequestBody AlumnoDTO alumnoDTO) {
        AlumnoDTO alumnoDTOSaved = (AlumnoDTO) alumnoUtilityService
                .convertEntityToDTO(iServicioAlumno.agregarAlumno(alumnoDTO));
        return new ResponseEntity<>(alumnoDTOSaved, OK);
    }

    @PutMapping("/update")
    public ResponseEntity<AlumnoDTO> editarAlumno(@RequestBody AlumnoDTO alumnoDTO) {
        AlumnoDTO alumnoUpdated = (AlumnoDTO) alumnoUtilityService.convertEntityToDTO(
                this.iServicioAlumno.editarAlumno(alumnoDTO));
        return new ResponseEntity<>(alumnoUpdated, OK);
    }


    @GetMapping("/list")
    public ResponseEntity<List<Object>> listarAlumnos() {
        log.info("Entrando a {} - listarAlumnos", this.getClass().getName());
        List<Object> alumnos = iServicioAlumno.getAlumnos()
                .stream()
                .map(alumnoUtilityService::convertEntityToDTO)
                .collect(Collectors.toList());
        return new ResponseEntity<>(alumnos, OK);
    }


    @GetMapping("/find/id/{idAlumno}")
    public ResponseEntity<Object> buscarAlumnoPorID(@PathVariable("idAlumno") Long idAlumno) {
        log.info("Entrando a {} - buscarAlumnoPorID", this.getClass().getName());
        AlumnoDTO alumnoDTO = (AlumnoDTO) alumnoUtilityService.convertEntityToDTO(iServicioAlumno.findAlumnoById(idAlumno));
        return new ResponseEntity<>(alumnoDTO, OK);
    }

    @DeleteMapping("/delete/{idAlumno}")
//    @PreAuthorize("hasAnyAuthority('user:delete')")
    public ResponseEntity<HttpResponse> eliminarAlumnoPorId(@PathVariable("idAlumno") Long idAlumno) {
        if (this.iServicioAlumno.eliminarAlumnoPorId(idAlumno))
            return response(OK, ALUMNO_ELIMINADO_CORRECTAMENTE);
        return response(HttpStatus.OK, "ERROR AL ELMINAR ALUMNO.");
    }

    private ResponseEntity<HttpResponse> response(HttpStatus httpStatus, String message) {
        return new ResponseEntity<>(
                new HttpResponse(httpStatus.value(), httpStatus, httpStatus.getReasonPhrase().toUpperCase(), message),
                httpStatus);
    }

    @GetMapping("/get/getAlumnosByParamsReporteAnual")
    public ResponseEntity<List<DetalleAlumnoReporteAnual>> getAlumnosByParamsReporteAnual(
            @ModelAttribute(value = "idNivel") String idNivel,
            @ModelAttribute(value = "idGrado") String idGrado,
            @ModelAttribute(value = "idSeccion") String idSeccion,
            @ModelAttribute(value = "year") String year
    ) {
        log.info("Entrando a {} - getnivelesDisponibles", this.getClass().getName());
        List<DetalleAlumnoReporteAnual> alumnos = iServicioAlumno
                .getAlumnosByParamsReporteAnual(idNivel, idGrado, idSeccion, year);
        return new ResponseEntity<>(alumnos, OK);
    }

}
