package com.happykids.backend.aplicacion.iServicios.Utilitarios;

import com.happykids.backend.dominio.dto.NivelDTO;
import com.happykids.backend.dominio.entidades.Nivel;

public interface iUtilityService {
    Object convertEntityToDTO(Object dtoObject);

    Object convertDTOtoEntity(Object entityObject);
}
