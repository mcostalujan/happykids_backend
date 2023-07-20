package com.happykids.backend.aplicacion.implServicios;

import com.happykids.backend.aplicacion.iServicios.iServicioHistorialRuntimeInformeAnualAlumno;
import com.happykids.backend.dominio.entidades.AlumnoNotaCapacidad;
import com.happykids.backend.dominio.entidades.HistorialRuntimeInformeAnualAlumno;
import com.happykids.backend.dominio.entidades.Nota;
import com.happykids.backend.persistencia.jpaRepositories.iRepositorioHistorialRuntimeInformeAnualAlumno;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@Slf4j
public class ImplServicioHistorialRuntimeInformeAnualAlumno
        implements iServicioHistorialRuntimeInformeAnualAlumno {

    @Autowired
    private iRepositorioHistorialRuntimeInformeAnualAlumno iRepositorioHistorialRuntimeInformeAnualAlumno;

    @Override
    public HistorialRuntimeInformeAnualAlumno registrarRuntime(Long idAlumno, String year, double runtime) {
        if (idAlumno != null && year != null) {
            HistorialRuntimeInformeAnualAlumno actual = this.iRepositorioHistorialRuntimeInformeAnualAlumno
                    .findByIdAlumAndYear(idAlumno, year);
            if (actual != null) {
                actual.setRuntime(runtime);
                actual.setFecModi(new Date());
                actual.setUsuModi("SYSTEM");
                return iRepositorioHistorialRuntimeInformeAnualAlumno
                        .save(actual);
            } else {
                HistorialRuntimeInformeAnualAlumno nuevo =
                        HistorialRuntimeInformeAnualAlumno.builder()
                                .idAlum(idAlumno)
                                .year(year)
                                .runtime(runtime)
                                .fecCrea(new Date())
                                .usuCrea("SYSTEM")
                                .build();

                return iRepositorioHistorialRuntimeInformeAnualAlumno.save(nuevo);
            }
        }
        return null;
    }
}
