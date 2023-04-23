package com.happykids.backend.presentacion.controladores;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.happykids.backend.aplicacion.iServicios.iServicioCompetencia;
import com.happykids.backend.aplicacion.implServicios.utilitarios.CompetenciaUtilityService;
import com.happykids.backend.dominio.dto.CompetenciaDTO;

import static org.springframework.http.HttpStatus.OK;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RequestMapping("/competencia")
@RestController
public class CompetenciaControlador {
    public static final String COMPETENCIA_ELIMINADA_CORRECTAMENTE = "Competencia eliminada.";

    @Autowired
    private iServicioCompetencia iServicioCompetencia;
    

    @Autowired
    private CompetenciaUtilityService competenciaUtilityService;

    @PostMapping("/register")
    public ResponseEntity<CompetenciaDTO> agregarCompetencia(@RequestBody CompetenciaDTO competenciaDTO) {
        CompetenciaDTO competenciaDTOSaved = (CompetenciaDTO) competenciaUtilityService.convertEntityToDTO(iServicioCompetencia.agregarCompetencia(competenciaDTO));
        return new ResponseEntity<>(competenciaDTOSaved, OK);
    }

    // @PutMapping("/update")
    // public ResponseEntity<CompetenciaDTO> editarCompetencia(@RequestBody CompetenciaDTO competenciaDTO) {
    //     CompetenciaDTO notaUpdated = this.iServicioCompetencia.editarCompetencia(competenciaDTO);
    //     return new ResponseEntity<>(competenciaUpdated, OK);
    // }

   
    // @GetMapping("/find/{idCompetencia}")
    // public ResponseEntity<CompetenciaDTO> buscarCompetenciaPorID(@PathVariable("idCompetencia") Long idCompetencia) {
    //     CompetenciaDTO competenciaDTO = iServicioCompetencia.findCompetenciaById(idCompetencia);
    //     return new ResponseEntity<>(competenciaDTO, OK);
    // }

    // @DeleteMapping("/delete/{idCompetencia}")
    // //@PreAuthorize("hasAnyAuthority('user:delete')")
    // public ResponseEntity<HttpResponse> eliminarCompetenciaPorId(@PathVariable("idCompetencia") Long idCompetencia) {
    //     this.iServicioCompetencia.eliminarCompetenciaPorId(idCompetencia);
    //     return response(OK, COMPETENCIA_ELIMINADA_CORRECTAMENTE);
    // }

    // private ResponseEntity<HttpResponse> response(HttpStatus httpStatus, String message) {
    //     return new ResponseEntity<>(
    //             new HttpResponse(httpStatus.value(), httpStatus, httpStatus.getReasonPhrase().toUpperCase(), message),
    //             httpStatus);
    // }
}
