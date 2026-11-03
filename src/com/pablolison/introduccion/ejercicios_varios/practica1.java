package com.pablolison.introduccion.ejercicios_varios;


import java.util.Scanner;

public class practica1 {
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();

        switch(n){
            case 1:
                System.out.println("Lunes");
            break;
            case 2:
                System.out.println("Martes");
            break;
            case 3:
                System.out.println("Mercoles");
            break;
            case 4:
                System.out.println("Jueves");
            break;
            case 5:
                System.out.println("Viernes");
            break;
            case 6:
                System.out.println("Sabado");
            break;
            case 7:
                System.out.println("Domingo");            
            default:
        }
    }
}
    

