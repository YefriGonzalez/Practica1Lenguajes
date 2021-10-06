package com.mycompany.Practica_1.token;

/**
 *
 * @author yefri
 */
public class Lexema {
    private String lexema;
    private String tipo;
    private int cantidad;

    public Lexema(String lexema, String tipo) {
        this.tipo = tipo;
        this.lexema = lexema;
        this.cantidad=0;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getLexema() {
        return lexema;
    }

    public void setLexema(String lexema) {
        this.lexema = lexema;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    
}
