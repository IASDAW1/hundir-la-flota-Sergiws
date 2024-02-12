package com.sergiorocasaez.hundirlaflota;

public abstract class Barco {
    private final int longitud;
    private final String nombre;
    private boolean[] partes;
    
    private int fila;
    private int columna;
    
    Barco(int longitud, String nombre){
        this.longitud = longitud;
        this.nombre = nombre;
        this.partes = new boolean[longitud]; //elementos false por defecto
    }
    
    abstract String getTipo();
    
    boolean haSidoHundido(){
        for(int i=0 ; i<this.longitud ; i++){
            if(this.partes[i] == false){
                return false;
            }
        }
        return true;
    }
    
    void hundirParte(int parte){
        this.partes[parte] = true;
    }
    
    int getLongitud(){
        return this.longitud;
    }
    
    void setFila(int numero){
        this.fila = numero;
    }
    
    void setColumna(int numero){
        this.columna = numero;
    }
    
    int getFila(){
        return fila;
    }
    
    int getColumna(){
        return columna;
    }
}
