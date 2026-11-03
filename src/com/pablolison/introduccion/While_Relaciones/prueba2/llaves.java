package com.pablolison.introduccion.While_Relaciones.prueba2;


// Definición de la clase principal llamada 'llaves'
public class llaves {

    // Método estático que busca un objeto ('objetivo') dentro de un arreglo de lugares ('bolsillos')
    static void registrar(String[] bolsillos, String objetivo) {
        // Variable para guardar la posición donde se encuentra el objeto. 
        // Comienza en -1 para indicar que inicialmente "no ha sido encontrado".
        int pos = -1;

        // Bucle 'for' para revisar cada bolsillo uno por uno
        for(int i = 0; i < bolsillos.length; i++) {
            // Muestra en consola qué bolsillo se está revisando en la vuelta actual
            System.out.println("Registrando bolsillo: " + bolsillos[i]);
            
            // Condición: Si el bolsillo actual contiene exactamente lo que estamos buscando
            if(bolsillos[i].equals(objetivo)) {
                pos = i; // Guarda el índice actual (la posición) en la variable 'pos'
                break;   // Detiene el bucle por completo. No hace falta seguir buscando.
            }
        }
        
        // Condición para verificar si se encontró el objeto
        // NOTA: Si se encuentra en la posición 0, esta condición fallará (0 no es mayor que 0)
        if(pos > 0) {
            System.out.println("!Llaves encontradas en " + objetivo + " posicion " + pos);
        } else {
            // Se ejecuta si pos es -1 (no encontrado) o 0 (primer elemento)
            System.out.println("Las llaves siguen perdidas tras registrar " + bolsillos.length + " bolsillos");
        }
    }

    // Método principal donde inicia la ejecución del programa
    public static void main(String[] args) {
        // Arreglo con la lista de bolsillos disponibles para revisar
        String[] bolsillos = {"abrigo", "pantalón", "mochila", "zapato", "gorro"};
        
        // Variable que define qué objeto queremos buscar en el primer intento
        String cosaquevoyabuscarenbolsillos = "mochila";
        
        // Ejecución de la primera búsqueda ("mochila")
        System.out.println("Registro 1");
        registrar(bolsillos, cosaquevoyabuscarenbolsillos);
        
        // Ejecución de la segunda búsqueda ("cartera", que no está en la lista)
        System.out.println("Registro 2");
        registrar(bolsillos, "cartera");
    }
}
