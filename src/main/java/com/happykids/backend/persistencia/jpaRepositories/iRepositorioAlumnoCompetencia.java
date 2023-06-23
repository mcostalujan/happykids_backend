package com.happykids.backend.persistencia.jpaRepositories;

import com.happykids.backend.dominio.entidades.AlumnoCompetencia;
import com.happykids.backend.dominio.entidades.AlumnoCompetenciaID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface iRepositorioAlumnoCompetencia extends 
JpaRepository<AlumnoCompetencia, AlumnoCompetenciaID> {
    AlumnoCompetencia findAlumnoCompetenciaByAlumnoCompetenciaID_IdAprogAndAlumnoCompetenciaID_IdCompe
    (Long idAprog, Long idCompe);

}
