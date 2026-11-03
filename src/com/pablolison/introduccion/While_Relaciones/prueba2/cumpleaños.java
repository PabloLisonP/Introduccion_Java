package com.pablolison.introduccion.While_Relaciones.prueba2;


// Definición de la clase principal llamada 'cumpleaños'
public class cumpleaños {

    // Método estático que procesa un arreglo de comida ('menu') y simula servir los platos
    static void servir(String[] menu) {

        // Variables contadoras para llevar el control de los platos
        int servidos = 0;   // Cuenta cuántos platos deliciosos se sirven
        int escondidos = 0; // Cuenta cuántos platos de brócoli se rechazan/esconden

        // Bucle 'for' para revisar cada elemento del menú uno por uno
        for(int i = 0; i < menu.length; i++) {
            
            // Condición: Si el alimento actual es exactamente "brócoli"
            if(menu[i].equals("brócoli")) {
                escondidos++; // Incrementa en 1 el contador de brócolis escondidos
                continue;     // Salta el resto del bucle y pasa directamente al siguiente alimento
            }
            
            // Si no era brócoli, el programa llega aquí: imprime el plato servido
            System.out.println("Servido:" + menu[i]);
            servidos++; // Incrementa en 1 el contador de platos servidos
        }
        
        // Finalizado el bucle, verifica si no se llegó a servir absolutamente nada
        if(servidos == 0) {
            System.out.println("Mesa vacia: solo habia brocoli.");
        }
        
        // Imprime el total de brócolis que se camuflaron o escondieron
        System.out.println("bROCOLIS SCONDIDOS:" + escondidos);
    }

    // Método principal donde inicia la ejecución del programa
    public static void main(String[] args) {

        // Primer menú de prueba con una mezcla de comida y brócoli
        String[] lista1 = {"brócoli", "tarta", "brócoli", "refresco", "brócoli"};
        
        // Segundo menú de prueba que contiene únicamente brócoli
        String[] lista2 = {"brócoli", "brócoli"};
        
        // Ejecución y muestra de resultados para el Menú 1
        System.out.println("Menu 1");
        servir(lista1);
        
        // Ejecución y muestra de resultados para el Menú 2
        System.out.println("Menu 2");
        servir(lista2);
    }
}