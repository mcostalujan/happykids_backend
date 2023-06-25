package com.happykids.backend.persistencia.jpaRepositories;

import com.happykids.backend.dominio.entidades.AlumnoProgreso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface iRepositorioAlumnoProgreso extends JpaRepository<AlumnoProgreso, Long> {

    AlumnoProgreso findAlumnoProgresoByIdAprog(Long idAprog);

    List<AlumnoProgreso> findAllByAlumno_IdAlum(Long idAlumno);



    @Query(value = "SELECT C.ID_CLASE, \n" +
            "C.COD_CLASE, \n" +
            "AP.ID_APROG,\n" +
            "AP.FEC_CREA_ALUMPROG, \n" +
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
            "AL.ID_ALUM, \n" +
            "AL.CODIGO_ALUM, \n" +
            "AL.VAR1_NAME_ALUM,\n" +
            "AL.VAR_LAST_PAT_ALUM,\n" +
            "AL.VAR_LAST_MAT_ALUM\n" +
            "FROM  DBO.ALUM_PROG AP, DBO.CLASE C, DBO.ALUMNO AL, \n" +
            "DBO.AREA A, DBO.GRADO G, DBO.SECCION S, DBO.NIVEL N,\n" +
            "DBO.PERIODO P\n" +
            "WHERE AP.CLASE_ID_CLASE = C.ID_CLASE\n" +
            "AND AP.ALUM_ID_ALUM = AL.ID_ALUM\n" +
            "AND C.AREA_ID_AREA = A.ID_AREA\n" +
            "AND A.NIVE_ID_NIVE = N.ID_NIVE\n" +
            "AND C.SECCI_ID_SECCI = S.ID_SECCI\n" +
            "AND S.GRADO_ID_GRADO = G.ID_GRADO\n" +
            "AND C.PER_ID_PER = P.ID_PER\n" +
            "AND C.ID_CLASE = ?1", nativeQuery = true)
    List<Object> getDetalleAlumnosPorClase(String idClase);


    @Query(value = "SELECT C.ID_CLASE, \n" +
            "C.COD_CLASE, \n" +
            "AP.ID_APROG,\n" +
            "AP.FEC_CREA_ALUMPROG, \n" +
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
            "AL.ID_ALUM, \n" +
            "AL.CODIGO_ALUM, \n" +
            "AL.VAR1_NAME_ALUM,\n" +
            "AL.VAR_LAST_PAT_ALUM,\n" +
            "AL.VAR_LAST_MAT_ALUM\n" +
            "FROM  DBO.ALUM_PROG AP, DBO.CLASE C, DBO.ALUMNO AL, \n" +
            "DBO.AREA A, DBO.GRADO G, DBO.SECCION S, DBO.NIVEL N,\n" +
            "DBO.PERIODO P\n" +
            "WHERE AP.CLASE_ID_CLASE = C.ID_CLASE\n" +
            "AND AP.ALUM_ID_ALUM = AL.ID_ALUM\n" +
            "AND C.AREA_ID_AREA = A.ID_AREA\n" +
            "AND A.NIVE_ID_NIVE = N.ID_NIVE\n" +
            "AND C.SECCI_ID_SECCI = S.ID_SECCI\n" +
            "AND S.GRADO_ID_GRADO = G.ID_GRADO\n" +
            "AND C.PER_ID_PER = P.ID_PER\n" +
            "AND C.ID_CLASE = ?1 \n" +
            "AND AL.ID_ALUM = ?2", nativeQuery = true)
    Object getDetalleAlumnoByIdClaseAndIdAlumno(String idClase, String idAlumno);

}
