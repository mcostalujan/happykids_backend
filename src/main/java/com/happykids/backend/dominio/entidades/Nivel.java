package com.happykids.backend.dominio.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity(name = "Nivel")
@Table(name = "nivel")
public class Nivel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_nive", updatable = false)
    private Long idNive;

    @Column(name = "cod_nive")
    private String codNive;

    @Column(name = "nive_desc")
    private String niveDesc;

    @Column(name = "usu_crea_nive")
    private String usuCreaNive;

    @Column(name = "fec_crea_nive")
    private Date fecCreaNive;

    @Column(name = "usu_modi_nive")
    private String usuModiNive;

    @Column(name = "fec_modi_nive")
    private Date fecModiNive;


    @Column(name = "ind_acti")
    private Boolean indActi;

    @Column(name = "ind_elim")
    private Boolean indElim;

}
