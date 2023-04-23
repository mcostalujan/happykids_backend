package com.happykids.backend.presentacion.controladores;

import com.happykids.backend.aplicacion.iServicios.iServicioPeriodo;
import com.happykids.backend.aplicacion.implServicios.utilitarios.PeriodoUtilityService;
import com.happykids.backend.dominio.dto.PeriodoDTO;
import com.happykids.backend.dominio.entidades.utilitarios.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.OK;

@RequestMapping("/periodo")
@RestController

public class PeriodoControlador {

    public static final String PERIODO_ELIMINADO_CORRECTAMENTE = "Periodo eliminado.";

    @Autowired
    private iServicioPeriodo iServicioPeriodo;

    @Autowired
    private PeriodoUtilityService periodoUtilityService;

    @PostMapping("/register")
    public ResponseEntity<PeriodoDTO> agregarPeriodo(@RequestBody PeriodoDTO periodoDTO) {
        PeriodoDTO periodoDTOSaved = (PeriodoDTO) periodoUtilityService
                .convertEntityToDTO(iServicioPeriodo.agregarPeriodo(periodoDTO));
        return new ResponseEntity<>(periodoDTOSaved, OK);
    }

    @PutMapping("/update")
    public ResponseEntity<PeriodoDTO> editarPeriodo(@RequestBody PeriodoDTO periodoDTO) {
        PeriodoDTO periodoUpdated = (PeriodoDTO) periodoUtilityService.convertEntityToDTO(
            this.iServicioPeriodo.editarPeriodo(periodoDTO));
        return new ResponseEntity<>(periodoUpdated, OK);
    }

    @GetMapping("/find/{idPeriodo}")
    public ResponseEntity<PeriodoDTO> buscarPeriodoPorID(@PathVariable("idPeriodo") Long idPeriodo) {
        PeriodoDTO periodoDTO = (PeriodoDTO) periodoUtilityService.convertEntityToDTO(
            iServicioPeriodo.buscarPeriodoPorID(idPeriodo));
        return new ResponseEntity<>(periodoDTO, OK);
    }

    @DeleteMapping("/delete/{idPeriodo}")
    // //@PreAuthorize("hasAnyAuthority('user:delete')")
     public ResponseEntity<HttpResponse> eliminarPeriodoPorId(@PathVariable("idPeriodo") Long idPeriodo) {
         this.iServicioPeriodo.eliminarPeriodoPorId(idPeriodo);
         return response(OK, PERIODO_ELIMINADO_CORRECTAMENTE);
     }

    private ResponseEntity<HttpResponse> response(HttpStatus httpStatus, String message) {
        return new ResponseEntity<>(
                new HttpResponse(httpStatus.value(), httpStatus, httpStatus.getReasonPhrase().toUpperCase(), message),
                httpStatus);
    }
}
