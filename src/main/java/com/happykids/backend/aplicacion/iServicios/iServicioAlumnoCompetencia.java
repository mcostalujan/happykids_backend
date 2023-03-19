package com.happykids.backend.aplicacion.iServicios;

import java.util.List;

import com.happykids.backend.dominio.dto.AlumnoCompetenciaDTO;
import com.happykids.backend.dominio.entidades.AlumnoCompetencia;

public interface iServicioAlumnoCompetencia {
    List<AlumnoCompetenciaDTO> getAlumnoCompetencias();
    
    AlumnoCompetencia findAlumnoByNombre(Long alumnoCompetenciaID) ;

    AlumnoCompetencia addNewAlumnoCompetencia(AlumnoCompetenciaDTO alumnoCompetenciaDTO) ;

    /*void deleteAlumnoCompetencia(String nombre);*/
    
    /*AlumnoCompetencia register(String nombre);*/
}


