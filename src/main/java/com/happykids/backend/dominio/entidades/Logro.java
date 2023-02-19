package com.happykids.backend.dominio.entidades;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Logro {

    private Long idLogro;
    private Competencia competencia;
    private String codLogro;
    private String logroDesc;
    private Boolean indActi;
    private Boolean indElim;
    private String usuCreaLogro;
    private Date fecCreaLogro;
    private String usuModiLogro;
    private Date fecModiLogro;

}
