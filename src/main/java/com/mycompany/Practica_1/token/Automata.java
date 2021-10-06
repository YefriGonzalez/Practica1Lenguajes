package com.mycompany.Practica_1.token;

import com.mycompany.Practica_1.Enum.Agrupacion;
import com.mycompany.Practica_1.Enum.Operador;
import com.mycompany.Practica_1.Enum.Puntuacion;
import com.mycompany.Practica_1.Enum.Tipo;
import com.mycompany.Practica_1.frames.ReportesFrame;
import com.mycompany.Practica_1.frames.VentanaPrincipal;
import java.util.ArrayList;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author yefri
 */
public class Automata {

    private JTextArea textoEntrada;
    private int[][] matrizAutomata;
    private final int[] ESTADOS_ACEPTACION = {1, 2, 4, 5, 6, 7};
    String[] lineas;
    String[] palabras;
    private int fila;
    private int columna;
    private int estadoActual = 0;
    private ArrayList<Token> tokens = new ArrayList<>();
    private ArrayList<Error> errores = new ArrayList<>();
    private ArrayList<Lexema> lexemas=new ArrayList<>();

    public Automata(JTextArea textoEntrada) {
        this.textoEntrada = textoEntrada;
        inicializarMatriz();
    }

    private void inicializarMatriz() {
        int filas = 8;
        int columnas = 7;
        //S1=0   S2=1  S3=2  S4=3  S5=4 S6=5 S7=6  S8=7   Error=-1
        matrizAutomata = new int[filas][columnas];
        matrizAutomata[0][0] = 1;
        matrizAutomata[0][1] = 2;
        matrizAutomata[0][2] = 6;
        matrizAutomata[0][3] = 5;
        matrizAutomata[0][4] = 7;
        matrizAutomata[0][5] = 5;

        matrizAutomata[1][0] = 1;
        matrizAutomata[1][1] = 1;
        matrizAutomata[1][2] = -1;
        matrizAutomata[1][3] = -1;
        matrizAutomata[1][4] = -1;
        matrizAutomata[1][5] = -1;

        matrizAutomata[2][0] = -1;
        matrizAutomata[2][1] = 2;
        matrizAutomata[2][2] = -1;
        matrizAutomata[2][3] = -1;
        matrizAutomata[2][4] = -1;
        matrizAutomata[2][5] = 3;

        matrizAutomata[3][0] = -1;
        matrizAutomata[3][1] = 4;
        matrizAutomata[3][2] = -1;
        matrizAutomata[3][3] = -1;
        matrizAutomata[3][4] = -1;
        matrizAutomata[3][5] = -1;

        matrizAutomata[4][0] = -1;
        matrizAutomata[4][1] = 4;
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

    public void leerTextArea() {
        String texto = textoEntrada.getText();
        lineas = texto.split("\n");
        for (int i = 0; i < lineas.length; i++) {
            palabras = lineas[i].split(" ");
            for (int j = 0; j < palabras.length; j++) {
                analizarPalabra(palabras[j]);
                columna++;
            }
            columna = 0;
            fila++;
        }
    }

    private void analizarPalabra(String token) {
        String opcion = "";
        estadoActual = 0;
        char[] cadenaPalabra = token.toCharArray();

        for (int i = 0; i < token.length(); i++) {
            columna++;
            if (Character.isAlphabetic(cadenaPalabra[i])) {
                VentanaPrincipal.textAreaTransicicion.append("Me movi del estado " + estadoActual + " al estado " + matrizAutomata[estadoActual][0] + " con:" + cadenaPalabra[i] + "\n");
                estadoActual = matrizAutomata[estadoActual][0];
            } else {
                if (Character.isDigit(cadenaPalabra[i])) {
                    VentanaPrincipal.textAreaTransicicion.append("Me movi del estado " + estadoActual + " al estado " + matrizAutomata[estadoActual][1] + " con:" + cadenaPalabra[i] + "\n");
                    estadoActual = matrizAutomata[estadoActual][1];
                } else {
                    if (verificarOperador(cadenaPalabra[i])) {
                        VentanaPrincipal.textAreaTransicicion.append("Me movi del estado " + estadoActual + " al estado " + matrizAutomata[estadoActual][2] + " con:" + cadenaPalabra[i] + "\n");
                        estadoActual = matrizAutomata[estadoActual][2];
                    } else {
                        if (verificarPuntuacion(cadenaPalabra[i]) && estadoActual == 0) {
                            VentanaPrincipal.textAreaTransicicion.append("Me movi del estado " + estadoActual + " al estado " + matrizAutomata[estadoActual][3] + " con:" + cadenaPalabra[i] + "\n");
                            estadoActual = matrizAutomata[estadoActual][3];
                        } else {
                            if (verificarAgrupacion(cadenaPalabra[i])) {
                                VentanaPrincipal.textAreaTransicicion.append("Me movi del estado " + estadoActual + " al estado " + matrizAutomata[estadoActual][4] + " con:" + cadenaPalabra[i] + "\n");
                                estadoActual = matrizAutomata[estadoActual][4];
                            } else {
                                if (cadenaPalabra[i] == '.' && estadoActual == 2) {
                                    VentanaPrincipal.textAreaTransicicion.append("Me movi del estado " + estadoActual + " al estado " + matrizAutomata[estadoActual][5] + " con:" + cadenaPalabra[i] + "\n");
                                    estadoActual = matrizAutomata[estadoActual][5];
                                }
                            }
                        }
                    }
                }
            }
            opcion += cadenaPalabra[i];
            if (estadoActual == -1) {
                errores.add(new Error(opcion, fila, columna));
                estadoActual = 0;
                opcion = "";
            }
        }
        Tipo[] tipos = Tipo.values();
        for (int i = 0; i < ESTADOS_ACEPTACION.length; i++) {
            if (ESTADOS_ACEPTACION[i] == estadoActual) {
                tokens.add(new Token(opcion, tipos[i].getTipo(), fila, columna));
                estadoActual = 0;
                opcion = "";
                break;
            } else {
                if (i == ESTADOS_ACEPTACION.length - 1) {
                    errores.add(new Error(opcion, fila, columna));
                    estadoActual = 0;
                    opcion = "";
                }
            }
        }
    }

    private boolean verificarOperador(char operador) {
        boolean existente = false;
        Operador[] instanciasOperador = Operador.values();
        for (int i = 0; i < instanciasOperador.length; i++) {
            if (instanciasOperador[i].getSimbolo() == operador) {
                existente = true;
            }
        }
        return existente;
    }

    private boolean verificarPuntuacion(char puntuacion) {
        boolean existente = false;
        Puntuacion[] instanciasPuntuacion = Puntuacion.values();
        for (int i = 0; i < instanciasPuntuacion.length; i++) {
            if (instanciasPuntuacion[i].getSimbolo() == puntuacion) {
                existente = true;
            }
        }
        return existente;
    }

    private boolean verificarAgrupacion(char agrupacion) {
        boolean existente = false;
        Agrupacion[] instanciasAgrupacion = Agrupacion.values();
        for (int i = 0; i < instanciasAgrupacion.length; i++) {
            if (instanciasAgrupacion[i].getSimbolo() == agrupacion) {
                existente = true;
            }
        }
        return existente;
    }

    public void enviarReportes() {
        if (errores.isEmpty()) {
            DefaultTableModel model = new DefaultTableModel();
            ReportesFrame.tokensTable.setModel(model);
            model.addColumn("Token");
            model.addColumn("Lexema");
            model.addColumn("Fila");
            model.addColumn("Columna");
            for (Token token : tokens) {
                model.addRow(new Object[]{token.getTipo(), token.getTexto(), token.getFila(), token.getColumna()});
            }
            recuentoLexemas();
            DefaultTableModel model1 = new DefaultTableModel();
            ReportesFrame.recuentoTable.setModel(model1);
            model1.addColumn("Lexema");
            model1.addColumn("Token");
            model1.addColumn("Cantidad");
            for (Lexema lexema: lexemas) {
                model1.addRow(new Object[]{lexema.getLexema(),lexema.getTipo(),lexema.getCantidad()});
            }
        } else {
            DefaultTableModel modelo = new DefaultTableModel();
            ReportesFrame.errorTable.setModel(modelo);
            modelo.addColumn("Cadena");
            modelo.addColumn("Fila");
            modelo.addColumn("Columna");
            for (Error error : errores) {
                modelo.addRow(new Object[]{error.getTexto(), error.getFila(), error.getColumna()});
            }
        }
    }
    
    public void recuentoLexemas(){
        lexemas.add(new Lexema(tokens.get(0).getTexto(), tokens.get(0).getTipo()));
        for (int i = 0; i < tokens.size(); i++) {
            for (int j = 0; j < lexemas.size(); j++) {
                if (tokens.get(i).getTexto().equals(lexemas.get(j).getLexema())) {
                    lexemas.get(j).setCantidad(lexemas.get(j).getCantidad()+1);
                    break;
                } else {
                    if (lexemas.size()-1==j) {
                        lexemas.add(new Lexema(tokens.get(i).getTexto(), tokens.get(i).getTipo()));
                    }
                }
            }
        }
    }
}
