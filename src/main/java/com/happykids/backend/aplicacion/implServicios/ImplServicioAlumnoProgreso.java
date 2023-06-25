package com.happykids.backend.aplicacion.implServicios;

import com.happykids.backend.aplicacion.iServicios.*;
import com.happykids.backend.aplicacion.implServicios.utilitarios.AlumnoProgresoUtilityService;
import com.happykids.backend.dominio.dto.AlumnoProgresoDTO;
import com.happykids.backend.dominio.dto.ConsultasSQL.DetalleAlumnoPorClase;
import com.happykids.backend.dominio.entidades.AlumnoProgreso;
import com.happykids.backend.persistencia.jpaRepositories.iRepositorioAlumnoProgreso;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ImplServicioAlumnoProgreso implements iServicioAlumnoProgreso {

    @Autowired
    private iRepositorioAlumnoProgreso iRepositorioAlumnoProgreso;

    @Autowired
    private AlumnoProgresoUtilityService alumnoProgresoUtilityService;

    @Autowired
    private iServicioAlumno iServicioAlumno;

    @Override
    public List<AlumnoProgreso> getAlumnoProgresosByIdAlumno(Long idAlumno) {
        return iRepositorioAlumnoProgreso.findAllByAlumno_IdAlum(idAlumno);
    }

    @Override
    public AlumnoProgreso findAlumnoProgresoById(Long idAProgreso) {
        if (idAProgreso != null)
            return iRepositorioAlumnoProgreso.findAlumnoProgresoByIdAprog(idAProgreso);
        return null;
    }

    @Override
    public AlumnoProgreso addNewAlumnoProgreso(AlumnoProgresoDTO alumnoProgresoDTO) {
        if (alumnoProgresoDTO != null) {
            alumnoProgresoDTO.setIndAntiAlumprog("true");
            return this.iRepositorioAlumnoProgreso.save((AlumnoProgreso)
                    alumnoProgresoUtilityService.convertDTOtoEntity(alumnoProgresoDTO));
        }
        return null;
    }

    @Override
    public List<DetalleAlumnoPorClase> getAlumnosPorClase(String idClase) {
        log.info("Entrando a {} - getAlumnosPorClase", this.getClass().getName());
        return iRepositorioAlumnoProgreso.getDetalleAlumnosPorClase(idClase)
                .stream()
                .map(DetalleAlumnoPorClase::convertTupleToEntity).toList();
    }

    @Override
    public DetalleAlumnoPorClase getDetalleAlumnoByIdClaseAndIdAlumno(String idClase, String idAlumno) {
        log.info("Entrando a {} - getDetalleAlumnoByIdClaseAndIdAlumno", this.getClass().getName());
        return DetalleAlumnoPorClase.convertTupleToEntity(
                iRepositorioAlumnoProgreso.getDetalleAlumnoByIdClaseAndIdAlumno(idClase, idAlumno));
    }
}
