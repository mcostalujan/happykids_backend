package com.happykids.backend.persistencia.jpaRepositories;

import com.happykids.backend.dominio.entidades.Seccion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface iRepositorioSeccion extends JpaRepository<Seccion, Long> {

    Seccion findSeccionByIdSecci(Long idSecci);

}
