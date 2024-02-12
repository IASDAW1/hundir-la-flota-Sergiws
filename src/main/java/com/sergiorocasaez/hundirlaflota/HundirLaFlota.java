package com.sergiorocasaez.hundirlaflota;

public class HundirLaFlota {

    public static void main(String[] args) {
        Barco[] barcos = {
            new BarcoTipo2("Barco1"),
            new BarcoTipo3("Barco2"),
            new BarcoTipo1("Barco3")
        };

        Tablero tablero = new Tablero(5, 5, barcos);
        tablero.colocarBarcos();
        tablero.jugar();
        
        System.out.println("¡VICTORIA!");
    
    }
}
