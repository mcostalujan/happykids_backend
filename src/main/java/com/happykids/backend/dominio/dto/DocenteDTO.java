package com.happykids.backend.dominio.dto;

import com.happykids.backend.dominio.entidades.ClaseDocente;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DocenteDTO {

    private String idDoc;
    private String codigoDoc;
    private String val1NameDoc;
    private String val2NameDoc;
    private String val3NameDoc;
    private String val4NameDoc;
    private String valLastPatDoc;
    private String valLastMatDoc;
    private String indActiDoc;
    private String usuCreaDoc;
    private String fecCreaDoc;
    private String usuModiDoc;
    private String fecModiDoc;

}
