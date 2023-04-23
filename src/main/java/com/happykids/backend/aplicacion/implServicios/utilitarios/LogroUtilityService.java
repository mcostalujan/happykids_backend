package com.happykids.backend.aplicacion.implServicios.utilitarios;

import org.springframework.beans.factory.annotation.Autowired;

import com.happykids.backend.aplicacion.iServicios.Utilitarios.iUtilityService;
import com.happykids.backend.dominio.dto.LogroDTO;
import com.happykids.backend.dominio.entidades.Logro;

import lombok.extern.slf4j.Slf4j;
@Slf4j
public class LogroUtilityService implements iUtilityService{
    @Autowired
    private UtilityService utilityService;

    @Override
    public Object convertEntityToDTO(Object entityObject) {
       Logro logro = (Logro) entityObject;
        log.info("Entrando a {} - convertEntityToDTO", this.getClass().getName());
        return LogroDTO.builder()
                .idLogro(String.valueOf(logro.getIdLogro()))
                .build();
    }

    @Override
    public Object convertDTOtoEntity(Object dtoObject) {
        return null;
    }

}
