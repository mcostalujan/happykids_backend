package com.happykids.backend.persistencia.jpaRepositories;

import com.happykids.backend.dominio.entidades.HistorialRuntimeInformeAnualAlumno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface iRepositorioHistorialRuntimeInformeAnualAlumno
        extends JpaRepository<HistorialRuntimeInformeAnualAlumno, Long> {

    HistorialRuntimeInformeAnualAlumno findByIdAlumAndYear(Long idAlum, String year);

}
