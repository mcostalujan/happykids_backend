package com.happykids.backend.aplicacion.implServicios;

import com.happykids.backend.aplicacion.iServicios.iServicioAlumno;
import com.happykids.backend.dominio.dto.AlumnoDTO;
import com.happykids.backend.dominio.entidades.Alumno;

import java.util.List;

public class ImplServicioAlumno implements iServicioAlumno {
    @Override
    public List<Alumno> getAlumnos() {
        return null;
    }

    @Override
    public Alumno findAlumnoByNombre(Long idAlum) {
        return null;
    }

    @Override
    public Alumno addNewAlumno(AlumnoDTO alumnoDTO) {
        return null;
    }

    @Override
    public Alumno updateAlumno(AlumnoDTO alumnoDTO) {
        return null;
    }

    @Override
    public void deleteAlumno(AlumnoDTO alumnoDTO) {

    }
}
