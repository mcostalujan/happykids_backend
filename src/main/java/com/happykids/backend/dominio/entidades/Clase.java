package com.happykids.backend.dominio.entidades;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity(name = "Clase")
@Table(name = "clase")
@Builder
public class Clase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_clase", updatable = false)
    private Long idClase;

    @ManyToOne
    @JoinColumn(
            name = "per_id_per",
            referencedColumnName = "id_per",
            foreignKey = @ForeignKey(name = "clase_per_id_per_fk")
    )
    private Periodo periodo;

    @ManyToOne
    @JoinColumn(
            name = "secci_id_secci",
            referencedColumnName = "id_secci",
            foreignKey = @ForeignKey(name = "clase_secci_id_secci_fk")
    )
    private Seccion seccion;

    @ManyToOne
    @JoinColumn(
            name = "area_id_area",
            referencedColumnName = "id_area",
            foreignKey = @ForeignKey(name = "clase_area_id_area_fk")
    )
    private Area area;


    @Column(name = "estatus",length = 20)
    private ClaseEstatus estatus;

    @Column(name = "cod_clase", length = 13)
    private String codClase;

    @Column(name = "usu_crea_clase", length = 12)
    private String usuCreaClase;

    @Column(name = "fec_crea_clase")
    private Date fecCreaClase;

    @Column(name = "usu_modi_clase", length = 12)
    private String usuModiClase;

    @Column(name = "fec_modi_clase")
    private Date fecModiClase;

}
