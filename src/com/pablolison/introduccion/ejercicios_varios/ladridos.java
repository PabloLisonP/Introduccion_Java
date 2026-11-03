// Definición del paquete para organizar el archivo dentro del proyecto
package com.pablolison.introduccion.ejercicios_varios;

// Definición de la clase principal llamada 'ladridos'
public class ladridos {

    // Método estático que genera secuencias crecientes de ladridos según el número 'n' recibido
    static void criar(int n) {

        // Control de errores: Si piden 0 o menos ladridos, no se procesa nada
        if(n <= 0) {
            System.out.println("No hay ladridos que criar");
            return; // Termina la ejecución del método inmediatamente
        }
             
        // Crea un arreglo de enteros con espacio para 'n' elementos
        int[] veces = new int[n];

        // Primer bucle: Llena el arreglo con números consecutivos empezando desde el 1
        // Si n=3, el arreglo terminará guardando: [1, 2, 3]
        for(int i = 0; i < veces.length; i++) {
            veces[i] = i + 1;
        }

        // Segundo bucle: Recorre el arreglo creado para procesar cada nivel de ladridos
        for(int i = 0; i < veces.length; i++) {
            // Inicializa una cadena de texto vacía para ir acumulando los "Guau"
            String ladridos = "";

            // Tercer bucle (Anidado): Se repite la cantidad de veces que indique el número guardado en veces[i]
            // Vuelta i=0 (veces[0]=1) -> Se ejecuta 1 vez -> ladridos = "Guau"
            // Vuelta i=1 (veces[1]=2) -> Se ejecuta 2 veces -> ladridos = "GuauGuau"
            // Vuelta i=2 (veces[2]=3) -> Se ejecuta 3 veces -> ladridos = "GuauGuauGuau"
            for(int u = 0; u < veces[i]; u++) {
                ladridos = ladridos + "Guau"; // Concatena / pega un "Guau" al texto anterior
            }
    
            // Imprime el número de Ladrido actual (sumando 1 al índice) y el texto final acumulado
            System.out.println("Ladrido" + (i + 1) + ":" + ladridos);
        }
    }

    // Método principal que arranca el programa
    public static void main(String[] args) {

        // Prueba A: Se piden 3 niveles de ladridos (funcionamiento normal)
        System.out.println("Pedido A:");
        criar(8);
        
        // Prueba N: Se pide un número negativo (activará el if de control de errores)
        System.out.println("Pedido N:");
        criar(-4);
    }
}
