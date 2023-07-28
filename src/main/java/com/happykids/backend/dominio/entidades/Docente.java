package com.happykids.backend.dominio.entidades;


import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity(name = "Docente")
@Table(name = "docente")
@Builder
public class Docente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_doc", updatable = false)
    private Long idDoc;

    @Column(name = "codigo_doc", length = 8)
    private String codigoDoc;

    @Column(name = "val1_name_doc", length = 50)
    private String val1NameDoc;

    @Column(name = "val2_name_doc", length = 50)
    private String val2NameDoc;

    @Column(name = "val3_name_doc", length = 50)
    private String val3NameDoc;

    @Column(name = "val4_name_doc", length = 50)
    private String val4NameDoc;

    @Column(name = "val_last_pat_doc", length = 50)
    private String valLastPatDoc;

    @Column(name = "val_last_mat_doc", length = 50)
    private String valLastMatDoc;

    @Column(name = "ind_acti_doc")
    private Boolean indActiDoc;

    @Column(name = "usu_crea_doc", length = 12)
    private String usuCreaDoc;

    @Column(name = "fec_crea_doc")
    private Date fecCreaDoc;

    @Column(name = "usu_modi_doc", length = 12)
    private String usuModiDoc;

    @Column(name = "fec_modi_doc")
    private Date fecModiDoc;

    @Column(name = "ind_elim")
    private Boolean indElim;

}
