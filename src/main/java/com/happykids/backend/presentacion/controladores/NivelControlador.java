package com.happykids.backend.presentacion.controladores;

import com.happykids.backend.aplicacion.iServicios.iServicioNivel;
import com.happykids.backend.aplicacion.implServicios.utilitarios.NivelUtilityService;
import com.happykids.backend.dominio.dto.NivelDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.OK;

@RequestMapping("/nivel")
@RestController
@Slf4j
public class NivelControlador {

    @Autowired
    private iServicioNivel iServicioNivel;

    @Autowired
    private NivelUtilityService nivelUtilityService;

    @GetMapping("/list")
    public ResponseEntity<List<Object>> listarNiveles() {
        log.info("Entrando a {} - listarNiveles", this.getClass().getName());
        List<Object> niveles = iServicioNivel.getNiveles()
                .stream()
                .map(nivelUtilityService::convertEntityToDTO)
                .collect(Collectors.toList());
        return new ResponseEntity<>(niveles, OK);
    }


    @GetMapping("/find/id/{idNivel}")
    public ResponseEntity<Object> buscarNivelPorID(@PathVariable("idNivel") Long idNivel) {
        log.info("Entrando a {} - buscarNivelPorID", this.getClass().getName());
        NivelDTO nivelDTO = (NivelDTO) nivelUtilityService.convertEntityToDTO(iServicioNivel.findNivel(idNivel));
        return new ResponseEntity<>(nivelDTO, OK);
    }

}
