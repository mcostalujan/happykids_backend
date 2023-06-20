package com.happykids.backend.dominio.dto.ConsultasSQL;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Slf4j
public class DetalleClase {

    private String idClase;
    private String codClase;
    private String estatus;
    private String idPer;
    private String periEduDescPer;
    private String idNive;
    private String niveDesc;
    private String idGrado;
    private String codGrado;
    private String idSecci;
    private String codSecci;
    private String idArea;
    private String areaDesc;

    public static DetalleClase convertTupleToEntity(Object queryResult) {
        log.info("Entrando a DetalleClase - convertTupleToEntity");
        Object[] aux = (Object[]) queryResult;
        log.info("Object [] - {}", aux);
        return DetalleClase.builder()
                .idClase(String.valueOf(aux[0]))
                .codClase(String.valueOf(aux[1]))
                .estatus(String.valueOf(aux[2]))
                .idPer(String.valueOf(aux[3]))
                .periEduDescPer(String.valueOf(aux[4]))
                .idNive(String.valueOf(aux[5]))
                .niveDesc(String.valueOf(aux[6]))
                .idGrado(String.valueOf(aux[7]))
                .codGrado(String.valueOf(aux[8]))
                .idSecci(String.valueOf(aux[9]))
                .codSecci(String.valueOf(aux[10]))
                .idArea(String.valueOf(aux[11]))
                .areaDesc(String.valueOf(aux[12]))
                .build();

    }

}
