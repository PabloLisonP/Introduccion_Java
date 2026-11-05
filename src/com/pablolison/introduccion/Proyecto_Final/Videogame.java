
import java.util.Scanner;
import java.util.Random;

public class Videogame {

    static final Scanner teclado = new Scanner(System.in);
    static final Random aleatorio = new Random();
    

static class Jefe{

    String nombre;
    int vida;
    int vidaMaxima;

        Jefe(String nombre, int vida, int vidaMaxima){
            this.nombre = nombre;
            this.vida = vida;
            this.vidaMaxima = vidaMaxima;
        }}    

static void menu() {

    System.out.println("""
        ) (     ) (       ) (
       (   )   (   )     (   )
      (     ) IRON DAYS (     )
     ) (   ) (         ) (   ) (
    (___) (___)       (___) (___)

              1.START
              2.INSTRUCCIONES
              3.SALIR
    """);
}

static void instrucciones() {
    System.out.println(
        "=== INSTRUCCIONES ===\n" +
        "Tienes 120 de vida. Gana quien deje al otro a 0.\n" +
        "Ataques disponibles:\n" +
        "1. Ataque normal: 1d8+4 de daño. Siempre disponible.\n" +
        "2. Ataque fuerte: 2d8+6 de daño. Solo cada 2 turnos.\n" +
        "3. Ultimate: 3d8+10 de daño. Solo cada 3 turnos.\n" +
        "Si sacas un 20 en el d20 de crítico, el daño se dobla.\n" +
        "Posees pasivas defensivas que se activaran al enemigo atacarte:\n" +
        "1. Esquivar: con 13 o mas en el d20 no recibes nada.\n" +
        "2. Bloquear: con 7 o mas en el d20 recibes la mitad.\n" +
        "3. Aguantar: recibes el daño completo."
    );
}


static int tirarDado(int caras){

    return aleatorio.nextInt(caras) + 1;
}

static int tirarDados(int cantidad, int caras){
    int total =0;

    for(int i=0;i< cantidad;i++){
        total = total + tirarDado(caras) ;
    }
    return total;
}

static int calculoHit(int ataque){
int hit;

    switch(ataque){
        case 1:
            hit = tirarDados(1, 8)+4;
                break;
        case 2:
            hit = tirarDados(2,8)+6;
                break;
        default:
            hit = tirarDados(3, 8)+10;
                break;
                }return hit;}

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
    }}} 

static Jefe elegirJefe(){
    System.out.println("""
                1.Rey Goblin de la Caverna
                2.Ser No-Muerto Ancestral
                3.Dragon Descamado
                        """);

    int eleccionJefe;
        eleccionJefe = leerTeclado("Seleccione a su contrincante. 1-2-3", 1, 3);
        
        switch (eleccionJefe) {
            case 1:
                return new Jefe("Rey Goblin de la Caverna", 150, 150);
            case 2:
                return new Jefe("Ser No-Muerto Ancestral", 200, 200);
            default:
                return new Jefe("Dragon Descamado", 250, 250);
        }}

static void turnoJugador(Jefe jefe,int[] enfriamientos){

        int opcion = pedirAtaque(enfriamientos);
            if(opcion == 2){
                enfriamientos[0] = 2;
            }else if(opcion == 3){
                enfriamientos[1] =3;
            }

        int golpe = calculoHit(opcion);
        jefe.vida = Math.max(0,jefe.vida - golpe);

        System.out.println("Has elegido el ataque " + opcion + ", y has realizado " + golpe + " de daño." );
        System.out.println("Vida actual de " + jefe.nombre + " " +  jefe.vida + " puntos de vida.");

    } 

static int turnoJefe(Jefe jefe){
int hitJefe;

    hitJefe = tirarDados(2, 6)+6;
        return hitJefe;
}

static void combate(Jefe jefe){
    int vidaJugador =120;
    int[] enfriamientos = {1,2};

    while(jefe.vida > 0 && vidaJugador > 0){
        turnoJugador(jefe,enfriamientos);
        if(jefe.vida > 0){
            int danioJefe= turnoJefe(jefe);
            vidaJugador = Math.max(0,vidaJugador - danioJefe);
            System.out.println(jefe.nombre + " te ha hecho " + danioJefe + " puntos de daño.");
            System.out.println("Tienes " + vidaJugador+ " puntos de vida");
        }}

        if(vidaJugador > 0){
            System.out.println("¡Felicidades has derrotado a " + jefe.nombre + "!");
        }else{
            System.out.println("Has sido derrotado por el " + jefe.nombre + ", intentalo de nuevo.");
        }      
}

static int pedirAtaque(int[] enfriamientos){

    while(true){
        int opcion = leerTeclado("Elige el siguiente ataque. 1-2-3", 1, 3);
        
        if(opcion == 2 && enfriamientos[0] > 0){
            System.out.println("El ataque fuerte estara listo en " + enfriamientos[0] + " turno.");
        }else if(opcion == 3 && enfriamientos[1] > 0){
            System.out.println("La ultimate estara lista en " + enfriamientos[1] + " turno.");
        }else{return opcion;}
    }
}
public static void main(String[] args) {

    int eleccionmenu; 

    do{menu();
        eleccionmenu = leerTeclado("Selecciona una opcion. 1-2-3", 1, 3);

        switch (eleccionmenu) 
        {
            case 1:
                combate(elegirJefe());
                break;
            case 2:
                instrucciones();
                break;
            case 3:
                System.out.println("Hasta la proxima!");
                break;  
        }
    }while(eleccionmenu != 3);
}}


