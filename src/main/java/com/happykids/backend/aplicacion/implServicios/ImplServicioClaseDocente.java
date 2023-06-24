package com.happykids.backend.aplicacion.implServicios;

import com.happykids.backend.aplicacion.iServicios.iServicioClaseDocente;
import com.happykids.backend.aplicacion.implServicios.utilitarios.ClaseDocenteUtilityService;
import com.happykids.backend.aplicacion.implServicios.utilitarios.ClaseUtilityService;
import com.happykids.backend.dominio.dto.ClaseDocenteDTO;
import com.happykids.backend.dominio.dto.ConsultasSQL.DetalleClase;
import com.happykids.backend.dominio.dto.ConsultasSQL.DetalleClasesDocente;
import com.happykids.backend.dominio.entidades.Clase;
import com.happykids.backend.dominio.entidades.ClaseDocente;
import com.happykids.backend.dominio.entidades.ClaseEstatus;
import com.happykids.backend.persistencia.jpaRepositories.iRepositorioClaseDocente;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ImplServicioClaseDocente implements iServicioClaseDocente {

    @Autowired
    private iRepositorioClaseDocente iRepositorioClaseDocente;

    @Autowired
    private ClaseDocenteUtilityService claseDocenteUtilityService;

    @Override
    public List<ClaseDocente> getClasesDocente() {
        return iRepositorioClaseDocente.findAll();
    }

    @Override
    public ClaseDocente findClaseDocenteById(Long idDocente, Long idClase) {
        if (idDocente != null && idClase != null)
            return iRepositorioClaseDocente
                    .findClaseDocenteByClaseDocenteID_IdClaseAndClaseDocenteID_IdDoc(idDocente, idClase);
        return null;
    }

    @Override
    public ClaseDocente createClaseDocente(ClaseDocenteDTO claseDocenteDTO) {
        if (claseDocenteDTO != null) {
            claseDocenteDTO.setIndActi("true");
            ClaseDocente newClaseDocente = (ClaseDocente) claseDocenteUtilityService
                    .convertDTOtoEntity(claseDocenteDTO);
            return this.iRepositorioClaseDocente.save(newClaseDocente);
        }
        return null;
    }

    @Override
    public ClaseDocente updateClaseDocente(ClaseDocenteDTO claseDocenteDTO) {
        if (claseDocenteDTO != null && claseDocenteDTO.getIdDoc() != null && claseDocenteDTO.getIdClase() != null) {
            ClaseDocente claseDocenteActual = this.findClaseDocenteById(
                    Long.valueOf(claseDocenteDTO.getIdDoc()),
                    Long.valueOf(claseDocenteDTO.getIdClase()));
            if (claseDocenteActual != null) {
                ClaseDocente claseDocenteToUpdate = (ClaseDocente) claseDocenteUtilityService
                        .convertDTOtoEntity(claseDocenteDTO);
                return iRepositorioClaseDocente.save(claseDocenteToUpdate);
            }
        }
        return null;
    }

    @Override
    public List<DetalleClasesDocente> getClasesByDocenteAndPeriodo(String idDocente, String idPer) {
        log.info("Entrando a {} - getClasesByDocenteAndPeriodo", this.getClass().getName());
        return iRepositorioClaseDocente.getClasesByDocenteAndPeriodo(idDocente, idPer)
                .stream()
                .map(DetalleClasesDocente::convertTupleToEntity).toList();
    }

}
