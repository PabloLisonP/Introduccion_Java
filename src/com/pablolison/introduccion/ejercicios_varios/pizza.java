// Definición del paquete donde se organiza este archivo dentro del proyecto
package com.pablolison.introduccion.ejercicios_varios;

// Definición de la clase principal llamada 'pizza'
public class pizza {

    // Método estático que cuenta cuántas veces aparece un ingrediente específico ('comprobar') en la lista del almacén
    static int contarIngredientes(String[] ingredientesquecomprueboalmacen, String comprobar) {

        int n = 0; // Contador para almacenar el número de coincidencias encontradas
        
        // Bucle 'for' para recorrer cada elemento del almacén de ingredientes
        for(int i = 0; i < ingredientesquecomprueboalmacen.length; i++) {
            // Si el ingrediente en la posición actual del almacén coincide exactamente con el que buscamos
            if(ingredientesquecomprueboalmacen[i].equals(comprobar)) {
                n++; // Incrementamos el contador
            }
        }
        
        /* 
         * Flujo de lo que analiza el bucle internamente:
         * i = 0 -> ingredientesquecomprueboalmacen[0] es "queso"
         * i = 1 -> ingredientesquecomprueboalmacen[1] es "piña"
         * i = 2 -> ingredientesquecomprueboalmacen[2] es "anchoa"
         * i = 3 -> ingredientesquecomprueboalmacen[3] es "queso"
         * i = 4 -> ingredientesquecomprueboalmacen[4] es "piña"
         */

        return n; // Devolvemos el total de ingredientes contados
    }

    // Método principal donde se inicia la ejecución del programa
    public static void main(String[] args) {

        // Arreglo que representa las existencias de ingredientes reales en el almacén de la pizzería
        String[] almacen = {"queso", "piña", "anchoa", "queso", "piña"};
        
        // Arreglo con la lista de ingredientes que queremos revisar si existen y en qué cantidad
        String[] ingredienteporcomprobar = {"queso", "chocolate", "regaliz"};

        // Bucle 'for' para evaluar cada uno de los ingredientes de la lista de comprobación
        for(int i = 0; i < ingredienteporcomprobar.length; i++) {
            
            // Llama al método 'contarIngredientes' para saber cuántas unidades hay del ingrediente actual
            // i = 0 -> Comprueba "queso" -> numerodeIngredientesdeI = 2
            // i = 1 -> Comprueba "chocolate" -> numerodeIngredientesdeI = 0
            // i = 2 -> Comprueba "regaliz" -> numerodeIngredientesdeI = 0
            int numerodeIngredientesdeI = contarIngredientes(almacen, ingredienteporcomprobar[i]); 
            
            // Condición: Si el contador es 0 significa que no queda nada en el almacén
            if(numerodeIngredientesdeI == 0) {
                // Mensaje gracioso cuando el almacén está vacío de ese ingrediente
                System.out.println("Se han comido todos los " + ingredienteporcomprobar[i]);
            } else {
                // Mensaje que informa la cantidad exacta disponible del ingrediente
                System.out.println("Hay " + numerodeIngredientesdeI + " " + ingredienteporcomprobar[i] + " en el almacen");
            }
        }
    }
}
