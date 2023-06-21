package com.happykids.backend.dominio.dto;

import java.util.Date;

import com.happykids.backend.dominio.entidades.Competencia;

import lombok.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CapacidadDTO {

    private String idcapacidad;
    private String idCompetencia;
    private String codcapacidad;
    private String capacidadDesc;
    private String indActi;
    private String indElim;
    private String usuCreacapacidad;
    private String fecCreacapacidad;
    private String usuModicapacidad;
    private String fecModicapacidad;

}




