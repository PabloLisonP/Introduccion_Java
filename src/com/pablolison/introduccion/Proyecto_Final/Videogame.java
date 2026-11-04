
import java.util.Scanner;



public class Videogame {

    static final Scanner teclado = new Scanner(System.in);
    //Fuera del main las funciones, cada funcion debe hacer una funcion diferente pero en relacion con la tematica elegida
    
    public static void main(String[] args) {
        
        int eleccionBoss; 
        do(menu();
    eleccionBoss = leerTeclado("Selecciona un boss. 1-2-3", 1, 3);
        switch (eleccionBoss) {
            case 1:
                instrucciones();
                
                break;
            case 2:
                instrucciones();
                
                break;
            case 3:
                instrucciones();
                
                break;              
        }

)
        
    
        



    }


static void instrucciones(){


}



static void menu() {

    System.out.println("""
        ) (     ) (       ) (
       (   )   (   )     (   )
      (     ) IRON DAYS (     )
    ) (   ) (          ) (   ) (
    (___) (___)       (___) (___)

            ELIGE UN JEFE 

            1.MORLUCK-FACIL
            2.JUTARO-MEDIO
            3.ROGURA-DIFICIL
    """);
}
    


    static int leerTeclado(String mensaje,int minimo,int maximo){

        while(true){System.out.println(mensaje);
            try{
        int numero = Integer.parseInt(teclado.nextLine());
        
        if (numero >= minimo && numero<= maximo){
            return numero;
        }
        System.out.println("Introduce un numero valido entre " + minimo + " y " + maximo + ".");
    }catch(NumberFormatException e){
        System.out.println("!ERROR!");
        System.out.println("INTRODUCE UN NUMERO ENTERO PARA SELECCIONAR UNA OPCION");
    }
    }
    } 
}


