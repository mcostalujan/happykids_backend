package com.happykids.backend.presentacion.controladores;

import com.happykids.backend.aplicacion.iServicios.iServicioClaseDocente;
import com.happykids.backend.aplicacion.implServicios.utilitarios.ClaseDocenteUtilityService;
import com.happykids.backend.dominio.dto.ClaseDocenteDTO;
import com.happykids.backend.dominio.dto.ClaseDocenteIdDTO;
import com.happykids.backend.dominio.dto.ConsultasSQL.DetalleClase;
import com.happykids.backend.dominio.dto.ConsultasSQL.DetalleClasesDocente;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.OK;

@RequestMapping("/clase-docente")
@RestController
@Slf4j
public class ClaseDocenteControlador {

    @Autowired
    private iServicioClaseDocente iServicioClaseDocente;

    @Autowired
    private ClaseDocenteUtilityService claseDocenteUtilityService;

    @PostMapping("/register")
    public ResponseEntity<ClaseDocenteDTO> agregarClaseDocente(@RequestBody ClaseDocenteDTO claseDocenteDTO) {
        ClaseDocenteDTO claseDocenteDTOSaved = (ClaseDocenteDTO) claseDocenteUtilityService
                .convertEntityToDTO(iServicioClaseDocente.createClaseDocente(claseDocenteDTO));
        return new ResponseEntity<>(claseDocenteDTOSaved, OK);
    }

    @PutMapping("/update")
    public ResponseEntity<ClaseDocenteDTO> editarClaseDocente(@RequestBody ClaseDocenteDTO ClaseDocenteDTO) {
        ClaseDocenteDTO claseDocenteUpdated = (ClaseDocenteDTO) claseDocenteUtilityService
                .convertEntityToDTO(iServicioClaseDocente.updateClaseDocente(ClaseDocenteDTO));
        return new ResponseEntity<>(claseDocenteUpdated, OK);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Object>> listarClasesDocente() {
        List<Object> clasesDocenteDTO = iServicioClaseDocente.getClasesDocente()
                .stream()
                .map(claseDocenteUtilityService::convertEntityToDTO)
                .collect(Collectors.toList());
        return new ResponseEntity<>(clasesDocenteDTO, OK);
    }

    @GetMapping("/find")
    public ResponseEntity<ClaseDocenteDTO> buscarClaseDocentePorID(@RequestBody ClaseDocenteIdDTO claseDocenteIdDTO) {
        ClaseDocenteDTO claseDocenteDTO = (ClaseDocenteDTO) claseDocenteUtilityService
                .convertEntityToDTO(iServicioClaseDocente
                        .findClaseDocenteById(
                                NumberUtils.toLong(claseDocenteIdDTO.getIdDoc()),
                                NumberUtils.toLong(claseDocenteIdDTO.getIdClase())));
        return new ResponseEntity<>(claseDocenteDTO, OK);
    }


    @GetMapping("/get/clasesDocentePeriodo")
    public ResponseEntity<List<DetalleClasesDocente>> getClasesByDocenteAndPeriodo(@ModelAttribute(value = "idDocente") String idDocente,
                                                                                   @ModelAttribute(value = "idPeriodo") String idPeriodo) {
        log.info("Entrando a {} - getDetalleClases", this.getClass().getName());
        List<DetalleClasesDocente> clasesDTO = iServicioClaseDocente.getClasesByDocenteAndPeriodo(idDocente, idPeriodo);
        return new ResponseEntity<>(clasesDTO, OK);
    }
}
