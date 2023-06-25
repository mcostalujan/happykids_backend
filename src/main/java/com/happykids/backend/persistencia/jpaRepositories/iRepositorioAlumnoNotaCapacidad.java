package com.happykids.backend.persistencia.jpaRepositories;

import com.happykids.backend.dominio.entidades.AlumnoNotaCapacidad;
import com.happykids.backend.dominio.entidades.AlumnoNotaCapacidadID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface iRepositorioAlumnoNotaCapacidad extends JpaRepository<AlumnoNotaCapacidad, AlumnoNotaCapacidadID> {

    AlumnoNotaCapacidad findAlumnoNotaCapacidadByAlumnoNotaCapacidadID_IdAcompeAndAlumnoNotaCapacidadID_IdCapacidad
            (Long idAcompe, Long idCapacidad);


    @Query(value = "SELECT \n" +
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
            "ACOMPE.COD_ACOMPE,\n" +
            "ACOMPE.VAL_PROM_LOGRO,\n" +
            "ACOMPE.VAL_PROM_LOGRO_DESC,\n" +
            "CAPA.ID_CAPACIDAD,\n" +
            "CAPA.COD_CAPACIDAD,\n" +
            "CAPA.CAPACIDAD_DESC,\n" +
            "ALNOC.IND_ACTI,\n" +
            "ALNOC.NOTA_CAPACIDAD,\n" +
            "ALNOC.NOTA_CAPACIDAD_DESC\n" +
            "FROM DBO.ALUM_NOTA_CAPA ALNOC\n" +
            "INNER JOIN DBO.ALUM_COMPE ACOMPE\n" +
            "ON ACOMPE.ID_ACOMPE = ALNOC.ACOMPE_ID_ACOMPE\n" +
            "INNER JOIN DBO.CAPACIDAD CAPA\n" +
            "ON CAPA.ID_CAPACIDAD = ALNOC.CAPACIDAD_ID_CAPACIDAD\n" +
            "INNER JOIN DBO.COMPETENCIA COMPE\n" +
            "ON COMPE.ID_COMPE = CAPA.COMPE_ID_COMPE\n" +
            "AND ACOMPE.COMPE_ID_COMPE = COMPE.ID_COMPE\n" +
            "INNER JOIN DBO.ALUM_PROG APROG\n" +
            "ON APROG.ID_APROG = ACOMPE.APROG_ID_APROG\n" +
            "INNER JOIN DBO.ALUMNO ALUM\n" +
            "ON ALUM.ID_ALUM = APROG.ALUM_ID_ALUM\n" +
            "INNER JOIN DBO.AREA AREA\n" +
            "ON AREA.ID_AREA = COMPE.AREA_ID_AREA\n" +
            "INNER JOIN DBO.CLASE CLASE\n" +
            "ON CLASE.ID_CLASE = APROG.CLASE_ID_CLASE\n" +
            "AND AREA.ID_AREA = CLASE.AREA_ID_AREA\n" +
            "INNER JOIN DBO.SECCION SECCI\n" +
            "ON SECCI.ID_SECCI = CLASE.SECCI_ID_SECCI\n" +
            "INNER JOIN DBO.GRADO GRADO\n" +
            "ON GRADO.ID_GRADO = SECCI.GRADO_ID_GRADO\n" +
            "INNER JOIN DBO.NIVEL NIVEL\n" +
            "ON NIVEL.ID_NIVE = GRADO.NIVE_ID_NIVE\n" +
            "AND NIVEL.ID_NIVE = AREA.NIVE_ID_NIVE\n" +
            "INNER JOIN DBO.PERIODO PER\n" +
            "ON PER.ID_PER = CLASE.PER_ID_PER\n" +
            "AND ACOMPE.ID_ACOMPE = ?1", nativeQuery = true)
    List<Object> getDetalleCapacidadPorAcompe(String  idAcompe);

    @Query(value="{call Logica_Promedio(?1, ?2)}",nativeQuery=true)  
    void calculoPromedioCapacidadadesPorIdClaseIdAprog(String idClase, String idAprog);
}
