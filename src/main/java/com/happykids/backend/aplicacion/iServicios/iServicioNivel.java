package com.happykids.backend.aplicacion.iServicios;
import java.util.List;

import com.happykids.backend.dominio.dto.NivelDTO;
import com.happykids.backend.dominio.entidades.Nivel;
public interface iServicioNivel {
    List<Nivel> getNiveles();
    
    Nivel findNivel(Long idNivel) ;
    
}
