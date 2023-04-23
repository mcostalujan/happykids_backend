package com.happykids.backend.presentacion.controladores;
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
import org.springframework.web.bind.annotation.RestController;

import com.happykids.backend.aplicacion.iServicios.iServicioPeriodo;
import com.happykids.backend.aplicacion.implServicios.utilitarios.PeriodoUtilityService;
import com.happykids.backend.dominio.dto.PeriodoDTO;

import static org.springframework.http.HttpStatus.OK;

@RequestMapping("/periodo")
@RestController

public class PeriodoControlador {
    public static final String PERIODO_ELIMINADA_CORRECTAMENTE = "Periodo eliminado.";

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

    // @GetMapping("/list")
    // public ResponseEntity<List<PeriodoDTO>> listarPeriodos() {
    //     List<PeriodoDTO> periodosDTO = iServicioPeriodo.getPeriodos();
    //     return new ResponseEntity<>(periodosDTO, OK);
    // }

    @GetMapping("/find/{idPeriodo}")
    public ResponseEntity<PeriodoDTO> buscarPeriodoPorID(@PathVariable("idPeriodo") Long idPeriodo) {
        PeriodoDTO periodoDTO = (PeriodoDTO) periodoUtilityService.convertEntityToDTO(
            iServicioPeriodo.buscarPeriodoPorID(idPeriodo));
        return new ResponseEntity<>(periodoDTO, OK);
    }

    //@DeleteMapping("/delete/{idPeriodo}")
    // //@PreAuthorize("hasAnyAuthority('user:delete')")
    // public ResponseEntity<HttpResponse> eliminarPeriodoPorId(@PathVariable("idPeriodo") Long idPeriodo) {
    //     this.iServicioPeriodo.eliminarPeriodoPorId(idPeriodo);
    //     return response(OK, PERIODO_ELIMINADA_CORRECTAMENTE);
    // }

    // private ResponseEntity<HttpResponse> response(HttpStatus httpStatus, String message) {
    //     return new ResponseEntity<>(
    //             new HttpResponse(httpStatus.value(), httpStatus, httpStatus.getReasonPhrase().toUpperCase(), message),
    //             httpStatus);
    // } 
}
