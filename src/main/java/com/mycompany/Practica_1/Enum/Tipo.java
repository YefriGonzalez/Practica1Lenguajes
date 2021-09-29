
package com.mycompany.Practica_1.Enum;

/**
 *
 * @author yefri
 */
public enum Tipo {
    IDENTIFICADOR("ID"),
    NUMERO("ENTERO"),
    DECIMAL("DECIMAL"),
    PUNTUACION("PUNTUACION"),
    OPERADOR("OPERADOR"),
    AGRUPACION("AGRUPACION");
    
    
    String tipo;
    private Tipo(String tipo){
        this.tipo=tipo;
    }
    
    public String getTipo(){
        return this.tipo;
    }
}
