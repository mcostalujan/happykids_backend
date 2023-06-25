package com.happykids.backend.persistencia.jpaRepositories;

import com.happykids.backend.dominio.entidades.AlumnoCompetencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface iRepositorioAlumnoCompetencia extends 
JpaRepository<AlumnoCompetencia, Long> {
    AlumnoCompetencia findAlumnoCompetenciaByIdAcompe(Long idAcompe);

    @Query(value = "SELECT\n" +
            "ALUM.ID_ALUM,\n" +
            "ALUM.CODIGO_ALUM,\n" +
            "ALUM.VAR1_NAME_ALUM,\n" +
            "ALUM.VAR_LAST_PAT_ALUM,\n" +
            "ALUM.VAR_LAST_MAT_ALUM,\n" +
            "NIVEL.ID_NIVE, \n" +
            "NIVEL.COD_NIVE, \n" +
            "NIVEL.NIVE_DESC,\n" +
            "GRADO.ID_GRADO,\n" +
            "GRADO.COD_GRADO,\n" +
            "GRADO.GRADO_DESC,\n" +
            "SECCI.ID_SECCI,\n" +
            "SECCI.COD_SECCI,\n" +
            "SECCI.SECCI_DESC,\n" +
            "AREA.ID_AREA,\n" +
            "AREA.COD_AREA,\n" +
            "AREA.AREA_DESC,\n" +
            "COMPE.ID_COMPE,\n" +
            "COMPE.CODIGO_COMPE,\n" +
            "COMPE.DESC_COMPE,\n" +
            "ACOMPE.ID_ACOMPE,\n" +
            "ACOMPE.COD_ACOMPE\n," +
            "ACOMPE.VAL_PROM_LOGRO,\n" +
            "ACOMPE.VAL_PROM_LOGRO_DESC\n" +
            "FROM DBO.CLASE CLASE, DBO.ALUMNO ALUM, DBO.ALUM_COMPE ACOMPE, DBO.ALUM_PROG APROG, DBO.COMPETENCIA COMPE,\n" +
            "DBO.AREA AREA, DBO.NIVEL NIVEL, DBO.GRADO GRADO, DBO.SECCION SECCI, DBO.PERIODO PER\n" +
            "WHERE CLASE.ID_CLASE = APROG.CLASE_ID_CLASE\n" +
            "AND APROG.ALUM_ID_ALUM = ALUM.ID_ALUM\n" +
            "AND APROG.ID_APROG = ACOMPE.APROG_ID_APROG\n" +
            "AND COMPE.ID_COMPE = ACOMPE.COMPE_ID_COMPE\n" +
            "AND COMPE.AREA_ID_AREA = AREA.ID_AREA\n" +
            "AND CLASE.AREA_ID_AREA = AREA.ID_AREA\n" +
            "AND NIVEL.ID_NIVE = AREA.NIVE_ID_NIVE\n" +
            "AND CLASE.SECCI_ID_SECCI = SECCI.ID_SECCI\n" +
            "AND SECCI.GRADO_ID_GRADO = GRADO.ID_GRADO\n" +
            "AND GRADO.NIVE_ID_NIVE = NIVEL.ID_NIVE\n" +
            "AND PER.ID_PER = CLASE.PER_ID_PER\n" +
            "AND CLASE.ID_CLASE = ?1 \n" +
            "AND ALUM.ID_ALUM =?2 ", nativeQuery = true)
    List<Object> getDetalleACompeByIdClaseAndIdAlumno(String idClase, String idAlumno);
}
