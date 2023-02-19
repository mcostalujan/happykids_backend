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
public class AlumnoProgreso {
    
    private Date fecCreaAlumprog;
    private Date fecModiAlmprog;
    private Long idAprog;
    private Boolean indAntiAlumprog;
    private String usuCreaAlumprog;
    private String usuModiAlumprog;
    

}

