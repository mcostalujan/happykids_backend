package com.happykids.backend.dominio.entidades;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity(name = "AlumnoProgreso")
@Table(name = "alum_prog")
@Builder
public class AlumnoProgreso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_aprog", updatable = false)
    private Long idAprog;

    @ManyToOne
    @JoinColumn(
            name = "alum_id_alum",
            nullable = false,
            referencedColumnName = "id_alum",
            foreignKey = @ForeignKey(name = "aprog_alum_id_alum_fk")
    )
    private Alumno alumno;

    @OneToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    @JoinColumn(
            name = "secci_id_secci",
            referencedColumnName = "id_secci",
            foreignKey = @ForeignKey(name = "aprog_secci_id_secci_fk")
    )
    private Seccion seccion;

    @OneToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    @JoinColumn(
            name = "area_id_area",
            referencedColumnName = "id_area",
            foreignKey = @ForeignKey(name = "aprog_area_id_area_fk")
    )
    private Area area;

    @OneToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    @JoinColumn(
            name = "per_id_per",
            referencedColumnName = "id_per",
            foreignKey = @ForeignKey(name = "aprog_per_id_per_fk")
    )
    private Periodo periodo;


    @Column(name = "ind_acti_alumprog")
    private Boolean indAntiAlumprog;

    @Column(name = "usu_crea_alumprog")
    private String usuCreaAlumprog;

    @Column(name = "fec_crea_alumprog")
    private Date fecCreaAlumprog;

    @Column(name = "usu_modi_alumprog")
    private String usuModiAlumprog;

    @Column(name = "fec_modi_alumprog")
    private Date fecModiAlmprog;


}

