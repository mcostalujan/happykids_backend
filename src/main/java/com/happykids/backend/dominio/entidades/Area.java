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
public class Area {

    private Long idArea;
    private Nivel nivel;
    private String codArea;
    private String areaDesc;
    private String usuCreaArea;
    private Date fecCreaArea;
    private String usuModiArea;
    private Date fecModiArea;

}
