package com.happykids.backend.persistencia.jpaRepositories;

import com.happykids.backend.dominio.entidades.Nivel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface iRepositorioNivel extends JpaRepository<Nivel, Long> {

    Nivel findByIdNive(Long idNive);

    @Query(value = "SELECT \n" +
            "DISTINCT(NIVE_DESC), \n" +
            "ID_NIVE, \n" +
            "COD_NIVE\n" +
            "FROM DBO.NIVEL NIVE", nativeQuery = true)
    List<Object> getNivelesDisponibles();
}
