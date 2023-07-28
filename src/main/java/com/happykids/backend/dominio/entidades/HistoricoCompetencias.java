package com.happykids.backend.dominio.entidades;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity(name = "HistoricoCompetencias")
@Table(name = "histo_compe")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class HistoricoCompetencias {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_compe_histo", updatable = false)
    private Long idCompeHisto;


    @ManyToOne
    @JoinColumn(
            name = "compe_id_compe",
            nullable = false,
            referencedColumnName = "id_compe",
            foreignKey = @ForeignKey(name = "histocompe_compe_id_compe_fk")
    )
    private Competencia competencia;

    @Column(name = "codigo_compe")
    private String codigoCompe;

    @Column(name = "desc_compe")
    private String descCompe;

    @Column(name = "ind_acti_compe")
    private Boolean indActiCompe;

    @Column(name = "ind_elim_compe")
    private Boolean indElimCompe;

    @Column(name = "usu_crea_compe")
    private String usuCreaCompe;

    @Column(name = "fec_crea_compe")
    private Date fecCreaCompe;

    @Column(name = "usu_modi_compe")
    private String usuModiCompe;

    @Column(name = "fec_modi_compe")
    private Date fecModiCompe;


    @ManyToOne
    @JoinColumn(
            name = "area_id_area",
            referencedColumnName = "id_area",
            foreignKey = @ForeignKey(name = "histocompe_area_id_area_fk")
    )
    private Area area;


    @Column(name = "fec_reg_histo")
    private Date fecRegHisto;

    @Column(name = "update_id")
    private Integer updateID;

}
