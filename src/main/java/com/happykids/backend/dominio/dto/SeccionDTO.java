package com.happykids.backend.dominio.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SeccionDTO {
    private String idSecci;
    private String idGrado;
    private String codSecci;
    private String secciDesc;
    private String usuCreaSecci;
    private String fecCreaSecci;
    private String usuModiSecci;
    private String fecModiSecci;
}
