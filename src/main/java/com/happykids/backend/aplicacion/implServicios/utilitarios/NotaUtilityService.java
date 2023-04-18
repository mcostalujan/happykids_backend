package com.happykids.backend.aplicacion.implServicios.utilitarios;

import com.happykids.backend.aplicacion.iServicios.Utilitarios.iUtilityService;
import com.happykids.backend.aplicacion.implServicios.ImplServicioNivel;
import com.happykids.backend.dominio.dto.NivelDTO;
import com.happykids.backend.dominio.dto.NotaDTO;
import com.happykids.backend.dominio.entidades.Nivel;
import com.happykids.backend.dominio.entidades.Nota;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@Slf4j
public class NotaUtilityService implements iUtilityService {

    @Autowired
    private UtilityService utilityService;
    @Autowired
    private ImplServicioNivel implServicioNivel;

    @Override
    public Object convertEntityToDTO(Object entityObject) {
        Nota nota = (Nota) entityObject;
        log.info("Entrando a {} - convertEntityToDTO", this.getClass().getName());
        return NotaDTO.builder()
                .idNota(String.valueOf(nota.getIdNota()))
                .idNivel(String.valueOf(nota.getNivel().getIdNive()))
                .codExpNota(nota.getCodExpNota())
                .rangInicNota(String.valueOf(nota.getRangInicNota()))
                .rangFinalNota(String.valueOf(nota.getRangFinalNota()))
                .usuCreaNota(nota.getUsuCreaNota())
                .fecCreaNota(utilityService.convertDateToString(nota.getFecCreaNota()))
                .usuModiNota(nota.getUsuModiNota())
                .fecModiNota(utilityService.convertDateToString(nota.getFecModiNota()))
                .build();
    }

    @Override
    public Object convertDTOtoEntity(Object dtoObject) {
        NotaDTO notaDTO = (NotaDTO) dtoObject;

        log.info("Entrando a {} - convertDTOtoEntity", this.getClass().getName());
        return Nota.builder()
                .idNota(Long.valueOf(notaDTO.getIdNota()))
                .nivel(implServicioNivel.findNivel(Long.valueOf(notaDTO.getIdNivel())))
                .codExpNota(notaDTO.getCodExpNota())
                .rangInicNota(Integer.valueOf(notaDTO.getRangInicNota()))
                .rangFinalNota(Integer.valueOf(notaDTO.getRangFinalNota()))
                .fecCreaNota(utilityService.convertStringToDate(notaDTO.getFecCreaNota()))
                .usuCreaNota(notaDTO.getUsuCreaNota())
                .fecModiNota(utilityService.convertStringToDate(notaDTO.getFecModiNota()))
                .usuModiNota(notaDTO.getUsuModiNota())
                .build();
    }
}
