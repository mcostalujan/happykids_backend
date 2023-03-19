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
@Entity(name = "Logro")
@Table(name = "logro")
public class Logro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_logro", updatable = false)
    private Long idLogro;

    @ManyToOne
    @JoinColumn(
            name = "compe_id_compe",
            nullable = false,
            referencedColumnName = "id_compe",
            foreignKey = @ForeignKey(name = "logro_compe_id_compe_fk")
    )
    private Competencia competencia;

    @Column(name = "cod_logro")
    private String codLogro;

    @Column(name = "logro_desc")
    private String logroDesc;

    @Column(name = "ind_acti")
    private Boolean indActi;

    @Column(name = "ind_elim")
    private Boolean indElim;

    @Column(name = "usu_crea_logro")
    private String usuCreaLogro;

    @Column(name = "fec_crea_logro")
    private Date fecCreaLogro;

    @Column(name = "usu_modi_logro")
    private String usuModiLogro;

    @Column(name = "fec_modi_logro")
    private Date fecModiLogro;

}
