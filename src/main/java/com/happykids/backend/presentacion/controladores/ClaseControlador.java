package com.happykids.backend.presentacion.controladores;

import com.happykids.backend.aplicacion.iServicios.iServicioClase;
import com.happykids.backend.aplicacion.implServicios.utilitarios.ClaseUtilityService;
import com.happykids.backend.dominio.dto.ClaseDTO;
import com.happykids.backend.dominio.dto.ConsultasSQL.DetalleClase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.OK;

@RequestMapping("/clase")
@RestController
@Slf4j
public class ClaseControlador {

    @Autowired
    private iServicioClase iServicioClase;

    @Autowired
    private ClaseUtilityService claseUtilityService;

    @PostMapping("/register")
    public ResponseEntity<ClaseDTO> agregarClase(@RequestBody ClaseDTO ClaseDTO) {
        ClaseDTO claseDTOSaved = (ClaseDTO) claseUtilityService
                .convertEntityToDTO(iServicioClase.createClase(ClaseDTO));
        return new ResponseEntity<>(claseDTOSaved, OK);
    }

    @PutMapping("/update")
    public ResponseEntity<ClaseDTO> editarClase(@RequestBody ClaseDTO ClaseDTO) {
        ClaseDTO claseUpdated = (ClaseDTO) claseUtilityService
                .convertEntityToDTO(iServicioClase.updateClase(ClaseDTO));
        return new ResponseEntity<>(claseUpdated, OK);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Object>> listarClases() {
        List<Object> clasesDTO = iServicioClase.getClases()
                .stream()
                .map(claseUtilityService::convertEntityToDTO)
                .collect(Collectors.toList());
        return new ResponseEntity<>(clasesDTO, OK);
    }

    @GetMapping("/find/{idClase}")
    public ResponseEntity<ClaseDTO> buscarClasePorID(@PathVariable("idClase") Long idClase) {
        ClaseDTO ClaseDTO = (ClaseDTO) claseUtilityService
                .convertEntityToDTO(iServicioClase.findClaseById(idClase));
        return new ResponseEntity<>(ClaseDTO, OK);
    }

    @GetMapping("/get/detalle")
    public ResponseEntity<List<DetalleClase>> getDetalleClases() {
        log.info("Entrando a {} - getDetalleClases", this.getClass().getName());
        List<DetalleClase> clasesDTO = iServicioClase.getDetalleClases();
        return new ResponseEntity<>(clasesDTO, OK);
    }

}
