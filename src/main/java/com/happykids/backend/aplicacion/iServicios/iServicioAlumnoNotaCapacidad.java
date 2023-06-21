package com.happykids.backend.aplicacion.iServicios;

import java.util.List;

import com.happykids.backend.dominio.dto.AlumnoNotaCapacidadDTO;
import com.happykids.backend.dominio.entidades.AlumnoNotaCapacidad;

public interface iServicioAlumnoNotaCapacidad {
    List<AlumnoNotaCapacidadDTO> getAlumnoNotaCapacidad();
    
    AlumnoNotaCapacidad findAlumnoByNombre() ;

    AlumnoNotaCapacidad addNewAlumnoNotaCapacidad(String nombre, String idUser) ;

    AlumnoNotaCapacidad updateAlumnoNotaCapacidad(String currentNombre, String newNombre, String idUser) ;

    void deleteAlumnoNotaCapacidad(String nombre);
    
    /*AlumnoCompetencia register(String nombre);*/
}
