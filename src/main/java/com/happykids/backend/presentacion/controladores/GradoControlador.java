package com.happykids.backend.presentacion.controladores;

import com.happykids.backend.aplicacion.iServicios.iServicioGrado;
import com.happykids.backend.aplicacion.implServicios.utilitarios.GradoUtilityService;
import com.happykids.backend.dominio.dto.ConsultasSQL.GradoDisponible;
import com.happykids.backend.dominio.dto.ConsultasSQL.NivelDisponible;
import com.happykids.backend.dominio.dto.GradoDTO;
import com.happykids.backend.dominio.dto.NivelDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.OK;

@RequestMapping("/grado")
@RestController
@Slf4j
public class GradoControlador {


    @Autowired
    private iServicioGrado iServicioGrado;

    @Autowired
    private GradoUtilityService gradoUtilityService;

    @GetMapping("/list")
    public ResponseEntity<List<Object>> listarGrados() {
        log.info("Entrando a {} - listarGrados", this.getClass().getName());
        List<Object> grados = iServicioGrado.getGrados()
                .stream()
                .map(gradoUtilityService::convertEntityToDTO)
                .collect(Collectors.toList());
        return new ResponseEntity<>(grados, OK);
    }


    @GetMapping("/find/id/{idGrado}")
    public ResponseEntity<GradoDTO> buscarGradoPorId(@PathVariable("idGrado") Long idGrado) {
        log.info("Entrando a {} - buscarGradoPorId", this.getClass().getName());
        GradoDTO gradoDTO = (GradoDTO) gradoUtilityService
                .convertEntityToDTO(iServicioGrado.buscarGradoPorId(idGrado));
        return new ResponseEntity<>(gradoDTO, OK);
    }

    @GetMapping("/get/getGradosDisponiblesByNivel")
    public ResponseEntity<List<GradoDisponible>> getGradosDisponiblesByNivel(
            @ModelAttribute(value = "idNivel") String idNivel
    ) {
        log.info("Entrando a {} - getnivelesDisponibles", this.getClass().getName());
        List<GradoDisponible> gradosDto = iServicioGrado.getGradosDisponiblesByNivel(idNivel);
        return new ResponseEntity<>(gradosDto, OK);
    }

}
