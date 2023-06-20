package com.happykids.backend.persistencia.jpaRepositories;

import com.happykids.backend.dominio.entidades.Clase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface iRepositorioClase extends JpaRepository<Clase, Long> {

    Clase findClaseByIdClase(Long idClase);

    @Query(value = "SELECT \n" +
            "\t\tCL.ID_CLASE AS IDCLASE,\n" +
            "\t\tCL.COD_CLASE AS CODCLASE, \n" +
            "\t\tCL.ESTATUS AS ESTATUS,  \n" +
            "\t\tPERI.ID_PER AS IDPER,\n" +
            "\t\tPERI.PERI_EDU_DESC_PER AS PERIEDUDESCPER, \n" +
            "\t\tNIV.ID_NIVE AS IDNIVE,\n" +
            "\t\tNIV.NIVE_DESC AS NIVEDESC, \n" +
            "\t\tGRADO.ID_GRADO AS IDGRADO,\n" +
            "\t\tGRADO.COD_GRADO AS CODGRADO, \n" +
            "\t\tSECCI.ID_SECCI AS IDSECCI,\n" +
            "\t\tSECCI.COD_SECCI AS CODSECCI,\n" +
            "\t\tAREA.ID_AREA AS IDAREA,\n" +
            "\t\tAREA.AREA_DESC AS AREADESC\n" +
            "FROM DBO.CLASE CL, DBO.AREA AREA, DBO.PERIODO PERI, DBO.SECCION SECCI, DBO.GRADO GRADO, DBO.NIVEL NIV\n" +
            "WHERE CL.AREA_ID_AREA = AREA.ID_AREA\n" +
            "AND CL.PER_ID_PER = PERI.ID_PER\n" +
            "AND CL.SECCI_ID_SECCI = SECCI.ID_SECCI\n" +
            "AND AREA.NIVE_ID_NIVE = NIV.ID_NIVE\n" +
            "AND SECCI.GRADO_ID_GRADO = GRADO.ID_GRADO\n" +
            "AND GRADO.NIVE_ID_NIVE = NIV.ID_NIVE", nativeQuery = true)
    List<Object> getDetalleFromAll();
}
