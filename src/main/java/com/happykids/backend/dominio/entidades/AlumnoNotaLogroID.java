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
public class AlumnoNotaLogroID implements Serializable {

    @Column(name = "id_aprog")
    private Long idAprog;

    @Column(name = "id_logro")
    private Long idLogro;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AlumnoNotaLogroID that = (AlumnoNotaLogroID) o;
        return Objects.equals(idAprog, that.idAprog) && Objects.equals(idLogro, that.idLogro);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAprog, idLogro);
    }
}
