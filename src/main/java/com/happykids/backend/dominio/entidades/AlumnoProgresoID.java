package com.happykids.backend.dominio.entidades;

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
public class AlumnoProgresoID implements Serializable {

    private Long idAprog;
    private Long idAlum;
    private Long idSecci;
    private Long idArea;
    private Long idPer;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AlumnoProgresoID that = (AlumnoProgresoID) o;
        return Objects.equals(idAlum, that.idAlum) && Objects.equals(idSecci, that.idSecci) && Objects.equals(idArea, that.idArea) && Objects.equals(idPer, that.idPer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAlum, idSecci, idArea, idPer);
    }
}
