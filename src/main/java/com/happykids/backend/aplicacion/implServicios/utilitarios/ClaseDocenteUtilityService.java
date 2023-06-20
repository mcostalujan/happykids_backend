package com.happykids.backend.aplicacion.implServicios.utilitarios;

import com.happykids.backend.aplicacion.iServicios.Utilitarios.iUtilityService;
import com.happykids.backend.aplicacion.iServicios.iServicioClase;
import com.happykids.backend.aplicacion.iServicios.iServicioDocente;
import com.happykids.backend.dominio.dto.ClaseDTO;
import com.happykids.backend.dominio.dto.ClaseDocenteDTO;
import com.happykids.backend.dominio.entidades.Clase;
import com.happykids.backend.dominio.entidades.ClaseDocente;
import com.happykids.backend.dominio.entidades.ClaseDocenteID;
import com.happykids.backend.dominio.entidades.ClaseEstatus;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ClaseDocenteUtilityService implements iUtilityService {

    @Autowired
    private UtilityService utilityService;

    @Autowired
    private iServicioDocente iServicioDocente;

    @Autowired
    private iServicioClase iServicioClase;

    @Override
    public Object convertEntityToDTO(Object entityObject) {
        ClaseDocente claseDocente = (ClaseDocente) entityObject;
        log.info("Entrando a {} - convertEntityToDTO", this.getClass().getName());
        return ClaseDocenteDTO.builder()
                .idClase(String.valueOf(claseDocente.getClaseDocenteID().getIdClase()))
                .idDoc(String.valueOf(claseDocente.getClaseDocenteID().getIdDoc()))
                .indActi(String.valueOf(claseDocente.getIndActi()))
                .usuCreaCladoc(claseDocente.getUsuCreaCladoc())
                .fecCreaCladoc(utilityService.convertDateToString(claseDocente.getFecCreaCladoc()))
                .usuModiCladoc(claseDocente.getUsuModiCladoc())
                .fecModiCladoc(utilityService.convertDateToString(claseDocente.getFecModiCladoc()))
                .build();
    }

    @Override
    public Object convertDTOtoEntity(Object dtoObject) {
        ClaseDocenteDTO claseDocenteDTO = (ClaseDocenteDTO) dtoObject;
        log.info("Entrando a {} - convertDTOtoEntity", this.getClass().getName());

//        if (claseDocenteDTO.getIdClase() != null && claseDocenteDTO.getIdDoc() != null) {
//            ClaseDocenteID claseDocenteID = new ClaseDocenteID(
//                    NumberUtils.toLong(claseDocenteDTO.getIdDoc()),
//                    NumberUtils.toLong(claseDocenteDTO.getIdClase()));
//        }

        return ClaseDocente.builder()
                .claseDocenteID(
                        (claseDocenteDTO.getIdClase() != null && claseDocenteDTO.getIdDoc() != null)
                                ? new ClaseDocenteID(
                                NumberUtils.toLong(claseDocenteDTO.getIdDoc()),
                                NumberUtils.toLong(claseDocenteDTO.getIdClase()))
                                : null
                )
                .docente(iServicioDocente.findDocenteById(NumberUtils.toLong(claseDocenteDTO.getIdDoc())))
                .clase(iServicioClase.findClaseById(NumberUtils.toLong(claseDocenteDTO.getIdClase())))
                .indActi(Boolean.valueOf(claseDocenteDTO.getIndActi()))
                .usuCreaCladoc(claseDocenteDTO.getUsuCreaCladoc())
                .fecCreaCladoc(utilityService.convertStringToDate(claseDocenteDTO.getFecCreaCladoc()))
                .usuModiCladoc(claseDocenteDTO.getUsuModiCladoc())
                .fecModiCladoc(utilityService.convertStringToDate(claseDocenteDTO.getFecModiCladoc()))
                .build();
    }
}
