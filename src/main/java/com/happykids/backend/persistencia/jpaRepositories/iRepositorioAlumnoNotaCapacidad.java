package com.happykids.backend.persistencia.jpaRepositories;

import com.happykids.backend.dominio.entidades.AlumnoNotaCapacidad;
import com.happykids.backend.dominio.entidades.AlumnoNotaCapacidadID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface iRepositorioAlumnoNotaCapacidad extends JpaRepository<AlumnoNotaCapacidad, AlumnoNotaCapacidadID> {

    AlumnoNotaCapacidad findAlumnoNotaCapacidadByAlumnoNotaCapacidadID_IdAcompeAndAlumnoNotaCapacidadID_IdCapacidad
            (Long idAcompe, Long idCapacidad);

}
