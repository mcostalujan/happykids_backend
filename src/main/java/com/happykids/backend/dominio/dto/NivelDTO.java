package com.happykids.backend.dominio.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NivelDTO {
    private String idNive;
    private String codNive;
    private String niveDesc;
    private String usuCreaNive;
    private String fecCreaNive;
    private String usuModiNive;
    private String fecModiNive;


}
