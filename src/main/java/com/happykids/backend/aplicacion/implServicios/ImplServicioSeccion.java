package com.happykids.backend.aplicacion.implServicios;
import com.happykids.backend.aplicacion.iServicios.*;
import com.happykids.backend.dominio.dto.SeccionDTO;
import com.happykids.backend.dominio.entidades.Seccion;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ImplServicioSeccion  implements iServicioSeccion{

    @Override
    public List<Seccion> getSecciones() {
        return null;
    }

    @Override
    public Seccion findSeccionById(Long Id) {
        return null;
    }

    @Override
    public Seccion addNewSeccion(SeccionDTO seccionDTO) {
        return null;
    }

    @Override
    public Seccion updateSeccion(SeccionDTO seccionDTO) {
        return null;
    }

    @Override
    public void deleteSeccion(SeccionDTO seccionDTO) {

    }
}
