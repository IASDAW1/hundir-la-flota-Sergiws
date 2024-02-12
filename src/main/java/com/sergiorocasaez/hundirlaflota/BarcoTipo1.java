package com.sergiorocasaez.hundirlaflota;

public class BarcoTipo1 extends Barco {
    private int longitud;
    private String nombre;
    private boolean partes[];
    
    BarcoTipo1(String nombre){
        super(2, nombre);
    }
    
    @Override
    String getTipo(){
        return "Barco Tipo 1";
    }
}
