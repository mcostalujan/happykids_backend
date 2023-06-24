package com.happykids.backend.aplicacion.iServicios;

import com.happykids.backend.dominio.dto.ClaseDocenteDTO;
import com.happykids.backend.dominio.dto.ConsultasSQL.DetalleClasesDocente;
import com.happykids.backend.dominio.entidades.ClaseDocente;

import java.util.List;

public interface iServicioClaseDocente {

    List<ClaseDocente> getClasesDocente();

    ClaseDocente findClaseDocenteById(Long idDocente, Long idClase);

    ClaseDocente createClaseDocente(ClaseDocenteDTO ClaseDocenteDTO);

    ClaseDocente updateClaseDocente(ClaseDocenteDTO ClaseDocenteDTO);

    List<DetalleClasesDocente> getClasesByDocenteAndPeriodo(String idDocente, String idPer);
}
