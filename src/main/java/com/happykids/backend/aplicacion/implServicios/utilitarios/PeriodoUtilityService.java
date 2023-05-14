package com.happykids.backend.aplicacion.implServicios.utilitarios;

import com.happykids.backend.aplicacion.implServicios.ImplServicioNivel;
import com.happykids.backend.dominio.dto.NotaDTO;
import com.happykids.backend.dominio.entidades.Nota;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.happykids.backend.aplicacion.iServicios.Utilitarios.iUtilityService;
import com.happykids.backend.dominio.dto.PeriodoDTO;
import com.happykids.backend.dominio.entidades.Periodo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class PeriodoUtilityService implements iUtilityService {

    @Autowired
    private UtilityService utilityService;

    @Override
    public Object convertEntityToDTO(Object entityObject) {
        Periodo periodo = (Periodo) entityObject;
        log.info("Entrando a {} - convertEntityToDTO", this.getClass().getName());
        return PeriodoDTO.builder()
                .idPer(String.valueOf(periodo.getIdPer()))
                .codPer(periodo.getCodPer())
                .yearPer(periodo.getYearPer())
                .periEduDescPer(periodo.getPeriEduDescPer())
                .fecIniActiPer(utilityService.convertDateToString(periodo.getFecFinActiPer()))
                .fecFinActiPer(utilityService.convertDateToString(periodo.getFecFinActiPer()))
                .usuCreaPer(periodo.getUsuCreaPer())
                .fecCreaPer(utilityService.convertDateToString(periodo.getFecCreaPer()))
                .usuModiPer(periodo.getUsuModiPer())
                .fecModiPer(utilityService.convertDateToString(periodo.getFecModiPer()))
                .build();
    }

    @Override
    public Object convertDTOtoEntity(Object dtoObject) {
        PeriodoDTO periodoDTO = (PeriodoDTO) dtoObject;

        log.info("Entrando a {} - convertDTOtoEntity", this.getClass().getName());
        return Periodo.builder()
                .idPer(NumberUtils.toLong(periodoDTO.getIdPer()))
                .codPer(periodoDTO.getCodPer())
                .yearPer(periodoDTO.getYearPer())
                .periEduDescPer(periodoDTO.getPeriEduDescPer())
                .fecIniActiPer(utilityService.convertStringToDate(periodoDTO.getFecIniActiPer()))
                .fecFinActiPer(utilityService.convertStringToDate(periodoDTO.getFecFinActiPer()))
                .usuCreaPer(periodoDTO.getUsuCreaPer())
                .fecCreaPer(utilityService.convertStringToDate(periodoDTO.getFecCreaPer()))
                .usuModiPer(periodoDTO.getUsuModiPer())
                .fecModiPer(utilityService.convertStringToDate(periodoDTO.getFecModiPer()))
                .build();
    }
}