package com.happykids.backend.dominio.entidades;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity(name = "HistoricoArea")
@Table(name = "histo_area")
@Builder
public class HistoricoArea {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_area_histo", updatable = false)
    private Long idAreaHisto;

    @ManyToOne
    @JoinColumn(
            name = "area_id_area",
            nullable = false,
            referencedColumnName = "id_area",
            foreignKey = @ForeignKey(name = "histoarea_area_id_area_fk")
    )
    private Area area;

    @ManyToOne
    @JoinColumn(
            name = "nive_id_nive",
            nullable = false,
            referencedColumnName = "id_nive",
            foreignKey = @ForeignKey(name = "histoarea_nive_id_nive_fk")
    )
    private Nivel nivel;

    @Column(name = "cod_area")
    private String codArea;

    @Column(name = "area_desc")
    private String areaDesc;

    @Column(name = "usu_crea_area")
    private String usuCreaArea;

    @Column(name = "fec_crea_area")
    private Date fecCreaArea;

    @Column(name = "usu_modi_area")
    private String usuModiArea;

    @Column(name = "fec_modi_area")
    private Date fecModiArea;

    @Column(name = "ind_acti")
    private Boolean indActi;

    @Column(name = "ind_elim")
    private Boolean indElim;

    @Column(name = "fec_reg_histo")
    private Date fecRegHisto;

    @Column(name = "update_id")
    private Integer updateID;

}
