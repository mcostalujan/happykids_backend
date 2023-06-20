package com.happykids.backend.aplicacion.implServicios.utilitarios;

import com.happykids.backend.aplicacion.iServicios.Utilitarios.iUtilityService;
import com.happykids.backend.aplicacion.implServicios.ImplServicioArea;
import com.happykids.backend.aplicacion.implServicios.ImplServicioPeriodo;
import com.happykids.backend.aplicacion.implServicios.ImplServicioSeccion;
import com.happykids.backend.dominio.dto.AlumnoProgresoDTO;
import com.happykids.backend.dominio.dto.ClaseDTO;
import com.happykids.backend.dominio.entidades.AlumnoProgreso;
import com.happykids.backend.dominio.entidades.Clase;
import com.happykids.backend.dominio.entidades.ClaseEstatus;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ClaseUtilityService implements iUtilityService {

    @Autowired
    private UtilityService utilityService;

    @Autowired
    private ImplServicioSeccion implServicioSeccion;

    @Autowired
    private ImplServicioArea implServicioArea;

    @Autowired
    private ImplServicioPeriodo implServicioPeriodo;

    @Override
    public Object convertEntityToDTO(Object entityObject) {
        Clase clase = (Clase) entityObject;
        log.info("Entrando a {} - convertEntityToDTO", this.getClass().getName());
        return ClaseDTO.builder()
                .idClase(String.valueOf(clase.getIdClase()))
                .codClase(String.valueOf(clase.getCodClase()))
                .estatus(String.valueOf(clase.getEstatus().getValue()))
                .idPer(String.valueOf(clase.getPeriodo().getIdPer()))
                .idSecci(String.valueOf(clase.getSeccion().getIdSecci()))
                .idArea(String.valueOf(clase.getArea().getIdArea()))
                .usuCreaClase(clase.getUsuCreaClase())
                .fecCreaClase(utilityService.convertDateToString(clase.getFecCreaClase()))
                .usuModiClase(clase.getUsuModiClase())
                .fecModiClase(utilityService.convertDateToString(clase.getFecModiClase()))
                .build();
    }

    @Override
    public Object convertDTOtoEntity(Object dtoObject) {
        ClaseDTO claseDTO = (ClaseDTO) dtoObject;
        log.info("Entrando a {} - convertDTOtoEntity", this.getClass().getName());
        return Clase.builder()
                .idClase(NumberUtils.toLong(claseDTO.getIdClase()))
                .codClase(claseDTO.getCodClase())
                .estatus(ClaseEstatus.valueOfLabel(claseDTO.getEstatus()))
                .seccion(implServicioSeccion.findSeccionById(Long.valueOf(claseDTO.getIdSecci())))
                .area(implServicioArea.findAreaById(Long.valueOf(claseDTO.getIdArea())))
                .periodo(implServicioPeriodo.buscarPeriodoPorID(Long.valueOf(claseDTO.getIdPer())))
                .usuCreaClase(claseDTO.getUsuCreaClase())
                .fecCreaClase(utilityService.convertStringToDate(claseDTO.getFecCreaClase()))
                .usuModiClase(claseDTO.getUsuModiClase())
                .fecModiClase(utilityService.convertStringToDate(claseDTO.getFecModiClase()))
                .build();
    }
}
