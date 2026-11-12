package com.pablolison.introduccion.Proyecto_Final;

public class Entornos_2prueba {

    static int pruebasTotales = 0;
    static int pruebasFallidas = 0;

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

        } else {

            pruebasFallidas++;

            System.out.println("[FALLA] " + nombre
                    + " esperado=" + esperado
                    + " obtenido=" + obtenido);
        }
    }

    public static void main(String[] args) {

        comprobar("tres ventas", 60,
                sumarVentas(new int[]{10, 20, 30}));

        comprobar("una venta", 15,
                sumarVentas(new int[]{15}));

        comprobar("sin ventas", 0,
                sumarVentas(new int[]{}));

        comprobar("prueba erronea", 50,
                sumarVentas(new int[]{20, 20}));

        System.out.println("Total: " + pruebasTotales);
        System.out.println("Fallidas: " + pruebasFallidas);
    }
}
