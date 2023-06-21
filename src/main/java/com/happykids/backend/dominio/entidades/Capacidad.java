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
@Entity(name = "Capacidad")
@Table(name = "capacidad")
public class Capacidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_capacidad", updatable = false)
    private Long idCapacidad;

    @ManyToOne
    @JoinColumn(
            name = "compe_id_compe",
            nullable = false,
            referencedColumnName = "id_compe",
            foreignKey = @ForeignKey(name = "capacidad_compe_id_compe_fk")
    )
    private Competencia competencia;

    @Column(name = "cod_capacidad")
    private String codCapacidad;

    @Column(name = "capacidad_desc")
    private String capacidadDesc;

    @Column(name = "ind_acti")
    private Boolean indActi;

    @Column(name = "ind_elim")
    private Boolean indElim;

    @Column(name = "usu_crea_capacidad")
    private String usuCreaCapacidad;

    @Column(name = "fec_crea_capacidad")
    private Date fecCreaCapacidad;

    @Column(name = "usu_modi_capacidad")
    private String usuModiCapacidad;

    @Column(name = "fec_modi_capacidad")
    private Date fecModiCapacidad;

}
