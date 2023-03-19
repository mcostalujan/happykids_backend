package com.happykids.backend.aplicacion.iServicios;
import java.util.List;

import com.happykids.backend.dominio.dto.AreaDTO;
import com.happykids.backend.dominio.entidades.Area;
public interface iServicioArea {
    List<Area> getAreas();
    
    Area findAreaById(Long idArea) ;

    Area addNewArea
    (AreaDTO areaDTO);

    Area updateArea 
    (AreaDTO areaDTO);

}



