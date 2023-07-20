package com.happykids.backend.persistencia.jpaRepositories;

import com.happykids.backend.dominio.entidades.Grado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface iRepositorioGrado extends JpaRepository<Grado, Long> {

    Grado findGradoByIdGrado(Long idGrado);

    @Query(value = "SELECT\n" +
            "DISTINCT(GRADO.GRADO_DESC),\n" +
            "GRADO.ID_GRADO,\n" +
            "GRADO.COD_GRADO\n" +
            "FROM DBO.GRADO GRADO\n" +
            "WHERE GRADO.NIVE_ID_NIVE = ?1", nativeQuery = true)
    List<Object> getGradosDisponiblesByNivel(String idNivel);

}
