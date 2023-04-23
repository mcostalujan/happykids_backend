package com.happykids.backend.persistencia.jpaRepositories;

import com.happykids.backend.dominio.entidades.Logro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface iRepositorioLogro extends JpaRepository<Logro, Long> {

    Logro findLogroByIdLogro(Long idLogro);

}
