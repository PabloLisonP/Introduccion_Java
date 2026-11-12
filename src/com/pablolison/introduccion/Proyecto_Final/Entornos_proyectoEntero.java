package com.pablolison.introduccion.Proyecto_Final;

public class Entornos_proyectoEntero {

    // ==========================================
    // VARIABLES GENERALES
    // ==========================================

    // Cuenta cuántas pruebas unitarias se han ejecutado en total
    static int pruebasTotales = 0;
    // Cuenta cuántas de esas pruebas han fallado
    static int pruebasFallidas = 0;
    // Contador para numerar las incidencias (INC-1, INC-2...)
    static int numIncidencia = 0;


    // ==========================================
    // PRUEBA 1: CAJA NEGRA
    // Clasificar el precio de las frutas
    // ==========================================

    
    // Este es el método que vamos a probar con caja negra
// Caja negra = probamos sin mirar el código de dentro, solo comparamos entrada con salida
// Recibe un precio y devuelve una categoría en texto
    static String clasificarPrecio(int precio) {

        // Un precio negativo no tiene sentido, así que es un error
        if (precio < 0) {
            return "ERROR";
        } 
        // De 0 a 1 es barato
        else if (precio < 2) {
            return "BARATO";
        } 
        // De 2 a 4 es normal
        else if (precio < 5) {
            return "NORMAL";
        } 
        // De 5 en adelante es caro
        else {
            return "CARO";
        }
    }


    // ==========================================
    // PRUEBA 2: PRUEBAS UNITARIAS
    // Sumar las ventas de la frutería
    // ==========================================

    // Método que vamos a probar de forma unitaria (una unidad pequeña de código, aislada)
// Recibe un array con las ventas y devuelve la suma de todas
    static int sumarVentas(int[] ventas) {

        // Acumulador que empieza en 0
        int total = 0;

        // Recorremos el array de la posición 0 hasta la última
        for (int i = 0; i < ventas.length; i++) {
            // Vamos sumando cada venta al total
            total = total + ventas[i];
        }
        // Devolvemos la suma final
        return total;
    }

    // Método auxiliar que hace de "mini framework" de pruebas
    // Compara el valor esperado con el obtenido e imprime si pasa o falla
    static void comprobar(String nombre, int esperado, int obtenido) {
        // Cada vez que se llama, contamos una prueba más
        pruebasTotales++;
        // Si lo esperado coincide con lo obtenido, la prueba pasa
        if (esperado == obtenido) {

            System.out.println("[PASA] " + nombre);

        } // Si no coinciden, la prueba falla
        else {
            // Sumamos una prueba fallida al contador
            pruebasFallidas++;
            // Mostramos qué esperábamos y qué salió realmente
            System.out.println("[FALLA] " + nombre
                    + " esperado=" + esperado
                    + " obtenido=" + obtenido);
        }
    }


    // ==========================================
    // PRUEBA 3: DEPURACIÓN
    // Controlar las cajas de fruta
    // ==========================================

    // Este método simula una sesión de depuración (debug) con trazas, breakpoint y watch

    static void depurarCajas() {
        // Cajas de fruta que llegan cada día
        int[] cajas = {4, 6, 3, 7, 2};
        // Total acumulado de cajas
        int total = 0;
        // Recorremos los días
        for (int dia = 0; dia < cajas.length; dia++) {

            // TRAZA ANTES
            // Las trazas son mensajes que imprimimos para seguir qué hace el programa paso a paso
            // Aquí vemos el valor de total antes de sumar
            System.out.println("[TRAZA] dia=" + dia
                    + " antes total=" + total);

            // SUMAR CAJAS
            // Sumamos las cajas de ese día al total
            total = total + cajas[dia];

            // TRAZA DESPUÉS
            // Vemos el valor de total ya sumado
            System.out.println("[TRAZA] dia=" + dia
                    + " despues total=" + total);

            // BREAKPOINT
            // Simula un punto de ruptura: el programa "se para" cuando se cumple una condición
            // En este caso, cuando el total supera 12
            if (total > 12) {

                System.out.println("[BREAKPOINT] total="
                        + total + " supera 12");

                // MODIFICAR VARIABLE
                // En un debugger real podrías cambiar el valor de una variable mientras está parado
                // Aquí lo forzamos a 12 (el límite)
                total = 12;

                // WATCH
                // Un watch es "vigilar" una variable
                // Mostramos su valor tras corregirlo para comprobar que ahora es 12
                System.out.println("[WATCH] total corregido a "
                        + total);
            }
        }
        // Mostramos el resultado final
        System.out.println("Total final: " + total);
    }


    // ==========================================
    // PRUEBA 4: INCIDENCIAS
    // Contar las frutas que cumplen el stock mínimo
    // ==========================================

    // MÉTODO ERRÓNEO

    static int contarFrutasErroneo(int[] stock, int minimo) {

        int contador = 0;
        // ERROR: el bucle usa stock.length - 1, así que se deja SIN revisar el último elemento

        for (int i = 0; i < stock.length - 1; i++) {
            // Si el stock de esa fruta llega al mínimo, la contamos
            if (stock[i] >= minimo) {
                contador++;
            }
        }

        return contador;
    }


