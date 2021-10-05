package com.mycompany.Practica_1.Enum;

/**
 *
 * @author yefri
 */
public enum Puntuacion {
    PUNTO('.'),
    COMA(','),
    PUNTO_COMA(';'),
    DOS_PUNTOS(':');

    private char simbolo;

    private Puntuacion(char simbolo) {
        this.simbolo = simbolo;
    }
    
    public char getSimbolo() {
        return simbolo;
    }
}
