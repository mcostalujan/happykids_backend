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
@Entity(name = "Alumno")
@Table(name = "alumno")
public class Alumno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_alum", updatable = false)
    private Long idAlum;

    @Column(name = "fecha_ingreso_alum")
    private Date fechaIngresoAlum;

    @Column(name = "codigo_alum")
    private String codigoAlum;

    @Column(name = "var1_name_alum")
    private String val1NameAlum;

    @Column(name = "var2_name_alum")
    private String val2NameAlum;

    @Column(name = "var3_name_alum")
    private String val3NameAlum;

    @Column(name = "var4_name_alum")
    private String val4NameAlum;

    @Column(name = "var_last_pat_alum")
    private String varLastPatAlum;

    @Column(name = "var_last_mat_alum")
    private String valLastMatAlum;

    @Column(name = "is_active_alum")
    private Boolean isActiveAlumn;

    @Column(name = "usu_crea_alum")
    private String usuCreaAlum;

    @Column(name = "fec_crea_alum")
    private Date fecCreaAlum;

    @Column(name = "usu_modi_alum")
    private String usuModiAlum;

    @Column(name = "fec_modi_alum")
    private Date fecModiAlum;


}
