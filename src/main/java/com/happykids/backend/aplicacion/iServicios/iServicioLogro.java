package com.happykids.backend.aplicacion.iServicios;
import java.util.List;
import com.happykids.backend.dominio.dto.LogroDTO;
import com.happykids.backend.dominio.entidades.Logro;

public interface iServicioLogro {
    List<Logro> getLogros();
    
    Logro findLogroById(Long Id) ;

    Logro addNewLogro(LogroDTO logroDTO) ;

    Logro updateLogro(LogroDTO logroDTO) ;

    void deleteLogro(LogroDTO logroDTO);

}
