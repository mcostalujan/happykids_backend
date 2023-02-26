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
public class Seccion {

    private Long idSecci;
    private Grado grado;
    private String codSecci;
    private String secciDesc;
    private String usuCreaSecci;
    private Date fecCreaSecci;
    private String usuModiSecci;
    private Date fecModiSecci;

}
