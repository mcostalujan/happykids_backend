package com.happykids.backend.dominio.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AreaDTO {
    private String idArea;
    private String idNivel;
    private String codArea;
    private String areaDesc;
    private String usuCreaArea;
    private String fecCreaArea;
    private String usuModiArea;
    private String fecModiArea;
}
