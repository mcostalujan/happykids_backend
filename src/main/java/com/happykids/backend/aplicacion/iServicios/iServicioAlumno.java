package com.happykids.backend.aplicacion.iServicios;
import java.util.List;

import com.happykids.backend.dominio.dto.AlumnoDTO;
import com.happykids.backend.dominio.entidades.Alumno;
public interface iServicioAlumno {

    List<Alumno> getAlumnos();
    
    Alumno findAlumnoByNombre(Long idAlum) ;

    Alumno addNewAlumno(AlumnoDTO alumnoDTO);

    Alumno updateAlumno(AlumnoDTO alumnoDTO) ;
    

    void deleteAlumno(AlumnoDTO alumnoDTO) ;


    /*ByteArrayInputStream exportarPiechartPopCursos(BufferedImage bufferedImage);*/
}



