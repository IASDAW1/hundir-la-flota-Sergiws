package com.sergiorocasaez.hundirlaflota;

public class BarcoTipo3 extends Barco {
    private int longitud;
    private String nombre;
    private boolean partes[];
    
    BarcoTipo3(String nombre){
        super(4, nombre);
    }
    
    @Override
    String getTipo(){
        return "Barco Tipo 3";
    }
}
