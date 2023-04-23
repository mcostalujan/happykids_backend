package com.happykids.backend.aplicacion.implServicios;

import com.happykids.backend.aplicacion.iServicios.*;
import com.happykids.backend.aplicacion.implServicios.utilitarios.SeccionUtilityService;
import com.happykids.backend.dominio.dto.SeccionDTO;
import com.happykids.backend.dominio.entidades.Nota;
import com.happykids.backend.dominio.entidades.Seccion;
import com.happykids.backend.persistencia.jpaRepositories.iRepositorioSeccion;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.happykids.backend.persistencia.jpaRepositories.iRepositorioSeccion;

import java.util.List;

@Service
@Slf4j
public class ImplServicioSeccion implements iServicioSeccion {


    @Autowired
    private iRepositorioSeccion iRepositorioSeccion;

    @Autowired
    private SeccionUtilityService seccionUtilityService;

    @Override
    public List<Seccion> getSecciones() {
        log.info("Entrando a {} - getSecciones", this.getClass().getName());
        return iRepositorioSeccion.findAll();
    }

    @Override
    public Seccion findSeccionById(Long Id) {
        if (Id != null)
            return iRepositorioSeccion.findSeccionByIdSecci(Id);
        return null;
    }

    @Override
    public Seccion addNewSeccion(SeccionDTO seccionDTO) {
        if (seccionDTO != null) {
            return this.iRepositorioSeccion.save((Seccion) seccionUtilityService.convertDTOtoEntity(seccionDTO));
        }
        return null;
    }

    @Override
    public Seccion updateSeccion(SeccionDTO seccionDTO) {
        if (seccionDTO != null && seccionDTO.getIdSecci() != null) {
            if (iRepositorioSeccion.findSeccionByIdSecci(Long.valueOf(seccionDTO.getIdSecci())) != null) {
                return iRepositorioSeccion
                        .save((Seccion) seccionUtilityService
                                .convertDTOtoEntity(seccionDTO));
            }
        }
        return null;
    }

    @Override
    public boolean deleteSeccion(Long idSeccion) {
        if (idSeccion != null) {
            if (iRepositorioSeccion.findSeccionByIdSecci(Long.valueOf(idSeccion)) != null) {
                iRepositorioSeccion.deleteById(Long.valueOf(idSeccion));
                return true;
            }
        }
        return false;
    }
}
