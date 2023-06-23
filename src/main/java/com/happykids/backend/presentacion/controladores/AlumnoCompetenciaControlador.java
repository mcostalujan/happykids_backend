package com.happykids.backend.presentacion.controladores;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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

    @GetMapping("/find")
    public ResponseEntity<AlumnoCompetenciaDTO> buscarAlumnoCompetenciaPorID(@RequestBody AlumnoCompetenciaIdDTO alumnoCompetenciaIdDTO) {
        AlumnoCompetenciaDTO alumnoCompetenciaDTO = (AlumnoCompetenciaDTO) alumnoCompetenciaUtilityService
                .convertEntityToDTO(iServicioAlumnoCompetencia
                        .findAlumnoCompetenciaById(
                                NumberUtils.toLong(alumnoCompetenciaIdDTO.getIdAprog()),
                                NumberUtils.toLong(alumnoCompetenciaIdDTO.getIdCompe())));
        return new ResponseEntity<>(alumnoCompetenciaDTO, OK);
    }

}

