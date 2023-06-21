package com.happykids.backend.aplicacion.implServicios;

import com.happykids.backend.aplicacion.iServicios.*;
import com.happykids.backend.aplicacion.implServicios.utilitarios.NotaUtilityService;
import com.happykids.backend.dominio.dto.AlumnoNotaCapacidadDTO;
import com.happykids.backend.dominio.dto.NotaDTO;
import com.happykids.backend.dominio.entidades.Nota;
import com.happykids.backend.persistencia.jpaRepositories.iRepositorioNota;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ImplServicioNota implements iServicioNota {

    @Autowired
    private NotaUtilityService notaUtilityService;

    @Autowired
    private iRepositorioNota iRepositorioNota;

    @Override
    public List<Nota> getNotas() {
        log.info("Entrando a {} - getNotas", this.getClass().getName());
        return iRepositorioNota.findAll();
    }

    @Override
    public Nota findNotaById(Long Id) {
        if (Id != null)
            return iRepositorioNota.findNotaByIdNota(Id);
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
    public Nota editarNota(NotaDTO notaDTO) {
        if (notaDTO != null && notaDTO.getIdNota() != null) {
            if (iRepositorioNota.findNotaByIdNota(Long.valueOf(notaDTO.getIdNota())) != null) {
                return iRepositorioNota
                        .save((Nota) notaUtilityService
                                .convertDTOtoEntity(notaDTO));
            }
        }
        return null;
    }

    @Override
    public boolean eliminarNotaPorId(Long idNota) {
        if (idNota != null) {
            if (iRepositorioNota.findNotaByIdNota(Long.valueOf(idNota)) != null) {
                iRepositorioNota.deleteById(Long.valueOf(idNota));
                return true;
            }
        }
        return false;
    }
}
