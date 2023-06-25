package com.happykids.backend.aplicacion.iServicios;

import java.util.List;

import com.happykids.backend.dominio.dto.AlumnoNotaCapacidadDTO;
import com.happykids.backend.dominio.dto.ConsultasSQL.DetalleAlumnoCapacidad;
import com.happykids.backend.dominio.entidades.AlumnoNotaCapacidad;

public interface iServicioAlumnoNotaCapacidad {
    List<AlumnoNotaCapacidad> getAlumnosNotaCapacidad();

    AlumnoNotaCapacidad findAlumnoNotaCapacidadById(Long idAcompe, Long idCapacidad);

    AlumnoNotaCapacidad createAlumnoNotaCapacidad(AlumnoNotaCapacidadDTO alumnoNotaCapacidadDTO);

    AlumnoNotaCapacidad updateAlumnoNotaCapacidad(AlumnoNotaCapacidadDTO alumnoNotaCapacidadDTO);

    List<DetalleAlumnoCapacidad> getDetalleCapacidadPorAcompe(String idAcompe);

    AlumnoNotaCapacidad updateNotaCapa(String idAcompe, String idCapacidad, String notaCapacidad);

    void calculoPromedioCapacidadadesPorIdClaseIdAprog(String idClase, String idAprog);

//    List<DetalleClasesDocente> getClasesByDocenteAndPeriodo(String idDocente, String idPer);
}
