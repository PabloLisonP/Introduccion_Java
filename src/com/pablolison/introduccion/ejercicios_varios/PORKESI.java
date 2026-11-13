package com.pablolison.introduccion.ejercicios_varios;

import java.util.Random;


public class PORKESI{
static final Random aleatorio= new Random(); 

    static int dado(int caras){

        return aleatorio.nextInt(caras)+1;
    }

    static int[] cantidad(int numDados,int caras){
        int[] resultados= new int[numDados];
            for(int i=0;i < numDados;i++){
                resultados[i] = dado(caras);
    } return resultados;
    }

    static int[] dados(){
        int[] lista = cantidad(5,6);

        System.out.print("Dado: ");
        for(int i=0; i < lista.length;i++){
            System.out.print(" "+ lista[i]);
            
        }System.out.println();
        return lista;
    }

    static int sumaDados(int[] acumulador){
        int total=0;

        for(int i=0;i < acumulador.length;i++){
            total=total+acumulador[i];
        }
        return total;
    }

    public static void main(String[] args){
            int[] acumulador= dados();
            int resulSuma =sumaDados(acumulador);
    System.out.println("Suma:" + resulSuma);
        }
}