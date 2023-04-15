package com.happykids.backend.persistencia.jpaRepositories;

import com.happykids.backend.dominio.entidades.Nivel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface iRepositorioNivel extends JpaRepository<Nivel, Long> {

    Nivel findByIdNive(Long idNive);
}
