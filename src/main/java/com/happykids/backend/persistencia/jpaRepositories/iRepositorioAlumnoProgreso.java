package com.happykids.backend.persistencia.jpaRepositories;

import com.happykids.backend.dominio.entidades.AlumnoProgreso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface iRepositorioAlumnoProgreso extends JpaRepository<AlumnoProgreso, Long> {

    AlumnoProgreso findAlumnoProgresoByIdAprog(Long idAprog);

    List<AlumnoProgreso> findAllByAlumno_IdAlum(Long idAlumno);

}
