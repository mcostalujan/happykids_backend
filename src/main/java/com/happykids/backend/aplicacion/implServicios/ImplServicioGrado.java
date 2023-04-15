package com.happykids.backend.aplicacion.implServicios;
import com.happykids.backend.aplicacion.iServicios.*;
import com.happykids.backend.dominio.dto.GradoDTO;
import com.happykids.backend.dominio.entidades.Grado;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ImplServicioGrado implements iServicioGrado{

    @Override
    public List<GradoDTO> getGrados() {
        return null;
    }

    @Override
    public GradoDTO buscarGradoPorId(Long idGrado) {
        return null;
    }
}
