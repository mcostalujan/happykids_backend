package com.happykids.backend.dominio.entidades;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AlumnoCompetenciaID implements Serializable {

    private Long idAprog;
    private Long idCompe;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AlumnoCompetenciaID that = (AlumnoCompetenciaID) o;
        return Objects.equals(idAprog, that.idAprog) && Objects.equals(idCompe, that.idCompe);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAprog, idCompe);
    }
}
