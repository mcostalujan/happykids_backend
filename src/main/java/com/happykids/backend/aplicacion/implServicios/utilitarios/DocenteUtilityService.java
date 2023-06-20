package com.happykids.backend.aplicacion.implServicios.utilitarios;

import com.happykids.backend.aplicacion.iServicios.Utilitarios.iUtilityService;
import com.happykids.backend.dominio.dto.ClaseDTO;
import com.happykids.backend.dominio.dto.DocenteDTO;
import com.happykids.backend.dominio.entidades.Clase;
import com.happykids.backend.dominio.entidades.ClaseEstatus;
import com.happykids.backend.dominio.entidades.Docente;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DocenteUtilityService implements iUtilityService {

    @Autowired
    private UtilityService utilityService;

    @Override
    public Object convertEntityToDTO(Object entityObject) {
        Docente docente = (Docente) entityObject;
        log.info("Entrando a {} - convertEntityToDTO", this.getClass().getName());
        return DocenteDTO.builder()
                .idDoc(String.valueOf((docente.getIdDoc())))
                .codigoDoc(docente.getCodigoDoc())
                .val1NameDoc(docente.getVal1NameDoc())
                .val2NameDoc(docente.getVal2NameDoc())
                .val3NameDoc(docente.getVal3NameDoc())
                .val4NameDoc(docente.getVal4NameDoc())
                .valLastPatDoc(docente.getValLastPatDoc())
                .valLastMatDoc(docente.getValLastMatDoc())
                .indActiDoc(String.valueOf(docente.getIndActiDoc()))
                .usuCreaDoc(docente.getUsuCreaDoc())
                .fecCreaDoc(utilityService.convertDateToString(docente.getFecCreaDoc()))
                .usuModiDoc(docente.getUsuModiDoc())
                .fecModiDoc(utilityService.convertDateToString(docente.getFecModiDoc()))
                .build();
    }

    @Override
    public Object convertDTOtoEntity(Object dtoObject) {
        DocenteDTO docenteDTO = (DocenteDTO) dtoObject;
        log.info("Entrando a {} - convertDTOtoEntity", this.getClass().getName());
        return Docente.builder()
                .idDoc(NumberUtils.toLong(docenteDTO.getIdDoc()))
                .codigoDoc(docenteDTO.getCodigoDoc())
                .val1NameDoc(docenteDTO.getVal1NameDoc())
                .val2NameDoc(docenteDTO.getVal2NameDoc())
                .val3NameDoc(docenteDTO.getVal3NameDoc())
                .val4NameDoc(docenteDTO.getVal4NameDoc())
                .valLastPatDoc(docenteDTO.getValLastPatDoc())
                .valLastMatDoc(docenteDTO.getValLastMatDoc())
                .indActiDoc(Boolean.valueOf(docenteDTO.getIndActiDoc()))
                .usuCreaDoc(docenteDTO.getUsuCreaDoc())
                .fecCreaDoc(utilityService.convertStringToDate(docenteDTO.getFecCreaDoc()))
                .usuModiDoc(docenteDTO.getUsuModiDoc())
                .fecModiDoc(utilityService.convertStringToDate(docenteDTO.getFecModiDoc()))
                .build();
    }
}
