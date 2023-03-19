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
@Entity(name = "AlumnoNotaLogro")
@Table(name = "alum_nota_logro")
public class AlumnoNotaLogro {

    @EmbeddedId
    AlumnoNotaLogroID alumnoNotaLogroID;

    @ManyToOne
    @MapsId("idAprog")
    @JoinColumn(name = "aprog_id_aprog")
    private AlumnoProgreso alumnoProgreso;

    @ManyToOne
    @MapsId("idLogro")
    @JoinColumn(name = "logro_id_logro")
    private Logro logro;

    @Column(name = "nota_logro")
    private Float notaLogro;

    @Column(name = "nota_logro_desc")
    private String notaLogroDesc;

    @Column(name = "usu_crea_alogro")
    private String usuCreaAlogro;

    @Column(name = "fec_crea_alogro")
    private Date fecCreaLogro;

    @Column(name = "usu_modi_alogro")
    private String usuModiCompe;

    @Column(name = "fec_modi_alogro")
    private Date fecModiCompe;


}
