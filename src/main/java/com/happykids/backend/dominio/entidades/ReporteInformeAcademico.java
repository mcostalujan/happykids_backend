package com.happykids.backend.dominio.entidades;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity(name = "ReporteInformeAcademico")
@Table(name = "repo_info_acad")
@Builder
public class ReporteInformeAcademico {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_repo_info_acad", updatable = false)
    private Long idRepoInfoAcad;

    private String yearPer;

    @ManyToOne
    @JoinColumn(
            name = "doc_id_doc",
            referencedColumnName = "id_doc",
            foreignKey = @ForeignKey(name = "repoinfoacad_doc_id_doc_fk")
    )
    private Docente docente;

    @ManyToOne
    @JoinColumn(
            name = "alum_id_alum",
            nullable = false,
            referencedColumnName = "id_alum",
            foreignKey = @ForeignKey(name = "repoinfoacad_alum_id_alum_fk")
    )
    private Alumno alumno;

    @ManyToOne
    @JoinColumn(
            name = "grado_id_grado",
            nullable = false,
            referencedColumnName = "id_grado",
            foreignKey = @ForeignKey(name = "repoinfoacad_grado_id_grado_fk")
    )
    private Grado grado;

    private String codSecci;

    @ManyToOne
    @JoinColumn(
            name = "area_id_area",
            nullable = false,
            referencedColumnName = "id_area",
            foreignKey = @ForeignKey(name = "repoinfoacad_area_id_area_fk")
    )
    private Area area;


    @ManyToOne
    @JoinColumn(
            name = "aprog_id_aprog",
            referencedColumnName = "id_aprog",
            foreignKey = @ForeignKey(name = "repoinfoacad_aprog_id_aprog_fk")
    )
    private AlumnoProgreso alumnoProgreso;


    @ManyToOne
    @JoinColumn(
            name = "compe_id_compe",
            referencedColumnName = "id_compe",
            foreignKey = @ForeignKey(name = "repoinfoacad_compe_id_compe_fk")
    )
    private Competencia competencia;


    @Column(name = "val_prom_logro_1")
    private Float valPromLogroPer1;

    @Column(name = "val_prom_logro_2")
    private Float valPromLogroPer2;

    @Column(name = "val_prom_logro_3")
    private Float valPromLogroPer3;

    @Column(name = "val_prom_logro_4")
    private Float valPromLogroPer4;


    @Column(name = "val_prom_logro_desc_1")
    private String valPromLogroPerDesc1;

    @Column(name = "val_prom_logro_desc_2")
    private String valPromLogroPerDesc2;


    @Column(name = "val_prom_logro_desc_3")
    private String valPromLogroPerDesc3;


    @Column(name = "val_prom_logro_desc_4")
    private String valPromLogroPerDesc4;

    @Column(name = "nota_anual_total")
    private Float notaAnualTotal;

    @Column(name = "fec_crea")
    private Date fecCrea;

    @Column(name = "usu_crea")
    private String usuCrea;

    @Column(name = "fec_modi")
    private Date fecModi;

    @Column(name = "usu_modi")
    private String usuModi;

}
