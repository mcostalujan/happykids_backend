package com.happykids.backend.aplicacion.implServicios;
import com.happykids.backend.aplicacion.iServicios.*;
import com.happykids.backend.dominio.dto.AlumnoCompetenciaDTO;
import com.happykids.backend.dominio.entidades.AlumnoCompetencia;

import java.util.List;

public class ImplServicioAlumnoCompetencia implements iServicioAlumnoCompetencia{

    @Override
    public List<AlumnoCompetenciaDTO> getAlumnoCompetencias() {
        return null;
    }

    @Override
    public AlumnoCompetencia findAlumnoByNombre(Long alumnoCompetenciaID) {
        return null;
    }

    @Override
    public AlumnoCompetencia addNewAlumnoCompetencia(AlumnoCompetenciaDTO alumnoCompetenciaDTO) {
        return null;
    }
}
