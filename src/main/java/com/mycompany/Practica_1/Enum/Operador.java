
package com.mycompany.Practica_1.Enum;

/**
 *
 * @author yefri
 */
public enum Operador {
    SUMA('+'),
    RESTA('-'),
    MULTIPLICACION('*'),
    DIVISION('/'),
    MODULO('%');
    
    private char simbolo;

    private Operador(char simbolo) {
        this.simbolo = simbolo;
    }
    
    public char getSimbolo() {
        return simbolo;
    }
}
