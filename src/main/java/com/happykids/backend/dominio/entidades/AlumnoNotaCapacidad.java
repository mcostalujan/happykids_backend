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
@Table(name = "alum_nota_capa")
public class AlumnoNotaCapacidad {

    @EmbeddedId
    AlumnoNotaCapacidadID alumnoNotaCapacidadID;

    @ManyToOne
    @MapsId("idAprog")
    @JoinColumn(
            name = "aprog_id_aprog",
            referencedColumnName = "id_aprog",
            foreignKey = @ForeignKey(name = "alnoc_aprog_id_aprog_fk")
    )
    private AlumnoProgreso alumnoProgreso;

    @ManyToOne
    @MapsId("idCapacidad")
    @JoinColumn(
            name = "capacidad_id_capacidad",
            referencedColumnName = "id_capacidad",
            foreignKey = @ForeignKey(name = "alnoc_capacidad_id_capacidad_fk")
    )
    private Capacidad capacidad;

    @Column(name = "nota_capacidad")
    private Float notaCapacidad;

    @Column(name = "nota_capacidad_desc")
    private String notaCapacidadDesc;

    @Column(name = "usu_crea_capa")
    private String usuCreaCapa;

    @Column(name = "fec_crea_capa")
    private Date fecCreaCapa;

    @Column(name = "usu_modi_capa")
    private String usuModiCapa;

    @Column(name = "fec_modi_capa")
    private Date fecModiCapa;


}
