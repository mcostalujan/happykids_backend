package com.happykids.backend.aplicacion.implServicios.utilitarios;

import org.springframework.beans.factory.annotation.Autowired;

import com.happykids.backend.aplicacion.iServicios.Utilitarios.iUtilityService;
import com.happykids.backend.dominio.dto.AlumnoDTO;
import com.happykids.backend.dominio.entidades.Alumno;

import lombok.extern.slf4j.Slf4j;
@Slf4j
public class AlumnoUtilityService implements iUtilityService{
    
    @Autowired 
    private UtilityService utilityService;

    @Override
    public Object convertEntityToDTO(Object entityObject) {
       Alumno alumno = (Alumno) entityObject;
        log.info("Entrando a {} - convertEntityToDTO", this.getClass().getName());
        return AlumnoDTO.builder()
                .idAlum(String.valueOf(alumno.getIdAlum()))
                .build();
    }

    @Override
    public Object convertDTOtoEntity(Object dtoObject) {
        return null;
    }
}
