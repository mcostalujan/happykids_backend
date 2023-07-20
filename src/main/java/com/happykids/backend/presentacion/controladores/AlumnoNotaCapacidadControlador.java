package com.happykids.backend.presentacion.controladores;

import com.happykids.backend.aplicacion.iServicios.iServicioAlumnoNotaCapacidad;
import com.happykids.backend.aplicacion.implServicios.utilitarios.AlumnoNotaCapacidadUtilityService;
import com.happykids.backend.dominio.dto.AlumnoNotaCapacidadDTO;
import com.happykids.backend.dominio.dto.ClaseDocenteDTO;
import com.happykids.backend.dominio.dto.ClaseDocenteIdDTO;
import com.happykids.backend.dominio.dto.ConsultasSQL.DetalleAlumnoCapacidad;
import com.happykids.backend.dominio.dto.ConsultasSQL.DetalleAlumnoCompetencia;
import com.happykids.backend.dominio.dto.ConsultasSQL.DetalleClasesDocente;
import com.happykids.backend.dominio.entidades.AlumnoNotaCapacidad;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.OK;

@RequestMapping("/alumno-capacidad")
@RestController
@Slf4j
public class AlumnoNotaCapacidadControlador {
    @Autowired
    private iServicioAlumnoNotaCapacidad iServicioAlumnoNotaCapacidad;

    @Autowired
    private AlumnoNotaCapacidadUtilityService alumnoNotaCapacidadUtilityService;

    @PostMapping("/register")
    public ResponseEntity<AlumnoNotaCapacidadDTO> agregarAlumnoNotaCapacidad(@RequestBody AlumnoNotaCapacidadDTO alumnoNotaCapacidadDTO) {
        AlumnoNotaCapacidadDTO alumnoNotaCapacidadDTOSaved = (AlumnoNotaCapacidadDTO) alumnoNotaCapacidadUtilityService
                .convertEntityToDTO(iServicioAlumnoNotaCapacidad.createAlumnoNotaCapacidad(alumnoNotaCapacidadDTO));
        return new ResponseEntity<>(alumnoNotaCapacidadDTOSaved, OK);
    }

    @PutMapping("/update")
    public ResponseEntity<AlumnoNotaCapacidadDTO> editarAlumnoNotaCapacidad(@RequestBody AlumnoNotaCapacidadDTO alumnoNotaCapacidadDTO) {
        AlumnoNotaCapacidadDTO alumnoNotaCapacidadDTOUpdated = (AlumnoNotaCapacidadDTO) alumnoNotaCapacidadUtilityService
                .convertEntityToDTO(iServicioAlumnoNotaCapacidad.updateAlumnoNotaCapacidad(alumnoNotaCapacidadDTO));
        return new ResponseEntity<>(alumnoNotaCapacidadDTOUpdated, OK);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Object>> listarAlumnosNotaCapacidad() {
        List<Object> alumnosNotaCapacidadDTO = iServicioAlumnoNotaCapacidad.getAlumnosNotaCapacidad()
                .stream()
                .map(alumnoNotaCapacidadUtilityService::convertEntityToDTO)
                .collect(Collectors.toList());
        return new ResponseEntity<>(alumnosNotaCapacidadDTO, OK);
    }

    @GetMapping("/find")
    public ResponseEntity<AlumnoNotaCapacidadDTO> buscarAlumnoNotaCapacidadById(@RequestBody AlumnoNotaCapacidadDTO alumnoNotaCapacidadDTO) {
        AlumnoNotaCapacidadDTO alumnoNotaCapaDTO = (AlumnoNotaCapacidadDTO) alumnoNotaCapacidadUtilityService
                .convertEntityToDTO(iServicioAlumnoNotaCapacidad
                        .findAlumnoNotaCapacidadById(
                                NumberUtils.toLong(alumnoNotaCapacidadDTO.getIdAcompe()),
                                NumberUtils.toLong(alumnoNotaCapacidadDTO.getIdCapacidad())));
        return new ResponseEntity<>(alumnoNotaCapaDTO, OK);
    }

    @GetMapping("/get/getDetalleCapacidadPorAcompe")
    public ResponseEntity<List<DetalleAlumnoCapacidad>> getDetalleCapacidadPorAcompe(
            @ModelAttribute(value = "idAcompe") String idAcompe) {
        log.info("Entrando a {} - getAlumnosPorClase", this.getClass().getName());
        List<DetalleAlumnoCapacidad> detallesAlumnoCapacidadDTO = iServicioAlumnoNotaCapacidad
                .getDetalleCapacidadPorAcompe(idAcompe);
        return new ResponseEntity<>(detallesAlumnoCapacidadDTO, OK);
    }

    @PostMapping("/post/updateNotaCapa")
    public ResponseEntity<AlumnoNotaCapacidadDTO> updateNotaCapa(
            @ModelAttribute(value = "idAcompe") String idAcompe,
            @ModelAttribute(value = "idCapacidad") String idCapacidad,
            @ModelAttribute(value = "notaCapacidad") String notaCapacidad) {
        log.info("Entrando a {} - updateNotaCapa", this.getClass().getName());
        AlumnoNotaCapacidadDTO alnocUpdated = (AlumnoNotaCapacidadDTO) alumnoNotaCapacidadUtilityService
                .convertEntityToDTO(iServicioAlumnoNotaCapacidad
                        .updateNotaCapa(idAcompe, idCapacidad, notaCapacidad));
        return new ResponseEntity<>(alnocUpdated, OK);
    }

        @PostMapping("/post/calculoPromedioCapacidadadesPorIdClaseIdAprog/{idClase}/{idAprog}/{usuarioModi}")
        public void calculoPromedioCapacidadadesPorIdClaseIdAprog(
            @PathVariable(value = "idAprog") String idAprog,
            @PathVariable(value = "idClase") String idClase,
            @PathVariable(value = "usuarioModi") String usuarioModi) {
        log.info("Entrando a {} - calculoPromedioCapacidadadesPorIdClaseIdAprog", this.getClass().getName());
            log.info("idAprog: {}, idClase: {}, usuarioModi: {}", idAprog, idClase, usuarioModi);
         iServicioAlumnoNotaCapacidad.calculoPromedioCapacidadadesPorIdClaseIdAprog(idClase, idAprog, usuarioModi);

    }

//    @GetMapping("/get/clasesDocentePeriodo")
//    public ResponseEntity<List<DetalleClasesDocente>> getClasesByDocenteAndPeriodo(@ModelAttribute(value = "idDocente") String idDocente,
//                                                                                   @ModelAttribute(value = "idPeriodo") String idPeriodo) {
//        log.info("Entrando a {} - getDetalleClases", this.getClass().getName());
//        List<DetalleClasesDocente> clasesDTO = iServicioClaseDocente.getClasesByDocenteAndPeriodo(idDocente, idPeriodo);
//        return new ResponseEntity<>(clasesDTO, OK);
//    }
}
