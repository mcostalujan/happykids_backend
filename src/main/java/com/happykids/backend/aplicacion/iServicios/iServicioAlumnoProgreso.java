package com.happykids.backend.aplicacion.iServicios;
import java.util.List;

import com.happykids.backend.dominio.entidades.AlumnoProgreso;
import com.happykids.backend.dominio.dto.AlumnoProgresoDTO;
public interface iServicioAlumnoProgreso {
    List<AlumnoProgreso> getAlumnoProgresos();
    
    AlumnoProgreso findAlumnoProgresoById(Long ID) ;

    AlumnoProgreso addNewAlumnoProgreso(AlumnoProgresoDTO alumnoProgresoDTO);

}




