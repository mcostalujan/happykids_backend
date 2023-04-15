package com.happykids.backend.aplicacion.iServicios;

import java.util.List;

import com.happykids.backend.dominio.dto.AlumnoNotaLogroDTO;
import com.happykids.backend.dominio.dto.NotaDTO;
import com.happykids.backend.dominio.entidades.Nota;
public interface iServicioNota {
    List<NotaDTO> getNotas();
    
    NotaDTO findNotaById(Long Id) ;

    Nota agregarNota(NotaDTO notaDTO) ;

    NotaDTO editarNota(NotaDTO notaDTO) ;

    void eliminarNotaPorId(Long idNota);
    
    /*AlumnoCompetencia register(String nombre);*/
}
