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
@Entity(name = "AlumnoNotaCapacidad")
@Table(name = "alum_nota_Capacidad")
public class AlumnoNotaCapacidad {

    @EmbeddedId
    AlumnoNotaCapacidadID alumnoNotaCapacidadID;

    @ManyToOne
    @MapsId("idAprog")
    @JoinColumn(name = "aprog_id_aprog")
    private AlumnoProgreso alumnoProgreso;

    @ManyToOne
    @MapsId("idCapacidad")
    @JoinColumn(name = "capacidad_id_capacidad")
    private Capacidad capacidad;

    @Column(name = "nota_capacidad")
    private Float notaCapacidad;

    @Column(name = "nota_capacidad_desc")
    private String notaCapacidadDesc;

    @Column(name = "usu_crea_acapacidad")
    private String usuCreaAcapacidad;

    @Column(name = "fec_crea_acapacidad")
    private Date fecCreaCapacidad;

    @Column(name = "usu_modi_acapacidad")
    private String usuModiCompe;

    @Column(name = "fec_modi_acapacidad")
    private Date fecModiCompe;


}
