package com.happykids.backend.presentacion.controladores;

import com.happykids.backend.aplicacion.iServicios.iServicioNota;
import com.happykids.backend.dominio.dto.NotaDTO;
import com.happykids.backend.dominio.entidades.utilitarios.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RequestMapping("/nota")
@RestController
public class NotaControlador {

    public static final String NOTA_ELIMINADA_CORRECTAMENTE = "Nota eliminada.";

    @Autowired
    private iServicioNota iServicioNota;

    @PostMapping("/register")
    public ResponseEntity<NotaDTO> agregarNota(@RequestBody NotaDTO notaDTO) {
        return new ResponseEntity<>(this.iServicioNota.agregarNota(notaDTO), OK);
    }

    @PutMapping("/update")
    public ResponseEntity<NotaDTO> editarNota(@RequestBody NotaDTO notaDTO) {
        NotaDTO notaUpdated = this.iServicioNota.editarNota(notaDTO);
        return new ResponseEntity<>(notaUpdated, OK);
    }

    @GetMapping("/list")
    public ResponseEntity<List<NotaDTO>> listarNiveles() {
        List<NotaDTO> notasDTO = iServicioNota.getNotas();
        return new ResponseEntity<>(notasDTO, OK);
    }

    @GetMapping("/find/{idNota}")
    public ResponseEntity<NotaDTO> buscarNotaPorID(@PathVariable("idNota") Long idNota) {
        NotaDTO notaDTO = iServicioNota.findNotaById(idNota);
        return new ResponseEntity<>(notaDTO, OK);
    }

    @DeleteMapping("/delete/{idNota}")
    //@PreAuthorize("hasAnyAuthority('user:delete')")
    public ResponseEntity<HttpResponse> eliminarNotaPorId(@PathVariable("idNota") Long idNota) {
        this.iServicioNota.eliminarNotaPorId(idNota);
        return response(OK, NOTA_ELIMINADA_CORRECTAMENTE);
    }

    private ResponseEntity<HttpResponse> response(HttpStatus httpStatus, String message) {
        return new ResponseEntity<>(
                new HttpResponse(httpStatus.value(), httpStatus, httpStatus.getReasonPhrase().toUpperCase(), message),
                httpStatus);
    }
}
