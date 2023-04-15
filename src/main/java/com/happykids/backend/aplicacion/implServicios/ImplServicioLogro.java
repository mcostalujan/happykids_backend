package com.happykids.backend.aplicacion.implServicios;
import com.happykids.backend.aplicacion.iServicios.*;
import com.happykids.backend.dominio.dto.LogroDTO;
import com.happykids.backend.dominio.entidades.Logro;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ImplServicioLogro implements iServicioLogro{

    @Override
    public List<Logro> getLogros() {
        return null;
    }

    @Override
    public Logro findLogroById(Long Id) {
        return null;
    }

    @Override
    public Logro addNewLogro(LogroDTO logroDTO) {
        return null;
    }

    @Override
    public Logro updateLogro(LogroDTO logroDTO) {
        return null;
    }

    @Override
    public void deleteLogro(LogroDTO logroDTO) {

    }
}
