package com.happykids.backend.aplicacion.iServicios;

import java.util.List;

import com.happykids.backend.dominio.dto.AlumnoNotaLogroDTO;
import com.happykids.backend.dominio.entidades.Nota;
public interface iServicioNota {
    List<Nota> getNotas();
    
    Nota findNotaById(Long Id) ;

    Nota addNewNota(AlumnoNotaLogroDTO alumnoNotaLogroDTO) ;

    Nota updateNota(AlumnoNotaLogroDTO alumnoNotaLogroDTO) ;

    void deleteNota(AlumnoNotaLogroDTO alumnoNotaLogroDTO);
    
    /*AlumnoCompetencia register(String nombre);*/
}
