package com.pablolison.introduccion.Proyecto_Final;

public class Entornos_proyectoEntero {

    // ==========================================
    // VARIABLES GENERALES
    // ==========================================

    static int pruebasTotales = 0;
    static int pruebasFallidas = 0;
    static int numIncidencia = 0;


    // ==========================================
    // PRUEBA 1: CAJA NEGRA
    // Clasificar el precio de las frutas
    // ==========================================

    static String clasificarPrecio(int precio) {

        if (precio < 0) {
            return "ERROR";
        } 
        else if (precio < 2) {
            return "BARATO";
        } 
        else if (precio < 5) {
            return "NORMAL";
        } 
        else {
            return "CARO";
        }
    }


    // ==========================================
    // PRUEBA 2: PRUEBAS UNITARIAS
    // Sumar las ventas de la frutería
    // ==========================================

    static int sumarVentas(int[] ventas) {

        int total = 0;

        for (int i = 0; i < ventas.length; i++) {
            total = total + ventas[i];
        }

        return total;
    }


    static void comprobar(String nombre, int esperado, int obtenido) {

        pruebasTotales++;

        if (esperado == obtenido) {

            System.out.println("[PASA] " + nombre);

        } 
        else {

            pruebasFallidas++;

            System.out.println("[FALLA] " + nombre
                    + " esperado=" + esperado
                    + " obtenido=" + obtenido);
        }
    }


    // ==========================================
    // PRUEBA 3: DEPURACIÓN
    // Controlar las cajas de fruta
    // ==========================================

    static void depurarCajas() {

        int[] cajas = {4, 6, 3, 7, 2};

        int total = 0;

        for (int dia = 0; dia < cajas.length; dia++) {

            // TRAZA ANTES
            System.out.println("[TRAZA] dia=" + dia
                    + " antes total=" + total);

            // SUMAR CAJAS
            total = total + cajas[dia];

            // TRAZA DESPUÉS
            System.out.println("[TRAZA] dia=" + dia
                    + " despues total=" + total);

            // BREAKPOINT
            if (total > 12) {

                System.out.println("[BREAKPOINT] total="
                        + total + " supera 12");

                // MODIFICAR VARIABLE
                total = 12;

                // WATCH
                System.out.println("[WATCH] total corregido a "
                        + total);
            }
        }

        System.out.println("Total final: " + total);
    }


    // ==========================================
    // PRUEBA 4: INCIDENCIAS
    // Contar las frutas que cumplen el stock mínimo
    // ==========================================

    // MÉTODO ERRÓNEO

    static int contarFrutasErroneo(int[] stock, int minimo) {

        int contador = 0;

        for (int i = 0; i < stock.length - 1; i++) {

            if (stock[i] >= minimo) {
                contador++;
            }
        }

        return contador;
    }


    // MÉTODO CORRECTO

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

    static void verificar(String funcion, int esperado, int obtenido) {

        if (esperado != obtenido) {

            numIncidencia++;

            System.out.println("INC-" + numIncidencia
                    + " | Funcion: " + funcion
                    + " | Esperado: " + esperado
                    + " | Obtenido: " + obtenido);
        }
    }


    // ==========================================
    // MAIN: EJECUCIÓN DE TODAS LAS PRUEBAS
    // ==========================================

    public static void main(String[] args) {


        // --------------------------------------
        // PRUEBA 1: CAJA NEGRA
        // --------------------------------------

        System.out.println("===== PRUEBA 1: CAJA NEGRA =====");

        int[] precios = {-1, 0, 1, 2, 4, 5};

        String[] esperados = {
            "ERROR", "BARATO", "BARATO",
            "NORMAL", "NORMAL", "CARO"
        };

        for (int i = 0; i < precios.length; i++) {

            String obtenido = clasificarPrecio(precios[i]);

            String estado;

            if (esperados[i].equals(obtenido)) {
                estado = "OK";
            } 
            else {
                estado = "FALLO";
            }

            System.out.println("Precio=" + precios[i]
                    + " esperado=" + esperados[i]
                    + " obtenido=" + obtenido
                    + " -> " + estado);
        }


        // --------------------------------------
        // PRUEBA 2: PRUEBAS UNITARIAS
        // --------------------------------------

        System.out.println("\n===== PRUEBA 2: UNITARIAS =====");

        comprobar("tres ventas", 60,
                sumarVentas(new int[]{10, 20, 30}));

        comprobar("una venta", 15,
                sumarVentas(new int[]{15}));

        comprobar("sin ventas", 0,
                sumarVentas(new int[]{}));

        comprobar("prueba erronea", 50,
                sumarVentas(new int[]{20, 20}));

        System.out.println("Total: " + pruebasTotales
                + " Fallidas: " + pruebasFallidas);


        // --------------------------------------
        // PRUEBA 3: DEPURACIÓN
        // --------------------------------------

        System.out.println("\n===== PRUEBA 3: DEPURACION =====");

        depurarCajas();


        // --------------------------------------
        // PRUEBA 4: INCIDENCIAS
        // --------------------------------------

        System.out.println("\n===== PRUEBA 4: INCIDENCIAS =====");

        int[] stock = {10, 3, 8, 20, 15};

        verificar("contarFrutasErroneo", 4,
                contarFrutasErroneo(stock, 8));

        verificar("contarFrutas", 4,
                contarFrutas(stock, 8));

        verificar("contarFrutasErroneo vacio", 0,
                contarFrutasErroneo(new int[]{}, 8));

        System.out.println("Incidencias detectadas: "
                + numIncidencia);

    }
}
