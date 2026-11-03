package com.pablolison.introduccion.While_Relaciones.prueba2;


// Definición de la clase principal llamada 'noche_karaoke'
public class noche_karaoke {

    // Método estático que simula la cuenta atrás de las canciones que se van cantando
    static void cantar(int canciones) {
        // Se crea una variable 'contador' y se inicializa con el número total de canciones recibidas
        int contador = canciones;

        // Condición de seguridad: Si no hay canciones para cantar (canciones es 0)
        if (canciones == 0) {
            System.out.println("No habia canciones"); // Muestra el aviso en la consola
            return; // Termina la ejecución del método inmediatamente (evita que pase al bucle)
        }

        // Bucle 'do-while': Ejecuta el bloque de código al menos una vez antes de evaluar la condición
        do {
            contador--; // Resta 1 al contador (simula que se ha cantado una canción)
            System.out.println("Quedan " + contador + " canciones."); // Muestra cuántas faltan
        } while(contador > 0); // El bucle se repetirá mientras el contador sea mayor que 0
    }

    // Método principal donde inicia la ejecución del programa
    public static void main(String[] args) {
        // Primera prueba: Empezamos con 3 canciones
        System.out.println("Karaoke 1");
        cantar(3);
        
        // Segunda prueba: Empezamos con 7 canciones
        System.out.println("Karaoke 2");
        cantar(7);
        
        // Tercera prueba: Empezamos con 0 canciones
        System.out.println("Karaoke 3");
        cantar(0);
    }
}
