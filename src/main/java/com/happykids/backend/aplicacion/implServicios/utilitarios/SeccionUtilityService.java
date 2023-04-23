package com.happykids.backend.aplicacion.implServicios.utilitarios;

import com.happykids.backend.aplicacion.iServicios.Utilitarios.iUtilityService;
import com.happykids.backend.aplicacion.implServicios.ImplServicioGrado;
import com.happykids.backend.dominio.dto.AreaDTO;
import com.happykids.backend.dominio.dto.SeccionDTO;
import com.happykids.backend.dominio.entidades.Area;
import com.happykids.backend.dominio.entidades.Seccion;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SeccionUtilityService implements iUtilityService {

    @Autowired
    private UtilityService utilityService;

    @Autowired
    private ImplServicioGrado implServicioGrado;

    @Override
    public Object convertEntityToDTO(Object entityObject) {
        Seccion seccion = (Seccion) entityObject;
        log.info("Entrando a {} - convertEntityToDTO", this.getClass().getName());
        return SeccionDTO.builder()
                .idSecci(String.valueOf(seccion.getIdSecci()))
                .idGrado(String.valueOf(seccion.getGrado().getIdGrado()))
                .codSecci(seccion.getCodSecci())
                .usuCreaSecci(seccion.getUsuCreaSecci())
                .fecCreaSecci(utilityService.convertDateToString(seccion.getFecCreaSecci()))
                .usuModiSecci(seccion.getUsuModiSecci())
                .fecModiSecci(utilityService.convertDateToString(seccion.getFecModiSecci()))
                .build();
    }

    @Override
    public Object convertDTOtoEntity(Object dtoObject) {
        SeccionDTO seccionDTO = (SeccionDTO) dtoObject;

        log.info("Entrando a {} - convertDTOtoEntity", this.getClass().getName());
        return Seccion.builder()
                .idSecci(NumberUtils.toLong(seccionDTO.getIdSecci()))
                .grado(implServicioGrado.buscarGradoPorId(Long.valueOf(seccionDTO.getIdGrado())))
                .codSecci(seccionDTO.getCodSecci())
                .usuCreaSecci(seccionDTO.getUsuCreaSecci())
                .fecCreaSecci(utilityService.convertStringToDate(seccionDTO.getFecCreaSecci()))
                .usuModiSecci(seccionDTO.getUsuModiSecci())
                .fecModiSecci(utilityService.convertStringToDate(seccionDTO.getFecModiSecci()))
                .build();
    }
}
