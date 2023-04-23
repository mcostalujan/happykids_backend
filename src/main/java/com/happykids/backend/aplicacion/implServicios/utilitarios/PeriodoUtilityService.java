package com.happykids.backend.aplicacion.implServicios.utilitarios;

import org.springframework.beans.factory.annotation.Autowired;

import com.happykids.backend.aplicacion.iServicios.Utilitarios.iUtilityService;
import com.happykids.backend.dominio.dto.PeriodoDTO;
import com.happykids.backend.dominio.entidades.Periodo;

import lombok.extern.slf4j.Slf4j;
@Slf4j
public class PeriodoUtilityService implements iUtilityService{
    
    @Autowired 
    private UtilityService utilityService;

    @Override
    public Object convertEntityToDTO(Object entityObject) {
       Periodo periodo = (Periodo) entityObject;
        log.info("Entrando a {} - convertEntityToDTO", this.getClass().getName());
        return PeriodoDTO.builder()
                .idPer(String.valueOf(periodo.getIdPer()))
                .build();
    }

    @Override
    public Object convertDTOtoEntity(Object dtoObject) {
        return null;
    }
}