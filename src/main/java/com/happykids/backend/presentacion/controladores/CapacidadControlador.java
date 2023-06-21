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
    public static final String CAPACIDAD_ELIMINADO_CORRECTAMENTE = "Capacidad eliminada.";

    @Autowired
    private iServicioCapacidad iServicioCapacidad;

    @Autowired
    private CapacidadUtilityService capacidadUtilityService;

    @PostMapping("/register")
    public ResponseEntity<CapacidadDTO> agregarCapacidad(@RequestBody CapacidadDTO capacidadDTO) {
        CapacidadDTO capacidadDTOSaved = (CapacidadDTO) capacidadUtilityService
                .convertEntityToDTO(iServicioCapacidad.agregarCapacidad(capacidadDTO));
        return new ResponseEntity<>(capacidadDTOSaved, OK);
    }

    @PutMapping("/update")
    public ResponseEntity<CapacidadDTO> editarCapacidad(@RequestBody CapacidadDTO capacidadDTO) {
        CapacidadDTO capacidadUpdated = (CapacidadDTO) capacidadUtilityService.convertEntityToDTO(
                this.iServicioCapacidad.editarCapacidad(capacidadDTO));
        return new ResponseEntity<>(capacidadUpdated, OK);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Object>> listarCapacidades() {
        List<Object> capacidadDTO = iServicioCapacidad.getCapacidades()
                .stream()
                .map(capacidadUtilityService::convertEntityToDTO)
                .collect(Collectors.toList());
        return new ResponseEntity<>(capacidadDTO, OK);
    }

    @GetMapping("/find/{idCapacidad}")
    public ResponseEntity<CapacidadDTO> buscarCapacidadPorID(@PathVariable("idCapacidad") Long idCapacidad) {
        CapacidadDTO capacidadDTO = (CapacidadDTO) capacidadUtilityService.convertEntityToDTO(
                iServicioCapacidad.findCapacidadById(idCapacidad));
        return new ResponseEntity<>(capacidadDTO, OK);
    }

    @DeleteMapping("/delete/{idCapacidad}")
    //@PreAuthorize("hasAnyAuthority('user:delete')")
    public ResponseEntity<HttpResponse> eliminarCapacidadPorId(@PathVariable("idCapacidad") Long idCapacidad) {
        if (this.iServicioCapacidad.eliminarCapacidadPorId(idCapacidad))
            return response(OK, CAPACIDAD_ELIMINADO_CORRECTAMENTE);
        return response(HttpStatus.OK, "ERROR AL ELMINAR CAPACIDAD.");
    }

    private ResponseEntity<HttpResponse> response(HttpStatus httpStatus, String message) {
        return new ResponseEntity<>(
                new HttpResponse(httpStatus.value(), httpStatus, httpStatus.getReasonPhrase().toUpperCase(), message),
                httpStatus);
    }
}
