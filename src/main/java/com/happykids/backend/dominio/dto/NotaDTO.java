package com.happykids.backend.dominio.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NotaDTO {

    private String idNota;
    private String idNivel;
    private String codExpNota;
    private String rangInicNota;
    private String rangFinalNota;
    private String usuCreaNota;
    private String fecCreaNota;
    private String usuModiNota;
    private String fecModiNota;
}
