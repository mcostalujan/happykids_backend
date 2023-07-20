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
public class NivelDisponible {
    private String idNive;
    private String niveDesc;
    private String codNive;

    public static NivelDisponible convertTupleToEntity(Object queryResult) {
        log.info("Entrando a NivelDisponible - convertTupleToEntity");
        Object[] aux = (Object[]) queryResult;
        log.info("Object [] - {}", Arrays.stream(aux).toList());
        return NivelDisponible.builder()
                .niveDesc(String.valueOf(aux[0]))
                .idNive(String.valueOf(aux[1]))
                .codNive(String.valueOf(aux[2]))
                .build();

    }
}
