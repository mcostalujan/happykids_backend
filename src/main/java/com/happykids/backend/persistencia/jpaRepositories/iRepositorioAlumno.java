package com.happykids.backend.persistencia.jpaRepositories;

import com.happykids.backend.dominio.entidades.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface iRepositorioAlumno extends JpaRepository<Alumno, Long> {
}
