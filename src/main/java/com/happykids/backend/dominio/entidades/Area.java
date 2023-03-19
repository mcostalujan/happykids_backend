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
@Entity(name = "Area")
@Table(name = "area")
public class Area {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_area", updatable = false)
    private Long idArea;

    @ManyToOne
    @JoinColumn(
            name = "nive_id_nive",
            nullable = false,
            referencedColumnName = "id_nive",
            foreignKey = @ForeignKey(name = "area_nive_id_nive_fk")
    )
    private Nivel nivel;

    @Column(name = "cod_area")
    private String codArea;

    @Column(name = "area_desc")
    private String areaDesc;

    @Column(name = "usu_crea_area")
    private String usuCreaArea;

    @Column(name = "fec_crea_area")
    private Date fecCreaArea;

    @Column(name = "usu_modi_area")
    private String usuModiArea;

    @Column(name = "fec_modi_area")
    private Date fecModiArea;

}
