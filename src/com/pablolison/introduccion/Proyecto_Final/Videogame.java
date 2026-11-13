package com.pablolison.introduccion.Proyecto_Final;
/*
IRON DAYS - Minijuego de combate por turnos en la terminal.
El jugador (120 de vida) se enfrenta a un jefe elegido por el. En cada ronda
ataca el jugador con uno de tres ataques (con tiempos de espera) y despues
ataca el jefe. El dano se calcula con dados y el jugador tiene pasivas
defensivas (esquivar y bloquear) que se activan por probabilidad.
Gana quien deje al otro a 0 de vida.
*/

// Scanner sirve para leer lo que el usuario escribe por teclado.
import java.util.Scanner;
// Random sirve para generar numeros aleatorios (los dados).
import java.util.Random;

public class Videogame {

    // Unico Scanner del programa. Es static final para que todas las funciones lo usen
    // y no se pueda reasignar.

    static final Scanner teclado = new Scanner(System.in);
// Unico Scanner del programa. Es static final para que todas las funciones lo usen
// y no se pueda reasignar.

    static final Random aleatorio = new Random();
// Generador de numeros aleatorios que usan los dados.


// Codigos ANSI de color: se escriben antes de un texto para pintarlo en la terminal.
// RESET devuelve el color a la normalidad (si se olvida, el color se queda pegado).
    static final String RESET = "\u001B[0m";
    static final String ROJO = "\u001B[31m";
    static final String VERDE = "\u001B[32m";
    static final String AMARILLO = "\u001B[33m";
    static final String AZUL = "\u001B[34m";
    static final String MORADO = "\u001B[35m";
/*
CLASE JEFE (la parte de objetos del proyecto).
Agrupa los datos de un jefe: su nombre, su vida actual y su vida maxima.
Cada jefe que se crea con "new Jefe(...)" es un objeto con sus propios datos.
*/
static class Jefe{

    String nombre;
    int vida;
    // Guarda la vida con la que empieza el jefe. Ahora mismo no se usa, pero
// serviria para una futura barra de vida.
    int vidaMaxima;

    // Constructor: se ejecuta al crear un jefe y rellena sus datos.
// "this.nombre" es el dato del jefe y "nombre" es el valor que llega por parametro.
        Jefe(String nombre, int vida, int vidaMaxima){
            this.nombre = nombre;
            this.vida = vida;
            this.vidaMaxima = vidaMaxima;
        }}    

/*
menu(): dibuja el menu principal en rojo.
No devuelve nada (void), solo imprime por pantalla.
El texto entre """ es un "text block": respeta los saltos de linea y los espacios.
*/        
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

/*
instrucciones(): explica las reglas del juego. Cada tipo de ataque se pinta con su color
(el mismo que se usa luego en combate) y las pasivas se pintan en azul.
Los "\n" son saltos de linea dentro de un mismo println.
*/
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

/*
tirarDado(): simula UN dado de "caras" caras.
nextInt(caras) da un numero de 0 a caras-1, asi que se suma 1 para que vaya de 1 a caras.
Devuelve el resultado de la tirada.
*/
static int tirarDado(int caras){

    return aleatorio.nextInt(caras) + 1;
}

/*
tirarDados(): simula VARIOS dados y devuelve la suma.
Ejemplo: tirarDados(2, 8) equivale a "2d8" (dos dados de 8 caras).
Un for repite "cantidad" veces la tirada y va acumulando el resultado en "total".
*/
static int tirarDados(int cantidad, int caras){
// Marcador de la suma. Empieza en 0 y esta fuera del for para no reiniciarse.

    int total =0;

    for(int i=0;i< cantidad;i++){
        total = total + tirarDado(caras) ;
    }
    return total;
}

/*
calculoHit(): traduce el ataque elegido (1, 2 o 3) en el dano que hace.
Normal: 1d8+4  |  Fuerte: 2d8+6  |  Ultimate: 3d8+10
Cada ataque tira mas dados y suma un bono mayor. Devuelve el dano.
*/
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


/*
leerTeclado(): pide un numero entero al usuario y lo repite hasta que sea valido.
Usa try/catch (excepciones): si el usuario escribe letras, parseInt lanza una
NumberFormatException, la capturamos y mostramos un error en lugar de que el
programa se cierre. Si el numero esta fuera de [minimo, maximo], tambien vuelve a preguntar.
El while(true) solo se rompe con el return cuando el numero es correcto.
*/                
static int leerTeclado(String mensaje,int minimo,int maximo){

        while(true){System.out.println(mensaje);
            try{
        // Lee una linea de texto y la convierte a numero entero.        
        int numero = Integer.parseInt(teclado.nextLine());
        
        if (numero >= minimo && numero<= maximo){
            return numero;
        }
        System.out.println("Introduce un numero valido entre " + minimo + " y " + maximo + ".");
    }catch(NumberFormatException e){
        System.out.println("!ERROR!");
        System.out.println("INTRODUCE UN NUMERO ENTERO PARA SELECCIONAR UNA OPCION");
    }}} 

/*
colorAtaque(): devuelve el color de cada ataque (normal verde, fuerte amarillo,
ultimate morado). Se usa para pintar el mensaje del ataque que ha elegido el jugador.
*/    
static String colorAtaque(int ataque){
    switch (ataque) {
        case 1:
    return VERDE;
        case 2:
    return AMARILLO;
        default:
    return MORADO;
}}


/*
elegirJefe(): muestra los tres jefes, deja elegir uno y DEVUELVE el objeto Jefe creado.
Cada case crea el jefe y lo devuelve en la misma linea (el return sale de la funcion,
por eso no hace falta break). Los jefes tienen mas vida cuanto mas dificiles son.
*/
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

