package com.happykids.backend.aplicacion.implServicios.utilitarios;

import com.happykids.backend.aplicacion.iServicios.Utilitarios.iUtilityService;
import com.happykids.backend.aplicacion.implServicios.ImplServicioNivel;
import com.happykids.backend.dominio.dto.AreaDTO;
import com.happykids.backend.dominio.dto.NotaDTO;
import com.happykids.backend.dominio.entidades.Area;
import com.happykids.backend.dominio.entidades.Nota;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AreaUtilityService implements iUtilityService {

    @Autowired
    private UtilityService utilityService;

    @Autowired
    private ImplServicioNivel implServicioNivel;

    @Override
    public Object convertEntityToDTO(Object entityObject) {
        Area area = (Area) entityObject;
        log.info("Entrando a {} - convertEntityToDTO", this.getClass().getName());
        return AreaDTO.builder()
                .idArea(String.valueOf(area.getIdArea()))
                .idNivel(String.valueOf(area.getNivel().getIdNive()))
                .codArea(area.getCodArea())
                .areaDesc(area.getAreaDesc())
                .usuCreaArea(area.getUsuCreaArea())
                .fecCreaArea(utilityService.convertDateToString(area.getFecCreaArea()))
                .usuModiArea(area.getUsuModiArea())
                .fecModiArea(utilityService.convertDateToString(area.getFecModiArea()))
                .build();
    }

    @Override
    public Object convertDTOtoEntity(Object dtoObject) {
        AreaDTO areaDTO = (AreaDTO) dtoObject;

        log.info("Entrando a {} - convertDTOtoEntity", this.getClass().getName());
        return Area.builder()
                .idArea(NumberUtils.toLong(areaDTO.getIdArea()))
                .nivel(implServicioNivel.findNivel(Long.valueOf(areaDTO.getIdNivel())))
                .codArea(areaDTO.getCodArea())
                .areaDesc(areaDTO.getAreaDesc())
                .fecCreaArea(utilityService.convertStringToDate(areaDTO.getFecCreaArea()))
                .usuCreaArea(areaDTO.getUsuCreaArea())
                .fecModiArea(utilityService.convertStringToDate(areaDTO.getFecModiArea()))
                .usuModiArea(areaDTO.getUsuModiArea())
                .build();
    }
}
