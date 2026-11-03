package com.pablolison.introduccion.ejercicios_varios;


public class PRUEBA34 {
    //Funcion: Unes el contenido de la funcion con la varioables frases para operar dentro de ella
    static void despedir(String[] frases){
        //for (int i = 0 ;i< frases.length; i++) orden normal
        //Declaro que i es igual al numero de arrays que hay en frases
        //Despues le digo que mientras sea mayor o igual a cero siga ejecutando el bucle
        //Y por ultimo que cada vez que de una vuelta reste 1
        for (int i = frases.length-1;i>=0;i--){
            //Pinto el contenido 
            //Primero hago un contador de el numero de arrays mas uno porque el array siempre empieza desde 0
            //en frases[i] le pido que me de el contenido en base al numero que tengo en esa vuelta del bucle 
            System.out.println("Frase "+ (i+1) + ":" + frases[i]);
        }
        //Pinto el total de objetos que tengo en frases
        System.out.println("Total de frases:" + frases.length);
            
    }
    public static void main(String[] args){
        //Declaros los arrays
    String[] jueves = {"Mi batería murió de risa", "Un hámster usó mi cargador", "Me confundí con una tostadora"};

    String[] viernes = {};
        
        //Pinto el resultado
    System.out.println("Jueves:");
    //Uno los arrays con la funcion
    despedir(jueves);
    System.out.println("Viernes:");
    despedir(viernes);
    }
}