        // dibujarGoblin(): pinta en verde el dibujo ASCII del Rey Goblin.
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
        // dibujarNoMuerto(): pinta en morado el dibujo ASCII del Ser No-Muerto.
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
        // dibujarDragon(): pinta en rojo el dibujo ASCII del Dragon.
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

/*
dibujarJefe(): elige que dibujo mostrar segun el nombre del jefe.
Los textos se comparan con .equals() y no con == (== compara objetos, no letras).
El dragon va en el else final porque es el unico que queda.
*/
static void dibujarJefe(Jefe jefe){
    if(jefe.nombre.equals("Rey Goblin de la Caverna")){
        dibujarGoblin();
}else if(jefe.nombre.equals("Ser No-Muerto Ancestral"))
    {dibujarNoMuerto();
}else{dibujarDragon();

}}

/*
mostrarTurno(): imprime un titulo de color para dejar claro de quien es el turno.
Recibe el texto del titulo y el color con el que se pinta.
*/
static void mostrarTurno(String titulo, String color){
    System.out.println(color + "======== " + titulo + " ========" + RESET);
}

/*
turnoJugador(): UN turno del jugador.
1. Pide el ataque (pedirAtaque ya comprueba que este disponible).
2. Si usa el fuerte o la ultimate, activa su tiempo de espera en el array.
3. Calcula el dano con dados y se lo resta al jefe (sin bajar de 0 gracias a Math.max).
4. Muestra el registro del ataque y la vida que le queda al jefe.
Como Jefe y los arrays se pasan "por referencia", los cambios que se hacen aqui
(jefe.vida y enfriamientos) se mantienen fuera de la funcion.
*/
static void turnoJugador(Jefe jefe,int[] enfriamientos){

        int opcion = pedirAtaque(enfriamientos);
        // Tiempo de espera: fuerte = 2 turnos, ultimate = 3 turnos.
        // El ataque normal no tiene espera.

            if(opcion == 2){
                enfriamientos[0] = 2;
            }else if(opcion == 3){
                enfriamientos[1] =3;
            }

        int golpe = calculoHit(opcion);
        // Math.max(0, ...) evita que la vida del jefe quede en negativo.
        jefe.vida = Math.max(0,jefe.vida - golpe);

        System.out.println(colorAtaque(opcion) + "Has elegido el ataque " + opcion + ", y has realizado " + golpe + " de daño." + RESET);
        System.out.println("Vida actual de " + jefe.nombre + " " +  jefe.vida + " puntos de vida.");

    }

