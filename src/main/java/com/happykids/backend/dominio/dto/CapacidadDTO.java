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

    private String idCapacidad;
    private String idCompetencia;
    private String codCapacidad;
    private String capacidadDesc;
    private String indActi;
    private String indElim;
    private String usuCreaCapacidad;
    private String fecCreaCapacidad;
    private String usuModiCapacidad;
    private String fecModiCapacidad;

}




