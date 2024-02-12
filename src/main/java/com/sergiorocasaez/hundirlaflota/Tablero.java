package com.sergiorocasaez.hundirlaflota;

import java.util.Scanner;

public class Tablero {
    private char[][] tablero;
    private Barco[] barcos;
    
    private final int nFilas;
    private final int nColumnas;
    private final int nBarcos;
    
    private char[][] tableroUsuario;
    
    Tablero(int filas, int columnas, Barco[] barcos){
        this.tablero = new char[filas][columnas];
        this.barcos = barcos;
        
        this.nFilas = filas;
        this.nColumnas = columnas;
        this.nBarcos = barcos.length;
        
        this.tableroUsuario = new char[filas][columnas];
        
        inicializarTablero();
    }
    
    void inicializarTablero(){
        for(int i=0 ; i<nFilas ; i++){
            for(int j=0 ; j<nColumnas ; j++){
                tablero[i][j] = 'a';
                tableroUsuario[i][j] = '~';
            }
        }
    }
    
    void imprimirTablero(){
        for(int i=0 ; i<nFilas ; i++){
            for(int j=0 ; j<nColumnas ; j++){
                System.out.print(tableroUsuario[i][j]+" ");
            }
            System.out.println();
        }
    }
    
    void colocarBarcos(){
        System.out.println("Colocando barcos...");
        int fila, columna;
        for(int i=0 ; i<nBarcos ; i++){
            do{
                fila = (int)(Math.random()*nFilas);
                columna = (int)(Math.random()*nColumnas);
            }while(!puedeColocarBarco(barcos[i], fila, columna));

            colocarBarcoEnTablero(barcos[i], fila, columna);

            //Imprimir tablero para ver el problema
            for(int k=0 ; k<nFilas ; k++){
                for(int j=0 ; j<nColumnas ; j++){
                    System.out.print(tablero[k][j]);
                }
                System.out.println();
            }
            System.out.println();


        }
    }
    
    boolean puedeColocarBarco(Barco barco, int fila, int columna){
        if(fila<0 || fila>=nFilas || columna<0 || columna+barco.getLongitud()-1>=nColumnas){
            return false;
        }
        
        for(int i=columna ; i<columna+barco.getLongitud() ; i++){
            if(tablero[fila][i]=='b'){
                return false;
            }
        }
        
        return true;
    }
    
    void colocarBarcoEnTablero(Barco barco, int fila, int columna){
        for(int i=columna ; i<columna+barco.getLongitud() ; i++){
            tablero[fila][i] = 'b';
        }
        
        barco.setFila(fila);
        barco.setColumna(columna);
    }
    
    boolean partidaTerminada(){
        for(int i=0 ; i<nBarcos ; i++){
            if(barcos[i].haSidoHundido() == false){
                return false;
            }
        }
        return true;
    }
    
    void jugar(){
        System.out.println("Jugando...");
        Scanner entrada = new Scanner(System.in);
        int fila, columna, i;
        boolean encontrado;
        
        while(!partidaTerminada()){
            imprimirTablero();
            System.out.println();
            System.out.print("Elija la fila que quiere bombardear (0 - "+(nFilas-1)+"): ");
            fila = entrada.nextInt();
            System.out.print("Elija la columna que quiere bombardear (0 - "+(nColumnas-1)+"): ");
            columna = entrada.nextInt();
            System.out.println();
            
            if(tablero[fila][columna] == 'a'){
                System.out.println("¡No diste a ningún barco!");
                tableroUsuario[fila][columna] = 'O';
            }
            else{
                System.out.println("¡Barco impactado!");
                tableroUsuario[fila][columna] = 'X';
                
                i=0;
                encontrado = false;
                while(!encontrado){
                    for(Barco barco : barcos){
                        for(int j=0 ; j<barco.getLongitud() ; j++){
                            if(barco.getFila()==fila && barco.getColumna()+j==columna){
                                barco.hundirParte(j);
                                if(barco.haSidoHundido()){
                                    System.out.println("¡Barco hundido!");
                                }
                                encontrado = true;
                            }
                        }
                    }
                }
            }
            
            System.out.println();
        }
    }
}
