package com.happykids.backend.persistencia.jpaRepositories;

import com.happykids.backend.dominio.entidades.Periodo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface iRepositorioPeriodo extends JpaRepository<Periodo, Long> {

    Periodo findPeriodoByIdPer(Long idPer);

    @Query(value = "SELECT \n" +
            "DISTINCT(CAST(YEAR(PER.FEC_INI_ACTI_PER) AS VARCHAR(5))) YEAR\n" +
            "FROM DBO.PERIODO PER", nativeQuery = true)
    List<Object> getYearsDisponibles();

}
