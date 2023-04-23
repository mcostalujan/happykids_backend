package com.happykids.backend.persistencia.jpaRepositories;

import com.happykids.backend.dominio.entidades.Competencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface iRepositorioCompetencia extends JpaRepository<Competencia, Long> {

    Competencia findCompetenciaByIdCompe(Long idCompetencia);

}
