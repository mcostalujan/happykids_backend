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
public class Grado {

    private Long idGrado;
    private Nivel nivel;
    private String codGrado;
    private String gradoDesc;
    private String usuCreaGrado;
    private Date fecCreaGrado;
    private String usuModiGrado;
    private Date fecModiGrado;

}
