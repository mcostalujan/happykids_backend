package com.happykids.backend.aplicacion.iServicios;
import java.util.List;

import com.happykids.backend.dominio.dto.CompetenciaDTO;
import com.happykids.backend.dominio.entidades.Competencia;

public interface iServicioCompetencia {
    List<Competencia> getCompetencias();
    
    Competencia findCompetenciaById(Long Id) ;

    Competencia agregarCompetencia(CompetenciaDTO competenciaDTO) ;

    void deleteCompetencia(CompetenciaDTO competenciaDTO) ;
    
}




