package com.happykids.backend.persistencia.jpaRepositories;

import com.happykids.backend.dominio.entidades.Nota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface iRepositorioNota extends JpaRepository<Nota, Long> {

    Nota findNotaByIdNota(Long idNota);

}
