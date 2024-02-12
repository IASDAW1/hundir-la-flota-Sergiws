[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-24ddc0f5d75046c5622901739e7c5dd533143b0c8e959d652212380cedb1ea36.svg)](https://classroom.github.com/a/6SoZHdOA)
[![Open in Visual Studio Code](https://classroom.github.com/assets/open-in-vscode-718a45dd9cf7e7f842a935f5ebbe5719a5e09af4491e668f4dbf3b35d5cca122.svg)](https://classroom.github.com/online_ide?assignment_repo_id=13818967&assignment_repo_type=AssignmentRepo)
# JUEGO DE HUNDIR LA FLOTA
Opción 1: Crear un juego simple de Hundir la Flota en Java utilizando programación orientada a objetos (POO). Debes implementar dos clases principales: Barco y Tablero.

Clase Barco:

Atributos:  

	longitud (int): la longitud del barco.  
 
	nombre (String): el nombre del barco.  
 
	partes (boolean[]): un arreglo que indica si cada parte del barco ha sido golpeada.  
 

Métodos:  

	Barco(int longitud, String nombre): constructor que inicializa los atributos del barco.  
 
	boolean haSidoHundido(): devuelve true si todas las partes del barco han sido golpeadas.  
 
	void hundirParte(int parte): marca una parte del barco como golpeada.  
 

Clase Tablero:

Atributos:  

	tablero (char[][]): una matriz que representa el tablero de juego.  
 
	barcos (Barco[]): un arreglo de objetos Barco que se colocarán en el tablero.  
 

Métodos:  

	Tablero(int filas, int columnas, Barco[] barcos): constructor que inicializa el tablero y los barcos.  
 
	void inicializarTablero(): inicializa el tablero con caracteres que representan el agua.  
 
	void imprimirTablero(): imprime el estado actual del tablero.  
 
	void colocarBarcos(): coloca los barcos en posiciones aleatorias del tablero.  
 
	boolean puedeColocarBarco(Barco barco, int fila, int columna): verifica si es posible colocar un barco en una posición específica.  
 
	void colocarBarcoEnTablero(Barco barco, int fila, int columna): coloca un barco en el tablero.  
 
	void jugar(): inicia el juego, permitiendo al jugador ingresar coordenadas para disparar contra los barcos. El juego continúa hasta que todos los barcos sean hundidos.  
 


Versión 2 - Avanzada: Implementación del juego Hundir la Flota en Java con herencia:  


Extender la implementación básica del juego Hundir la Flota para utilizar herencia en las clases Barco. Ahora, existirá una clase base abstracta Barco con tres clases derivadas: BarcoTipo1, BarcoTipo2, y BarcoTipo3, representando diferentes tipos de barcos con longitudes específicas.  


Clase Barco (clase base abstracta):

Atributos:  

	longitud (int): la longitud del barco.  
 
	nombre (String): el nombre del barco.  
 
	partes (boolean[]): un arreglo que indica si cada parte del barco ha sido golpeada.  
 

Métodos:  

	Barco(int longitud, String nombre): constructor que inicializa los atributos del barco.  
 
	abstract String getTipo(): método abstracto que devuelve el tipo de barco.  
 
	boolean haSidoHundido(): devuelve true si todas las partes del barco han sido golpeadas.  
 
	void hundirParte(int parte): marca una parte del barco como golpeada.  
 

Clase BarcoTipo1 (clase derivada):  


	Constructor: llama al constructor de la clase base con valores específicos para el tipo de barco.  
 

Clase BarcoTipo2 (clase derivada):   


	Constructor: llama al constructor de la clase base con valores específicos para el tipo de barco.  
 

Clase BarcoTipo3 (clase derivada):  


	Constructor: llama al constructor de la clase base con valores específicos para el tipo de barco.  
 

Clase Tablero (sin cambios):  


	Añadir instancias de las nuevas clases derivadas al arreglo de Barco[].  
 
Con estas modificaciones, el juego ahora utiliza herencia para representar diferentes tipos de barcos con longitudes específicas.

