package com.happykids.backend.presentacion.controladores;

import com.happykids.backend.aplicacion.iServicios.iServicioNota;
import com.happykids.backend.aplicacion.implServicios.utilitarios.NotaUtilityService;
import com.happykids.backend.dominio.dto.NotaDTO;
import com.happykids.backend.dominio.entidades.utilitarios.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.OK;

@RequestMapping("/nota")
@RestController
public class NotaControlador {

    public static final String NOTA_ELIMINADA_CORRECTAMENTE = "Nota eliminada.";

    @Autowired
    private iServicioNota iServicioNota;

    @Autowired
    private NotaUtilityService notaUtilityService;

    @PostMapping("/register")
    public ResponseEntity<NotaDTO> agregarNota(@RequestBody NotaDTO notaDTO) {
        NotaDTO notaDTOSaved = (NotaDTO) notaUtilityService
                .convertEntityToDTO(iServicioNota.agregarNota(notaDTO));
        return new ResponseEntity<>(notaDTOSaved, OK);
    }

    @PutMapping("/update")
    public ResponseEntity<NotaDTO> editarNota(@RequestBody NotaDTO notaDTO) {
        NotaDTO notaUpdated = (NotaDTO) notaUtilityService
                .convertEntityToDTO(iServicioNota.editarNota(notaDTO));
        return new ResponseEntity<>(notaUpdated, OK);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Object>> listarNotas() {
        List<Object> notasDTO = iServicioNota.getNotas()
                .stream()
                .map(notaUtilityService::convertEntityToDTO)
                .collect(Collectors.toList());
        return new ResponseEntity<>(notasDTO, OK);
    }

    @GetMapping("/find/{idNota}")
    public ResponseEntity<NotaDTO> buscarNotaPorID(@PathVariable("idNota") Long idNota) {
        NotaDTO notaDTO = (NotaDTO) notaUtilityService
                .convertEntityToDTO(iServicioNota.findNotaById(idNota));
        return new ResponseEntity<>(notaDTO, OK);
    }

    @DeleteMapping("/delete/{idNota}")
    //@PreAuthorize("hasAnyAuthority('user:delete')")
    public ResponseEntity<HttpResponse> eliminarNotaPorId(@PathVariable("idNota") Long idNota) {
        if(this.iServicioNota.eliminarNotaPorId(idNota))
            return response(OK, NOTA_ELIMINADA_CORRECTAMENTE);
        return response(HttpStatus.OK, "ERROR AL ELMINAR NOTA.");
    }

    private ResponseEntity<HttpResponse> response(HttpStatus httpStatus, String message) {
        return new ResponseEntity<>(
                new HttpResponse(httpStatus.value(), httpStatus, httpStatus.getReasonPhrase().toUpperCase(), message),
                httpStatus);
    }
}
