package com.happykids.backend.aplicacion.iServicios;
import java.util.List;

import com.happykids.backend.dominio.dto.SeccionDTO;
import com.happykids.backend.dominio.entidades.Seccion;
public interface iServicioSeccion {
    List<Seccion> getSecciones();
    
    Seccion findSeccionById(Long Id) ;

    Seccion addNewSeccion(SeccionDTO seccionDTO) ;

    Seccion updateSeccion(SeccionDTO seccionDTO) ;

    boolean deleteSeccion(Long idSeccion);
    
    /*AlumnoCompetencia register(String nombre);*/
}
