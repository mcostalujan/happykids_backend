package com.happykids.backend.aplicacion.implServicios.utilitarios;

import com.happykids.backend.dominio.dto.CapacidadDTO;
import com.happykids.backend.dominio.entidades.Capacidad;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.happykids.backend.aplicacion.iServicios.Utilitarios.iUtilityService;
import com.happykids.backend.aplicacion.implServicios.ImplServicioAlumnoCompetencia;
import com.happykids.backend.aplicacion.implServicios.ImplServicioAlumnoProgreso;
import com.happykids.backend.aplicacion.implServicios.ImplServicioCompetencia;
import com.happykids.backend.dominio.dto.AlumnoCompetenciaDTO;
import com.happykids.backend.dominio.dto.AlumnoDTO;
import com.happykids.backend.dominio.entidades.Alumno;
import com.happykids.backend.dominio.entidades.AlumnoCompetencia;
import com.happykids.backend.dominio.entidades.AlumnoCompetenciaID;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AlumnoCompetenciaUtilityService implements iUtilityService {
    
    @Autowired
    private UtilityService utilityService;
    @Autowired
    private ImplServicioAlumnoProgreso ImplServicioAlumnoProgreso;
    @Autowired
    private ImplServicioCompetencia ImplServicioCompetencia;

    @Override
    public Object convertEntityToDTO(Object entityObject) {
        AlumnoCompetencia alumnoCompetencia = (AlumnoCompetencia) entityObject;
        log.info("Entrando a {} - convertEntityToDTO", this.getClass().getName());
        return AlumnoCompetenciaDTO.builder()

                .idAprog(String.valueOf(alumnoCompetencia.getAlumnoProgreso().getIdAprog()))
                .idCompe(String.valueOf(alumnoCompetencia.getCompetencia().getIdCompe()))
                .usuCreaCompe(alumnoCompetencia.getUsuCreaCompe())
                .fecCreaCompe(utilityService.convertDateToString(alumnoCompetencia.getFecCreaCompe()))
                .usuModiCompe(alumnoCompetencia.getUsuModiCompe())
                .fecModiCompe(utilityService.convertDateToString(alumnoCompetencia.getFecModiCompe()))
                .valPromedio(String.valueOf(alumnoCompetencia.getValPromedio()))
                .valPromedioDesc(alumnoCompetencia.getValPromedioDesc())
                .indActi(String.valueOf(alumnoCompetencia.getIndActi()))
                .build();
    }

    @Override
    public Object convertDTOtoEntity(Object dtoObject) {
        AlumnoCompetenciaDTO alumnoCompetenciaDTO = (AlumnoCompetenciaDTO) dtoObject;

        log.info("Entrando a {} - convertDTOtoEntity", this.getClass().getName());
        return AlumnoCompetencia.builder()
                .alumnoProgreso(ImplServicioAlumnoProgreso.findAlumnoProgresoById
                (NumberUtils.toLong(alumnoCompetenciaDTO.getIdAprog())))
                .competencia(ImplServicioCompetencia.findCompetenciaById
                (NumberUtils.toLong(alumnoCompetenciaDTO.getIdAprog())))
                .alumnoCompetenciaID((alumnoCompetenciaDTO.getIdCompe()!=null
                && alumnoCompetenciaDTO.getIdCompe()!=null)
                ?new AlumnoCompetenciaID
                (
                    NumberUtils.toLong(alumnoCompetenciaDTO.getIdAprog()),
                    NumberUtils.toLong(alumnoCompetenciaDTO.getIdCompe()))
                    :null
                    
                )

                .usuCreaCompe(alumnoCompetenciaDTO.getUsuCreaCompe())
                .fecCreaCompe(utilityService.convertStringToDate(alumnoCompetenciaDTO.getFecCreaCompe()))
                .usuModiCompe(alumnoCompetenciaDTO.getUsuModiCompe())
                .fecModiCompe(utilityService.convertStringToDate(alumnoCompetenciaDTO.getFecModiCompe()))
                .valPromedio(Float.valueOf(alumnoCompetenciaDTO.getValPromedio()))
                .valPromedioDesc(alumnoCompetenciaDTO.getValPromedioDesc())
                .indActi(Boolean.valueOf(alumnoCompetenciaDTO.getIndActi()))
                .build();
    }
}
