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
                .idcapacidad(String.valueOf(capacidad.getIdcapacidad()))
                .idCompetencia(String.valueOf(capacidad.getCompetencia().getIdCompe()))
                .codcapacidad(capacidad.getCodcapacidad())
                .capacidadDesc(capacidad.getCapacidadDesc())
                .indActi(String.valueOf(capacidad.getIndActi()))
                .indElim(String.valueOf(capacidad.getIndElim()))
                .usuCreacapacidad(capacidad.getUsuCreacapacidad())
                .fecCreacapacidad(utilityService.convertDateToString(capacidad.getFecCreacapacidad()))
                .usuModicapacidad(capacidad.getUsuModicapacidad())
                .fecModicapacidad(utilityService.convertDateToString(capacidad.getFecModicapacidad()))
                .build();
    }

    @Override
    public Object convertDTOtoEntity(Object dtoObject) {
        CapacidadDTO capacidadDTO = (CapacidadDTO) dtoObject;

        log.info("Entrando a {} - convertDTOtoEntity", this.getClass().getName());
        return Capacidad.builder()
                .idcapacidad(NumberUtils.toLong(capacidadDTO.getCodcapacidad()))
                .competencia(implServicioCompetencia.findCompetenciaById(Long.valueOf(capacidadDTO.getIdCompetencia())))
                .codcapacidad(capacidadDTO.getCodcapacidad())
                .capacidadDesc(capacidadDTO.getCapacidadDesc())
                .indActi(Boolean.valueOf(capacidadDTO.getIndActi()))
                .indElim(Boolean.valueOf(capacidadDTO.getIndElim()))
                .fecCreacapacidad(utilityService.convertStringToDate(capacidadDTO.getFecCreacapacidad()))
                .usuCreacapacidad(capacidadDTO.getUsuCreacapacidad())
                .fecModicapacidad(utilityService.convertStringToDate(capacidadDTO.getFecModicapacidad()))
                .usuModicapacidad(capacidadDTO.getUsuModicapacidad())
                .build();
    }

}
