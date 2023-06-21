package com.happykids.backend.aplicacion.implServicios.utilitarios;

import com.happykids.backend.aplicacion.implServicios.ImplServicioCompetencia;
import com.happykids.backend.dominio.dto.CapacidadDTO;
import com.happykids.backend.dominio.dto.NotaDTO;
import com.happykids.backend.dominio.entidades.Capacidad;
import com.happykids.backend.dominio.entidades.Nota;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.happykids.backend.aplicacion.iServicios.Utilitarios.iUtilityService;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CapacidadUtilityService implements iUtilityService {
    @Autowired
    private UtilityService utilityService;

    @Autowired
    private ImplServicioCompetencia implServicioCompetencia;

    @Override
    public Object convertEntityToDTO(Object entityObject) {
        Capacidad capacidad = (Capacidad) entityObject;
        log.info("Entrando a {} - convertEntityToDTO", this.getClass().getName());
        return CapacidadDTO.builder()
                .idCapacidad(String.valueOf(capacidad.getIdCapacidad()))
                .idCompetencia(String.valueOf(capacidad.getCompetencia().getIdCompe()))
                .codCapacidad(capacidad.getCodCapacidad())
                .capacidadDesc(capacidad.getCapacidadDesc())
                .indActi(String.valueOf(capacidad.getIndActi()))
                .indElim(String.valueOf(capacidad.getIndElim()))
                .usuCreaCapacidad(capacidad.getUsuCreaCapacidad())
                .fecCreaCapacidad(utilityService.convertDateToString(capacidad.getFecCreaCapacidad()))
                .usuModiCapacidad(capacidad.getUsuModiCapacidad())
                .fecModiCapacidad(utilityService.convertDateToString(capacidad.getFecModiCapacidad()))
                .build();
    }

    @Override
    public Object convertDTOtoEntity(Object dtoObject) {
        CapacidadDTO capacidadDTO = (CapacidadDTO) dtoObject;

        log.info("Entrando a {} - convertDTOtoEntity", this.getClass().getName());
        return Capacidad.builder()
                .idCapacidad(NumberUtils.toLong(capacidadDTO.getCodCapacidad()))
                .competencia(implServicioCompetencia.findCompetenciaById(Long.valueOf(capacidadDTO.getIdCompetencia())))
                .codCapacidad(capacidadDTO.getCodCapacidad())
                .capacidadDesc(capacidadDTO.getCapacidadDesc())
                .indActi(Boolean.valueOf(capacidadDTO.getIndActi()))
                .indElim(Boolean.valueOf(capacidadDTO.getIndElim()))
                .fecCreaCapacidad(utilityService.convertStringToDate(capacidadDTO.getFecCreaCapacidad()))
                .usuCreaCapacidad(capacidadDTO.getUsuCreaCapacidad())
                .fecModiCapacidad(utilityService.convertStringToDate(capacidadDTO.getFecModiCapacidad()))
                .usuModiCapacidad(capacidadDTO.getUsuModiCapacidad())
                .build();
    }

}
