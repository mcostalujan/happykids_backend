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
public class Nota {

    private Long idNota;
    private Nivel nivel;
    private String codExpNota;
    private Integer rangInicNota;
    private Integer rangFinalNota;
    private String usuCreaNota;
    private Date fecCreaNota;
    private String usuModiNota;
    private Date fecModiNota;

}
