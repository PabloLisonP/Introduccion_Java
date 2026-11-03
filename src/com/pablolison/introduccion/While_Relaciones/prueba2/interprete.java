package com.pablolison.introduccion.While_Relaciones.prueba2;


// Definición de la clase principal llamada 'interprete'
public class interprete { 

    // Método estático que recibe un gesto (texto) y devuelve su significado (texto)
    static String interpretar(String gesto) {
        // Estructura de control para evaluar el valor de la variable 'gesto'
        switch(gesto) {
            case "ceja": 
                return "Eso no me lo creo;"; // Si es "ceja", devuelve este texto y sale del método
            case "bostezo": 
                return "Que aburrimiento";    // Si es "bostezo", devuelve este texto y sale del método
            case "pulgar": 
                return "Todo bajo control";   // Si es "pulgar", devuelve este texto y sale del método
            case "": 
                return "Cara de poker";       // Si es un texto vacío, devuelve este texto y sale del método
            default: 
                return "Gesto desconocido";   // Si no coincide con ninguno de los anteriores, usa esta opción por defecto
        }
    } 

    // Método principal (punto de entrada del programa)
    public static void main(String[] args) {
        // Declaración e inicialización de un arreglo (lista) con 5 gestos de prueba
        String[] gestos = {"ceja", "bostezo", "", "baile", "pulgar"}; 
        
        // Bucle 'for' que recorre el arreglo desde el índice 0 hasta el final (longitud del arreglo)
        for(int i = 0; i < gestos.length; i++) {
            // Imprime en consola el gesto actual junto con el resultado de llamar al método 'interpretar'
            System.out.println("Gesto " + "'" + gestos[i] + "'" + "= " + interpretar(gestos[i])); 
        }
    }
}