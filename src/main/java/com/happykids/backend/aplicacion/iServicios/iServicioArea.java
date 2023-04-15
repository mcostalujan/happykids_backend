package com.happykids.backend.aplicacion.iServicios;

import java.util.List;

import com.happykids.backend.dominio.dto.AreaDTO;
import com.happykids.backend.dominio.entidades.Area;

public interface iServicioArea {
    List<AreaDTO> getAreas();

    AreaDTO findAreaById(Long idArea);

    AreaDTO agregarArea(AreaDTO areaDTO);

    AreaDTO updateArea(AreaDTO areaDTO);

}



