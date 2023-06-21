package com.happykids.backend.presentacion.controladores;


import com.happykids.backend.aplicacion.iServicios.iServicioCapacidad;
import com.happykids.backend.aplicacion.implServicios.utilitarios.CapacidadUtilityService;
import com.happykids.backend.dominio.dto.CapacidadDTO;
import com.happykids.backend.dominio.entidades.utilitarios.HttpResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.OK;

@RequestMapping("/capacidad")
@Slf4j
@RestController
public class CapacidadControlador {
    public static final String CAPACIDAD_ELIMINADO_CORRECTAMENTE = "Capacidad eliminado.";

    @Autowired
    private iServicioCapacidad iServiciocapacidad;

    @Autowired
    private CapacidadUtilityService capacidadUtilityService;

    @PostMapping("/register")
    public ResponseEntity<CapacidadDTO> agregarcapacidad(@RequestBody CapacidadDTO capacidadDTO) {
        CapacidadDTO capacidadDTOSaved = (CapacidadDTO) capacidadUtilityService
                .convertEntityToDTO(iServiciocapacidad.agregarcapacidad(capacidadDTO));
        return new ResponseEntity<>(capacidadDTOSaved, OK);
    }

    @PutMapping("/update")
    public ResponseEntity<CapacidadDTO> editarcapacidad(@RequestBody CapacidadDTO capacidadDTO) {
        CapacidadDTO capacidadUpdated = (CapacidadDTO) capacidadUtilityService.convertEntityToDTO(
                this.iServiciocapacidad.editarcapacidad(capacidadDTO));
        return new ResponseEntity<>(capacidadUpdated, OK);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Object>> listarcapacidads() {
        List<Object> capacidadsDTO = iServiciocapacidad.getcapacidads()
                .stream()
                .map(capacidadUtilityService::convertEntityToDTO)
                .collect(Collectors.toList());
        return new ResponseEntity<>(capacidadsDTO, OK);
    }

    @GetMapping("/find/{idcapacidad}")
    public ResponseEntity<CapacidadDTO> buscarcapacidadPorID(@PathVariable("idcapacidad") Long idcapacidad) {
        CapacidadDTO capacidadDTO = (CapacidadDTO) capacidadUtilityService.convertEntityToDTO(
                iServiciocapacidad.findcapacidadById(idcapacidad));
        return new ResponseEntity<>(capacidadDTO, OK);
    }

    @DeleteMapping("/delete/{idcapacidad}")
    //@PreAuthorize("hasAnyAuthority('user:delete')")
    public ResponseEntity<HttpResponse> eliminarcapacidadPorId(@PathVariable("idcapacidad") Long idcapacidad) {
        if (this.iServiciocapacidad.eliminarcapacidadPorId(idcapacidad))
            return response(OK, CAPACIDAD_ELIMINADO_CORRECTAMENTE);
        return response(HttpStatus.OK, "ERROR AL ELMINAR capacidad.");
    }

    private ResponseEntity<HttpResponse> response(HttpStatus httpStatus, String message) {
        return new ResponseEntity<>(
                new HttpResponse(httpStatus.value(), httpStatus, httpStatus.getReasonPhrase().toUpperCase(), message),
                httpStatus);
    }
}
