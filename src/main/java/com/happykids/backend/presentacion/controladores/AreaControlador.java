package com.happykids.backend.presentacion.controladores;

import com.happykids.backend.aplicacion.iServicios.iServicioArea;
import com.happykids.backend.dominio.dto.AreaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RequestMapping("/area")
@RestController
public class AreaControlador {


    @Autowired
    private iServicioArea servicioArea;

    @PostMapping("/register")
    public ResponseEntity<AreaDTO> agregarArea(@RequestBody AreaDTO areaDTO) {
        return new ResponseEntity<>(this.servicioArea.agregarArea(areaDTO), OK);
    }

    @PutMapping("/update")
    public ResponseEntity<AreaDTO> editarArea(@RequestBody AreaDTO areaDTO) {
        AreaDTO areaUpdated = this.servicioArea.updateArea(areaDTO);
        return new ResponseEntity<>(areaUpdated, OK);
    }

    @GetMapping("/list")
    public ResponseEntity<List<AreaDTO>> listarAreas() {
        List<AreaDTO> areasDTO = servicioArea.getAreas();
        return new ResponseEntity<>(areasDTO, OK);
    }

    @GetMapping("/find/{idArea}")
    public ResponseEntity<AreaDTO> buscarAreaPorID(@PathVariable("idArea") Long idArea) {
        AreaDTO areaDTO = servicioArea.findAreaById(idArea);
        return new ResponseEntity<>(areaDTO, OK);
    }
}
