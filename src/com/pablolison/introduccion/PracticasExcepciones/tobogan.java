package com.pablolison.introduccion.PracticasExcepciones;


public class tobogan {
    
    public static void main(String[] args){

        String[] toboganes = {"rojo", "verde", "amarillo"}; //rojo -> 0
        int[] pedidos = {2, 7, -3};


        for(int posicion=0;posicion<pedidos.length;posicion++){
            System.out.println(bajar(toboganes,pedidos[posicion])); //pedidos[0] -> 2 //pedidos[1] -> 7 //pedidos[2] -> -3
        }
    }

    static String bajar(String[] toboganes, int numerodetoboganquemehanpedido){

        try{
            return "Deslizandose por" + toboganes[numerodetoboganquemehanpedido];
        }catch(ArrayIndexOutOfBoundsException e){
            return ("Ese tobogan no existe.");
        } finally{
           System.out.println("Caso guardado.");
        }

}
}
