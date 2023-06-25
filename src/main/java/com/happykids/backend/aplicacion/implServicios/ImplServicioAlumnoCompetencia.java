package com.happykids.backend.aplicacion.implServicios;
import com.happykids.backend.aplicacion.iServicios.*;
import com.happykids.backend.aplicacion.implServicios.utilitarios.AlumnoCompetenciaUtilityService;
import com.happykids.backend.aplicacion.implServicios.utilitarios.AlumnoUtilityService;
import com.happykids.backend.dominio.dto.AlumnoCompetenciaDTO;
import com.happykids.backend.dominio.dto.ConsultasSQL.DetalleAlumnoCompetencia;
import com.happykids.backend.dominio.dto.ConsultasSQL.DetalleAlumnoPorClase;
import com.happykids.backend.dominio.entidades.AlumnoCompetencia;
import com.happykids.backend.persistencia.jpaRepositories.iRepositorioAlumnoCompetencia;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Slf4j
public class ImplServicioAlumnoCompetencia implements iServicioAlumnoCompetencia{

    @Autowired
    private iRepositorioAlumnoCompetencia iRepositorioAlumnoCompetencia;

    @Autowired
    private AlumnoCompetenciaUtilityService alumnoCompetenciaUtilityService;

    @Override
    public List<AlumnoCompetencia> getAlumnoCompetencias() {
        return iRepositorioAlumnoCompetencia.findAll();
    }

    @Override
    public AlumnoCompetencia findAlumnoCompetenciaByIdAcompe(Long idAcompe) {
        if (idAcompe != null)
            return iRepositorioAlumnoCompetencia
            .findAlumnoCompetenciaByIdAcompe(idAcompe);
        return null;
    }
    

    @Override
    public AlumnoCompetencia createAlumnoCompetencia(AlumnoCompetenciaDTO alumnoCompetenciaDTO) {
        if (alumnoCompetenciaDTO != null) {
            alumnoCompetenciaDTO.setIndActi("true");
            AlumnoCompetencia newAlumnoCompetencia = (AlumnoCompetencia) alumnoCompetenciaUtilityService
                    .convertDTOtoEntity(alumnoCompetenciaDTO);
            return this.iRepositorioAlumnoCompetencia.save(newAlumnoCompetencia);
        }
        return null;
    }

    @Override
    public AlumnoCompetencia updateAlumnoCompetencia(AlumnoCompetenciaDTO alumnoCompetenciaDTO) {
        if (alumnoCompetenciaDTO != null && alumnoCompetenciaDTO.getIdCompe()!= null) {
            AlumnoCompetencia alumnoCompetenciaActual = this.
                    findAlumnoCompetenciaByIdAcompe(NumberUtils.toLong(alumnoCompetenciaDTO.getIdAcompe()));
            if (alumnoCompetenciaActual != null) {
                AlumnoCompetencia alumnoCompetenciaToUpdate = (AlumnoCompetencia) alumnoCompetenciaUtilityService
                        .convertDTOtoEntity(alumnoCompetenciaDTO);
                return iRepositorioAlumnoCompetencia.save(alumnoCompetenciaToUpdate);
            }
        }
        return null;
    }

    @Override
    public List<DetalleAlumnoCompetencia> getDetalleACompeByIdClaseAndIdAlumno(String idClase, String idAlumno) {
        log.info("Entrando a {} - getDetalleACompeByIdClaseAndIdAlumno", this.getClass().getName());
        return iRepositorioAlumnoCompetencia.getDetalleACompeByIdClaseAndIdAlumno(idClase, idAlumno)
                        .stream()
                        .map(DetalleAlumnoCompetencia::convertTupleToEntity).toList();
    }

}
