package com.pablolison.introduccion.While_Relaciones.prueba2;


// Definición de la clase principal llamada 'partidos'
public class partidos {
    
    // Método estático que recibe el número de victorias, empates y derrotas de un equipo
    static void imprimirresultados(int victorias, int empates, int derrotas) {
        
        // Bucle para procesar las victorias. Se repite tantas veces como victorias tenga el equipo
        while(victorias > 0) {
            System.out.println("Ha ganado un partido");
            victorias--; // Resta 1 en cada vuelta para evitar un bucle infinito
        }
        
        // Bucle para procesar los empates. Funciona igual reduciendo el contador a cero
        while(empates > 0) {
            System.out.println("Se a empatado un partido"); // Nota: Gramaticalmente debería ser "Se ha..."
            empates--; // Resta 1 en cada vuelta
        }
        
        // Condición especial de seguridad: Si el número de derrotas es exactamente cero
        if(derrotas == 0) {
            System.out.println("Equipo invicto"); // El equipo no ha perdido ningún encuentro
            return; // Termina la ejecución de este método de inmediato. No evalúa el bucle de abajo.
        }
        
        // Bucle para procesar las derrotas. Solo se ejecuta si el 'return' de arriba no se activó
        while(derrotas > 0) {
            System.out.println("A sido derrotado"); // Nota: Gramaticalmente debería ser "Ha sido..."
            derrotas--; // Resta 1 en cada vuelta
        }
    }
    
    // Método principal que inicia la ejecución del programa
    public static void main(String[] args) {
        // Simulación 1: España con 3 victorias, 3 empates y 4 derrotas (Entrará en los 3 bucles)
        System.out.println("Vamos a imprimir los resultados de España");
        imprimirresultados(3, 3, 4);
        
        // Simulación 2: Francia con 9 victorias, 1 empate y 0 derrotas (Se detendrá en el 'if' de invicto)
        System.out.println("Vamos a imprimir los resultados de Francia");
        imprimirresultados(9, 1, 0);
    }
}
