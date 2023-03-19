package com.happykids.backend.aplicacion.implServicios;
import com.happykids.backend.aplicacion.iServicios.*;
import com.happykids.backend.dominio.dto.AlumnoNotaLogroDTO;
import com.happykids.backend.dominio.entidades.AlumnoNotaLogro;

import java.util.List;

public class ImplServicioAlumnoNotaLogro implements iServicioAlumnoNotaLogro{

    @Override
    public List<AlumnoNotaLogroDTO> getAlumnoNotaLogros() {
        return null;
    }

    @Override
    public AlumnoNotaLogro findAlumnoByNombre() {
        return null;
    }

    @Override
    public AlumnoNotaLogro addNewAlumnoNotaLogro(String nombre, String idUser) {
        return null;
    }

    @Override
    public AlumnoNotaLogro updateAlumnoNotaLogro(String currentNombre, String newNombre, String idUser) {
        return null;
    }

    @Override
    public void deleteAlumnoNotaLogro(String nombre) {

    }
}
