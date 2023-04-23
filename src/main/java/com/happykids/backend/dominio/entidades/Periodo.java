package com.happykids.backend.dominio.entidades;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity(name = "Periodo")
@Table(name = "periodo")
@Builder
public class Periodo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_per", updatable = false)
    private Long idPer;

    @Column(name = "cod_per")
    private String codPer;

    @Column(name = "peri_edu_desc_per")
    private String periEduDescPer;

    @Column(name = "fec_ini_acti_per")
    private Date fecIniActiPer;

    @Column(name = "fec_fin_acti_per")
    private Date fecFinActiPer;

    @Column(name = "year_per")
    private Date yearPer;

    @Column(name = "usu_crea_per")
    private String usuCreaPer;

    @Column(name = "fec_crea_per")
    private Date fecCreaPer;

    @Column(name = "usu_modi_per")
    private String usuModiPer;

    @Column(name = "fec_modi_per")
    private Date fecModiPer;
}
