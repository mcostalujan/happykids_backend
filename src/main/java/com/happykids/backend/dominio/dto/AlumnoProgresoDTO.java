package com.happykids.backend.dominio.dto;

import com.happykids.backend.dominio.entidades.Alumno;
import com.happykids.backend.dominio.entidades.Area;
import com.happykids.backend.dominio.entidades.Periodo;
import com.happykids.backend.dominio.entidades.Seccion;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;


@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AlumnoProgresoDTO {

    private String idAprog;
    private String idAlumno;
//    private String idSeccion;
//    private String idArea;
//    private String idPeriodo;
    private String indAntiAlumprog;
    private String usuCreaAlumprog;
    private String fecCreaAlumprog;
    private String usuModiAlumprog;
    private String fecModiAlmprog;

}
