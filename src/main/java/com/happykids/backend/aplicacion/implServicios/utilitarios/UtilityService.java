package com.happykids.backend.aplicacion.implServicios.utilitarios;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
@Slf4j
public class UtilityService {
    public String convertDateToString(Date date) {
        log.info("Entrando a {} - convertDateToString", this.getClass().getName());
        if (date != null) {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            return dateFormat.format(date);
        }
        return null;
    }
}
