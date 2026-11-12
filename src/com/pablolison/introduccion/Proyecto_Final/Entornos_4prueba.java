package com.pablolison.introduccion.Proyecto_Final;

public class Entornos_4prueba {


    static int numIncidencia = 0;

    // METODO CON ERROR

    static int contarFrutasErroneo(int[] stock, int minimo) {

        int contador = 0;

        for (int i = 0; i < stock.length - 1; i++) {

            if (stock[i] >= minimo) {
                contador++;
            }
        }

        return contador;
    }

    // METODO CORRECTO

    static int contarFrutas(int[] stock, int minimo) {

        int contador = 0;

        for (int i = 0; i < stock.length; i++) {

            if (stock[i] >= minimo) {
                contador++;
            }
        }

        return contador;
    }

    // REGISTRO DE INCIDENCIAS

    static void verificar(String funcion,
                          int esperado,
                          int obtenido) {

        if (esperado != obtenido) {

            numIncidencia++;

            System.out.println("INC-" + numIncidencia
                    + " | Funcion: " + funcion
                    + " | Esperado: " + esperado
                    + " | Obtenido: " + obtenido);
        }
    }

    public static void main(String[] args) {

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
