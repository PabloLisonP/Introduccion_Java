

import java.util.Scanner;
import java.util.Random;

public class Videogame {

    static final Scanner teclado = new Scanner(System.in);
    static final Random aleatorio = new Random();
    static final String RESET = "\u001B[0m";
    static final String ROJO = "\u001B[31m";
    static final String VERDE = "\u001B[32m";
    static final String AMARILLO = "\u001B[33m";
    static final String AZUL = "\u001B[34m";
    static final String MORADO = "\u001B[35m";
    

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

    System.out.println(ROJO + """

        
        ) (     ) (       ) (
       (   )   (   )     (   )
      (     ) IRON DAYS (     )
     ) (   ) (         ) (   ) (
    (___) (___)       (___) (___)

              1.START
              2.INSTRUCCIONES
              3.SALIR
    """ + RESET);
}

static void instrucciones() {
System.out.println(
"=== INSTRUCCIONES ===\n" +
"Tienes 120 de vida. Gana quien deje al otro a 0.\n" +
"----Ataques disponibles:\n" +
VERDE + "1. Ataque normal: 1d8+4 de daño. Siempre disponible." + RESET + "\n" +
AMARILLO + "2. Ataque fuerte: 2d8+6 de daño. Solo cada 2 turnos." + RESET + "\n" +
MORADO + "3. Ultimate: 3d8+10 de daño. Solo cada 3 turnos." + RESET + "\n" +
"----Posees pasivas defensivas que se activan cuando el enemigo te ataca:\n" +
AZUL + "1. Esquivar: 15% de probabilidad de no recibir daño." + RESET + "\n" +
AZUL + "2. Bloquear: 20% de probabilidad de recibir la mitad del daño." + RESET + "\n" +
AZUL + "3. Aguantar: en el resto de casos recibes el daño completo." + RESET
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

static String colorAtaque(int ataque){
    switch (ataque) {
        case 1:
    return VERDE;
        case 2:
    return AMARILLO;
        default:
    return MORADO;
}}

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
                return new Jefe("Ser No-Muerto Ancestral", 175, 175);
            default:
                return new Jefe("Dragon Descamado", 200, 200);
        }}

        static void dibujarGoblin(){
System.out.println(VERDE + """
                                        Rey Goblin de la Caverna

                                                 W W W
                                            <&> <(o o)>
                                            ||   |vvv|
                                            ||===|###|
                                                 |###|
                                                 |_|_|
""" + RESET);
}

        static void dibujarNoMuerto(){
System.out.println(MORADO + """
                                            Ser No-Muerto Ancestral

                                                  _!_!_ <&>
                                                  (x x)  |
                                                  |^^^|  |
                                                O=|{|}|==0
                                                  |{|}|  |
                                                  _| |_  |
""" + RESET);
}

static void dibujarDragon(){
System.out.println(ROJO + """
                                            Dragon Descamado

                                                 ^   ^            
                                            <<=(Ò_! !_Ó)=>>   
                                                 |vvv|
                                         <<---|  |vvv|  |--->>
                                        <<<<-----|###|----->>>>
                                         <<---|  |###|  |--->>
                                                 |_|_|
                                                 |_|_|/ª_
                                                 |_|_|/ª_
""" + RESET);
}

static void dibujarJefe(Jefe jefe){
    if(jefe.nombre.equals("Rey Goblin de la Caverna")){
        dibujarGoblin();
}else if(jefe.nombre.equals("Ser No-Muerto Ancestral"))
    {dibujarNoMuerto();
}else{dibujarDragon();

}}

static void mostrarTurno(String titulo, String color){
    System.out.println(color + "======== " + titulo + " ========" + RESET);
}

static void turnoJugador(Jefe jefe,int[] enfriamientos){

        int opcion = pedirAtaque(enfriamientos);
            if(opcion == 2){
                enfriamientos[0] = 2;
            }else if(opcion == 3){
                enfriamientos[1] =3;
            }

        int golpe = calculoHit(opcion);
        jefe.vida = Math.max(0,jefe.vida - golpe);

        System.out.println(colorAtaque(opcion) + "Has elegido el ataque " + opcion + ", y has realizado " + golpe + " de daño." + RESET);
        System.out.println("Vida actual de " + jefe.nombre + " " +  jefe.vida + " puntos de vida.");

    }
    
    static void dibujarJugador(){
System.out.println(AZUL + """
   ___
  (o o)
 [=|###|=====>
   |###|
  _| |_
""" + RESET);
}

static int turnoJefe(Jefe jefe){
int hitJefe;

    hitJefe = tirarDados(2, 6)+6;
        return hitJefe;
}

static void combate(Jefe jefe){
    int vidaJugador =120;
    int[] enfriamientos = {1,2};

    dibujarJugador();
    dibujarJefe(jefe);

    while(jefe.vida > 0 && vidaJugador > 0){
        mostrarTurno("TU TURNO", AZUL);
        turnoJugador(jefe,enfriamientos);

        if(jefe.vida > 0){
            mostrarTurno("TURNO DE " + jefe.nombre.toUpperCase(), ROJO);
                
                pausa(5000);

            int danioJefe= aplicarDefensa(turnoJefe(jefe));
            vidaJugador = Math.max(0,vidaJugador - danioJefe);

                System.out.println(ROJO + jefe.nombre + " te ha hecho " + danioJefe + " puntos de daño." + RESET);

                System.out.println("Tienes " + vidaJugador + " puntos de vida");
}
        for(int i=0;i< enfriamientos.length;i++){
            if(enfriamientos[i]>0){
            enfriamientos[i]--;
        }}}

        if(vidaJugador > 0){
            System.out.println(VERDE + "¡Felicidades has derrotado a " + jefe.nombre + "!" + RESET);
        }else{
            System.out.println(ROJO + "Has sido derrotado por " + jefe.nombre + ", intentalo de nuevo." + RESET);
        }}


static int pedirAtaque(int[] enfriamientos){

    while(true){
        System.out.println("1= Ataque Normal");
        System.out.println("2= Ataque Fuerte");
        System.out.println("3= ULTIMATE");
        int opcion = leerTeclado("Elige el siguiente ataque. 1-2-3", 1, 3);
        
        
        if(opcion == 2 && enfriamientos[0] > 0){
            System.out.println("El ataque fuerte estara listo en " + enfriamientos[0] + " turno.");
        }else if(opcion == 3 && enfriamientos[1] > 0){
            System.out.println("La ultimate estara lista en " + enfriamientos[1] + " turno.");
        }else{return opcion;}
    }}

static int aplicarDefensa(int danio){
    int tirada = tirarDado(100);

    if(tirada <= 15){
            System.out.println(AZUL + "¡Has esquivado el ataque!" + RESET);
                return 0;
        }else if(tirada <= 35){

            System.out.println(AZUL + "¡Has bloqueado el ataque!" + RESET);
                return  danio / 2;
        }else{
                return danio;

}}

static void pausa(int milisegundos){
    try {
        Thread.sleep(milisegundos);
    }
    catch(InterruptedException e){
        System.out.println("La pausa se a interrumpido.");
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
