package com.happykids.backend.aplicacion.implServicios;

import com.happykids.backend.aplicacion.iServicios.*;
import com.happykids.backend.aplicacion.implServicios.utilitarios.AlumnoNotaCapacidadUtilityService;
import com.happykids.backend.dominio.dto.AlumnoNotaCapacidadDTO;
import com.happykids.backend.dominio.dto.ConsultasSQL.DetalleAlumnoCapacidad;
import com.happykids.backend.dominio.dto.ConsultasSQL.DetalleAlumnoCompetencia;
import com.happykids.backend.dominio.entidades.AlumnoNotaCapacidad;
import com.happykids.backend.dominio.entidades.ClaseDocente;
import com.happykids.backend.persistencia.jpaRepositories.iRepositorioAlumnoNotaCapacidad;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import java.util.List;

@Service
@Slf4j
public class ImplServicioAlumnoNotaCapacidad implements iServicioAlumnoNotaCapacidad {


    @Autowired
    private iRepositorioAlumnoNotaCapacidad iRepositorioAlumnoNotaCapacidad;

    @Autowired
    private AlumnoNotaCapacidadUtilityService alumnoNotaCapacidadUtilityService;

    @Override
    public List<AlumnoNotaCapacidad> getAlumnosNotaCapacidad() {
        return this.iRepositorioAlumnoNotaCapacidad.findAll();
    }

    @Override
    public AlumnoNotaCapacidad findAlumnoNotaCapacidadById(Long idAcompe, Long idCapacidad) {
        if (idAcompe != null && idCapacidad != null)
            return iRepositorioAlumnoNotaCapacidad
                    .findAlumnoNotaCapacidadByAlumnoNotaCapacidadID_IdAcompeAndAlumnoNotaCapacidadID_IdCapacidad
                            (idAcompe, idCapacidad);
        return null;
    }

    @Override
    public AlumnoNotaCapacidad createAlumnoNotaCapacidad(AlumnoNotaCapacidadDTO alumnoNotaCapacidadDTO) {
        if (alumnoNotaCapacidadDTO != null) {
            alumnoNotaCapacidadDTO.setIndActi("true");
            AlumnoNotaCapacidad newAlumnoNotaCapacidad = (AlumnoNotaCapacidad) alumnoNotaCapacidadUtilityService
                    .convertDTOtoEntity(alumnoNotaCapacidadDTO);
            return this.iRepositorioAlumnoNotaCapacidad.save(newAlumnoNotaCapacidad);
        }
        return null;
    }

    @Override
    public AlumnoNotaCapacidad updateAlumnoNotaCapacidad(AlumnoNotaCapacidadDTO alumnoNotaCapacidadDTO) {
        if (alumnoNotaCapacidadDTO != null && alumnoNotaCapacidadDTO.getIdAcompe() != null && alumnoNotaCapacidadDTO.getIdCapacidad() != null) {
            AlumnoNotaCapacidad alumnoNotaCapacidadActual = this.findAlumnoNotaCapacidadById(
                    NumberUtils.toLong(alumnoNotaCapacidadDTO.getIdAcompe()),
                    NumberUtils.toLong(alumnoNotaCapacidadDTO.getIdCapacidad()));
            if (alumnoNotaCapacidadActual != null) {
                AlumnoNotaCapacidad alumnoNotaCapacidadToUpdate = (AlumnoNotaCapacidad) alumnoNotaCapacidadUtilityService
                        .convertDTOtoEntity(alumnoNotaCapacidadDTO);
                return iRepositorioAlumnoNotaCapacidad.save(alumnoNotaCapacidadToUpdate);
            }
        }
        return null;
    }

    @Override
    public List<DetalleAlumnoCapacidad> getDetalleCapacidadPorAcompe(String idAcompe) {
        log.info("Entrando a {} - getDetalleCapacidadPorAcompe", this.getClass().getName());
        return iRepositorioAlumnoNotaCapacidad.getDetalleCapacidadPorAcompe(idAcompe)
                .stream()
                .map(DetalleAlumnoCapacidad::convertTupleToEntity).toList();
    }

    @Override
    public AlumnoNotaCapacidad updateNotaCapa(String idAcompe, String idCapacidad, String notaCapacidad) {
        if (idAcompe != null && idCapacidad != null && notaCapacidad != null) {
            AlumnoNotaCapacidad alumnoNotaCapacidadActual = this.findAlumnoNotaCapacidadById(
                    NumberUtils.toLong(idAcompe),
                    NumberUtils.toLong(idCapacidad));
            if (alumnoNotaCapacidadActual != null) {
                alumnoNotaCapacidadActual.setNotaCapacidad(NumberUtils.toFloat(notaCapacidad));
                return iRepositorioAlumnoNotaCapacidad.save(alumnoNotaCapacidadActual);
            }
        }
        return null;
    }

    @Override
    public void calculoPromedioCapacidadadesPorIdClaseIdAprog(String idClase, String idAprog) {
        log.info("Entrando a {} - calculoPromedioCapacidadadesPorIdClaseIdAprog", 
        this.getClass().getName());
        iRepositorioAlumnoNotaCapacidad.calculoPromedioCapacidadadesPorIdClaseIdAprog(idClase, idAprog);
           
    }
}
