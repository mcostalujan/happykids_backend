package com.happykids.backend.dominio.entidades;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Nivel {

    private Long idNive;
    private String codNive;
    private String niveDesc;
    private String usuCreaNive;
    private Date fecCreaNive;
    private String usuModiNive;
    private Date fecModiNive;

}
