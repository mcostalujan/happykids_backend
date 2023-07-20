package com.happykids.backend.dominio.entidades;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity(name = "HistorialRuntimeInformeAnualAlumno")
@Table(name = "histo_runtime_info_anual_alum")
@Builder
public class HistorialRuntimeInformeAnualAlumno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_run_repo_anu", updatable = false)
    private Long idRunRepoAnu;

    @Column(name = "idAlum")
    private Long idAlum;

    @Column(name = "year")
    private String year;

    @Column(name = "runtime")
    private Double runtime;

    @Column(name = "fec_crea")
    private Date fecCrea;

    @Column(name = "usu_crea")
    private String usuCrea;

    @Column(name = "fec_modi")
    private Date fecModi;

    @Column(name = "usu_modi")
    private String usuModi;

}
