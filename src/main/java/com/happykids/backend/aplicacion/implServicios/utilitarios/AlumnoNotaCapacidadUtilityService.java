package com.happykids.backend.aplicacion.implServicios.utilitarios;

import com.happykids.backend.aplicacion.iServicios.Utilitarios.iUtilityService;
import com.happykids.backend.aplicacion.iServicios.iServicioAlumnoCompetencia;
import com.happykids.backend.aplicacion.iServicios.iServicioCapacidad;
import com.happykids.backend.dominio.dto.AlumnoNotaCapacidadDTO;
import com.happykids.backend.dominio.entidades.AlumnoNotaCapacidad;
import com.happykids.backend.dominio.entidades.AlumnoNotaCapacidadID;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AlumnoNotaCapacidadUtilityService implements iUtilityService {

    @Autowired
    private UtilityService utilityService;

    @Autowired
    private iServicioAlumnoCompetencia iServicioCompetencia;

    @Autowired
    private iServicioCapacidad iServicioCapacidad;

    @Override
    public Object convertEntityToDTO(Object entityObject) {
        AlumnoNotaCapacidad alumnoNotaCapacidad = (AlumnoNotaCapacidad) entityObject;
        log.info("Entrando a {} - convertEntityToDTO", this.getClass().getName());
        return AlumnoNotaCapacidadDTO.builder()
                .idAcompe(String.valueOf(alumnoNotaCapacidad.getAlumnoCompetencia().getIdAcompe()))
                .idCapacidad(String.valueOf(alumnoNotaCapacidad.getCapacidad().getIdCapacidad()))
                .notaCapacidad(String.valueOf(alumnoNotaCapacidad.getNotaCapacidad()))
                .notaCapacidadDesc(alumnoNotaCapacidad.getNotaCapacidadDesc())
                .indActi(String.valueOf(alumnoNotaCapacidad.getIndActi()))
                .usuCreaCapa(alumnoNotaCapacidad.getUsuCreaCapa())
                .fecCreaCapa(utilityService.convertDateToString(alumnoNotaCapacidad.getFecCreaCapa()))
                .usuModiCapa(alumnoNotaCapacidad.getUsuModiCapa())
                .fecModiCapa(utilityService.convertDateToString(alumnoNotaCapacidad.getFecModiCapa()))
                .build();
    }

    @Override
    public Object convertDTOtoEntity(Object dtoObject) {
        AlumnoNotaCapacidadDTO alumnoNotaCapacidadDTO = (AlumnoNotaCapacidadDTO) dtoObject;
        log.info("Entrando a {} - convertDTOtoEntity", this.getClass().getName());

        return AlumnoNotaCapacidad.builder()
                .alumnoNotaCapacidadID(
                        (alumnoNotaCapacidadDTO.getIdAcompe() != null && alumnoNotaCapacidadDTO.getIdCapacidad() != null)
                                ? new AlumnoNotaCapacidadID(
                                NumberUtils.toLong(alumnoNotaCapacidadDTO.getIdAcompe()),
                                NumberUtils.toLong(alumnoNotaCapacidadDTO.getIdCapacidad()))
                                : null
                )
                .alumnoCompetencia(iServicioCompetencia.findAlumnoCompetenciaByIdAcompe(
                        NumberUtils.toLong(alumnoNotaCapacidadDTO.getIdAcompe())))
                .capacidad(iServicioCapacidad.findCapacidadById(
                        NumberUtils.toLong(alumnoNotaCapacidadDTO.getIdCapacidad())))
                .notaCapacidad(Float.valueOf(alumnoNotaCapacidadDTO.getNotaCapacidad()))
                .notaCapacidadDesc(alumnoNotaCapacidadDTO.getNotaCapacidadDesc())
                .indActi(Boolean.valueOf(alumnoNotaCapacidadDTO.getIndActi()))
                .usuCreaCapa(alumnoNotaCapacidadDTO.getUsuCreaCapa())
                .fecCreaCapa(utilityService.convertStringToDate(alumnoNotaCapacidadDTO.getFecCreaCapa()))
                .usuModiCapa(alumnoNotaCapacidadDTO.getUsuModiCapa())
                .fecModiCapa(utilityService.convertStringToDate(alumnoNotaCapacidadDTO.getFecModiCapa()))
                .build();
    }

}
