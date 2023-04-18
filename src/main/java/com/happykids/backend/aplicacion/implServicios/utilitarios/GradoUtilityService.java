package com.happykids.backend.aplicacion.implServicios.utilitarios;

import com.happykids.backend.aplicacion.iServicios.Utilitarios.iUtilityService;
import com.happykids.backend.aplicacion.implServicios.ImplServicioNivel;
import com.happykids.backend.dominio.dto.GradoDTO;
import com.happykids.backend.dominio.dto.NivelDTO;
import com.happykids.backend.dominio.dto.NotaDTO;
import com.happykids.backend.dominio.entidades.Grado;
import com.happykids.backend.dominio.entidades.Nivel;
import com.happykids.backend.dominio.entidades.Nota;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class GradoUtilityService implements iUtilityService {

    @Autowired
    private UtilityService utilityService;

    @Autowired
    private ImplServicioNivel implServicioNivel;

    @Override
    public Object convertEntityToDTO(Object entityObject) {
        Grado grado = (Grado) entityObject;
        log.info("Entrando a {} - convertEntityToDTO", this.getClass().getName());
        return GradoDTO.builder()
                .idGrado(String.valueOf(grado.getIdGrado()))
                .idNivel(String.valueOf(grado.getNivel().getIdNive()))
                .codGrado(grado.getCodGrado())
                .gradoDesc(grado.getGradoDesc())
                .usuCreaGrado(grado.getUsuCreaGrado())
                .fecCreaGrado(utilityService.convertDateToString(grado.getFecCreaGrado()))
                .usuModiGrado(grado.getUsuModiGrado())
                .fecModiGrado(utilityService.convertDateToString(grado.getFecModiGrado()))
                .build();
    }

    @Override
    public Object convertDTOtoEntity(Object dtoObject) {
        GradoDTO gradoDTO = (GradoDTO) dtoObject;

        log.info("Entrando a {} - convertDTOtoEntity", this.getClass().getName());
        return Grado.builder()
                .idGrado(Long.valueOf(gradoDTO.getIdGrado()))
                .nivel(implServicioNivel.findNivel(Long.valueOf(gradoDTO.getIdNivel())))
                .codGrado(gradoDTO.getCodGrado())
                .gradoDesc(gradoDTO.getGradoDesc())
                .usuCreaGrado(gradoDTO.getUsuCreaGrado())
                .fecCreaGrado(utilityService.convertStringToDate(gradoDTO.getFecCreaGrado()))
                .usuModiGrado(gradoDTO.getUsuModiGrado())
                .fecModiGrado(utilityService.convertStringToDate(gradoDTO.getFecModiGrado()))
                .build();
    }
}
