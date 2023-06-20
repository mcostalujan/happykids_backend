package com.happykids.backend.aplicacion.implServicios;

import com.happykids.backend.aplicacion.iServicios.iServicioDocente;
import com.happykids.backend.aplicacion.implServicios.utilitarios.DocenteUtilityService;
import com.happykids.backend.dominio.dto.DocenteDTO;
import com.happykids.backend.dominio.entidades.Clase;
import com.happykids.backend.dominio.entidades.ClaseEstatus;
import com.happykids.backend.dominio.entidades.Docente;
import com.happykids.backend.persistencia.jpaRepositories.iRepositorioDocente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class ImplServicioDocente implements iServicioDocente {

    @Autowired
    private iRepositorioDocente iRepositorioDocente;

    @Autowired
    private DocenteUtilityService docenteUtilityService;

    @Override
    public List<Docente> getDocentes() {
        return iRepositorioDocente.findAll();
    }

    @Override
    public Docente findDocenteById(Long idDocente) {
        if (idDocente != null)
            return iRepositorioDocente.findDocenteByIdDoc(idDocente);
        return null;
    }

    @Override
    public Docente createDocente(DocenteDTO docenteDTO) {
        if (docenteDTO != null) {
            docenteDTO.setIndActiDoc("true");
            Docente newDocente = (Docente) docenteUtilityService.convertDTOtoEntity(docenteDTO);
            return this.iRepositorioDocente.save(newDocente);
        }
        return null;
    }

    @Override
    public Docente updateDocente(DocenteDTO docenteDTO) {
        if (docenteDTO != null && docenteDTO.getIdDoc() != null) {
            Docente docenteActual = this.findDocenteById(Long.valueOf(docenteDTO.getIdDoc()));
            if (docenteActual != null) {
                Docente docenteToUpdate = (Docente) docenteUtilityService.convertDTOtoEntity(docenteDTO);
                return iRepositorioDocente.save(docenteToUpdate);
            }
        }
        return null;
    }
}
