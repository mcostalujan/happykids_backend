package com.happykids.backend.aplicacion.iServicios;

import java.util.List;

import com.happykids.backend.dominio.dto.AlumnoNotaLogroDTO;
import com.happykids.backend.dominio.entidades.AlumnoNotaLogro;

public interface iServicioAlumnoNotaLogro {
    List<AlumnoNotaLogroDTO> getAlumnoNotaLogros();
    
    AlumnoNotaLogro findAlumnoByNombre() ;

    AlumnoNotaLogro addNewAlumnoNotaLogro(String nombre, String idUser) ;

    AlumnoNotaLogro updateAlumnoNotaLogro(String currentNombre, String newNombre, String idUser) ;

    void deleteAlumnoNotaLogro(String nombre);
    
    /*AlumnoCompetencia register(String nombre);*/
}
