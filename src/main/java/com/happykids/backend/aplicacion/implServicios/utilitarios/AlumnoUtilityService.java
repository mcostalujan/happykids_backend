package com.happykids.backend.aplicacion.implServicios.utilitarios;

import com.happykids.backend.dominio.dto.LogroDTO;
import com.happykids.backend.dominio.entidades.Logro;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.happykids.backend.aplicacion.iServicios.Utilitarios.iUtilityService;
import com.happykids.backend.dominio.dto.AlumnoDTO;
import com.happykids.backend.dominio.entidades.Alumno;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AlumnoUtilityService implements iUtilityService {

    @Autowired
    private UtilityService utilityService;

    @Override
    public Object convertEntityToDTO(Object entityObject) {
        Alumno alumno = (Alumno) entityObject;
        log.info("Entrando a {} - convertEntityToDTO", this.getClass().getName());
        return AlumnoDTO.builder()
                .idAlum(String.valueOf(alumno.getIdAlum()))
                .fechaIngresoAlum(utilityService.convertDateToString(alumno.getFechaIngresoAlum()))
                .codigoAlum(alumno.getCodigoAlum())
                .val1NameAlum(alumno.getVal1NameAlum())
                .val2NameAlum(alumno.getVal2NameAlum())
                .val3NameAlum(alumno.getVal3NameAlum())
                .val4NameAlum(alumno.getVal4NameAlum())
                .varLastPatAlum(alumno.getVarLastPatAlum())
                .valLastMatAlum(alumno.getValLastMatAlum())
                .isActiveAlumn(String.valueOf(alumno.getIsActiveAlumn()))
                .usuCreaAlum(alumno.getUsuCreaAlum())
                .fecCreaAlum(utilityService.convertDateToString(alumno.getFecCreaAlum()))
                .usuModiAlum(alumno.getUsuModiAlum())
                .fecModiAlum(utilityService.convertDateToString(alumno.getFecModiAlum()))
                .build();
    }

    @Override
    public Object convertDTOtoEntity(Object dtoObject) {
        AlumnoDTO alumnoDTO = (AlumnoDTO) dtoObject;

        log.info("Entrando a {} - convertDTOtoEntity", this.getClass().getName());
        return Alumno.builder()
                .idAlum(NumberUtils.toLong(alumnoDTO.getIdAlum()))
                .fechaIngresoAlum(utilityService.convertStringToDate(alumnoDTO.getFechaIngresoAlum()))
                .codigoAlum(alumnoDTO.getCodigoAlum())
                .val1NameAlum(alumnoDTO.getVal1NameAlum())
                .val2NameAlum(alumnoDTO.getVal2NameAlum())
                .val3NameAlum(alumnoDTO.getVal3NameAlum())
                .val4NameAlum(alumnoDTO.getVal4NameAlum())
                .varLastPatAlum(alumnoDTO.getVarLastPatAlum())
                .valLastMatAlum(alumnoDTO.getValLastMatAlum())
                .isActiveAlumn(Boolean.valueOf(alumnoDTO.getIsActiveAlumn()))
                .usuCreaAlum(alumnoDTO.getUsuCreaAlum())
                .fecCreaAlum(utilityService.convertStringToDate(alumnoDTO.getFecCreaAlum()))
                .usuModiAlum(alumnoDTO.getUsuModiAlum())
                .fecModiAlum(utilityService.convertStringToDate(alumnoDTO.getFecModiAlum()))
                .build();
    }
}
