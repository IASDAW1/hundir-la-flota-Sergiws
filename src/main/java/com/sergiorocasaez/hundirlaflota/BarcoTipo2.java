package com.sergiorocasaez.hundirlaflota;

public class BarcoTipo2 extends Barco {
    private int longitud;
    private String nombre;
    private boolean partes[];
    
    BarcoTipo2(String nombre){
        super(3, nombre);
    }
    
    @Override
    String getTipo(){
        return "Barco Tipo 2";
    }
}
