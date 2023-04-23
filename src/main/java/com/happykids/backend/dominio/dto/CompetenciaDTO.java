package com.happykids.backend.dominio.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CompetenciaDTO {
    private String idCompe;
    private String idNivel;
    private String codigoCompe;
    private String descCompe;
    private String indActiCompe;
    private String indElimCompe;
    private String usuCreaCompe;
    private String fecCreaCompe;
    private String usuModiCompe;
    private String fecModiCompe;
}
