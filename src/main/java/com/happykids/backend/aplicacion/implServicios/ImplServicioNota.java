package com.happykids.backend.aplicacion.implServicios;

import com.happykids.backend.aplicacion.iServicios.*;
import com.happykids.backend.aplicacion.implServicios.utilitarios.NotaUtilityService;
import com.happykids.backend.dominio.dto.AlumnoNotaLogroDTO;
import com.happykids.backend.dominio.dto.NotaDTO;
import com.happykids.backend.dominio.entidades.Nota;
import com.happykids.backend.persistencia.jpaRepositories.iRepositorioNota;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImplServicioNota implements iServicioNota {

    @Autowired
    private NotaUtilityService notaUtilityService;

    @Autowired
    private iRepositorioNota iRepositorioNota;

    @Override
    public List<NotaDTO> getNotas() {
        return null;
    }

    @Override
    public NotaDTO findNotaById(Long Id) {
        return null;
    }

    @Override
    public Nota agregarNota(NotaDTO notaDTO) {
        if (notaDTO != null) {
            return this.iRepositorioNota.save((Nota) notaUtilityService.convertDTOtoEntity(notaDTO));
        }
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
