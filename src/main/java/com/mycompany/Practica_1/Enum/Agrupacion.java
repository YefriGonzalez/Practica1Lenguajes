
package com.mycompany.Practica_1.Enum;

/**
 *
 * @author yefri
 */
public enum Agrupacion {
    CORCHETE_IZQUIERDO('['),
    CORCHETE_DERECHO(']'),
    PARENTESIS_IZQUIERDO('('),
    PARENTESIS_DERECHO(')'),
    LLAVE_IZQUIERDA('{'),
    LLAVE_DERECHA('}');
    
    private char simbolo;

    private Agrupacion(char simbolo) {
        this.simbolo = simbolo;
    }

    public char getSimbolo() {
        return simbolo;
    }
    
    
}
