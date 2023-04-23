package com.happykids.backend.dominio.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class GradoDTO {
    private String idGrado;
    private String idNivel;
    private String codGrado;
    private String gradoDesc;
    private String usuCreaGrado;
    private String fecCreaGrado;
    private String usuModiGrado;
    private String fecModiGrado;
}
