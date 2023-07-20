package com.happykids.backend.aplicacion.iServicios;
import java.util.List;

import com.happykids.backend.dominio.dto.PeriodoDTO;
import com.happykids.backend.dominio.entidades.Periodo;
public interface iServicioPeriodo {
    List<Periodo> getPeriodos();
    
    Periodo buscarPeriodoPorID (Long Id) ;

    Periodo agregarPeriodo(PeriodoDTO periodoDTO) ;

    Periodo editarPeriodo(PeriodoDTO periodoDTO) ;

    boolean eliminarPeriodoPorId(Long idPeriodo);

    List<Object> getYearsDisponibles();
}
