package com.happykids.backend.dominio.entidades;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity(name = "Nota")
@Table(name = "nota")
@Builder
public class Nota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_nota", updatable = false)
    private Long idNota;

    @ManyToOne
    @JoinColumn(
            name = "nive_id_nive",
            nullable = false,
            referencedColumnName = "id_nive",
            foreignKey = @ForeignKey(name = "nota_nive_id_nive_fk")
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

}
