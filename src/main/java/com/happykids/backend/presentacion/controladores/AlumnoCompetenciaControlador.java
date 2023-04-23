package com.happykids.backend.presentacion.controladores;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
@RequestMapping("/alumnocompetencia")
@RestController
@Slf4j
public class AlumnoCompetenciaControlador{
    
    // public static final String ALUMNOCOMPETENCIA_ELIMINADA_CORRECTAMENTE = "AlumnoCompetencia eliminado.";

    // @Autowired
    // private iServicioAlumnoCompetencia iServicioAlumnoCompetencia;

    // @Autowired
    // private AlumnoCompetenciaUtilityService alumnoUtilityService;

    // @GetMapping("/find/id/{idAlumno}")
    // public ResponseEntity<Object> buscarAlumnoPorID(@PathVariable("idAlumno") Long idAlumno) {
    //     log.info("Entrando a {} - buscarAlumnoPorID", this.getClass().getName());
    //     AlumnoCompetenciaDTO alumnocompetenciaDTO = (AlumnoDTO) alumnocompetenciaUtilityService.convertEntityToDTO(iServicioAlumno.findAlumnoById(idAlumno));
    //     return new ResponseEntity<>(alumnoDTO, OK);
    // }

    // @GetMapping("/list")
    // public ResponseEntity<List<Object>> listarAlumnos() {
    //     log.info("Entrando a {} - listarAlumnos", this.getClass().getName());
    //     List<Object> alumnos = iServicioAlumno.getAlumnos()
    //             .stream()
    //             .map(alumnoUtilityService::convertEntityToDTO)
    //             .collect(Collectors.toList());
    //     return new ResponseEntity<>(alumnos, OK);
    // }

    // @PostMapping("/register")
    // public ResponseEntity<AlumnoDTO> agregarAlumno(@RequestBody AlumnoDTO alumnoDTO) {
    //     AlumnoDTO alumnoDTOSaved = (AlumnoDTO) alumnoUtilityService
    //             .convertEntityToDTO(iServicioAlumno.agregarAlumno(alumnoDTO));
    //     return new ResponseEntity<>(alumnoDTOSaved, OK);
    // }

}
