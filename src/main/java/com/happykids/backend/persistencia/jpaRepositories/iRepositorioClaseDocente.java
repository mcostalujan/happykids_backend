package com.happykids.backend.persistencia.jpaRepositories;

import com.happykids.backend.dominio.entidades.ClaseDocente;
import com.happykids.backend.dominio.entidades.ClaseDocenteID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface iRepositorioClaseDocente extends JpaRepository<ClaseDocente, ClaseDocenteID> {

    ClaseDocente findClaseDocenteByClaseDocenteID_IdClaseAndClaseDocenteID_IdDoc(Long idDoc, Long idClase);

}
