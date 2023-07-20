package com.happykids.backend.persistencia.jpaRepositories;

import com.happykids.backend.dominio.entidades.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface iRepositorioAlumno extends JpaRepository<Alumno, Long> {

    Alumno findAlumnoByIdAlum(Long idAlum);

    @Query(value = "SELECT \n" +
            "DISTINCT(ALUM.ID_ALUM),\n" +
            "ALUM.CODIGO_ALUM,\n" +
            "ALUM.VAR1_NAME_ALUM,\n" +
            "ALUM.VAR_LAST_PAT_ALUM,\n" +
            "ALUM.VAR_LAST_MAT_ALUM\n" +
            "FROM DBO.ALUMNO ALUM\n" +
            "INNER JOIN DBO.ALUM_PROG APROG\n" +
            "ON APROG.ALUM_ID_ALUM = ALUM.ID_ALUM\n" +
            "INNER JOIN DBO.CLASE CLASE\n" +
            "ON APROG.CLASE_ID_CLASE = CLASE.ID_CLASE\n" +
            "INNER JOIN DBO.SECCION SECCI\n" +
            "ON CLASE.SECCI_ID_SECCI = SECCI.ID_SECCI\n" +
            "INNER JOIN DBO.GRADO GRADO\n" +
            "ON GRADO.ID_GRADO = SECCI.GRADO_ID_GRADO\n" +
            "INNER JOIN PERIODO PER\n" +
            "ON CLASE.PER_ID_PER = PER.ID_PER\n" +
            "INNER JOIN DBO.NIVEL NIVE\n" +
            "ON NIVE.id_nive = GRADO.nive_id_nive\n" +
            "AND NIVE.id_nive = ?1\n" +
            "AND GRADO.id_grado = ?2\n" +
            "AND SECCI.id_secci = ?3\n" +
            "AND PER.ID_PER IN (SELECT PER.ID_PER FROM DBO.PERIODO PER WHERE CAST(YEAR(PER.FEC_INI_ACTI_PER) AS VARCHAR(5)) = ?4)", nativeQuery = true)
    List<Object> getAlumnosByParamsReporteAnual(String idNivel, String idGrado, String idSeccion, String year);

}
