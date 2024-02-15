package com.sergiorocasaez.hundirlaflota;

import java.util.Scanner;

public class Tablero {
    private char[][] tablero; //Matriz que representa el tablero de juego
    private Barco[] barcos; //Array de barcos que se colocarán en el tablero
    
    private final int nFilas;
    private final int nColumnas;
    private final int nBarcos;
    
    private char[][] tableroUsuario; //Matriz que será mostrada al usuario
    
    Scanner entrada = new Scanner(System.in);
    
    Tablero(int filas, int columnas, Barco[] barcos){
        this.tablero = new char[filas][columnas];
        this.barcos = barcos;
        
        this.nFilas = filas;
        this.nColumnas = columnas;
        this.nBarcos = barcos.length;
        
        this.tableroUsuario = new char[filas][columnas];
        
        inicializarTablero();
    }
    
    //Inicializa los tableros con caracteres que representan agua
    private void inicializarTablero(){
        for(int i=0 ; i<nFilas ; i++){
            for(int j=0 ; j<nColumnas ; j++){
                tablero[i][j] = 'a';
                tableroUsuario[i][j] = '~';
            }
        }
    }
    
    //Imprime el estado actual del tablero del usuario
    private void imprimirTablero(){
        for(int i=0 ; i<nFilas ; i++){
            for(int j=0 ; j<nColumnas ; j++){
                System.out.print(tableroUsuario[i][j]+" ");
            }
            System.out.println();
        }
    }
    
    //Coloca los barcos en posiciones aleatorias del tablero
    void colocarBarcos(){
        System.out.println("Colocando barcos...");
        int fila, columna;
        String direccion;
        for(int i=0 ; i<nBarcos ; i++){
            do{
                fila = (int)(Math.random()*nFilas);
                columna = (int)(Math.random()*nColumnas);
                direccion = (int)(Math.random()*2) == 0 ? "horizontal" : "vertical";
            }while(!puedeColocarBarco(barcos[i], fila, columna, direccion));

            barcos[i].setDireccion(direccion);
            colocarBarcoEnTablero(barcos[i], fila, columna);
            
            //Print para ver cómo se colocan los barcos
            for(int k=0 ; k<nFilas ; k++){
                for(int j=0 ; j<nColumnas ; j++){
                    System.out.print(tablero[k][j]+" ");
                }
                System.out.println();
            }
            System.out.println();
            
        }
    }
    
    //Devuelve true si se puede colocar un barco en la posición indicada
    private boolean puedeColocarBarco(Barco barco, int fila, int columna, String direccion){
        if(fila<0 || columna<0){
            return false;
        }
        
        if(direccion.equals("horizontal")){
            if(columna+barco.getLongitud()-1>=nColumnas){
                return false;
            }
            for(int i=columna ; i<columna+barco.getLongitud() ; i++){
                if(tablero[fila][i]=='b'){
                    return false;
                }
            }
        }
        
        if(direccion.equals("vertical")){
            if(fila+barco.getLongitud()-1>=nFilas){
                return false;
            }
            for(int i=fila ; i<fila+barco.getLongitud() ; i++){
                if(tablero[i][columna]=='b'){
                    return false;
                }
            }
        }
        
        
        
        
        return true;
    }
    
    //Coloca un barco en la posición indicada del tablero
    private void colocarBarcoEnTablero(Barco barco, int fila, int columna){
        if(barco.getDireccion().equals("horizontal")){
            for(int i=columna ; i<columna+barco.getLongitud() ; i++){
                tablero[fila][i] = 'b';
            }
        }
        
        if(barco.getDireccion().equals("vertical")){
            for(int i=fila ; i<fila+barco.getLongitud() ; i++){
                tablero[i][columna] = 'b';
            }
        }
        
        
        barco.setFila(fila);
        barco.setColumna(columna);
    }
    
    //Devuelve true si todos los barcos han sido hundidos
    private boolean partidaTerminada(){
        for(int i=0 ; i<nBarcos ; i++){
            if(barcos[i].haSidoHundido() == false){
                return false;
            }
        }
        return true;
    }
    
    /*Esta función es el juego principal.
    Se basa en un bucle en el que se imprime el tablero, se solicita al usuario
    las coordenadas que quiere bombardear y se muestra si dio a un barco o no.
    El juego termina cuando todos los barcos están hundidos*/
    void jugar(){
        System.out.println("Jugando...");
        int fila, columna;
        boolean encontrado;
        
        while(!partidaTerminada()){
            imprimirTablero();
            System.out.println();
            
            fila = pedirFila()-1;
            columna = pedirColumna()-1;
            
            System.out.println();
            
            if(tablero[fila][columna] == 'a'){
                System.out.println("¡No diste a ningún barco!");
                tableroUsuario[fila][columna] = 'O';
            }
            else{
                System.out.println("¡Barco impactado!");
                tableroUsuario[fila][columna] = 'X';
                
                encontrado = false;
                while(!encontrado){ //Buscamos qué barco ha sido impactado
                    for(Barco barco : barcos){
                        for(int i=0 ; i<barco.getLongitud() ; i++){
                            if(barco.getDireccion().equals("horizontal")){
                                if(barco.getFila()==fila && barco.getColumna()+i==columna){
                                    barco.hundirParte(i);
                                    if(barco.haSidoHundido()){
                                        System.out.println("¡"+barco.getTipo()+" hundido!");
                                    }
                                    encontrado = true;
                                }
                            }
                            
                            if(barco.getDireccion().equals("vertical")){
                                if(barco.getFila()+i==fila && barco.getColumna()==columna){
                                    barco.hundirParte(i);
                                    if(barco.haSidoHundido()){
                                        System.out.println("¡"+barco.getTipo()+" hundido!");
                                    }
                                    encontrado = true;
                                }
                            }
                        }
                    }
                }
            }
            System.out.println();
        }
        
        imprimirTablero(); //Imrpimimos el tablero una vez más al terminar el bucle
   }
    
    //Pide un número de fila al usuario y lo devuelve
    int pedirFila(){
        int fila;
        try{
            System.out.print("Elija la fila que quiere bombardear (1 - "+(nFilas)+"): ");
            fila = entrada.nextInt();
        }
        catch(Exception e){
            System.out.println("[ERROR] Escriba un número entero del 1 al "+nFilas);
            entrada.nextLine(); //Para limpiar el buffer
            fila = pedirFila();
        }
        
        if(fila<1 || fila>nFilas){
            System.out.println("[ERROR] Escriba un número entero del 1 al "+nFilas);
            fila = pedirFila();
        }

        return fila;
    }
    
    //Pide un número de columna al usuario y lo devuelve
    int pedirColumna(){
        int columna;
        try{
            System.out.print("Elija la columna que quiere bombardear (1 - "+(nColumnas)+"): ");
            columna = entrada.nextInt();
        }
        catch(Exception e){
            System.out.println("[ERROR] Escriba un número entero del 1 al "+nColumnas);
            entrada.nextLine(); //Para limpiar el buffer
            columna = pedirColumna();
        }
        
        if(columna<1 || columna>nColumnas){
            System.out.println("[ERROR] Escriba un número entero del 1 al "+nColumnas);
            columna = pedirColumna();
        }

        return columna;
    }
}
