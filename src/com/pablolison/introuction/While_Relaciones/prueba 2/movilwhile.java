// Definición de la clase principal llamada 'movilwhile'
public class movilwhile {
    
    // Método estático que simula la carga de la batería según el porcentaje 'faltante' recibido
    static void cargar(int faltante) {

        // Variable contador para registrar cuántos bloques de carga de 20% se necesitan
        int tanda = 0;

        // Bucle 'while': Se ejecuta mientras el porcentaje que falta por cargar sea mayor que 0
        while(faltante > 0) {
            tanda++; // Incrementa en 1 el número de la tanda actual
            
            // Resta 20 al porcentaje faltante (simula que en cada tanda se carga un 20%)
            faltante = faltante - 20; 
            
            // Muestra en consola el progreso de la tanda actual y el porcentaje que queda
            // NOTA: Si faltante baja de 0 (por ejemplo, si faltaba un 10%), mostrará un valor negativo momentáneamente
            System.out.println("Tanda " + tanda + ":" + " falta " + faltante + "%");
        }

        // Finalizado el bucle, evalúa cuántas tandas se realizaron
        if(tanda == 0) {
            // Si las tandas se quedaron en 0, significa que 'faltante' ya era 0 o menor desde el principio
            System.out.println("Ya estaba cargado.");
        } else {
            // Muestra el número total de tandas que tomó completar la carga completa
            System.out.println("Movil cargado en " + tanda + ".");
        }
    }

    // Método principal donde se inicia la ejecución para probar varios días de la semana
    public static void main(String[] args) {
        System.out.println("Miercoles:");
        cargar(80); // Requiere 4 tandas (80 / 20 = 4)
        
        System.out.println("Jueves:");
        cargar(0);  // Muestra "Ya estaba cargado." (0 tandas)
        
        System.out.println("Viernes:");
        cargar(40); // Requiere 2 tandas (40 / 20 = 2)
        
        System.out.println("Sabado:");
        cargar(20); // Requiere 1 tanda (20 / 20 = 1)
        
        System.out.println("Domingo:");
        cargar(100); // Requiere 5 tandas (100 / 20 = 5)
        
        System.out.println("Lunes:");
        cargar(0);  // Muestra "Ya estaba cargado."
        
        System.out.println("Martes:");
        cargar(60); // Requiere 3 tandas (60 / 20 = 3)
    }
}
