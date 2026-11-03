package com.pablolison.introduccion.ejercicios_varios;

public class Vuelo{
public static void main(String[] args) 

{
String name= "==Aerolineas del sur==";
String vuelo="AS-4412";
int plazas= 180;
int ocupadas = 174;
double precio =89.9;
char puerta = 'D';
boolean completo= false;
long km= 32000000000L;
{
    System.out.println(name);
    System.out.println("El vuelo es el " + vuelo);
    System.out.println("El avion encargado contiene " + plazas + " y se han ocupado " + ocupadas + ".");
    System.out.println("El precio del vuelo es " + precio);
    System.out.println("La puerta de entrada es la letra " + puerta);
    System.out.println("El vuelo va completo: " + completo);
    System.out.println("El avion con referencia " + vuelo + " acumula " + km + "km recorridos.");

}
}
}       
