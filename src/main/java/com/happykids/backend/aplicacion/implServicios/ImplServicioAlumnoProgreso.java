package com.happykids.backend.aplicacion.implServicios;

import com.happykids.backend.aplicacion.iServicios.*;
import com.happykids.backend.aplicacion.implServicios.utilitarios.AlumnoProgresoUtilityService;
import com.happykids.backend.dominio.dto.AlumnoProgresoDTO;
import com.happykids.backend.dominio.entidades.Alumno;
import com.happykids.backend.dominio.entidades.AlumnoProgreso;
import com.happykids.backend.persistencia.jpaRepositories.iRepositorioAlumnoProgreso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.happykids.backend.persistencia.jpaRepositories.iRepositorioAlumnoProgreso;

import java.util.List;

@Service
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
}
