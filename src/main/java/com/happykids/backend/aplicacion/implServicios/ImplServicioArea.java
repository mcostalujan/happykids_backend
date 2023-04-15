package com.happykids.backend.aplicacion.implServicios;
import com.happykids.backend.aplicacion.iServicios.*;
import com.happykids.backend.dominio.dto.AreaDTO;
import com.happykids.backend.dominio.entidades.Area;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ImplServicioArea implements iServicioArea{


    @Override
    public List<AreaDTO> getAreas() {
        return null;
    }

    @Override
    public AreaDTO findAreaById(Long idArea) {
        return null;
    }

    @Override
    public AreaDTO agregarArea(AreaDTO areaDTO) {
        return null;
    }

    @Override
    public AreaDTO updateArea(AreaDTO areaDTO) {
        return null;
    }
}
