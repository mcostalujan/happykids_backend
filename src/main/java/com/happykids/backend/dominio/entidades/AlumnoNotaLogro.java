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
public class AlumnoNotaLogro {

    private Logro idAlogro;
    private AlumnoProgreso alumnoProgreso;
    private Logro logro;
    private Float notaLogro;
    private String notaLogroDesc;
    private String usuCreaAlogro;
    private Date fecCreaLogro;
    private String usuModiCompe;
    private Date fecModiCompe;


}
