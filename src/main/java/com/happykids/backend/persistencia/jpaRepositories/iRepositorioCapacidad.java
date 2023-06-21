package com.happykids.backend.persistencia.jpaRepositories;

import com.happykids.backend.dominio.entidades.Capacidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface iRepositorioCapacidad extends JpaRepository<Capacidad, Long> {

    Capacidad findCapacidadByIdCapacidad(Long idCapacidad);

}
