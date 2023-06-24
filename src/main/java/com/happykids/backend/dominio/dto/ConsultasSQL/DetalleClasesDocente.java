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
public class DetalleClasesDocente {

    private String idClase;
    private String codClase;
    private String fecCreaCladoc;
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
    private String idDoc;
    private String codigoDoc;
    private String val1NameDoc;
    private String valLastPatDoc;
    private String valLastMatDoc;


    public static DetalleClasesDocente convertTupleToEntity(Object queryResult) {
        log.info("Entrando a DetalleClasesDocente - convertTupleToEntity");
        Object[] aux = (Object[]) queryResult;
        log.info("Object [] - {}", Arrays.stream(aux).toList());
        return DetalleClasesDocente.builder()
                .idClase(String.valueOf(aux[0]))
                .codClase(String.valueOf(aux[1]))
                .fecCreaCladoc(String.valueOf(aux[2]))
                .idPer(String.valueOf(aux[3]))
                .codPer(String.valueOf(aux[4]))
                .yearPer(String.valueOf(aux[5]))
                .periEduDescPer(String.valueOf(aux[6]))
                .idNive(String.valueOf(aux[7]))
                .codNive(String.valueOf(aux[8]))
                .niveDesc(String.valueOf(aux[9]))
                .idGrado(String.valueOf(aux[10]))
                .codGrado(String.valueOf(aux[11]))
                .gradoDesc(String.valueOf(aux[12]))
                .idSecci(String.valueOf(aux[13]))
                .codSecci(String.valueOf(aux[14]))
                .secciDesc(String.valueOf(aux[15]))
                .idArea(String.valueOf(aux[16]))
                .codArea(String.valueOf(aux[17]))
                .areaDesc(String.valueOf(aux[18]))
                .idDoc(String.valueOf(aux[18]))
                .codigoDoc(String.valueOf(aux[20]))
                .val1NameDoc(String.valueOf(aux[21]))
                .valLastPatDoc(String.valueOf(aux[22]))
                .valLastMatDoc(String.valueOf(aux[23]))
                .build();

    }

}
