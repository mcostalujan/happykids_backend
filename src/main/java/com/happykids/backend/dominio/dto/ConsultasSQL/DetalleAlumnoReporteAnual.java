package com.happykids.backend.dominio.dto.ConsultasSQL;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Slf4j
public class DetalleAlumnoReporteAnual {

    private String idAlum;
    private String codigoAlum;
    private String var1NameAlum;
    private String varLastPatAlum;
    private String varLastMatAlum;

    public static DetalleAlumnoReporteAnual convertTupleToEntity(Object queryResult) {
        log.info("Entrando a NivelDisponible - convertTupleToEntity");
        Object[] aux = (Object[]) queryResult;
        log.info("Object [] - {}", Arrays.stream(aux).toList());
        return DetalleAlumnoReporteAnual.builder()
                .idAlum(String.valueOf(aux[0]))
                .codigoAlum(String.valueOf(aux[1]))
                .var1NameAlum(String.valueOf(aux[2]))
                .varLastPatAlum(String.valueOf(aux[3]))
                .varLastMatAlum(String.valueOf(aux[4]))
                .build();

    }

}
