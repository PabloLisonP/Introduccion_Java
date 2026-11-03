// Definición del paquete para organizar el archivo dentro del proyecto
package com.pablolison.introduccion.ejercicios_varios;

// Definición de la clase principal llamada 'magodespistado'
public class magodespistado {

    // Método estático que recibe un arreglo de cadenas ('caja') y lista todos sus elementos
    static void revisar(String[] caja){
        // Control de errores: Si el arreglo está vacío (longitud igual a 0)
        if(caja.length == 0){
            System.out.println("La mochila esta vacia.");
            return; // Termina la ejecución del método inmediatamente para evitar procesar un arreglo vacío
        }
        
        // Bucle 'for' para recorrer cada uno de los objetos guardados en la mochila
        for(int i = 0; i < caja.length; i++){
            // Imprime el elemento actual con un formato de lista numerada humana (empezando en 1 en lugar de 0)
            // (i + 1) calcula el número de orden y caja[i] extrae el texto del objeto actual
            System.out.println((i + 1) + "." + caja[i]);
        }
    }
    
    // Método principal que arranca la ejecución del programa
    public static void main(String[] args){
        
        // Caso de prueba 1: Un arreglo con 3 objetos mágicos (su longitud es 3, los índices van de 0 a 2)
        String[] mochila1 = {"Varita roja", "Bocadillo de dragon", "Calcetin magico"};
        
        // Caso de prueba 2: Un arreglo completamente vacío
        String[] mochila2 = {};

        // Ejecución y muestra de resultados para la Mochila A
        System.out.println("Mochila A:");
        revisar(mochila1);
        
        // Ejecución y muestra de resultados para la Mochila B
        System.out.println("Mochila B:");
        revisar(mochila2);
    }
}
