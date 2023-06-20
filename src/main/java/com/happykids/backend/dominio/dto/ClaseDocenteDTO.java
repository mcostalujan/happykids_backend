package com.happykids.backend.dominio.dto;

import com.happykids.backend.dominio.entidades.Clase;
import com.happykids.backend.dominio.entidades.Docente;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ClaseDocenteDTO {
    private String idDoc;
    private String idClase;
    private String indActi;
    private String usuCreaCladoc;
    private String fecCreaCladoc;
    private String usuModiCladoc;
    private String fecModiCladoc;
}
