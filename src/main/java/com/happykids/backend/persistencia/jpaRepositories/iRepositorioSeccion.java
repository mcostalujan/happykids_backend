package com.happykids.backend.persistencia.jpaRepositories;

import com.happykids.backend.dominio.entidades.Seccion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface iRepositorioSeccion extends JpaRepository<Seccion, Long> {

    Seccion findSeccionByIdSecci(Long idSecci);

    @Query(value = "SELECT\n" +
            "DISTINCT(SECCI.secci_desc),\n" +
            "SECCI.id_secci,\n" +
            "SECCI.cod_secci\n" +
            "FROM DBO.SECCION SECCI\n" +
            "INNER JOIN DBO.GRADO GRADO\n" +
            "ON SECCI.grado_id_grado = GRADO.id_grado\n" +
            "INNER JOIN DBO.NIVEL NIVE\n" +
            "ON GRADO.nive_id_nive = NIVE.id_nive\n" +
            "AND SECCI.grado_id_grado = ?2\n" +
            "AND NIVE.id_nive = ?1", nativeQuery = true)
    List<Object> getSeccionesDisponiblesByNivelAndGrado(String idNivel, String idGrado);

}
