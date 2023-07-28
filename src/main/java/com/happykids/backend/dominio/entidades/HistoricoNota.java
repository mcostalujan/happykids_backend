package com.happykids.backend.dominio.entidades;


import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity(name = "HistoricoNota")
@Table(name = "histo_nota")
@Builder
public class HistoricoNota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_nota_histo", updatable = false)
    private Long idNotaHisto;


    @ManyToOne
    @JoinColumn(
            name = "nota_id_nota",
            nullable = false,
            referencedColumnName = "id_nota",
            foreignKey = @ForeignKey(name = "histonota_id_nota_fk")
    )
    private Nota nota;


    @ManyToOne
    @JoinColumn(
            name = "nive_id_nive",
            nullable = false,
            referencedColumnName = "id_nive",
            foreignKey = @ForeignKey(name = "histonota_nive_id_nive_fk")
    )
    private Nivel nivel;


    @Column(name = "cod_exp_nota")
    private String codExpNota;

    @Column(name = "rang_inic_nota")
    private Integer rangInicNota;

    @Column(name = "rang_final_nota")
    private Integer rangFinalNota;

    @Column(name = "usu_crea_nota")
    private String usuCreaNota;

    @Column(name = "fec_crea_nota")
    private Date fecCreaNota;

    @Column(name = "usu_modi_nota")
    private String usuModiNota;

    @Column(name = "fec_modi_nota")
    private Date fecModiNota;


    @Column(name = "ind_acti")
    private Boolean indActi;

    @Column(name = "ind_elim")
    private Boolean indElim;

    @Column(name = "fec_reg_histo")
    private Date fecRegHisto;

    @Column(name = "update_id")
    private Integer updateID;

}
