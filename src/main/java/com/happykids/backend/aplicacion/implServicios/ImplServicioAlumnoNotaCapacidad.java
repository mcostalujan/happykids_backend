package com.happykids.backend.aplicacion.implServicios;
import com.happykids.backend.aplicacion.iServicios.*;
import com.happykids.backend.dominio.dto.AlumnoNotaCapacidadDTO;
import com.happykids.backend.dominio.entidades.AlumnoNotaCapacidad;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ImplServicioAlumnoNotaCapacidad implements iServicioAlumnoNotaCapacidad{

    @Override
    public List<AlumnoNotaCapacidadDTO> getAlumnoNotaCapacidad() {
        return null;
    }

    @Override
    public AlumnoNotaCapacidad findAlumnoByNombre() {
        return null;
    }

    @Override
    public AlumnoNotaCapacidad addNewAlumnoNotaCapacidad(String nombre, String idUser) {
        return null;
    }

    @Override
    public AlumnoNotaCapacidad updateAlumnoNotaCapacidad(String currentNombre, String newNombre, String idUser) {
        return null;
    }

    @Override
    public void deleteAlumnoNotaCapacidad(String nombre) {

    }
}
