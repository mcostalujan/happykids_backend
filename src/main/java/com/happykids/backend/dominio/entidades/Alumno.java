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
public class Alumno {

    private Long idAlum;
    private Date fechaIngresoAlum;
    private String codigoAlum;
    private String val1NameAlum;
    private String val2NameAlum;
    private String val3NameAlum;
    private String val4NameAlum;
    private String varLastPatAlum;
    private String valLastMatAlum;
    private Boolean isActiveAlumn;
    private String usuCreaAlum;
    private Date fecCreaAlum;
    private String usuModiAlum;
    private Date fecModiAlum;


}
