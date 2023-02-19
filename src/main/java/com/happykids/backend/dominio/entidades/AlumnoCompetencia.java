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
public class AlumnoCompetencia {
private Date fecCreaCompe;
private Date fecModiCompe;
private String usuCreaCompe;
private String usuModiCompe;
private Float valPromedio;
private String valPromedioDesc;
  
}
