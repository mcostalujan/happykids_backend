package com.happykids.backend.dominio.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity(name = "AlumnoCompetencia")
@Table(name = "alum_compe")
public class AlumnoCompetencia {

    @EmbeddedId
    private AlumnoCompetenciaID alumnoCompetenciaID;

    @ManyToOne
    @MapsId("idAprog")
    @JoinColumn(
            name = "aprog_id_aprog",
            referencedColumnName = "id_aprog",
            foreignKey = @ForeignKey(name = "acompe_aprog_id_aprog_fk")
    )
    private AlumnoProgreso alumnoProgreso;

    @ManyToOne
    @MapsId("idCompe")
    @JoinColumn(
            name = "compe_id_compe",
            referencedColumnName = "id_compe",
            foreignKey = @ForeignKey(name = "acompe_compe_id_compe_fk")
    )
    private Competencia competencia;

    @Column(name = "fec_crea_compe")
    private Date fecCreaCompe;

    @Column(name = "fec_modi_compe")
    private Date fecModiCompe;

    @Column(name = "usu_crea_compe")
    private String usuCreaCompe;

    @Column(name = "usu_modi_compe")
    private String usuModiCompe;

    @Column(name = "val_promedio")
    private Float valPromedio;

    @Column(name = "val_promedio_desc")
    private String valPromedioDesc;

}
