package com.happykids.backend.dominio.dto;

import lombok.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AlumnoNotaCapacidadIdDto {

    private Long idAcompe;
    private Long idCapacidad;

}
