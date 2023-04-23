package com.happykids.backend.aplicacion.implServicios.utilitarios;

import com.happykids.backend.aplicacion.implServicios.ImplServicioCompetencia;
import com.happykids.backend.dominio.dto.NotaDTO;
import com.happykids.backend.dominio.entidades.Nota;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.happykids.backend.aplicacion.iServicios.Utilitarios.iUtilityService;
import com.happykids.backend.dominio.dto.LogroDTO;
import com.happykids.backend.dominio.entidades.Logro;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class LogroUtilityService implements iUtilityService {
    @Autowired
    private UtilityService utilityService;

    @Autowired
    private ImplServicioCompetencia implServicioCompetencia;

    @Override
    public Object convertEntityToDTO(Object entityObject) {
        Logro logro = (Logro) entityObject;
        log.info("Entrando a {} - convertEntityToDTO", this.getClass().getName());
        return LogroDTO.builder()
                .idLogro(String.valueOf(logro.getIdLogro()))
                .idCompetencia(String.valueOf(logro.getCompetencia().getIdCompe()))
                .codLogro(logro.getCodLogro())
                .logroDesc(logro.getLogroDesc())
                .indActi(String.valueOf(logro.getIndActi()))
                .indElim(String.valueOf(logro.getIndElim()))
                .usuCreaLogro(logro.getUsuCreaLogro())
                .fecCreaLogro(utilityService.convertDateToString(logro.getFecCreaLogro()))
                .usuModiLogro(logro.getUsuModiLogro())
                .fecModiLogro(utilityService.convertDateToString(logro.getFecModiLogro()))
                .build();
    }

    @Override
    public Object convertDTOtoEntity(Object dtoObject) {
        LogroDTO logroDTO = (LogroDTO) dtoObject;

        log.info("Entrando a {} - convertDTOtoEntity", this.getClass().getName());
        return Logro.builder()
                .idLogro(NumberUtils.toLong(logroDTO.getCodLogro()))
                .competencia(implServicioCompetencia.findCompetenciaById(Long.valueOf(logroDTO.getIdCompetencia())))
                .codLogro(logroDTO.getCodLogro())
                .logroDesc(logroDTO.getLogroDesc())
                .indActi(Boolean.valueOf(logroDTO.getIndActi()))
                .indElim(Boolean.valueOf(logroDTO.getIndElim()))
                .fecCreaLogro(utilityService.convertStringToDate(logroDTO.getFecCreaLogro()))
                .usuCreaLogro(logroDTO.getUsuCreaLogro())
                .fecModiLogro(utilityService.convertStringToDate(logroDTO.getFecModiLogro()))
                .usuModiLogro(logroDTO.getUsuModiLogro())
                .build();
    }

}
