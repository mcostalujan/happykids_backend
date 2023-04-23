package com.happykids.backend.aplicacion.implServicios;

import com.happykids.backend.aplicacion.iServicios.iServicioAlumno;
import com.happykids.backend.dominio.dto.AlumnoDTO;
import com.happykids.backend.dominio.entidades.Alumno;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ImplServicioAlumno implements iServicioAlumno {
   @Override
   public List<Alumno> getAlumnos() {
       return null;
   }

   @Override
   public Alumno findAlumnoById(Long idAlum) {
       return null;
   }

   @Override
   public Alumno agregarAlumno(AlumnoDTO alumnoDTO) {
       return null;
   }

   @Override
   public Alumno editarAlumno(AlumnoDTO alumnoDTO) {
       return null;
   }

   @Override
   public void eliminarAlumnoPorId(Long idAlum) {

   }
}
