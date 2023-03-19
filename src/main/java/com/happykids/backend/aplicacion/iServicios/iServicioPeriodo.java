package com.happykids.backend.aplicacion.iServicios;
import java.util.List;

import com.happykids.backend.dominio.dto.PeriodoDTO;
import com.happykids.backend.dominio.entidades.Periodo;
public interface iServicioPeriodo {
    List<Periodo> getPeriodos();
    
    Periodo findPeriodosById(Long Id) ;

    Periodo addNewPeriodo(PeriodoDTO periodoDTO) ;

    Periodo updatePeriodo(PeriodoDTO periodoDTO) ;

    void deletePeriodo(PeriodoDTO periodoDTO);
    
    /*AlumnoCompetencia register(String nombre);*/
}
