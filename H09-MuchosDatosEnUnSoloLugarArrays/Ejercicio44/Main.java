package Ejercicio44;

import Ejercicio44.clases.Bosque;
import Ejercicio44.clases.Parcela;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int n;
        int fila;
        int col;
        int contador = 1;
        Bosque bosque;
        boolean valido = false;
        Scanner entrada = new Scanner(System.in);


        try {

            do {

                System.out.print("Introduce el tamano del bosque cuadrado (4-20): ");
                n = entrada.nextInt();

                valido = (n >= 4 && n <= 20);

            }while (!valido);

            bosque = new Bosque(n,n);

            System.out.println("=== INICIO DE LA SIMULACION ===");

            bosque.mostrarMapa();

            valido = false;
            do {
                System.out.printf("Introduce la fila de impacto del rayo (0-%d): ", bosque.getMapa().length - 1);
                fila = entrada.nextInt();

                System.out.printf("Introduce la columna de impacto del rayo (0-%d): ", bosque.getMapa().length - 1);
                col = entrada.nextInt();

                if ( fila < 0 || fila > bosque.getMapa().length - 1)  {
                    System.out.println("Tamano de fila no valido");
                } else if (col < 0 || col > bosque.getMapa()[0].length - 1) {
                    System.out.println("Tamano de columna no valido");
                } else if (!bosque.getMapa()[fila][col].esCombustible()) {
                    System.out.printf("Esa parcela no es combustible (%s)\n", bosque.getMapa()[fila][col].getTipo());
                } else {
                    valido = true;
                }

            }while (!valido);

            bosque.iniciarIncendio(fila,col);

            while (bosque.contarFocosActivos() > 0) {
                System.out.printf("=== CICLO %d (Focos activos: %d) ===\n", contador, bosque.contarFocosActivos());
                bosque.mostrarMapa();
                System.out.printf("Pulsa ENTER para avanzar ciclo...");
                System.console().readLine();
                bosque.avanzarCiclo();

                contador++;
            }

            System.out.printf("=== CICLO %d (Focos activos: %d - INCENDIO EXTINGUIDO) ===\n", contador, bosque.contarFocosActivos());
            bosque.mostrarMapa();


            bosque.mostrarInformeFinal();

        }catch (InputMismatchException ime) {
            System.out.println("Debe ser un tipo valido");
        }


        entrada.close();

    }
}
