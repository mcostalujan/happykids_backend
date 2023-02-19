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
public class Periodo {

    private Long idPer;
    private String codPer;
    private String periEduDescPer;
    private Date fecIniActiPer;
    private Date fecFinActiPer;
    private String yearPer;
    private String usuCreaPer;
    private Date fecCreaPer;
    private String usuModiPer;
    private Date fecModiPer;
}
