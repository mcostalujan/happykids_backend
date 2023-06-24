package com.happykids.backend.presentacion.controladores;

import com.happykids.backend.aplicacion.iServicios.iServicioAlumno;
import com.happykids.backend.aplicacion.iServicios.iServicioAlumnoProgreso;
import com.happykids.backend.aplicacion.implServicios.utilitarios.AlumnoProgresoUtilityService;
import com.happykids.backend.dominio.dto.AlumnoDTO;
import com.happykids.backend.dominio.dto.AlumnoProgresoDTO;
import com.happykids.backend.dominio.dto.ConsultasSQL.DetalleAlumnosPorClase;
import com.happykids.backend.dominio.dto.ConsultasSQL.DetalleClasesDocente;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
    public ResponseEntity<List<DetalleAlumnosPorClase>> getAlumnosPorClase(@ModelAttribute(value = "idClase") String idClase) {
        log.info("Entrando a {} - getAlumnosPorClase", this.getClass().getName());
        List<DetalleAlumnosPorClase> clasesDTO = iServicioAlumnoProgreso.getAlumnosPorClase(idClase);
        return new ResponseEntity<>(clasesDTO, OK);
    }

}
