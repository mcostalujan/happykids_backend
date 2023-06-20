package com.happykids.backend.aplicacion.implServicios;

import com.happykids.backend.aplicacion.iServicios.iServicioClase;
import com.happykids.backend.aplicacion.implServicios.utilitarios.ClaseUtilityService;
import com.happykids.backend.dominio.dto.ClaseDTO;
import com.happykids.backend.dominio.entidades.Clase;
import com.happykids.backend.dominio.entidades.ClaseEstatus;
import com.happykids.backend.dominio.dto.ConsultasSQL.DetalleClase;
import com.happykids.backend.persistencia.jpaRepositories.iRepositorioClase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Slf4j
public class ImplServicioClase implements iServicioClase {

    @Autowired
    private iRepositorioClase iRepositorioClase;

    @Autowired
    private ClaseUtilityService claseUtilityService;


    @Override
    public List<Clase> getClases() {
        return iRepositorioClase.findAll();
    }

    @Override
    public Clase findClaseById(Long idClase) {
        if (idClase != null)
            return iRepositorioClase.findClaseByIdClase(idClase);
        return null;
    }

    @Override
    public Clase createClase(ClaseDTO claseDTO) {
        if (claseDTO != null) {
            claseDTO.setEstatus(ClaseEstatus.NUEVA.getValue());
            Clase newClase = (Clase) claseUtilityService.convertDTOtoEntity(claseDTO);
            return this.iRepositorioClase.save(newClase);
        }
        return null;
    }

    @Override
    public Clase updateClase(ClaseDTO claseDTO) {
        if (claseDTO != null && claseDTO.getIdClase() != null) {
            Clase claseActual = this.findClaseById(Long.valueOf(claseDTO.getIdClase()));
            if (claseActual != null) {
                Clase claseToUpdate = (Clase) claseUtilityService.convertDTOtoEntity(claseDTO);
                return iRepositorioClase.save(claseToUpdate);
            }
        }
        return null;
    }

    @Override
    public List<DetalleClase> getDetalleClases() {
        log.info("Entrando a {} - getDetalleClases", this.getClass().getName());
        return iRepositorioClase.getDetalleFromAll()
                .stream()
                .map(DetalleClase::convertTupleToEntity).toList();
    }
}
