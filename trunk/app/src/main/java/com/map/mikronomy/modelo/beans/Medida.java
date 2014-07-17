package com.map.mikronomy.modelo.beans;

/**
 * Created by Mikel on 16/07/2014.
 */
public enum Medida {
    KILOGRAMO ("Kg."),
    UNIDAD ("Ud.");

    private final String tipoMedida;

    private Medida(String s) {
        tipoMedida = s;
    }

    public boolean equalsName(String otherName){
        return (otherName == null)? false: tipoMedida.equals(otherName);
    }

    public String toString(){
        return tipoMedida;
    }
}
