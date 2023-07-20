package com.happykids.backend.aplicacion.implServicios;

import com.happykids.backend.aplicacion.iServicios.*;
import com.happykids.backend.aplicacion.implServicios.utilitarios.NivelUtilityService;
import com.happykids.backend.dominio.dto.ConsultasSQL.DetalleClasesDocente;
import com.happykids.backend.dominio.dto.ConsultasSQL.NivelDisponible;
import com.happykids.backend.dominio.dto.NivelDTO;
import com.happykids.backend.dominio.entidades.Nivel;
import com.happykids.backend.persistencia.jpaRepositories.iRepositorioNivel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class ImplServicioNivel implements iServicioNivel {

    @Autowired
    private iRepositorioNivel repositorioNivel;

    @Autowired
    private NivelUtilityService nivelUtilityService;

    @Override
    public List<Nivel> getNiveles() {
        log.info("Entrando a {} - getNiveles", this.getClass().getName());
        return repositorioNivel.findAll();
    }

    @Override
    public Nivel findNivel(Long Id) {
        return repositorioNivel.findByIdNive(Id);
    }

    @Override
    public List<NivelDisponible> getNivelesDisponibles() {
        log.info("Entrando a {} - getNivelesDisponibles", this.getClass().getName());
        return repositorioNivel.getNivelesDisponibles()
                .stream()
                .map(NivelDisponible::convertTupleToEntity).toList();
    }
}