    // MÉTODO CORRECTO
    // Misma lógica, pero el bucle recorre TODOS los elementos (i < stock.length)
    static int contarFrutas(int[] stock, int minimo) {

        int contador = 0;

        for (int i = 0; i < stock.length; i++) {

            if (stock[i] >= minimo) {
                contador++;
            }
        }

        return contador;
    }


    // MÉTODO PARA REGISTRAR INCIDENCIAS

    // Compara lo esperado con lo obtenido
    // Si NO coinciden, registra una incidencia numerada (como un ticket de error)
    static void verificar(String funcion, int esperado, int obtenido) {

        if (esperado != obtenido) {
            // Subimos el número de incidencia (INC-1, INC-2...)
            numIncidencia++;
            // Imprimimos el informe de la incidencia: qué función falló y qué valores hubo
            System.out.println("INC-" + numIncidencia
                    + " | Funcion: " + funcion
                    + " | Esperado: " + esperado
                    + " | Obtenido: " + obtenido);
        }
    }


    // ==========================================
    // MAIN: EJECUCIÓN DE TODAS LAS PRUEBAS
    // ==========================================

    // Punto de entrada del programa: aquí se lanzan las 4 pruebas
    public static void main(String[] args) {


        // --------------------------------------
        // PRUEBA 1: CAJA NEGRA
        // --------------------------------------

        System.out.println("===== PRUEBA 1: CAJA NEGRA =====");

        // Valores de entrada elegidos en los límites de cada categoría (valores frontera)
        // -1 (error), 0 y 1 (barato), 2 y 4 (normal), 5 (caro)
        int[] precios = {-1, 0, 1, 2, 4, 5};
        // Resultado que ESPERAMOS para cada precio, en el mismo orden
        String[] esperados = {
            "ERROR", "BARATO", "BARATO",
            "NORMAL", "NORMAL", "CARO"
        };
        // Recorremos todos los precios de prueba
        for (int i = 0; i < precios.length; i++) {
            // Llamamos al método con el precio y guardamos lo que devuelve
            String obtenido = clasificarPrecio(precios[i]);
            // Aquí guardaremos si la prueba salió bien o mal
            String estado;

            // Comparamos Strings con equals (nunca con ==)
            if (esperados[i].equals(obtenido)) {
                estado = "OK";
            } 
            else {
                estado = "FALLO";
            }

            // Mostramos la entrada, lo esperado, lo obtenido y el veredicto
            System.out.println("Precio=" + precios[i]
                    + " esperado=" + esperados[i]
                    + " obtenido=" + obtenido
                    + " -> " + estado);
        }


        // --------------------------------------
        // PRUEBA 2: PRUEBAS UNITARIAS
        // --------------------------------------

        System.out.println("\n===== PRUEBA 2: UNITARIAS =====");

        // Caso normal: 10 + 20 + 30 = 60
        comprobar("tres ventas", 60,
                sumarVentas(new int[]{10, 20, 30}));
        // Caso con un solo elemento
        comprobar("una venta", 15,
                sumarVentas(new int[]{15}));
        // Caso límite: array vacío, la suma debe ser 0
        comprobar("sin ventas", 0,
                sumarVentas(new int[]{}));
        // Prueba que FALLA a propósito: 20 + 20 = 40, pero decimos que esperamos 50
        // Sirve para ver cómo se muestra un fallo
        comprobar("prueba erronea", 50,
                sumarVentas(new int[]{20, 20}));

        // Resumen: pruebas ejecutadas y cuántas han fallado
        System.out.println("Total: " + pruebasTotales
                + " Fallidas: " + pruebasFallidas);


        // --------------------------------------
        // PRUEBA 3: DEPURACIÓN
        // --------------------------------------

        System.out.println("\n===== PRUEBA 3: DEPURACION =====");

        // Lanzamos el método con trazas, breakpoint y watch
        depurarCajas();


        // --------------------------------------
        // PRUEBA 4: INCIDENCIAS
        // --------------------------------------

        System.out.println("\n===== PRUEBA 4: INCIDENCIAS =====");

        // Stock de 5 frutas
        int[] stock = {10, 3, 8, 20, 15};

        // Con mínimo 8 deberían cumplir 4 frutas (10, 8, 20 y 15)
        // El método erróneo se salta la última (15) y devuelve 3, así que genera la INC-1
        verificar("contarFrutasErroneo", 4,
                contarFrutasErroneo(stock, 8));

        // El método correcto devuelve 4, coincide, y no genera incidencia
        verificar("contarFrutas", 4,
                contarFrutas(stock, 8));

        // Con array vacío el erróneo devuelve 0, que es lo esperado, así que tampoco falla
        // (el bug solo se nota cuando el último elemento importa)
        verificar("contarFrutasErroneo vacio", 0,
                contarFrutasErroneo(new int[]{}, 8));

        // Total de incidencias registradas (será 1)
        System.out.println("Incidencias detectadas: "
                + numIncidencia);

    }
}
