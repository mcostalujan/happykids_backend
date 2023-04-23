package com.happykids.backend.persistencia.jpaRepositories;

import com.happykids.backend.dominio.entidades.Periodo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface iRepositorioPeriodo extends JpaRepository<Periodo, Long> {

    Periodo findPeriodoByIdPer(Long idPer);

}
