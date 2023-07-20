package com.happykids.backend.aplicacion.implServicios;

import com.happykids.backend.aplicacion.iServicios.iServicioAlumno;
import com.happykids.backend.aplicacion.implServicios.utilitarios.AlumnoUtilityService;
import com.happykids.backend.dominio.dto.AlumnoDTO;
import com.happykids.backend.dominio.dto.ConsultasSQL.DetalleAlumnoReporteAnual;
import com.happykids.backend.dominio.dto.ConsultasSQL.GradoDisponible;
import com.happykids.backend.dominio.entidades.Alumno;
import com.happykids.backend.persistencia.jpaRepositories.iRepositorioAlumno;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.happykids.backend.persistencia.jpaRepositories.iRepositorioAlumno;

@Service
@Slf4j
public class ImplServicioAlumno implements iServicioAlumno {

    @Autowired
    private iRepositorioAlumno iRepositorioAlumno;

    @Autowired
    private AlumnoUtilityService alumnoUtilityService;

    @Override
    public List<Alumno> getAlumnos() {
        log.info("Entrando a {} - getAlumnos", this.getClass().getName());
        return iRepositorioAlumno.findAll();
    }

    @Override
    public Alumno findAlumnoById(Long idAlum) {
        if (idAlum != null)
            return iRepositorioAlumno.findAlumnoByIdAlum(idAlum);
        return null;
    }

    @Override
    public Alumno agregarAlumno(AlumnoDTO alumnoDTO) {
        if (alumnoDTO != null) {
            alumnoDTO.setIsActiveAlumn("true");
            return this.iRepositorioAlumno.save((Alumno) alumnoUtilityService.convertDTOtoEntity(alumnoDTO));
        }
        return null;
    }

    @Override
    public Alumno editarAlumno(AlumnoDTO alumnoDTO) {
        if (alumnoDTO != null && alumnoDTO.getIdAlum() != null) {
            if (iRepositorioAlumno.findAlumnoByIdAlum(Long.valueOf(alumnoDTO.getIdAlum())) != null) {
                return iRepositorioAlumno
                        .save((Alumno) alumnoUtilityService
                                .convertDTOtoEntity(alumnoDTO));
            }
        }
        return null;
    }

    @Override
    public boolean eliminarAlumnoPorId(Long idAlumno) {
        if (idAlumno != null) {
            if (iRepositorioAlumno.findAlumnoByIdAlum(Long.valueOf(idAlumno)) != null) {
                iRepositorioAlumno.deleteById(Long.valueOf(idAlumno));
                return true;
            }
        }
        return false;
    }

    @Override
    public List<DetalleAlumnoReporteAnual> getAlumnosByParamsReporteAnual(String idNivel, String idGrado, String idSeccion, String year) {
        log.info("Entrando a {} - getAlumnosByParamsReporteAnual", this.getClass().getName());
        return iRepositorioAlumno.getAlumnosByParamsReporteAnual(idNivel, idGrado, idSeccion, year)
                .stream()
                .map(DetalleAlumnoReporteAnual::convertTupleToEntity).toList();
    }
}
