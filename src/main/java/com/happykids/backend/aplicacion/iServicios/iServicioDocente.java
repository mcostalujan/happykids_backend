package com.happykids.backend.aplicacion.iServicios;

import com.happykids.backend.dominio.dto.DocenteDTO;
import com.happykids.backend.dominio.entidades.Docente;

import java.util.List;

public interface iServicioDocente {

    List<Docente> getDocentes();

    Docente findDocenteById(Long idDocente);

    Docente createDocente(DocenteDTO DocenteDTO);

    Docente updateDocente(DocenteDTO DocenteDTO);

}
