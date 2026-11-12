package com.pablolison.introduccion.Proyecto_Final;

public class Entornos_3prueba {

    public static void main(String[] args) {

        int[] cajas = {4, 6, 3, 7, 2};
        int total = 0;

        for (int dia = 0; dia < cajas.length; dia++) {
            // TRAZA ANTES
            System.out.println("[TRAZA] dia=" + dia
                    + " antes total=" + total);
            total = total + cajas[dia];
            // TRAZA DESPUES
            System.out.println("[TRAZA] dia=" + dia
                    + " despues total=" + total);
            // BREAKPOINT
            if (total > 12) {
                System.out.println("[BREAKPOINT] total="
                        + total + " supera 12");
                total = 12;
                // WATCH
                System.out.println("[WATCH] total corregido a "
                        + total);
            }
        }
        System.out.println("Total final: " + total);
    }
}

