package com.happykids.backend.presentacion.controladores;

import com.happykids.backend.aplicacion.iServicios.iServicioCompetencia;
import com.happykids.backend.aplicacion.implServicios.utilitarios.CompetenciaUtilityService;
import com.happykids.backend.dominio.dto.CompetenciaDTO;
import com.happykids.backend.dominio.entidades.utilitarios.HttpResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.OK;

@RequestMapping("/competencia")
@RestController
@Slf4j
public class CompetenciaControlador {
    public static final String COMPETENCIA_ELIMINADA_CORRECTAMENTE = "Competencia eliminada.";

    @Autowired
    private iServicioCompetencia iServicioCompetencia;


    @Autowired
    private CompetenciaUtilityService competenciaUtilityService;

    @PostMapping("/register")
    public ResponseEntity<CompetenciaDTO> agregarCompetencia(@RequestBody CompetenciaDTO competenciaDTO) {
        CompetenciaDTO competenciaDTOSaved = (CompetenciaDTO) competenciaUtilityService
                .convertEntityToDTO(iServicioCompetencia
                        .agregarCompetencia(competenciaDTO));
        return new ResponseEntity<>(competenciaDTOSaved, OK);
    }

    @PutMapping("/update")
    public ResponseEntity<CompetenciaDTO> editarCompetencia(@RequestBody CompetenciaDTO competenciaDTO) {
        CompetenciaDTO logroUpdated = (CompetenciaDTO) competenciaUtilityService.convertEntityToDTO(
                this.iServicioCompetencia.editarCompetencia(competenciaDTO));
        return new ResponseEntity<>(logroUpdated, OK);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Object>> listarCompetencias() {
        List<Object> competenciasDTO = iServicioCompetencia.getCompetencias()
                .stream()
                .map(competenciaUtilityService::convertEntityToDTO)
                .collect(Collectors.toList());
        return new ResponseEntity<>(competenciasDTO, OK);
    }

    @GetMapping("/find/{idCompetencia}")
    public ResponseEntity<CompetenciaDTO> buscarCompetenciaPorID(@PathVariable("idCompetencia") Long idCompetencia) {
        CompetenciaDTO competenciaDTO = (CompetenciaDTO) competenciaUtilityService.convertEntityToDTO(
                iServicioCompetencia.findCompetenciaById(idCompetencia));
        return new ResponseEntity<>(competenciaDTO, OK);
    }

    @DeleteMapping("/delete/{idCompetencia}")
    //@PreAuthorize("hasAnyAuthority('user:delete')")
    public ResponseEntity<HttpResponse> eliminarCompetenciaPorId(@PathVariable("idCompetencia") Long idCompetencia) {
        if (this.iServicioCompetencia.deleteCompetencia(idCompetencia))
            return response(OK, COMPETENCIA_ELIMINADA_CORRECTAMENTE);
        return response(HttpStatus.OK, "ERROR AL ELMINAR COMPETENCIA.");
    }

    private ResponseEntity<HttpResponse> response(HttpStatus httpStatus, String message) {
        return new ResponseEntity<>(
                new HttpResponse(httpStatus.value(), httpStatus, httpStatus.getReasonPhrase().toUpperCase(), message),
                httpStatus);
    }
}
