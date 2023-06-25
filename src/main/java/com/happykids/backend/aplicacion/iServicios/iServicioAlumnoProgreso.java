package com.happykids.backend.aplicacion.iServicios;

import java.util.List;

import com.happykids.backend.dominio.dto.ConsultasSQL.DetalleAlumnoPorClase;
import com.happykids.backend.dominio.entidades.AlumnoProgreso;
import com.happykids.backend.dominio.dto.AlumnoProgresoDTO;

public interface iServicioAlumnoProgreso {
    List<AlumnoProgreso> getAlumnoProgresosByIdAlumno(Long idAlumno);

    AlumnoProgreso findAlumnoProgresoById(Long idAProgreso);

    AlumnoProgreso addNewAlumnoProgreso(AlumnoProgresoDTO alumnoProgresoDTO);

    List<DetalleAlumnoPorClase> getAlumnosPorClase(String idClase);

    DetalleAlumnoPorClase getDetalleAlumnoByIdClaseAndIdAlumno(String idClase, String idAlumno);

}




