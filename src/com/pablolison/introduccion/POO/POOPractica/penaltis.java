package com.pablolison.introduccion.POO.POOPractica;
class tanda{
    static int penaltisMarcado=0;
    static int tandasJugadas=0;
    String equipoA; 
    String equipoB;
    int penaltisA;
    int penaltisB;

    tanda(String equipoA, int penaltisA, String equipoB, int penaltisB){
        this.equipoA=equipoA;
        this.equipoB=equipoB;
        this.penaltisA=penaltisA;
        this.penaltisB=penaltisB;

        penaltisMarcado += penaltisA+penaltisB;
        tandasJugadas++;
    }

    String resultado(){
        return equipoA + " " + penaltisA + "-" + penaltisB + " " + equipoB;
    }

    static String resumen(){

        int media=0;
        if (tandasJugadas > 0){
            media= penaltisMarcado / tandasJugadas;
        } 
        return "Tandas: " + tandasJugadas+", marcados: " + penaltisMarcado + ", media entera: " + media;
    }
}

public class penaltis {
    public static void main(String[] args){
    System.out.println("Antes de empezar " + tanda.resumen());
    

        tanda p1 =new tanda("Cebolla CF", 4, "Pimiento CF", 3);
        tanda p2 =new tanda("Real Berenjena", 5, "Calabacion United", 5);
        tanda p3 =new tanda("Deportivo Lenteja", 0, "Deportivo Alubia", 0);

        System.out.println(p1.resultado());
        System.out.println(p2.resultado());
        System.out.println(p3.resultado());
        System.out.println("Despues de empezar " + tanda.resumen());
}}
