package PRIMERO.Asignaturas.Programacion.prueba1.programacion.src.ejercicios.primertrimestre;


import java.util.Scanner;

public class calculadoraswitch {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Primer valor para operar");
        int num1 = sc.nextInt();
        

        System.out.println("Segundo valor para operar");
        int num2 = sc.nextInt();
        

        System.out.println("Que operacion quieres hacer:(+, -, /, *,) ");
        char operacion = sc.next().charAt(0);
        
        switch (operacion) {
            case '*':
            System.out.println("Resultado es:" + num1*num2);
                break;
            case '/':
            System.out.println("Resultado es: " + num1/num2);
                break;
            case '+':
            System.out.println("Resultado es: " + num1+num2);
                break;
            case '-':
            System.out.println("Resultado es: " + (num1-num2));
                break;
            default:
            System.out.println("Error elige subnormal");
            
        }
        sc.close();
    }
}