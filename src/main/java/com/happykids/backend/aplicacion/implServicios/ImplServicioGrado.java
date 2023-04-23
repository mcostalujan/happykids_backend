package com.happykids.backend.aplicacion.implServicios;

import com.happykids.backend.aplicacion.iServicios.*;
import com.happykids.backend.dominio.dto.GradoDTO;
import com.happykids.backend.dominio.entidades.Grado;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.happykids.backend.persistencia.jpaRepositories.iRepositorioGrado;

import java.util.List;

@Service
@Slf4j
public class ImplServicioGrado implements iServicioGrado {

    @Autowired
    private iRepositorioGrado iRepositorioGrado;

    @Override
    public List<Grado> getGrados() {
        log.info("Entrando a {} - getNiveles", this.getClass().getName());
        return iRepositorioGrado.findAll();
    }

    @Override
    public Grado buscarGradoPorId(Long idGrado) {
        return iRepositorioGrado.findGradoByIdGrado(idGrado);
    }
}
