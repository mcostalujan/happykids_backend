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
public class SeccionDisponible {
    private String idSeccion;
    private String secciDesc;
    private String codSecci;

    public static SeccionDisponible convertTupleToEntity(Object queryResult) {
        log.info("Entrando a NivelDisponible - convertTupleToEntity");
        Object[] aux = (Object[]) queryResult;
        log.info("Object [] - {}", Arrays.stream(aux).toList());
        return SeccionDisponible.builder()
                .secciDesc(String.valueOf(aux[0]))
                .idSeccion(String.valueOf(aux[1]))
                .codSecci(String.valueOf(aux[2]))
                .build();

    }
}
