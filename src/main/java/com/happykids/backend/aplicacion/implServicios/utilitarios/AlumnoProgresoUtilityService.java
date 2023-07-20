package com.happykids.backend.aplicacion.implServicios.utilitarios;

import com.happykids.backend.aplicacion.iServicios.Utilitarios.iUtilityService;
import com.happykids.backend.aplicacion.implServicios.ImplServicioAlumno;
import com.happykids.backend.aplicacion.implServicios.ImplServicioArea;
import com.happykids.backend.aplicacion.implServicios.ImplServicioPeriodo;
import com.happykids.backend.aplicacion.implServicios.ImplServicioSeccion;
import com.happykids.backend.dominio.dto.AlumnoDTO;
import com.happykids.backend.dominio.dto.AlumnoProgresoDTO;
import com.happykids.backend.dominio.entidades.Alumno;
import com.happykids.backend.dominio.entidades.AlumnoProgreso;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AlumnoProgresoUtilityService implements iUtilityService {

    @Autowired
    private UtilityService utilityService;

    @Autowired
    private ImplServicioAlumno implServicioAlumno;

    @Autowired
    private ImplServicioSeccion implServicioSeccion;

    @Autowired
    private ImplServicioArea implServicioArea;

    @Autowired
    private ImplServicioPeriodo implServicioPeriodo;

    @Override
    public Object convertEntityToDTO(Object entityObject) {
        AlumnoProgreso alumnoProgreso = (AlumnoProgreso) entityObject;
        log.info("Entrando a {} - convertEntityToDTO", this.getClass().getName());
        return AlumnoProgresoDTO.builder()
                .idAprog(String.valueOf(alumnoProgreso.getIdAprog()))
                .idAlumno(String.valueOf(alumnoProgreso.getAlumno().getIdAlum()))
//                .idSeccion(String.valueOf(alumnoProgreso.getSeccion().getIdSecci()))
//                .idArea(String.valueOf(alumnoProgreso.getArea().getIdArea()))
//                .idPeriodo(String.valueOf(alumnoProgreso.getPeriodo().getIdPer()))
                .indAntiAlumprog(String.valueOf(alumnoProgreso.getIndAntiAlumprog()))
                .usuCreaAlumprog(alumnoProgreso.getUsuCreaAlumprog())
                .fecCreaAlumprog(utilityService.convertDateToString(alumnoProgreso.getFecCreaAlumprog()))
                .usuModiAlumprog(alumnoProgreso.getUsuModiAlumprog())
                .fecModiAlmprog(utilityService.convertDateToString(alumnoProgreso.getFecModiAlmprog()))
                .runtime(alumnoProgreso.getRuntime())
                .build();
    }

    @Override
    public Object convertDTOtoEntity(Object dtoObject) {
        AlumnoProgresoDTO alumnoProgresoDTO = (AlumnoProgresoDTO) dtoObject;

        log.info("Entrando a {} - convertDTOtoEntity", this.getClass().getName());
        return AlumnoProgreso.builder()
                .idAprog(NumberUtils.toLong(alumnoProgresoDTO.getIdAprog()))
                .alumno(implServicioAlumno.findAlumnoById(Long.valueOf(alumnoProgresoDTO.getIdAlumno())))
//                .seccion(implServicioSeccion.findSeccionById(Long.valueOf(alumnoProgresoDTO.getIdSeccion())))
//                .area(implServicioArea.findAreaById(Long.valueOf(alumnoProgresoDTO.getIdArea())))
//                .periodo(implServicioPeriodo.buscarPeriodoPorID(Long.valueOf(alumnoProgresoDTO.getIdPeriodo())))
                .indAntiAlumprog(Boolean.valueOf(alumnoProgresoDTO.getIndAntiAlumprog()))
                .usuCreaAlumprog(alumnoProgresoDTO.getUsuCreaAlumprog())
                .fecCreaAlumprog(utilityService.convertStringToDate(alumnoProgresoDTO.getFecCreaAlumprog()))
                .usuModiAlumprog(alumnoProgresoDTO.getUsuModiAlumprog())
                .fecModiAlmprog(utilityService.convertStringToDate(alumnoProgresoDTO.getFecModiAlmprog()))
                .runtime(alumnoProgresoDTO.getRuntime())
                .build();
    }
}
