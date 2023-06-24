package com.happykids.backend.dominio.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Builder

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity(name = "AlumnoCompetencia")
@Table(name = "alum_compe")
public class AlumnoCompetencia {

//    @EmbeddedId
//    private AlumnoCompetenciaID alumnoCompetenciaID;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_acompe", updatable = false)
    private Long idAcompe;

    @ManyToOne
    @JoinColumn(
            name = "aprog_id_aprog",
            referencedColumnName = "id_aprog",
            foreignKey = @ForeignKey(name = "acompe_aprog_id_aprog_fk")
    )
    private AlumnoProgreso alumnoProgreso;

    @ManyToOne
    @JoinColumn(
            name = "compe_id_compe",
            referencedColumnName = "id_compe",
            foreignKey = @ForeignKey(name = "acompe_compe_id_compe_fk")
    )
    private Competencia competencia;

    @Column(name="cod_acompe")
    private String codAcompe;
    
    @Column(name="ind_acti")
    private Boolean indActi;

    @Column(name = "fec_crea_compe")
    private Date fecCreaCompe;

    @Column(name = "fec_modi_compe")
    private Date fecModiCompe;

    @Column(name = "usu_crea_compe")
    private String usuCreaCompe;

    @Column(name = "usu_modi_compe")
    private String usuModiCompe;

    @Column(name = "val_prom_logro")
    private Float valPromLogro;

    @Column(name = "val_prom_logro_desc")
    private String valPromLogroDesc;

}
