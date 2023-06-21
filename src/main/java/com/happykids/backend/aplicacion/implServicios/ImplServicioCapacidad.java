package com.happykids.backend.aplicacion.implServicios;

import com.happykids.backend.aplicacion.iServicios.*;
import com.happykids.backend.aplicacion.implServicios.utilitarios.CapacidadUtilityService;
import com.happykids.backend.dominio.dto.CapacidadDTO;
import com.happykids.backend.dominio.entidades.Capacidad;
import com.happykids.backend.dominio.entidades.Nota;
import com.happykids.backend.persistencia.jpaRepositories.iRepositorioCapacidad;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
@Slf4j
public class ImplServicioCapacidad implements iServicioCapacidad {


    @Autowired
    private iRepositorioCapacidad iRepositoriocapacidad;

    @Autowired
    private CapacidadUtilityService capacidadUtilityService;

    @Override
    public List<Capacidad> getCapacidades() {
        log.info("Entrando a {} - getcapacidads", this.getClass().getName());
        return iRepositoriocapacidad.findAll();
    }

    @Override
    public Capacidad findCapacidadById(Long idCapacidad) {
        if (idCapacidad != null)
            return iRepositoriocapacidad.findCapacidadByIdCapacidad(idCapacidad);
        return null;
    }

    @Override
    public Capacidad editarCapacidad(CapacidadDTO capacidadDTO) {
        if (capacidadDTO != null && capacidadDTO.getIdCapacidad() != null) {
            if (iRepositoriocapacidad.findCapacidadByIdCapacidad(Long.valueOf(capacidadDTO.getIdCapacidad())) != null) {
                return iRepositoriocapacidad
                        .save((Capacidad) capacidadUtilityService
                                .convertDTOtoEntity(capacidadDTO));
            }
        }
        return null;
    }

    @Override
    public Capacidad agregarCapacidad(CapacidadDTO capacidadDTO) {
        if (capacidadDTO != null) {
            capacidadDTO.setIndActi("true");
            capacidadDTO.setIndElim("false");
            return this.iRepositoriocapacidad.save((Capacidad) capacidadUtilityService.convertDTOtoEntity(capacidadDTO));
        }
        return null;
    }

    @Override
    public boolean eliminarCapacidadPorId(Long idCapacidad) {
        if (idCapacidad != null) {
            if (iRepositoriocapacidad.findCapacidadByIdCapacidad(Long.valueOf(idCapacidad)) != null) {
                iRepositoriocapacidad.deleteById(Long.valueOf(idCapacidad));
                return true;
            }
        }
        return false;
    }
}
