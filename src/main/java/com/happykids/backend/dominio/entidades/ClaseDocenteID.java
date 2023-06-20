package com.happykids.backend.dominio.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ClaseDocenteID implements Serializable {

    @Column(name = "id_doc")
    private Long idDoc;

    @Column(name = "id_clase")
    private Long idClase;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClaseDocenteID that = (ClaseDocenteID) o;
        return Objects.equals(idDoc, that.idDoc) && Objects.equals(idClase, that.idClase);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idDoc, idClase);
    }
}
