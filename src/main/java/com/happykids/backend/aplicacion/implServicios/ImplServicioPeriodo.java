package com.happykids.backend.aplicacion.implServicios;
import com.happykids.backend.aplicacion.iServicios.*;
import com.happykids.backend.dominio.dto.PeriodoDTO;
import com.happykids.backend.dominio.entidades.Periodo;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ImplServicioPeriodo implements iServicioPeriodo{

    @Override
    public List<Periodo> getPeriodos() {
        return null;
    }

    @Override
    public Periodo findPeriodosById(Long Id) {
        return null;
    }

    @Override
    public Periodo addNewPeriodo(PeriodoDTO periodoDTO) {
        return null;
    }

    @Override
    public Periodo updatePeriodo(PeriodoDTO periodoDTO) {
        return null;
    }

    @Override
    public void deletePeriodo(PeriodoDTO periodoDTO) {

    }
}