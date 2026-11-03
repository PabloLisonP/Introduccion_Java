package com.pablolison.introduccion.POO.POOPractica;
class PenaFutbol{
    private String nombre;
    private int euros = 0;

    PenaFutbol(String nombre){
        this.nombre = nombre;
    }

    public String getnombre(){
        return nombre;
    }

    public int geteuros(){
        return euros;
    }

    public boolean ingresar(int euros){
        if(euros != 5 && euros != 10 && euros != 20){
            return false;
        }this.euros += euros;
            return true;
        }
    }

public class caja {
    
    public static void main(String[] args){
        PenaFutbol j1 = new PenaFutbol("Peña los pellizcos");
        int[] cuota={5,10,7,20,10};

        for(int i=0;i < cuota.length;i++){
            boolean aceptado = j1.ingresar(cuota[i]);
            if(aceptado){
                System.out.println("Cuota " + (i+1) + ": CUENTA DE " + cuota[i]+ " TOTAL " + j1.geteuros());
            }else{
                System.out.println("Cuota " + (i+1) + ": " + "billete falso. DE "  + cuota[i] + " EUROS.");
            }
        }
            System.out.println("Caja: " + j1.getnombre() + " con " + j1.geteuros() + " euros");
    }
}
