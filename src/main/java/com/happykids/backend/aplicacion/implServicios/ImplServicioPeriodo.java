package com.happykids.backend.aplicacion.implServicios;

import com.happykids.backend.aplicacion.iServicios.iServicioPeriodo;
import com.happykids.backend.aplicacion.implServicios.utilitarios.PeriodoUtilityService;
import com.happykids.backend.dominio.dto.PeriodoDTO;
import com.happykids.backend.dominio.entidades.Nota;
import com.happykids.backend.dominio.entidades.Periodo;
import com.happykids.backend.persistencia.jpaRepositories.iRepositorioPeriodo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ImplServicioPeriodo implements iServicioPeriodo {


    @Autowired
    private iRepositorioPeriodo iRepositorioPeriodo;

    @Autowired
    private PeriodoUtilityService periodoUtilityService;


    @Override
    public List<Periodo> getPeriodos() {
        log.info("Entrando a {} - getPeriodos", this.getClass().getName());
        return iRepositorioPeriodo.findAll();
    }

    @Override
    public Periodo buscarPeriodoPorID(Long Id) {
        if (Id != null)
            return iRepositorioPeriodo.findPeriodoByIdPer(Id);
        return null;
    }

    @Override
    public Periodo agregarPeriodo(PeriodoDTO periodoDTO) {
        if (periodoDTO != null) {
            return this.iRepositorioPeriodo.save((Periodo) periodoUtilityService.convertDTOtoEntity(periodoDTO));
        }
        return null;
    }

    @Override
    public Periodo editarPeriodo(PeriodoDTO periodoDTO) {
        if (periodoDTO != null && periodoDTO.getIdPer() != null) {
            if (iRepositorioPeriodo.findPeriodoByIdPer(Long.valueOf(periodoDTO.getIdPer())) != null) {
                return iRepositorioPeriodo
                        .save((Periodo) periodoUtilityService
                                .convertDTOtoEntity(periodoDTO));
            }
        }
        return null;
    }

    @Override
    public boolean eliminarPeriodoPorId(Long idPeriodo) {
        if (idPeriodo != null) {
            if (iRepositorioPeriodo.findPeriodoByIdPer(Long.valueOf(idPeriodo)) != null) {
                iRepositorioPeriodo.deleteById(Long.valueOf(idPeriodo));
                return true;
            }
        }
        return false;
    }
}