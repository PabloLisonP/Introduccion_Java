import java.util.Random;
import java.util.Scanner;

public class pruebajuego {

static final Scanner teclado = new Scanner(System.in);
static final Random aleatorio = new Random();
static final int VIDA_JUGADOR = 100;
static final int PAUSA_MS = 5000;
static final String[] NOMBRES_ATAQUES = {"Ataque normal", "Ataque fuerte", "Ultimate"};

static class Jefe {
String nombre;
int vida;
String[] ataques;
int cantidadDados;
int carasDado;
int bono;

Jefe(String nombre, int vida, String[] ataques, int cantidadDados, int carasDado, int bono) {
this.nombre = nombre;
this.vida = vida;
this.ataques = ataques;
this.cantidadDados = cantidadDados;
this.carasDado = carasDado;
this.bono = bono;
}
}

public static void main(String[] args) {
int opcion;
do {
menu();
opcion = leerTeclado("Elige una opcion. 1-2-3", 1, 3);
switch (opcion) {
case 1:
jugarCombate(elegirJefe());
break;
case 2:
instrucciones();
break;
case 3:
System.out.println("Hasta la proxima!");
break;
}
} while (opcion != 3);
}

static void menu() {
System.out.println("""

=== IRON DAYS ===
1. START
2. INSTRUCCIONES
3. SALIR
""");
}

static void instrucciones() {
System.out.println("""

=== INSTRUCCIONES ===
Tienes 100 de vida. Gana quien deje al otro a 0.
Ataques disponibles:
1. Ataque normal: 1d8+4 de daño. Siempre disponible.
2. Ataque fuerte: 2d8+6 de daño. Solo cada 2 turnos.
3. Ultimate: 3d8+10 de daño. Solo cada 3 turnos.
Si sacas un 20 en el d20 de crítico, el daño se dobla.
Cuando el jefe ataca puedes reaccionar:
1. Esquivar: con 13 o mas en el d20 no recibes nada.
2. Bloquear: con 7 o mas en el d20 recibes la mitad.
3. Aguantar: recibes el daño completo.
""");
}

static Jefe elegirJefe() {
System.out.println("""

1. Goblin Rey (100 de vida)
2. Orco Bestial (130 de vida)
3. Dragon Ancestral (160 de vida)
""");
int eleccion = leerTeclado("Selecciona un boss. 1-2-3", 1, 3);
switch (eleccion) {
case 1:
return new Jefe("Goblin Rey", 100, new String[]{"Punalada", "Golpe sucio", "Lanzamiento de piedra"}, 1, 6, 4);
case 2:
return new Jefe("Orco Bestial", 130, new String[]{"Hachazo", "Embestida", "Rugido de guerra"}, 2, 6, 2);
default:
return new Jefe("Dragon Ancestral", 160, new String[]{"Mordisco", "Cola de fuego", "Aliento de llamas"}, 2, 8, 2);
}
}

static void jugarCombate(Jefe jefe) {
int vidaJugador = VIDA_JUGADOR;
int turno = 1;
int[] enfriamientos = {1, 2};

System.out.println("Te enfrentas a " + jefe.nombre + "!");

while (vidaJugador > 0 && jefe.vida > 0) {
System.out.println("\n--- TURNO " + turno + " ---");
System.out.println("Tu vida: " + vidaJugador + " | " + jefe.nombre + ": " + jefe.vida);

turnoJugador(jefe, enfriamientos);

if (jefe.vida > 0) {
pausa(PAUSA_MS);
vidaJugador = Math.max(0, vidaJugador - turnoJefe(jefe));
for (int i = 0; i < enfriamientos.length; i++) {
if (enfriamientos[i] > 0) {
enfriamientos[i]--;
}
}
turno++;
}
}

if (vidaJugador > 0) {
System.out.println("\nHAS DERROTADO A " + jefe.nombre.toUpperCase() + "! VICTORIA");
} else {
System.out.println("\nHas caido en combate... GAME OVER");
}
}

static void turnoJugador(Jefe jefe, int[] enfriamientos) {
int accion = pedirAtaque(enfriamientos);
int danio;

switch (accion) {
case 1:
danio = tirarDados(1, 8) + 4;
break;
case 2:
danio = tirarDados(2, 8) + 6;
enfriamientos[0] = 2;
break;
default:
danio = tirarDados(3, 8) + 10;
enfriamientos[1] = 3;
break;
}

if (tirarDado(20) == 20) {
danio = danio * 2;
System.out.println("CRITICO! Has sacado un 20");
}

jefe.vida = Math.max(0, jefe.vida - danio);
System.out.println(NOMBRES_ATAQUES[accion - 1] + " ha realizado " + danio + " de daño");
}

static int pedirAtaque(int[] enfriamientos) {
while (true) {
System.out.println("\nTu turno:");
System.out.println("1. Ataque normal");
if (enfriamientos[0] == 0) {
System.out.println("2. Ataque fuerte (listo)");
} else {
System.out.println("2. Ataque fuerte (disponible en " + enfriamientos[0] + " turno/s)");
}
if (enfriamientos[1] == 0) {
System.out.println("3. Ultimate (listo)");
} else {
System.out.println("3. Ultimate (disponible en " + enfriamientos[1] + " turno/s)");
}

int opcion = leerTeclado("Elige tu ataque. 1-2-3", 1, 3);

if (opcion == 2 && enfriamientos[0] > 0) {
System.out.println("El ataque fuerte aun no esta listo.");
} else if (opcion == 3 && enfriamientos[1] > 0) {
System.out.println("La ultimate aun no esta lista.");
} else {
return opcion;
}
}
}

static int turnoJefe(Jefe jefe) {
String ataque = jefe.ataques[aleatorio.nextInt(jefe.ataques.length)];
int danio = tirarDados(jefe.cantidadDados, jefe.carasDado) + jefe.bono;

System.out.println("\n" + jefe.nombre + " prepara " + ataque + "...");
System.out.println("1. Esquivar  2. Bloquear  3. Aguantar");
int reaccion = leerTeclado("Como reaccionas? 1-2-3", 1, 3);
int tirada;

switch (reaccion) {
case 1:
tirada = tirarDado(20);
System.out.println("Dado de esquivar: " + tirada);
if (tirada >= 13) {
danio = 0;
System.out.println("Esquivas el ataque!");
} else {
System.out.println("Fallas la esquiva.");
}
break;
case 2:
tirada = tirarDado(20);
System.out.println("Dado de bloqueo: " + tirada);
if (tirada >= 7) {
danio = danio / 2;
System.out.println("Bloqueas parte del golpe!");
} else {
System.out.println("Fallas el bloqueo.");
}
break;
default:
System.out.println("Aguantas el golpe.");
break;
}

System.out.println(jefe.nombre + " usa " + ataque + " e hizo " + danio + " de daño");
return danio;
}

static int tirarDado(int caras) {
return aleatorio.nextInt(caras) + 1;
}

static int tirarDados(int cantidad, int caras) {
int total = 0;
for (int i = 0; i < cantidad; i++) {
total += tirarDado(caras);
}
return total;
}

static void pausa(int milisegundos) {
try {
Thread.sleep(milisegundos);
} catch (InterruptedException e) {
Thread.currentThread().interrupt();
}
}

static int leerTeclado(String mensaje, int minimo, int maximo) {
while (true) {
System.out.println(mensaje);
try {
int numero = Integer.parseInt(teclado.nextLine());
if (numero >= minimo && numero <= maximo) {
return numero;
}
System.out.println("Introduce un numero valido entre " + minimo + " y " + maximo + ".");
} catch (NumberFormatException e) {
System.out.println("!ERROR!");
System.out.println("INTRODUCE UN NUMERO ENTERO PARA SELECCIONAR UNA OPCION");
}
}
}
}