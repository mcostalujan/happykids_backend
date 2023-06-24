package com.happykids.backend.aplicacion.implServicios.utilitarios;

import com.happykids.backend.aplicacion.iServicios.Utilitarios.iUtilityService;
import com.happykids.backend.aplicacion.implServicios.ImplServicioAlumnoProgreso;
import com.happykids.backend.aplicacion.implServicios.ImplServicioCompetencia;
import com.happykids.backend.dominio.dto.AlumnoCompetenciaDTO;
import com.happykids.backend.dominio.entidades.AlumnoCompetencia;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
                .idAcompe(String.valueOf(alumnoCompetencia.getIdAcompe()))
                .codAcompe(alumnoCompetencia.getCodAcompe())
                .idAprog(String.valueOf(alumnoCompetencia.getAlumnoProgreso().getIdAprog()))
                .idCompe(String.valueOf(alumnoCompetencia.getCompetencia().getIdCompe()))
                .usuCreaCompe(alumnoCompetencia.getUsuCreaCompe())
                .fecCreaCompe(utilityService.convertDateToString(alumnoCompetencia.getFecCreaCompe()))
                .usuModiCompe(alumnoCompetencia.getUsuModiCompe())
                .fecModiCompe(utilityService.convertDateToString(alumnoCompetencia.getFecModiCompe()))
                .valPromLogro(String.valueOf(alumnoCompetencia.getValPromLogro()))
                .valPromLogroDesc(alumnoCompetencia.getValPromLogroDesc())
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
//                .alumnoCompetenciaID((alumnoCompetenciaDTO.getIdCompe()!=null
//                && alumnoCompetenciaDTO.getIdCompe()!=null)
//                ?new AlumnoCompetenciaID
//                (
//                    NumberUtils.toLong(alumnoCompetenciaDTO.getIdAprog()),
//                    NumberUtils.toLong(alumnoCompetenciaDTO.getIdCompe()))
//                    :null
//
//                )
                .idAcompe(NumberUtils.toLong(alumnoCompetenciaDTO.getIdAcompe()))
                .codAcompe(alumnoCompetenciaDTO.getCodAcompe())
                .usuCreaCompe(alumnoCompetenciaDTO.getUsuCreaCompe())
                .fecCreaCompe(utilityService.convertStringToDate(alumnoCompetenciaDTO.getFecCreaCompe()))
                .usuModiCompe(alumnoCompetenciaDTO.getUsuModiCompe())
                .fecModiCompe(utilityService.convertStringToDate(alumnoCompetenciaDTO.getFecModiCompe()))
                .valPromLogro(Float.valueOf(alumnoCompetenciaDTO.getValPromLogro()))
                .valPromLogroDesc(alumnoCompetenciaDTO.getValPromLogroDesc())
                .indActi(Boolean.valueOf(alumnoCompetenciaDTO.getIndActi()))
                .build();
    }
}
