package com.pablolison.introduccion.ejercicios_varios;


import java.util.Scanner;

public class escaner {
    public static void main(String[] args){
        System.out.println("Que nota a sacado el alumno?");
        Scanner sc= new Scanner(System.in);
        int nota = sc.nextInt();
        sc.close();
        
        switch(nota){
            case 1,2,3,4:
                System.out.println("Has suspendio tus muertos");
                break;
            case 5,6:
                System.out.println("Has sacado un bien");
                break;
            case 7,8:
                System.out.println("Has sacado un notable");
                break;
            case 9,10:
                System.out.println("Enhorabuena has sacado un sobresaliente");
                break;
            default:                
        }
    }
}