package com.pablolison.introduccion.Proyecto_Final;
// Pruebas SEPARADAS del juego: solo llaman a las funciones de Videogame, no las modifican.


public class Entornos_1prueba{

    static String clasificarPrecio(int precio) {

        if (precio < 0) {
            return "ERROR";
        } else if (precio < 2) {
            return "BARATO";
        } else if (precio < 5) {
            return "NORMAL";
        } else {
            return "CARO";
        }
    }

    public static void main(String[] args) {

        int[] entradas = {-1, 0, 1, 2, 4, -20};

        String[] esperados = {
            "ERROR", "BARATO", "BARATO",
            "NORMAL", "NORMAL", "CARO"
        };

        for (int i = 0; i < entradas.length; i++) {

            String obtenido = clasificarPrecio(entradas[i]);

            if (esperados[i].equals(obtenido)) {
                System.out.println("OK");
            } else {
                System.out.println("FALLO");
            }
            System.out.println(esperados[i]);
        }
    }
}
