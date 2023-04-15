package com.happykids.backend.aplicacion.implServicios.utilitarios;

import com.happykids.backend.aplicacion.iServicios.Utilitarios.iUtilityService;
import com.happykids.backend.dominio.dto.NivelDTO;
import com.happykids.backend.dominio.entidades.Nivel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class NivelUtilityService implements iUtilityService {

    @Autowired
    private UtilityService utilityService;

    @Override
    public Object convertEntityToDTO(Object dtoObject) {
        Nivel nivel = (Nivel) dtoObject;
        log.info("Entrando a {} - convertEntityToDTO", this.getClass().getName());
        return NivelDTO.builder()
                .idNive(String.valueOf(nivel.getIdNive()))
                .codNive(nivel.getCodNive())
                .niveDesc(nivel.getNiveDesc())
                .usuCreaNive(nivel.getUsuCreaNive())
                .fecCreaNive(utilityService.convertDateToString(nivel.getFecCreaNive()))
                .usuModiNive(nivel.getUsuModiNive())
                .fecModiNive(utilityService.convertDateToString(nivel.getFecModiNive()))
                .build();
    }

    @Override
    public Object convertDTOtoEntity(Object entityObject) {
        return null;
    }
}