        // dibujarJugador(): pinta en azul el dibujo ASCII del caballero del jugador.
        static void dibujarJugador(){
System.out.println(AZUL + """
   ___
  (o o)
 [=|###|=====>
   |###|
  _| |_
""" + RESET);
}

/*
turnoJefe(): calcula el golpe del jefe (2d6+6) y lo devuelve.
No resta vida: solo calcula el dano. La resta la hace combate(), que es quien
tiene la vida del jugador. (El parametro jefe se podria usar para que cada jefe
pegue distinto.)
*/
static int turnoJefe(Jefe jefe){
int hitJefe;

    hitJefe = tirarDados(2, 6)+6;
        return hitJefe;
}

/*
combate(): controla toda la pelea. Es la funcion que une al resto.
- vidaJugador y el array enfriamientos nacen aqui porque duran toda la pelea.
- enfriamientos[0] = turnos que faltan para el ataque fuerte; [1] = para la ultimate.
  Empieza en {1,2}: el fuerte esta listo en la ronda 2 y la ultimate en la 3.
- El while repite rondas mientras LOS DOS sigan vivos (condicion con &&).
Cada ronda: turno del jugador -> (si el jefe sigue vivo) pausa, golpe del jefe con
defensa pasiva -> bajar los tiempos de espera.
*/
static void combate(Jefe jefe){
    int vidaJugador =120;
    int[] enfriamientos = {1,2};

    dibujarJugador();
    dibujarJefe(jefe);

    while(jefe.vida > 0 && vidaJugador > 0){
        mostrarTurno("TU TURNO", AZUL);
        turnoJugador(jefe,enfriamientos);

        // Un jefe muerto no ataca, por eso este if.
        if(jefe.vida > 0){
            mostrarTurno("TURNO DE " + jefe.nombre.toUpperCase(), ROJO);
                
                // Espera de 5 segundos entre tu ataque y el del jefe.
                pausa(5000);
            
            // El golpe del jefe pasa primero por las pasivas (esquivar/bloquear/aguantar)
            // y despues se resta de la vida del jugador.
            int danioJefe= aplicarDefensa(turnoJefe(jefe));
            vidaJugador = Math.max(0,vidaJugador - danioJefe);

                System.out.println(ROJO + jefe.nombre + " te ha hecho " + danioJefe + " puntos de daño." + RESET);

                System.out.println("Tienes " + vidaJugador + " puntos de vida");
}       
        // Al final de cada ronda, los tiempos de espera bajan 1 (sin pasar de 0).
        for(int i=0;i< enfriamientos.length;i++){
            if(enfriamientos[i]>0){
            enfriamientos[i]--;
        }}}

        // Fuera del bucle alguien ha muerto. Si el jugador sigue vivo, ha ganado.
        if(vidaJugador > 0){
            System.out.println(VERDE + "¡Felicidades has derrotado a " + jefe.nombre + "!" + RESET);
        }else{
            System.out.println(ROJO + "Has sido derrotado por " + jefe.nombre + ", intentalo de nuevo." + RESET);
        }}

/*
pedirAtaque(): muestra los ataques y pide uno, comprobando que este listo.
Si eliges el fuerte o la ultimate y todavia les queda tiempo de espera
(enfriamientos[x] > 0), avisa y vuelve a preguntar. Solo sale con return cuando
el ataque elegido se puede usar. Devuelve el numero del ataque (1, 2 o 3).
*/
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

/*
aplicarDefensa(): pasivas defensivas del jugador. Recibe el dano del jefe y devuelve
el dano que llega de verdad. Se tira un d100 (porcentaje):
- 1 a 15  (15%): esquivas, no recibes nada.
- 16 a 35 (20%): bloqueas, recibes la mitad.
- 36 a 100 (65%): aguantas, recibes el dano completo.
El else if solo se mira si el primer if ha fallado, por eso la tirada ya es mayor que 15.
*/
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

/*
pausa(): detiene el programa los milisegundos indicados (1000 ms = 1 segundo).
Thread.sleep puede lanzar una InterruptedException, y Java obliga a controlarla
con try/catch. Casi nunca salta, pero tiene que estar tratada.
*/
static void pausa(int milisegundos){
    try {
        Thread.sleep(milisegundos);
    }
    catch(InterruptedException e){
        System.out.println("La pausa se a interrumpido.");
    }
}

/*
main(): punto de entrada del programa. Muestra el menu en bucle hasta que el
usuario elige SALIR. El do-while ejecuta el menu al menos una vez.
1 = jugar (elegir jefe y combatir) | 2 = ver instrucciones | 3 = salir
*/
public static void main(String[] args) {

    int eleccionmenu; 

    //Cogemos la parte que puede ir mal con el try y seguimos
    try{
        do{menu();
            eleccionmenu = leerTeclado("Selecciona una opcion. 1-2-3", 1, 3);

            switch (eleccionmenu) 
            {
                case 1:
                    // elegirJefe() devuelve el jefe y combate() lo recibe como parametro.
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
        //Finally devuelve al final del bucLe que cuando decidimos salir literalmente del juego cerremos el scanner que se queda abierto durante toda la partida
    }finally{teclado.close();}

}}
