package com.pablolison.introduccion.PracticasExcepciones;


public class PRUEBA34 {

    static void despedir(String[] frases){
        //for (int i = 0 ;i< frases.length; i++) orden normal
        //tendriamos que hacer cambiar el 0 y ponemos el >= en vez del < con el length y le ponemos el -1 y en vez de ++ es --
        for (int i = frases.length-1;i>=0;i--){
            System.out.println("Jueves:" + frases[i]);
        }
            //2
            //1
            //0
            //NO QUEREMOS -1
    }
    public static void main(String[] args){

    String[] jueves = {"Mi batería murió de risa", "Un hámster usó mi cargador", "Me confundí con una tostadora"};

    String[] viernes = {};

    despedir(jueves);
    despedir(viernes);
    }
}