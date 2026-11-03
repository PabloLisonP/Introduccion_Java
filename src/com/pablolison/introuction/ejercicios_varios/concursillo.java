// Definición del paquete para organizar el archivo dentro del proyecto
package PRIMERO.Asignaturas.Programacion.prueba1.programacion.src.ejercicios.primertrimestre;

// Definición de la clase principal llamada 'concursillo'
public class concursillo {
    
    // Método estático que recibe un arreglo de enteros ('estornudo') y calcula sus estadísticas
    static void calcula(int[] estornudo){

        // Control de errores: Si el arreglo está vacío (longitud igual a 0)
        if (estornudo.length == 0){
            System.out.println("Nadie estornudó, la alergia se tomó el día libre!");
            return; // Termina la ejecución del método inmediatamente para evitar errores aritméticos (división por cero)
        }

        // Variables para los cálculos estadísticos
        int suma = 0;             // Acumulador para sumar todos los estornudos
        int maximo = estornudo[0]; // Guarda el valor máximo encontrado (inicia con el primer elemento)
        int base = 0;             // Guarda el índice (posición) donde se encuentra ese valor máximo

        // Bucle 'for' para recorrer cada elemento del arreglo 'estornudo'
        for (int i = 0 ; i < estornudo.length; i++){
            suma += estornudo[i]; // Suma el valor del elemento actual al acumulador total

            // Condición: Si el elemento actual es mayor que el máximo registrado hasta ahora
            if (estornudo[i] > maximo){
                maximo = estornudo[i]; // Actualiza el valor del máximo
                base = i;              // Actualiza la posición (índice) donde se encontró el nuevo máximo
            }
        }
        
        // Calcula la media aritmética dividiendo la suma total entre la cantidad de elementos
        // NOTA: Al ser una división entre dos enteros, el resultado perderá los decimales (división entera)
        int media = suma / estornudo.length;

        // Imprime todos los resultados estadísticos en la consola
        System.out.println("La base es " + base);
        System.out.println("La suma total es " + suma);
        System.out.println("El maximo estornudo es " + maximo);
        System.out.println("La media de estornudos es de " + media);
    }
    
    // Método principal que arranca la ejecución del programa
    public static void main(String[] args){
        // Caso de prueba 1: Un arreglo vacío para probar el control de errores
        int[] concurso1 = {};
        
        // Caso de prueba 2: Un arreglo con 5 mediciones de estornudos
        int[] concurso2 = {35, 90, 48, 72, 56};

        // Ejecución y muestra de resultados para el Concurso 1
        System.out.println("Concurso 1:");
        calcula(concurso1);
        
        // Ejecución y muestra de resultados para el Concurso 2
        System.out.println("Concurso 2:");
        calcula(concurso2);
    }
}
