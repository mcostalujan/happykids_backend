package com.happykids.backend.dominio.entidades;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity(name = "Grado")
@Table(name = "grado")
@Builder
public class Grado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_grado", updatable = false)
    private Long idGrado;

    @ManyToOne
    @JoinColumn(
            name = "nive_id_nive",
            nullable = false,
            referencedColumnName = "id_nive",
            foreignKey = @ForeignKey(name = "grado_nive_id_nive_fk")
    )
    private Nivel nivel;

    @OneToMany(
            mappedBy = "grado",
            orphanRemoval = true,
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
            fetch = FetchType.LAZY
    )
    private List<Seccion> seccionList;

    @Column(name = "cod_grado")
    private String codGrado;

    @Column(name = "grado_desc")
    private String gradoDesc;

    @Column(name = "usu_crea_grado")
    private String usuCreaGrado;

    @Column(name = "fec_crea_grado")
    private Date fecCreaGrado;

    @Column(name = "usu_modi_grado")
    private String usuModiGrado;

    @Column(name = "fec_modi_grado")
    private Date fecModiGrado;


    @Column(name = "ind_acti")
    private Boolean indActi;

    @Column(name = "ind_elim")
    private Boolean indElim;
}
