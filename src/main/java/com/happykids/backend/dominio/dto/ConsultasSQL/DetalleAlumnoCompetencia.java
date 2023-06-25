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
public class DetalleAlumnoCompetencia {


    private String idAlum;
    private String codigoAlum;
    private String var1NameAlum;
    private String varLastPatAlum;
    private String varLastMatAlum;
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
    private String idCompe;
    private String codigoCompe;
    private String descCompe;
    private String idAcompe;
    private String codAcompe;
    private String valPromLogro;
    private String valPromLogroDesc;


    public static DetalleAlumnoCompetencia convertTupleToEntity(Object queryResult) {
        log.info("Entrando a DetalleAlumnoCompetencia - convertTupleToEntity");
        Object[] aux = (Object[]) queryResult;
        log.info("Object [] - {}", Arrays.stream(aux).toList());
        return DetalleAlumnoCompetencia.builder()
                .idAlum(String.valueOf(aux[0]))
                .codigoAlum(String.valueOf(aux[1]))
                .var1NameAlum(String.valueOf(aux[2]))
                .varLastPatAlum(String.valueOf(aux[3]))
                .varLastMatAlum(String.valueOf(aux[4]))
                .idNive(String.valueOf(aux[5]))
                .codNive(String.valueOf(aux[6]))
                .niveDesc(String.valueOf(aux[7]))
                .idGrado(String.valueOf(aux[8]))
                .codGrado(String.valueOf(aux[9]))
                .gradoDesc(String.valueOf(aux[10]))
                .idSecci(String.valueOf(aux[11]))
                .codSecci(String.valueOf(aux[12]))
                .secciDesc(String.valueOf(aux[13]))
                .idArea(String.valueOf(aux[14]))
                .codArea(String.valueOf(aux[15]))
                .areaDesc(String.valueOf(aux[16]))
                .idCompe(String.valueOf(aux[17]))
                .codigoCompe(String.valueOf(aux[18]))
                .descCompe(String.valueOf(aux[19]))
                .idAcompe(String.valueOf(aux[20]))
                .codAcompe(String.valueOf(aux[21]))
                .valPromLogro(String.valueOf(aux[22]))
                .valPromLogroDesc(String.valueOf(aux[23]))
                .build();

    }


}
