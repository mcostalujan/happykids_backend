package com.happykids.backend.aplicacion.iServicios;
import com.happykids.backend.dominio.dto.GradoDTO;
import com.happykids.backend.dominio.entidades.Grado;
import java.util.List;
public interface iServicioGrado {
    List<GradoDTO> getGrados();
    
    GradoDTO buscarGradoPorId(Long idGrado);
}

