package com.happykids.backend.presentacion.controladores;

import java.net.http.HttpResponse;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.happykids.backend.aplicacion.iServicios.iServicioAlumno;
import com.happykids.backend.aplicacion.implServicios.utilitarios.AlumnoUtilityService;
import com.happykids.backend.dominio.dto.AlumnoDTO;
import com.happykids.backend.dominio.entidades.Alumno;

import lombok.extern.slf4j.Slf4j;

import static org.springframework.http.HttpStatus.OK;
@RequestMapping("/alumno")
@RestController
@Slf4j
public class AlumnoControlador {
    public static final String NOTA_ELIMINADA_CORRECTAMENTE = "Alumno eliminado.";

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

    //@DeleteMapping("/delete/{idAlumno}")
    //@PreAuthorize("hasAnyAuthority('user:delete')")
    //public ResponseEntity<HttpResponse> eliminarAlumnoPorId(@PathVariable("idAlumno") Long idAlumno) {
       // this.iServicioAlumno.eliminarAlumnoPorId(idAlumno);
        //return response(OK, ALUMNO_ELIMINADA_CORRECTAMENTE);
    //}

    // private ResponseEntity<HttpResponse> response(HttpStatus httpStatus, String message) {
    //    return new ResponseEntity<>(
    //            new HttpResponse(httpStatus.value(), httpStatus, httpStatus.getReasonPhrase().toUpperCase(), message),
    //            httpStatus);
    //}
   
}
