package com.happykids.backend.aplicacion.iServicios;

import com.happykids.backend.dominio.entidades.HistorialRuntimeInformeAnualAlumno;

public interface iServicioHistorialRuntimeInformeAnualAlumno {

    HistorialRuntimeInformeAnualAlumno registrarRuntime(Long idAlumno, String year, double runtime);

}
