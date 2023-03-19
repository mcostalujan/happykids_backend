package com.happykids.backend.dominio.entidades;

import jakarta.persistence.*;

import java.util.Date;
@Entity(name = "Competencia")
@Table(name = "competencia")
public class Competencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_compe", updatable = false)
    private Long idCompe;

    @ManyToOne
    @JoinColumn(
            name = "nive_id_nive",
            nullable = false,
            referencedColumnName = "id_nive",
            foreignKey = @ForeignKey(name = "compe_nive_id_nive_fk")
    )
    private Nivel nivel;

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

}
