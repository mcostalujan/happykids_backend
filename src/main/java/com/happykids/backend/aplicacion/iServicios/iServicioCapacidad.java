package com.happykids.backend.aplicacion.iServicios;
import java.util.List;
import com.happykids.backend.dominio.dto.CapacidadDTO;
import com.happykids.backend.dominio.entidades.Capacidad;

public interface iServicioCapacidad {
    List<Capacidad> getCapacidades();
    
    Capacidad findCapacidadById (Long idCapacidad) ;

    Capacidad editarCapacidad (CapacidadDTO capacidadDTO) ;

    Capacidad agregarCapacidad (CapacidadDTO capacidadDTO) ;

    boolean eliminarCapacidadPorId (Long idCapacidad);

}
