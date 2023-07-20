package com.happykids.backend.presentacion.controladores;

import com.happykids.backend.aplicacion.iServicios.iServicioSeccion;
import com.happykids.backend.aplicacion.implServicios.utilitarios.SeccionUtilityService;
import com.happykids.backend.dominio.dto.ConsultasSQL.GradoDisponible;
import com.happykids.backend.dominio.dto.ConsultasSQL.SeccionDisponible;
import com.happykids.backend.dominio.dto.SeccionDTO;
import com.happykids.backend.dominio.entidades.Seccion;
import com.happykids.backend.dominio.entidades.utilitarios.HttpResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.OK;

@RequestMapping("/seccion")
@RestController
@Slf4j
public class SeccionControlador {

    public static final String SECCION_ELIMINADA_CORRECTAMENTE = "Seccion eliminada.";

    @Autowired
    private iServicioSeccion iServicioSeccion;

    @Autowired
    private SeccionUtilityService seccionUtilityService;

    @PostMapping("/register")
    public ResponseEntity<SeccionDTO> agregarSeccion(@RequestBody SeccionDTO seccionDTO) {
        SeccionDTO seccionDTOSaved = (SeccionDTO) seccionUtilityService
                .convertEntityToDTO(iServicioSeccion.addNewSeccion(seccionDTO));
        return new ResponseEntity<>(seccionDTOSaved, OK);
    }

    @PutMapping("/update")
    public ResponseEntity<SeccionDTO> editarSeccion(@RequestBody SeccionDTO seccionDTO) {
        SeccionDTO seccionUpdated = (SeccionDTO) seccionUtilityService
                .convertEntityToDTO(iServicioSeccion.updateSeccion(seccionDTO));
        return new ResponseEntity<>(seccionUpdated, OK);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Object>> listarSecciones() {
        List<Object> seccionesDTO = iServicioSeccion.getSecciones()
                .stream()
                .map(seccionUtilityService::convertEntityToDTO)
                .collect(Collectors.toList());
        return new ResponseEntity<>(seccionesDTO, OK);
    }

    @GetMapping("/find/{idSeccion}")
    public ResponseEntity<SeccionDTO> buscarSeccionPorID(@PathVariable("idSeccion") Long idSeccion) {
        SeccionDTO seccionDTO = (SeccionDTO) seccionUtilityService
                .convertEntityToDTO(iServicioSeccion.findSeccionById(idSeccion));
        return new ResponseEntity<>(seccionDTO, OK);
    }

    @DeleteMapping("/delete/{idSeccion}")
    //@PreAuthorize("hasAnyAuthority('user:delete')")
    public ResponseEntity<HttpResponse> eliminarSeccionPorId(@PathVariable("idSeccion") Long idSeccion) {
        if (this.iServicioSeccion.deleteSeccion(idSeccion))
            return response(OK, SECCION_ELIMINADA_CORRECTAMENTE);
        return response(HttpStatus.OK, "ERROR AL ELMINAR SECCION.");
    }

    private ResponseEntity<HttpResponse> response(HttpStatus httpStatus, String message) {
        return new ResponseEntity<>(
                new HttpResponse(httpStatus.value(), httpStatus, httpStatus.getReasonPhrase().toUpperCase(), message),
                httpStatus);
    }


    @GetMapping("/get/getSeccionesDisponiblesByNivelAndGrado")
    public ResponseEntity<List<SeccionDisponible>> getSeccionesDisponiblesByNivelAndGrado(
            @ModelAttribute(value = "idNivel") String idNivel,
            @ModelAttribute(value = "idGrado") String idGrado
    ) {
        log.info("Entrando a {} - getSeccionesDisponiblesByNivelAndGrado", this.getClass().getName());
        List<SeccionDisponible> seccionesDisponibles = iServicioSeccion.getSeccionesDisponiblesByNivelAndGrado(idNivel, idGrado);
        return new ResponseEntity<>(seccionesDisponibles, OK);
    }

}
