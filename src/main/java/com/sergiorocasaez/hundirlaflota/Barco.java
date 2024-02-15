package com.sergiorocasaez.hundirlaflota;

public abstract class Barco {
    private final int longitud;
    private final String nombre;
    private boolean[] partes;
    
    private int fila; //Su coordenada X (su parte más a la izquierda)
    private int columna; //Su coordenada Y (su parte más arriba)
    private String direccion;
    
    Barco(int longitud, String nombre){
        this.longitud = longitud;
        this.nombre = nombre;
        this.partes = new boolean[longitud]; //elementos false por defecto
    }
    
    abstract String getTipo();
    
    //Devuelve true si todas las partes del barco han sido hundidas
    boolean haSidoHundido(){
        for(int i=0 ; i<this.longitud ; i++){
            if(this.partes[i] == false){
                return false;
            }
        }
        return true;
    }
    
    //Marca una parte del barco como golpeada
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
    
    void setDireccion(String direccion){
        switch(direccion){
            case "horizontal" -> {this.direccion = "horizontal";}
            case "vertical" -> {this.direccion = "vertical";}
            default -> {System.out.println("[ERROR] No se declaró correctamente "
                    + "la dirección del barco");}
        }
    }
    
    String getDireccion(){
        return this.direccion;
    }
}
