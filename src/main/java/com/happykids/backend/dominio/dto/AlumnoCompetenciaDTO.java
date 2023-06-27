package com.happykids.backend.dominio.dto;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class AlumnoCompetenciaDTO {
    private String idAcompe;
    private String codAcompe;
    private String idAprog;
    private String idCompe;
    private String fecCreaCompe;
    private String fecModiCompe;
    private String usuCreaCompe;
    private String usuModiCompe;
    private String valPromLogro;
    private String valPromLogroDesc;
    private String indActi;
    private String runtime;
}
