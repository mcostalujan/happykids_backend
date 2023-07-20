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
public class GradoDisponible {
    private String idGrado;
    private String gradoDesc;
    private String codGrado;

    public static GradoDisponible convertTupleToEntity(Object queryResult) {
        log.info("Entrando a NivelDisponible - convertTupleToEntity");
        Object[] aux = (Object[]) queryResult;
        log.info("Object [] - {}", Arrays.stream(aux).toList());
        return GradoDisponible.builder()
                .gradoDesc(String.valueOf(aux[0]))
                .idGrado(String.valueOf(aux[1]))
                .codGrado(String.valueOf(aux[2]))
                .build();

    }
}
