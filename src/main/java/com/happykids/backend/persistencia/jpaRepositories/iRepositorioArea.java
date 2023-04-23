package com.happykids.backend.persistencia.jpaRepositories;

import com.happykids.backend.dominio.entidades.Area;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface iRepositorioArea extends JpaRepository<Area, Long> {

    Area findAreaByIdArea(Long idArea);

}
