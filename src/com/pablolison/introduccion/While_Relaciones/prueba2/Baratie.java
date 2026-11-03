package com.pablolison.introduccion.While_Relaciones.prueba2;


public class Baratie {
    
    public static void main (String[] args){

        int[] entradas = {-5,0,49,50,199,200};
        String[] esperados = {"ERROR","BARATO","BARATO","NORMAL","NORMAL","LUJO"};
        
        for(int i= 0;i<entradas.length;i++){
            int entrada = entradas[i];
            String esperado = esperados[i];

            String obtenido = etiquetaPrecio(entrada);
            String veredicto= obtenido.equals(esperado) ? "OK" : "FALLO";

            System.out.println("Caso" + (i+1)+"entrada="+entrada+"esperado="+esperado+"obtenido="+obtenido+"->"+veredicto);
        }
    }

    public static String etiquetaPrecio(int berries){

        if(berries < 0){
            return "ERROR";
        }else if(berries <50){
            return "BARATO";
        }else if(berries <200){
            return "CARO";
        }else{
            return"LUJO";}
    }
    }

