package com.happykids.backend.dominio.entidades;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity(name = "HistoricoCapacidad")
@Table(name = "histo_capa")
public class HistoricoCapacidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_capa_histo", updatable = false)
    private Long idCapaHisto;


    @ManyToOne
    @JoinColumn(
            name = "capa_id_capa",
            nullable = false,
            referencedColumnName = "id_capacidad",
            foreignKey = @ForeignKey(name = "histocapa_capa_id_capa_fk")
    )
    private Capacidad capacidad;

    @ManyToOne
    @JoinColumn(
            name = "compe_id_compe",
            nullable = false,
            referencedColumnName = "id_compe",
            foreignKey = @ForeignKey(name = "histocapa_compe_id_compe_fk")
    )
    private Competencia competencia;

    @Column(name = "cod_capacidad")
    private String codCapacidad;

    @Column(name = "capacidad_desc")
    private String capacidadDesc;

    @Column(name = "ind_acti")
    private Boolean indActi;

    @Column(name = "ind_elim")
    private Boolean indElim;

    @Column(name = "usu_crea_capacidad")
    private String usuCreaCapacidad;

    @Column(name = "fec_crea_capacidad")
    private Date fecCreaCapacidad;

    @Column(name = "usu_modi_capacidad")
    private String usuModiCapacidad;

    @Column(name = "fec_modi_capacidad")
    private Date fecModiCapacidad;

    @Column(name = "fec_reg_histo")
    private Date fecRegHisto;

    @Column(name = "update_id")
    private Integer updateID;

}
