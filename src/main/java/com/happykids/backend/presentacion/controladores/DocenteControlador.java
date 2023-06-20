package com.happykids.backend.presentacion.controladores;

import com.happykids.backend.aplicacion.iServicios.iServicioDocente;
import com.happykids.backend.aplicacion.implServicios.utilitarios.DocenteUtilityService;
import com.happykids.backend.dominio.dto.DocenteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.OK;

@RequestMapping("/docente")
@RestController
public class DocenteControlador {

    @Autowired
    private iServicioDocente iServicioDocente;

    @Autowired
    private DocenteUtilityService docenteUtilityService;

    @PostMapping("/register")
    public ResponseEntity<DocenteDTO> agregarDocente(@RequestBody DocenteDTO DocenteDTO) {
        DocenteDTO docenteDTOSaved = (DocenteDTO) docenteUtilityService
                .convertEntityToDTO(iServicioDocente.createDocente(DocenteDTO));
        return new ResponseEntity<>(docenteDTOSaved, OK);
    }

    @PutMapping("/update")
    public ResponseEntity<DocenteDTO> editarDocente(@RequestBody DocenteDTO DocenteDTO) {
        DocenteDTO docenteUpdated = (DocenteDTO) docenteUtilityService
                .convertEntityToDTO(iServicioDocente.updateDocente(DocenteDTO));
        return new ResponseEntity<>(docenteUpdated, OK);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Object>> listarDocentes() {
        List<Object> docentesDTO = iServicioDocente.getDocentes()
                .stream()
                .map(docenteUtilityService::convertEntityToDTO)
                .collect(Collectors.toList());
        return new ResponseEntity<>(docentesDTO, OK);
    }

    @GetMapping("/find/{idDocente}")
    public ResponseEntity<DocenteDTO> buscarDocentePorID(@PathVariable("idDocente") Long idDocente) {
        DocenteDTO docenteDTO = (DocenteDTO) docenteUtilityService
                .convertEntityToDTO(iServicioDocente.findDocenteById(idDocente));
        return new ResponseEntity<>(docenteDTO, OK);
    }

}
