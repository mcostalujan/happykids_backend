package com.happykids.backend.dominio.dto;

import lombok.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ClaseDTO {
    private String idClase;
    private String idPer;
    private String idSecci;
    private String idArea;
    private String estatus;
    private String codClase;
    private String usuCreaClase;
    private String fecCreaClase;
    private String usuModiClase;
    private String fecModiClase;
}
