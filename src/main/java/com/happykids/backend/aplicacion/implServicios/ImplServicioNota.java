package com.happykids.backend.aplicacion.implServicios;
import com.happykids.backend.aplicacion.iServicios.*;
import com.happykids.backend.dominio.dto.AlumnoNotaLogroDTO;
import com.happykids.backend.dominio.dto.NotaDTO;
import com.happykids.backend.dominio.entidades.Nota;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ImplServicioNota implements iServicioNota {

    @Override
    public List<NotaDTO> getNotas() {
        return null;
    }

    @Override
    public NotaDTO findNotaById(Long Id) {
        return null;
    }

    @Override
    public NotaDTO agregarNota(NotaDTO notaDTO) {
        return null;
    }

    @Override
    public NotaDTO editarNota(NotaDTO notaDTO) {
        return null;
    }

    @Override
    public void eliminarNotaPorId(Long idNota) {

    }
}
