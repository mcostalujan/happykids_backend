package com.happykids.backend.presentacion.controladores;

import com.happykids.backend.aplicacion.iServicios.iServicioGrado;
import com.happykids.backend.dominio.dto.GradoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RequestMapping("/grado")
@RestController
public class GradoControlador {


    @Autowired
    private iServicioGrado servicioGrado;

    @GetMapping("/list")
    public ResponseEntity<List<GradoDTO>> listarGrados() {
        List<GradoDTO> grados = servicioGrado.getGrados();
        return new ResponseEntity<>(grados, OK);
    }


    @GetMapping("/find/{idGrado}")
    public ResponseEntity<GradoDTO> buscarGradoPorId(@PathVariable("idGrado") Long idGrado) {
        GradoDTO gradoDTO = servicioGrado.buscarGradoPorId(idGrado);
        return new ResponseEntity<>(gradoDTO, OK);
    }

}
