package com.happykids.backend.dominio.entidades;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity(name = "Seccion")
@Table(name = "seccion")
@Builder
public class Seccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_secci", updatable = false)
    private Long idSecci;


    @ManyToOne
    @JoinColumn(
            name = "grado_id_grado",
            nullable = false,
            referencedColumnName = "id_grado",
            foreignKey = @ForeignKey(name = "secci_grado_id_grado_fk")
    )
    private Grado grado;

    @Column(name = "cod_secci")
    private String codSecci;

    @Column(name = "secci_desc")
    private String secciDesc;

    @Column(name = "usu_crea_secci")
    private String usuCreaSecci;

    @Column(name = "fec_crea_secci")
    private Date fecCreaSecci;

    @Column(name = "usu_modi_secci")
    private String usuModiSecci;

    @Column(name = "fec_modi_secci")
    private Date fecModiSecci;

    @Column(name = "ind_acti")
    private Boolean indActi;

    @Column(name = "ind_elim")
    private Boolean indElim;

}
