// Clase principal
public class HundirLaFlota {
    public static void main(String[] args) {
        Barco[] barcos = {
            new Barco(3, "Barco1"),
            new Barco(4, "Barco2"),
            new Barco(2, "Barco3")
        };

        Tablero tablero = new Tablero(5, 5, barcos);
        tablero.colocarBarcos();
        tablero.jugar();
    }
}
