package com.happykids.backend.aplicacion.iServicios;
import java.util.List;
import com.happykids.backend.dominio.dto.CapacidadDTO;
import com.happykids.backend.dominio.entidades.Capacidad;

public interface iServicioCapacidad {
    List<Capacidad> getcapacidads();
    
    Capacidad findcapacidadById(Long idcapacidad) ;

    Capacidad editarcapacidad(CapacidadDTO capacidadDTO) ;

    Capacidad agregarcapacidad(CapacidadDTO capacidadDTO) ;

    boolean eliminarcapacidadPorId(Long idcapacidad);

}
