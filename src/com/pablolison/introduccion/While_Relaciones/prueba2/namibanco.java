package com.pablolison.introduccion.While_Relaciones.prueba2;


public class namibanco {
    
    static int pruebasTotales=0;
    static int pruebasFallidas=0;

        static int sumarIngresos(int[] ingresos){
            int sumadeingresos = 0;
        
            for(int i=0; i<ingresos.length;i++){
                sumadeingresos +=ingresos[i];
            }
            return sumadeingresos;
        }

        static void comprobar(String nombre, int esperado, int obtenido){
            pruebasTotales++;

            if(esperado==obtenido){
                System.out.println(" [PASA] "+ nombre );
            }else{pruebasFallidas++;
                System.out.println(" [FALLO] "+ nombre + " esperado= "+ esperado + " obtenido= " + obtenido);
            }
        }

    public static void main (String[] args){

        comprobar("cuatro ingresos",100,sumarIngresos(new int[] {10,20,30,40}));
        comprobar("un ingreso",7,sumarIngresos(new int[]{7}));
        comprobar("sin ingresos",0,sumarIngresos(new int[]{}));
        comprobar("prueba error",20,sumarIngresos(new int[]{8,9}));
    System.out.println("Total: " + pruebasTotales + " Fallidas: " + pruebasFallidas);
}
}
