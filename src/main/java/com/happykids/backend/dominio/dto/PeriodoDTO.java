package com.happykids.backend.dominio.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PeriodoDTO {
    private String idPer;
    private String codPer;
    private String periEduDescPer;
    private String fecIniActiPer;
    private String fecFinActiPer;
    private String yearPer;
    private String usuCreaPer;
    private String fecCreaPer;
    private String usuModiPer;
    private String fecModiPer;
}
