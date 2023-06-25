package com.happykids.backend.presentacion.controladores;
import java.util.List;
import java.util.stream.Collectors;

import com.happykids.backend.dominio.dto.AlumnoDTO;
import com.happykids.backend.dominio.dto.ConsultasSQL.DetalleAlumnoCompetencia;
import com.happykids.backend.dominio.dto.ConsultasSQL.DetalleAlumnoPorClase;
import com.happykids.backend.dominio.entidades.AlumnoCompetencia;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.happykids.backend.aplicacion.implServicios.utilitarios.AlumnoCompetenciaUtilityService;
import com.happykids.backend.dominio.dto.AlumnoCompetenciaDTO;
import com.happykids.backend.dominio.dto.AlumnoCompetenciaIdDTO;
import com.happykids.backend.aplicacion.iServicios.iServicioAlumnoCompetencia;
import static org.springframework.http.HttpStatus.OK;

import lombok.extern.slf4j.Slf4j;
@RequestMapping("/alumnoCompetencia")
@RestController
@Slf4j

public class AlumnoCompetenciaControlador{
    
    @Autowired
    private iServicioAlumnoCompetencia iServicioAlumnoCompetencia;

    @Autowired
    private AlumnoCompetenciaUtilityService alumnoCompetenciaUtilityService;

    @PostMapping("/register")
    public ResponseEntity<AlumnoCompetenciaDTO> agregarAlumnoCompetencia(@RequestBody AlumnoCompetenciaDTO alumnoCompetenciaDTO) {
        AlumnoCompetenciaDTO alumnoCompetenciaDTOSaved = (AlumnoCompetenciaDTO) alumnoCompetenciaUtilityService
                .convertEntityToDTO(iServicioAlumnoCompetencia.createAlumnoCompetencia(alumnoCompetenciaDTO));
        return new ResponseEntity<>(alumnoCompetenciaDTOSaved, OK);
    }

    @PutMapping("/update")
    public ResponseEntity<AlumnoCompetenciaDTO> editarAlumnoCompetencia(@RequestBody AlumnoCompetenciaDTO AlumnoCompetenciaDTO) {
        AlumnoCompetenciaDTO alumnoCompetenciaUpdated = (AlumnoCompetenciaDTO) alumnoCompetenciaUtilityService
                .convertEntityToDTO(iServicioAlumnoCompetencia.updateAlumnoCompetencia(AlumnoCompetenciaDTO));
        return new ResponseEntity<>(alumnoCompetenciaUpdated, OK);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Object>> listarAlumnoCompetencia() {
        List<Object> clasesDocenteDTO = iServicioAlumnoCompetencia.getAlumnoCompetencias()
                .stream()
                .map(alumnoCompetenciaUtilityService::convertEntityToDTO)
                .collect(Collectors.toList());
        return new ResponseEntity<>(clasesDocenteDTO, OK);
    }

    @GetMapping("/find/id/{idAcompe}")
    public ResponseEntity<Object> buscarACompePorID(@PathVariable("idAcompe") Long idAcompe) {
        log.info("Entrando a {} - buscarACompePorID", this.getClass().getName());
        AlumnoCompetenciaDTO aCompeDTO = (AlumnoCompetenciaDTO) alumnoCompetenciaUtilityService
                .convertEntityToDTO(iServicioAlumnoCompetencia.findAlumnoCompetenciaByIdAcompe(idAcompe));
        return new ResponseEntity<>(aCompeDTO, OK);
    }

    @GetMapping("/get/getDetalleACompeByIdClaseAndIdAlumno")
    public ResponseEntity<List<DetalleAlumnoCompetencia>> getAlumnosPorClase(@ModelAttribute(value = "idClase") String idClase,
                                                                             @ModelAttribute(value = "idAlumno") String idAlumno) {
        log.info("Entrando a {} - getAlumnosPorClase", this.getClass().getName());
        List<DetalleAlumnoCompetencia> detallesAlumnoCompetenciaDTO = iServicioAlumnoCompetencia.getDetalleACompeByIdClaseAndIdAlumno(idClase, idAlumno);
        return new ResponseEntity<>(detallesAlumnoCompetenciaDTO, OK);
    }


}

