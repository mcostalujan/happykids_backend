package com.happykids.backend.aplicacion.implServicios.utilitarios;

import com.happykids.backend.aplicacion.iServicios.Utilitarios.iUtilityService;
import com.happykids.backend.dominio.dto.NotaDTO;

public class NotaUtilityService implements iUtilityService {
    @Override
    public Object convertEntityToDTO(Object entityObject) {
        return null;
    }

    @Override
    public Object convertDTOtoEntity(Object dtoObject) {
        NotaDTO notaDTO = (NotaDTO) dtoObject;
        return null;
    }
}
