package com.happykids.backend.dominio.dto;

import com.happykids.backend.dominio.entidades.Nivel;
import com.happykids.backend.dominio.entidades.Seccion;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

public class GradoDTO {
    private String idGrado;
    private String idNivel;
    private String codGrado;
    private String gradoDesc;
    private String usuCreaGrado;
    private String fecCreaGrado;
    private String usuModiGrado;
    private String fecModiGrado;
}
