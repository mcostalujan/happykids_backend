package com.happykids.backend.aplicacion.implServicios.utilitarios;

import com.happykids.backend.aplicacion.iServicios.Utilitarios.iUtilityService;
import com.happykids.backend.aplicacion.implServicios.ImplServicioArea;
import com.happykids.backend.aplicacion.implServicios.ImplServicioNivel;
import com.happykids.backend.dominio.dto.CompetenciaDTO;
import com.happykids.backend.dominio.entidades.Competencia;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CompetenciaUtilityService implements iUtilityService {

    @Autowired
    private UtilityService utilityService;

    @Autowired
    private ImplServicioNivel implServicioNivel;

    @Autowired
    private ImplServicioArea implServicioArea;

    @Override
    public Object convertEntityToDTO(Object entityObject) {
        Competencia competencia = (Competencia) entityObject;
        log.info("Entrando a {} - convertEntityToDTO", this.getClass().getName());
        return CompetenciaDTO.builder()
                .idCompe(String.valueOf(competencia.getIdCompe()))
//                .idNivel(String.valueOf(competencia.getNivel().getIdNive()))
                .idArea(String.valueOf(competencia.getArea().getIdArea()))
                .codigoCompe(competencia.getCodigoCompe())
                .descCompe(competencia.getDescCompe())
                .indActiCompe(String.valueOf(competencia.getIndActiCompe()))
                .indElimCompe(String.valueOf(competencia.getIndElimCompe()))
                .usuCreaCompe(competencia.getUsuCreaCompe())
                .fecCreaCompe(utilityService.convertDateToString(competencia.getFecCreaCompe()))
                .usuModiCompe(competencia.getUsuModiCompe())
                .fecModiCompe(utilityService.convertDateToString(competencia.getFecModiCompe()))
                .build();
    }

    @Override
    public Object convertDTOtoEntity(Object dtoObject) {
        CompetenciaDTO competenciaDTO = (CompetenciaDTO) dtoObject;

        log.info("Entrando a {} - convertDTOtoEntity", this.getClass().getName());
        return Competencia.builder()
                .idCompe(NumberUtils.toLong(competenciaDTO.getIdCompe()))
//                .nivel(implServicioNivel.findNivel(Long.valueOf(competenciaDTO.getIdNivel())))
                .area(implServicioArea.findAreaById(NumberUtils.toLong(competenciaDTO.getIdArea())))
                .descCompe(competenciaDTO.getDescCompe())
                .codigoCompe(competenciaDTO.getCodigoCompe())
                .indActiCompe(Boolean.valueOf(competenciaDTO.getIndActiCompe()))
                .indElimCompe(Boolean.valueOf(competenciaDTO.getIndElimCompe()))
                .fecCreaCompe(utilityService.convertStringToDate(competenciaDTO.getFecCreaCompe()))
                .usuCreaCompe(competenciaDTO.getUsuCreaCompe())
                .fecModiCompe(utilityService.convertStringToDate(competenciaDTO.getFecModiCompe()))
                .usuModiCompe(competenciaDTO.getUsuModiCompe())
                .build();
    }

}
