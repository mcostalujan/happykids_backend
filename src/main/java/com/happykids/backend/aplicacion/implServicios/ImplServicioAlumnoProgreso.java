package com.happykids.backend.aplicacion.implServicios;
import com.happykids.backend.aplicacion.iServicios.*;
import com.happykids.backend.dominio.dto.AlumnoProgresoDTO;
import com.happykids.backend.dominio.entidades.AlumnoProgreso;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ImplServicioAlumnoProgreso implements iServicioAlumnoProgreso{

    @Override
    public List<AlumnoProgreso> getAlumnoProgresos() {
        return null;
    }

    @Override
    public AlumnoProgreso findAlumnoProgresoById(Long ID) {
        return null;
    }

    @Override
    public AlumnoProgreso addNewAlumnoProgreso(AlumnoProgresoDTO alumnoProgresoDTO) {
        return null;
    }
}
