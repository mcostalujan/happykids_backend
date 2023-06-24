package com.happykids.backend.persistencia.jpaRepositories;

import com.happykids.backend.dominio.entidades.ClaseDocente;
import com.happykids.backend.dominio.entidades.ClaseDocenteID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface iRepositorioClaseDocente extends JpaRepository<ClaseDocente, ClaseDocenteID> {

    ClaseDocente findClaseDocenteByClaseDocenteID_IdClaseAndClaseDocenteID_IdDoc
    (Long idDoc, Long idClase);

    @Query(value = "SELECT C.ID_CLASE, \n" +
            "C.COD_CLASE, \n" +
            "CD.FEC_CREA_CLADOC, \n" +
            "P.ID_PER,\n" +
            "P.COD_PER,\n" +
            "P.YEAR_PER,\n" +
            "P.PERI_EDU_DESC_PER,\n" +
            "N.ID_NIVE,\n" +
            "N.COD_NIVE,\n" +
            "N.NIVE_DESC,\n" +
            "G.ID_GRADO,\n" +
            "G.COD_GRADO,\n" +
            "G.GRADO_DESC,\n" +
            "S.ID_SECCI,\n" +
            "S.COD_SECCI,\n" +
            "S.SECCI_DESC,\n" +
            "A.ID_AREA,\n" +
            "A.COD_AREA,\n" +
            "A.AREA_DESC,\n" +
            "D.ID_DOC, \n" +
            "D.CODIGO_DOC, \n" +
            "D.VAL1_NAME_DOC,\n" +
            "D.VAL_LAST_PAT_DOC,\n" +
            "D.VAL_LAST_MAT_DOC\n" +
            "FROM  DBO.CLASE_DOCENTE CD, DBO.CLASE C, DBO.DOCENTE D, \n" +
            "DBO.AREA A, DBO.GRADO G, DBO.SECCION S, DBO.NIVEL N,\n" +
            "DBO.PERIODO P\n" +
            "WHERE CD.CLASE_ID_CLASE = C.ID_CLASE\n" +
            "AND CD.DOC_ID_DOC = D.ID_DOC\n" +
            "AND C.AREA_ID_AREA = A.ID_AREA\n" +
            "AND A.NIVE_ID_NIVE = N.ID_NIVE\n" +
            "AND C.SECCI_ID_SECCI = S.ID_SECCI\n" +
            "AND S.GRADO_ID_GRADO = G.ID_GRADO\n" +
            "AND C.PER_ID_PER = P.ID_PER\n" +
            "AND D.ID_DOC = ?1 \n" +
            "AND P.ID_PER = ?2", nativeQuery = true)
    List<Object> getClasesByDocenteAndPeriodo(String idDocente, String idPer);

}
