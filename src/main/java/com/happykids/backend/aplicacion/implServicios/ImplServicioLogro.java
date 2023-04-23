package com.happykids.backend.aplicacion.implServicios;

import com.happykids.backend.aplicacion.iServicios.*;
import com.happykids.backend.aplicacion.implServicios.utilitarios.LogroUtilityService;
import com.happykids.backend.dominio.dto.LogroDTO;
import com.happykids.backend.dominio.entidades.Logro;
import com.happykids.backend.dominio.entidades.Nota;
import com.happykids.backend.persistencia.jpaRepositories.iRepositorioLogro;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.happykids.backend.persistencia.jpaRepositories.iRepositorioLogro;

@Service
@Slf4j
public class ImplServicioLogro implements iServicioLogro {


    @Autowired
    private iRepositorioLogro iRepositorioLogro;

    @Autowired
    private LogroUtilityService logroUtilityService;

    @Override
    public List<Logro> getLogros() {
        log.info("Entrando a {} - getLogros", this.getClass().getName());
        return iRepositorioLogro.findAll();
    }

    @Override
    public Logro findLogroById(Long idLogro) {
        if (idLogro != null)
            return iRepositorioLogro.findLogroByIdLogro(idLogro);
        return null;
    }

    @Override
    public Logro editarLogro(LogroDTO logroDTO) {
        if (logroDTO != null && logroDTO.getIdLogro() != null) {
            if (iRepositorioLogro.findLogroByIdLogro(Long.valueOf(logroDTO.getIdLogro())) != null) {
                return iRepositorioLogro
                        .save((Logro) logroUtilityService
                                .convertDTOtoEntity(logroDTO));
            }
        }
        return null;
    }

    @Override
    public Logro agregarLogro(LogroDTO logroDTO) {
        if (logroDTO != null) {
            logroDTO.setIndActi("true");
            logroDTO.setIndElim("false");
            return this.iRepositorioLogro.save((Logro) logroUtilityService.convertDTOtoEntity(logroDTO));
        }
        return null;
    }

    @Override
    public boolean eliminarLogroPorId(Long idLogro) {
        if (idLogro != null) {
            if (iRepositorioLogro.findLogroByIdLogro(Long.valueOf(idLogro)) != null) {
                iRepositorioLogro.deleteById(Long.valueOf(idLogro));
                return true;
            }
        }
        return false;
    }
}
