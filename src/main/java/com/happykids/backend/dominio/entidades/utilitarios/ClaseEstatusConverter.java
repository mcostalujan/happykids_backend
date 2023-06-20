package com.happykids.backend.dominio.entidades.utilitarios;

import com.happykids.backend.dominio.entidades.ClaseEstatus;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.stream.Stream;

@Converter(autoApply = true)
public class ClaseEstatusConverter implements AttributeConverter<ClaseEstatus, String> {
    @Override
    public String convertToDatabaseColumn(ClaseEstatus claseEstatus) {
        if (claseEstatus == null) {
            return null;
        }
        return claseEstatus.getValue();
    }

    @Override
    public ClaseEstatus convertToEntityAttribute(String value) {
        if (value == null) {
            return null;
        }
        //Añadir lógica de conversión si los estados cambian en un futuro
        return ClaseEstatus.valueOfLabel(value);
    }
}
