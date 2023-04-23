package com.happykids.backend.presentacion.controladores;

import com.happykids.backend.aplicacion.iServicios.iServicioArea;
import com.happykids.backend.aplicacion.implServicios.utilitarios.AreaUtilityService;
import com.happykids.backend.dominio.dto.AreaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.OK;

@RequestMapping("/area")
@RestController
public class AreaControlador {


    @Autowired
    private iServicioArea iServicioArea;

    @Autowired
    private AreaUtilityService areaUtilityService;

    @PostMapping("/register")
    public ResponseEntity<AreaDTO> agregarArea(@RequestBody AreaDTO areaDTO) {
        AreaDTO areaDtoSaved = (AreaDTO) areaUtilityService
                .convertEntityToDTO(iServicioArea.agregarArea(areaDTO));
        return new ResponseEntity<>(areaDtoSaved, OK);
    }

    @PutMapping("/update")
    public ResponseEntity<AreaDTO> editarArea(@RequestBody AreaDTO areaDTO) {
        AreaDTO areaUpdated = (AreaDTO) areaUtilityService
                .convertEntityToDTO(iServicioArea.updateArea(areaDTO));
        return new ResponseEntity<>(areaUpdated, OK);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Object>> listarAreas() {
        List<Object> areasDTO = iServicioArea.getAreas()
                .stream()
                .map(areaUtilityService::convertEntityToDTO)
                .collect(Collectors.toList());
        return new ResponseEntity<>(areasDTO, OK);
    }

    @GetMapping("/find/{idArea}")
    public ResponseEntity<AreaDTO> buscarAreaPorID(@PathVariable("idArea") Long idArea) {
        AreaDTO areaDTO = (AreaDTO) areaUtilityService
                .convertEntityToDTO(iServicioArea.findAreaById(idArea));
        return new ResponseEntity<>(areaDTO, OK);
    }
}
