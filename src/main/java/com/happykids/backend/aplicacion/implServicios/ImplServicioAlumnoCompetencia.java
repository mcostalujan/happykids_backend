package com.happykids.backend.aplicacion.implServicios;
import com.happykids.backend.aplicacion.iServicios.*;
import com.happykids.backend.aplicacion.implServicios.utilitarios.AlumnoCompetenciaUtilityService;
import com.happykids.backend.aplicacion.implServicios.utilitarios.AlumnoUtilityService;
import com.happykids.backend.dominio.dto.AlumnoCompetenciaDTO;
import com.happykids.backend.dominio.entidades.AlumnoCompetencia;
import com.happykids.backend.persistencia.jpaRepositories.iRepositorioAlumnoCompetencia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
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
    public AlumnoCompetencia findAlumnoCompetenciaById(Long idAprog, Long idCompe) {
        if (idAprog != null && idCompe != null)
            return iRepositorioAlumnoCompetencia
            .findAlumnoCompetenciaByAlumnoCompetenciaID_IdAprogAndAlumnoCompetenciaID_IdCompe(idAprog, idCompe);
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
        if (alumnoCompetenciaDTO != null && alumnoCompetenciaDTO.getIdAprog()!= null && alumnoCompetenciaDTO.getIdCompe() != null) {
            AlumnoCompetencia alumnoCompetenciaActual = this.findAlumnoCompetenciaById(
                    Long.valueOf(alumnoCompetenciaDTO.getIdAprog()),
                    Long.valueOf(alumnoCompetenciaDTO.getIdCompe()));
            if (alumnoCompetenciaActual != null) {
                AlumnoCompetencia alumnoCompetenciaToUpdate = (AlumnoCompetencia) alumnoCompetenciaUtilityService
                        .convertDTOtoEntity(alumnoCompetenciaDTO);
                return iRepositorioAlumnoCompetencia.save(alumnoCompetenciaToUpdate);
            }
        }
        return null;
    }

}
