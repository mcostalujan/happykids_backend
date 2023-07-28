package com.happykids.backend.dominio.entidades;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity(name = "AlumnoNotaCapacidad")
@Table(name = "alum_nota_capa")
@Builder
public class AlumnoNotaCapacidad {

    @EmbeddedId
    AlumnoNotaCapacidadID alumnoNotaCapacidadID;

    @ManyToOne
    @MapsId("idAcompe")
    @JoinColumn(
            name = "acompe_id_acompe",
            referencedColumnName = "id_acompe",
            foreignKey = @ForeignKey(name = "alnoc_acompe_id_acompe_fk")
    )
    private AlumnoCompetencia alumnoCompetencia;

    @ManyToOne
    @MapsId("idCapacidad")
    @JoinColumn(
            name = "capacidad_id_capacidad",
            referencedColumnName = "id_capacidad",
            foreignKey = @ForeignKey(name = "alnoc_capacidad_id_capacidad_fk")
    )
    private Capacidad capacidad;

    @Column(name = "nota_capacidad")
    private Float notaCapacidad;

    @Column(name = "nota_capacidad_desc")
    private String notaCapacidadDesc;

    @Column(name = "usu_crea_capa")
    private String usuCreaCapa;

    @Column(name = "fec_crea_capa")
    private Date fecCreaCapa;

    @Column(name = "usu_modi_capa")
    private String usuModiCapa;

    @Column(name = "fec_modi_capa")
    private Date fecModiCapa;

    @Column(name = "ind_acti")
    private Boolean indActi;

    @Column(name = "ind_elim")
    private Boolean indElim;
}
