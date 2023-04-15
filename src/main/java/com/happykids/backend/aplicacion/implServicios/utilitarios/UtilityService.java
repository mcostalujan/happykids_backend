package com.happykids.backend.aplicacion.implServicios.utilitarios;

import com.happykids.backend.dominio.dto.NivelDTO;
import com.happykids.backend.dominio.entidades.Nivel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
@Slf4j
public class UtilityService {

    public NivelDTO convertEntityToDTO(Nivel nivel) {
        log.info("Entrando a {} - convertEntityToDTO", this.getClass().getName());
        return NivelDTO.builder()
                .idNive(String.valueOf(nivel.getIdNive()))
                .codNive(nivel.getCodNive())
                .niveDesc(nivel.getNiveDesc())
                .usuCreaNive(nivel.getUsuCreaNive())
                .fecCreaNive(convertDateToString(nivel.getFecCreaNive()))
                .usuModiNive(nivel.getUsuModiNive())
                .fecModiNive(convertDateToString(nivel.getFecModiNive()))
                .build();
    }


    private String convertDateToString(Date date) {
        log.info("Entrando a {} - convertDateToString", this.getClass().getName());
        if (date != null) {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            return dateFormat.format(date);
        }
        return null;
    }


}
