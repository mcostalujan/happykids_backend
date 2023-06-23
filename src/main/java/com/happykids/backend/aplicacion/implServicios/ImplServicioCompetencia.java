package com.happykids.backend.aplicacion.implServicios;

import com.happykids.backend.aplicacion.iServicios.iServicioCompetencia;
import com.happykids.backend.aplicacion.implServicios.utilitarios.CompetenciaUtilityService;
import com.happykids.backend.dominio.dto.CompetenciaDTO;
import com.happykids.backend.dominio.entidades.Competencia;
import com.happykids.backend.persistencia.jpaRepositories.iRepositorioCompetencia;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ImplServicioCompetencia implements iServicioCompetencia {

    @Autowired
    private iRepositorioCompetencia iRepositorioCompetencia;

    @Autowired
    private CompetenciaUtilityService competenciaUtilityService;


    @Override
    public List<Competencia> getCompetencias() {
        log.info("Entrando a {} - getCompetencias", this.getClass().getName());
        return iRepositorioCompetencia.findAll();
    }

    @Override
    public Competencia findCompetenciaById(Long Id) {
        if (Id != null)
            return iRepositorioCompetencia.findCompetenciaByIdCompe(Id);
        return null;
    }

    @Override
    public Competencia agregarCompetencia(CompetenciaDTO competenciaDTO) {
        if (competenciaDTO != null) {
            competenciaDTO.setIndActiCompe("true");
            competenciaDTO.setIndElimCompe("false");
            return this.iRepositorioCompetencia.save((Competencia) competenciaUtilityService
                    .convertDTOtoEntity(competenciaDTO));
        }
        return null;
    }

    @Override
    public Competencia editarCompetencia(CompetenciaDTO competenciaDTO) {
        if (competenciaDTO != null && competenciaDTO.getIdCompe() != null) {
            if (iRepositorioCompetencia.findCompetenciaByIdCompe(Long.valueOf(competenciaDTO.getIdCompe())) != null) {
                return iRepositorioCompetencia
                        .save((Competencia) competenciaUtilityService
                                .convertDTOtoEntity(competenciaDTO));
            }
        }
        return null;
    }

    @Override
    public boolean deleteCompetencia(Long idCompetencia) {
        if (idCompetencia != null) {
            if (iRepositorioCompetencia.findCompetenciaByIdCompe(Long.valueOf(idCompetencia)) != null) {
                iRepositorioCompetencia.deleteById(Long.valueOf(idCompetencia));
                return true;
            }
        }
        return false;
    }
}
