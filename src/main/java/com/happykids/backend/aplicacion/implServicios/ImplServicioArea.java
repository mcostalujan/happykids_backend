package com.happykids.backend.aplicacion.implServicios;

import com.happykids.backend.aplicacion.iServicios.*;
import com.happykids.backend.aplicacion.implServicios.utilitarios.AreaUtilityService;
import com.happykids.backend.dominio.dto.AreaDTO;
import com.happykids.backend.dominio.entidades.Area;
import com.happykids.backend.dominio.entidades.Nota;
import com.happykids.backend.persistencia.jpaRepositories.iRepositorioArea;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.happykids.backend.persistencia.jpaRepositories.iRepositorioArea;

import java.util.List;

@Service
@Slf4j
public class ImplServicioArea implements iServicioArea {

    @Autowired
    private iRepositorioArea iRepositorioArea;

    @Autowired
    private AreaUtilityService areaUtilityService;


    @Override
    public List<Area> getAreas() {
        log.info("Entrando a {} - getAreas", this.getClass().getName());
        return iRepositorioArea.findAll();
    }

    @Override
    public Area findAreaById(Long idArea) {
        if (idArea != null)
            return iRepositorioArea.findAreaByIdArea(idArea);
        return null;
    }

    @Override
    public Area agregarArea(AreaDTO areaDTO) {
        if (areaDTO != null) {
            return this.iRepositorioArea.save((Area) areaUtilityService.convertDTOtoEntity(areaDTO));
        }
        return null;
    }

    @Override
    public Area updateArea(AreaDTO areaDTO) {
        if (areaDTO != null && areaDTO.getIdArea() != null) {
            if (iRepositorioArea.findAreaByIdArea(Long.valueOf(areaDTO.getIdArea())) != null) {
                return iRepositorioArea
                        .save((Area) areaUtilityService
                                .convertDTOtoEntity(areaDTO));
            }
        }
        return null;
    }
}
