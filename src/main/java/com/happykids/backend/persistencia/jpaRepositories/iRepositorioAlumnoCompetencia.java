package com.happykids.backend.persistencia.jpaRepositories;

import com.happykids.backend.dominio.entidades.AlumnoCompetencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface iRepositorioAlumnoCompetencia extends 
JpaRepository<AlumnoCompetencia, Long> {
    AlumnoCompetencia findAlumnoCompetenciaByIdAcompe(Long idAcompe);

}
