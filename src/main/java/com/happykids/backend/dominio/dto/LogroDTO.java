package com.happykids.backend.dominio.dto;

import java.util.Date;

import com.happykids.backend.dominio.entidades.Competencia;

import lombok.Builder;

@Builder
public class LogroDTO {

    private String idLogro;
    private String idCompetencia;
    private String codLogro;
    private String logroDesc;
    private String indActi;
    private String indElim;
    private String usuCreaLogro;
    private String fecCreaLogro;
    private String usuModiLogro;
    private String fecModiLogro;

}




