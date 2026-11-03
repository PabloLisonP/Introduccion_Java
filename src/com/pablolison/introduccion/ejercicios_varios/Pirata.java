package com.pablolison.introduccion.ejercicios_varios;


public class Pirata {
    static void dividir(int[] monedas , int[] piratas){

        for(int posicion=0;posicion <= monedas.length; posicion++){

            try{
                System.out.println("Cofre "+ (posicion+1)+ ": " + (monedas[posicion] / piratas[posicion])+ " monedas por pirata.");
}
            catch (ArithmeticException e){
                System.out.println("Cofre " + (posicion+1) + ": ningun pirata, el loro se lo quedo todo" );
            }
            catch(ArrayIndexOutOfBoundsException e){
                System.out.println("Cofre " + (posicion+1) + ": no existe, el kraken se lo trago.");
            }
        }
    }

    public static void main(String[] args){
        int[] monedas={20,15,7};
        int[] piratas = {5, 0, 2};

        dividir(monedas,piratas);
    }
}
