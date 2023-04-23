package com.happykids.backend.presentacion.controladores;
import java.util.List;

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

import com.happykids.backend.aplicacion.implServicios.utilitarios.LogroUtilityService;
import com.happykids.backend.aplicacion.implServicios.utilitarios.UtilityService;
import com.happykids.backend.dominio.dto.LogroDTO;

import lombok.extern.slf4j.Slf4j;
import com.happykids.backend.aplicacion.iServicios.iServicioLogro;
import static org.springframework.http.HttpStatus.OK;

@RequestMapping("/logro")
@Slf4j
@RestController
public class LogroControlador {
    public static final String LOGRO_ELIMINADO_CORRECTAMENTE = "Logro eliminado.";

    @Autowired
    private iServicioLogro iServicioLogro;

    @Autowired
    private LogroUtilityService logroUtilityService;

    @PostMapping("/register")
    public ResponseEntity<LogroDTO> agregarLogro(@RequestBody LogroDTO logroDTO) {
        LogroDTO logroDTOSaved = (LogroDTO) logroUtilityService
                .convertEntityToDTO(iServicioLogro.agregarLogro(logroDTO));
        return new ResponseEntity<>(logroDTOSaved, OK);
    }

    @PutMapping("/update")
    public ResponseEntity<LogroDTO> editarLogro(@RequestBody LogroDTO logroDTO) {
        LogroDTO logroUpdated =(LogroDTO) logroUtilityService.convertEntityToDTO( 
            this.iServicioLogro.editarLogro(logroDTO)); 
        return new ResponseEntity<>(logroUpdated, OK);
    }

    // @GetMapping("/list")
    // public ResponseEntity<List<LogroDTO>> listarLogros() {
    //     List<LogroDTO> logrosDTO = iServicioLogro.getLogros();
    //     return new ResponseEntity<>(logrosDTO, OK);
    // }

    @GetMapping("/find/{idLogro}")
    public ResponseEntity<LogroDTO> buscarLogroPorID(@PathVariable("idLogro") Long idLogro) {
        LogroDTO logroDTO = (LogroDTO) logroUtilityService.convertEntityToDTO(
             iServicioLogro.findLogroById(idLogro));
        return new ResponseEntity<>(logroDTO, OK);
    }

    // @DeleteMapping("/delete/{idLogro}")
    // //@PreAuthorize("hasAnyAuthority('user:delete')")
    // public ResponseEntity<HttpResponse> eliminarLogroPorId(@PathVariable("idLogro") Long idLogro) {
    //     this.iServicioLogro.eliminarLogroPorId(idLogro);
    //     return response(OK, LOGRO_ELIMINADO_CORRECTAMENTE);
    // }

    // private ResponseEntity<HttpResponse> response(HttpStatus httpStatus, String message) {
    //     return new ResponseEntity<>(
    //             new HttpResponse(httpStatus.value(), httpStatus, httpStatus.getReasonPhrase().toUpperCase(), message),
    //             httpStatus);
    // }
}
