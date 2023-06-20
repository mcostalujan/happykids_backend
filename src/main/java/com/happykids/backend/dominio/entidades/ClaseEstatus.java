package com.happykids.backend.dominio.entidades;

public enum ClaseEstatus {
    NUEVA("Nueva"), EN_CURSO("En curso"), CERRADA("Cerrada");

    private final String value;

    ClaseEstatus(String value) {
        this.value = value;
    }

    public static ClaseEstatus valueOfLabel(String label) {
        for (ClaseEstatus ce : values()) {
            if (ce.value.equals(label)) {
                return ce;
            }
        }
        return null;
    }

    public String getValue() {
        return value;
    }

}
