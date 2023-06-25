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
public class DetalleAlumnoPorClase {


    private String idClase;
    private String codClase;
    private String idAprog;
    private String fecCreaAlumProg;
    private String idPer;
    private String codPer;
    private String yearPer;
    private String periEduDescPer;
    private String idNive;
    private String codNive;
    private String niveDesc;
    private String idGrado;
    private String codGrado;
    private String gradoDesc;
    private String idSecci;
    private String codSecci;
    private String secciDesc;
    private String idArea;
    private String codArea;
    private String areaDesc;
    private String idAlum;
    private String codigoAlum;
    private String var1NameAlum;
    private String varLastPatAlum;
    private String varLastMatAlum;

    public static DetalleAlumnoPorClase convertTupleToEntity(Object queryResult) {
        log.info("Entrando a DetalleAlumnosPorClase - convertTupleToEntity");
        Object[] aux = (Object[]) queryResult;
        log.info("Object [] - {}", Arrays.stream(aux).toList());
        return DetalleAlumnoPorClase.builder()
                .idClase(String.valueOf(aux[0]))
                .codClase(String.valueOf(aux[1]))
                .idAprog(String.valueOf(aux[2]))
                .fecCreaAlumProg(String.valueOf(aux[3]))
                .idPer(String.valueOf(aux[4]))
                .codPer(String.valueOf(aux[5]))
                .yearPer(String.valueOf(aux[6]))
                .periEduDescPer(String.valueOf(aux[7]))
                .idNive(String.valueOf(aux[8]))
                .codNive(String.valueOf(aux[9]))
                .niveDesc(String.valueOf(aux[10]))
                .idGrado(String.valueOf(aux[11]))
                .codGrado(String.valueOf(aux[12]))
                .gradoDesc(String.valueOf(aux[13]))
                .idSecci(String.valueOf(aux[14]))
                .codSecci(String.valueOf(aux[15]))
                .secciDesc(String.valueOf(aux[16]))
                .idArea(String.valueOf(aux[17]))
                .codArea(String.valueOf(aux[18]))
                .areaDesc(String.valueOf(aux[19]))
                .idAlum(String.valueOf(aux[20]))
                .codigoAlum(String.valueOf(aux[21]))
                .var1NameAlum(String.valueOf(aux[22]))
                .varLastPatAlum(String.valueOf(aux[23]))
                .varLastMatAlum(String.valueOf(aux[24]))
                .build();

    }

}
