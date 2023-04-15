package com.happykids.backend.aplicacion.implServicios;

import com.happykids.backend.aplicacion.iServicios.*;
import com.happykids.backend.aplicacion.implServicios.utilitarios.UtilityService;
import com.happykids.backend.dominio.dto.NivelDTO;
import com.happykids.backend.dominio.entidades.Nivel;
import com.happykids.backend.persistencia.jpaRepositories.iRepositorioNivel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class ImplServicioNivel implements iServicioNivel {

    @Autowired
    private iRepositorioNivel repositorioNivel;

    @Autowired
    private UtilityService utilityService;

    @Override
    public List<NivelDTO> getNiveles() {
        log.info("Entrando a {} - getNiveles", this.getClass().getName());
        List<Nivel> listaNiveles = repositorioNivel.findAll();
        List<NivelDTO> listaNivelesDTO = new ArrayList<>();

        for (Nivel nivel : listaNiveles) {
            listaNivelesDTO.add(utilityService.convertEntityToDTO(nivel));
        }

        return listaNivelesDTO;

    }

    @Override
    public NivelDTO findNivel(Long Id) {
        return utilityService.convertEntityToDTO(repositorioNivel.findByIdNive(Id));
    }
}
