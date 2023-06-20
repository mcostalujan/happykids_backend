package com.happykids.backend.aplicacion.iServicios;

import com.happykids.backend.dominio.dto.ClaseDTO;
import com.happykids.backend.dominio.entidades.Clase;
import com.happykids.backend.dominio.dto.ConsultasSQL.DetalleClase;

import java.util.List;

public interface iServicioClase {

    List<Clase> getClases();

    Clase findClaseById(Long idClase);

    Clase createClase(ClaseDTO claseDTO);

    Clase updateClase(ClaseDTO claseDTO);

    List<DetalleClase> getDetalleClases();


}
