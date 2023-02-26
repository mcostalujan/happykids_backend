package com.happykids.backend.dominio.entidades;

import jakarta.persistence.EmbeddedId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AlumnoCompetencia {

    @EmbeddedId
    private AlumnoCompetenciaID alumnoCompetenciaID;

    private Date fecCreaCompe;
    private Date fecModiCompe;
    private String usuCreaCompe;
    private String usuModiCompe;
    private Float valPromedio;
    private String valPromedioDesc;

}
