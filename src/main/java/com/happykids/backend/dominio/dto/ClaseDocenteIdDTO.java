package com.happykids.backend.dominio.dto;

import lombok.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ClaseDocenteIdDTO {
    private String idDoc;
    private String idClase;
}
