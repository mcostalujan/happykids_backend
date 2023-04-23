package com.happykids.backend.aplicacion.iServicios;
import java.util.List;
import com.happykids.backend.dominio.dto.LogroDTO;
import com.happykids.backend.dominio.entidades.Logro;

public interface iServicioLogro {
    List<Logro> getLogros();
    
    Logro findLogroById(Long idLogro) ;

    Logro editarLogro(LogroDTO logroDTO) ;

    Logro agregarLogro(LogroDTO logroDTO) ;

    void eliminarLogroPorId(LogroDTO logroDTO);

}
