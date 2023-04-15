package com.happykids.backend.aplicacion.implServicios.utilitarios;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
@Slf4j
public class UtilityService {

    public static final String DATE_FORMAT = "yyyy-MM-dd hh:mm:ss";

    public String convertDateToString(Date date) {
        log.info("Entrando a {} - convertDateToString", this.getClass().getName());
        if (date != null) {
            DateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
            return dateFormat.format(date);
        }
        return null;
    }

    public Date convertStringToDate(String stringDate) {
        log.info("Entrando a {} - convertStringToDate", this.getClass().getName());
        if (stringDate != null && !stringDate.isEmpty()) {
            try {
                return new SimpleDateFormat(DATE_FORMAT).parse(stringDate);
            } catch (Exception ex) {
                log.info("Error en {} - Conversion de String to Date fallida", this.getClass().getName());
                return null;
            }
        }
        return null;
    }
}
