package com.happykids.backend.aplicacion.iServicios;
import com.happykids.backend.dominio.dto.AlumnoCompetenciaDTO;
import com.happykids.backend.dominio.dto.ConsultasSQL.DetalleAlumnoCompetencia;
import com.happykids.backend.dominio.dto.ConsultasSQL.DetalleAlumnoPorClase;
import com.happykids.backend.dominio.entidades.AlumnoCompetencia;

import java.util.List;

public interface iServicioAlumnoCompetencia {
    List<AlumnoCompetencia> getAlumnoCompetencias();

    AlumnoCompetencia findAlumnoCompetenciaByIdAcompe(Long idAcompe);
    
    AlumnoCompetencia createAlumnoCompetencia(AlumnoCompetenciaDTO AlumnoCompetenciaDTO);
    
    AlumnoCompetencia updateAlumnoCompetencia(AlumnoCompetenciaDTO AlumnoCompetenciaDTO);

    List<DetalleAlumnoCompetencia> getDetalleACompeByIdClaseAndIdAlumno(String idClase, String idAlumno);
}

