package com.happykids.backend.dominio.entidades;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity(name = "ClaseDocente")
@Table(name = "clase_docente")
@Builder
public class ClaseDocente {


    @EmbeddedId
    ClaseDocenteID claseDocenteID;

    @ManyToOne
    @MapsId("idDoc")
    @JoinColumn(
            name = "doc_id_doc",
            referencedColumnName = "id_doc",
            foreignKey = @ForeignKey(name = "cladoc_doc_id_doc_fk")
    )
    private Docente docente;

    @ManyToOne
    @MapsId("idClase")
    @JoinColumn(
            name = "clase_id_clase",
            referencedColumnName = "id_clase",
            foreignKey = @ForeignKey(name = "cladoc_clase_id_clase_fk")
    )
    private Clase clase;


    private Boolean indActi;

    private String usuCreaCladoc;

    private Date fecCreaCladoc;

    private String usuModiCladoc;

    private Date fecModiCladoc;

}
