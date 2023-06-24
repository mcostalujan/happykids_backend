package com.happykids.backend.dominio.dto;

import lombok.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AlumnoNotaCapacidadDTO {

    private String idAcompe;
    private String idCapacidad;
    private String notaCapacidad;
    private String notaCapacidadDesc;
    private String usuCreaCapa;
    private String fecCreaCapa;
    private String usuModiCapa;
    private String fecModiCapa;
    private String indActi;

}