package com.happykids.backend.aplicacion.iServicios;
import com.happykids.backend.dominio.entidades.Grado;
import java.util.List;
public interface iServicioGrado {
    List<Grado> getGrados();
    
    Grado findGradosById(Long Id);
}

