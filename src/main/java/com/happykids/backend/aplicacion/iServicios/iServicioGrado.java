package com.happykids.backend.aplicacion.iServicios;
import com.happykids.backend.dominio.dto.ConsultasSQL.GradoDisponible;
import com.happykids.backend.dominio.dto.ConsultasSQL.NivelDisponible;
import com.happykids.backend.dominio.dto.GradoDTO;
import com.happykids.backend.dominio.entidades.Grado;
import java.util.List;
public interface iServicioGrado {
    List<Grado> getGrados();
    
    Grado buscarGradoPorId(Long idGrado);

    List<GradoDisponible> getGradosDisponiblesByNivel(String idNivel);
}

