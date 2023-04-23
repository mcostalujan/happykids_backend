package com.happykids.backend.aplicacion.iServicios;
import java.util.List;

import com.happykids.backend.dominio.dto.AlumnoDTO;
import com.happykids.backend.dominio.entidades.Alumno;
public interface iServicioAlumno {

    List<Alumno> getAlumnos();
    
    Alumno findAlumnoById(Long idAlum) ;

    Alumno agregarAlumno(AlumnoDTO alumnoDTO);

    Alumno editarAlumno(AlumnoDTO alumnoDTO) ;
    
    boolean eliminarAlumnoPorId(Long idAlumno) ;
}



