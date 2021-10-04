package com.mycompany.Practica_1.token;

import javax.swing.JTextArea;

/**
 *
 * @author yefri
 */
public class Automata {
    private JTextArea textoEntrada;
    private int[][] matrizAutomata;
    private final int[] ESTADOS_ACEPTACION = {2, 3, 5, 6, 7, 8};
    private final int ESTADO_INICIAL=1;
    private String[] lineasTexto;
    private String[] palabrasTexto;
    private int fila;
    private int columna;
    private int estadoActual;
    private int letras = 0;
    private int numero = 1;
    private int signoOperacion = 2;
    private int signoPuntuacion = 3;
    private int signoAgrupacion = 4;
    private int punto = 5;
    
    public Automata(JTextArea textoEntrada){
        this.textoEntrada=textoEntrada;
        inicializarMatriz();
    }
    private void inicializarMatriz() {
        int filas=8;
        int columnas=6;
        matrizAutomata = new int[filas][columnas];
        matrizAutomata[0][0] = 2;
        matrizAutomata[0][1] = 3;
        matrizAutomata[0][2] = 7;
        matrizAutomata[0][3] = 6;
        matrizAutomata[0][4] = 8;
        matrizAutomata[0][5] = -1; // numero -1 signfica error

        matrizAutomata[1][0] = 2;
        matrizAutomata[1][1] = 2;
        matrizAutomata[1][2] = -1;
        matrizAutomata[1][3] = -1;
        matrizAutomata[1][4] = -1;
        matrizAutomata[1][5] = -1;

        matrizAutomata[2][0] = -1;
        matrizAutomata[2][1] = 3;
        matrizAutomata[2][2] = -1;
        matrizAutomata[2][3] = -1;
        matrizAutomata[2][4] = -1;
        matrizAutomata[2][5] = 4;

        matrizAutomata[3][0] = -1;
        matrizAutomata[3][1] = 5;
        matrizAutomata[3][2] = -1;
        matrizAutomata[3][3] = -1;
        matrizAutomata[3][4] = -1;
        matrizAutomata[3][5] = -1;

        matrizAutomata[4][0] = -1;
        matrizAutomata[4][1] = 5;
        matrizAutomata[4][2] = -1;
        matrizAutomata[4][3] = -1;
        matrizAutomata[4][4] = -1;
        matrizAutomata[4][5] = -1;

        matrizAutomata[5][0] = -1;
        matrizAutomata[5][1] = -1;
        matrizAutomata[5][2] = -1;
        matrizAutomata[5][3] = -1;
        matrizAutomata[5][4] = -1;
        matrizAutomata[5][5] = -1;

        matrizAutomata[6][0] = -1;
        matrizAutomata[6][1] = -1;
        matrizAutomata[6][2] = -1;
        matrizAutomata[6][3] = -1;
        matrizAutomata[6][4] = -1;
        matrizAutomata[6][5] = -1;

        matrizAutomata[7][0] = -1;
        matrizAutomata[7][1] = -1;
        matrizAutomata[7][2] = -1;
        matrizAutomata[7][3] = -1;
        matrizAutomata[7][4] = -1;
        matrizAutomata[7][5] = -1;

    }

}
