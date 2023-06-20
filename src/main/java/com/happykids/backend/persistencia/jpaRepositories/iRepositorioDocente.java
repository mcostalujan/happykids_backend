package com.happykids.backend.persistencia.jpaRepositories;

import com.happykids.backend.dominio.entidades.Docente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface iRepositorioDocente extends JpaRepository<Docente, Long> {

    Docente findDocenteByIdDoc(Long idDoc);

}
