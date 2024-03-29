package com.happykids.backend.aplicacion.iServicios;
import java.util.List;

import com.happykids.backend.dominio.dto.ConsultasSQL.NivelDisponible;
import com.happykids.backend.dominio.dto.ConsultasSQL.SeccionDisponible;
import com.happykids.backend.dominio.dto.SeccionDTO;
import com.happykids.backend.dominio.entidades.Seccion;
public interface iServicioSeccion {
    List<Seccion> getSecciones();
    
    Seccion findSeccionById(Long Id) ;

    Seccion addNewSeccion(SeccionDTO seccionDTO) ;

    Seccion updateSeccion(SeccionDTO seccionDTO) ;

    boolean deleteSeccion(Long idSeccion);

    List<SeccionDisponible> getSeccionesDisponiblesByNivelAndGrado(String idNivel, String idGrado);
    
    /*AlumnoCompetencia register(String nombre);*/
}
