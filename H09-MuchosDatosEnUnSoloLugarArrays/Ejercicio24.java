import java.util.Scanner;

public class Ejercicio24 {
    public static void main(String[] args) {
        int[] numeros = new int[10];

        Scanner entrada = new Scanner(System.in);

        inicializar(numeros);
        mostrar(numeros);
        cambiar(numeros, entrada);
        mostrar(numeros);

        entrada.close();
    }

    public static void inicializar(int[] vector) {
        for (int i = 0; i < vector.length; i++) {
            vector[i] = (int) (Math.random() * 51);
        }
    }

    public static void mostrar(int[] vector) {
        System.out.printf("%-10s", "INDICES");
        for (int i = 0; i < vector.length; i++) {
            System.out.printf("%5d", i);
        }
        System.out.println();

        System.out.printf("%-10s", "VALORES");
        for (int i = 0; i < vector.length; i++) {
            System.out.printf("%5d", vector[i]);
        }
        System.out.println("\n");
    }

    public static void cambiar(int[] vector, Scanner entrada) {
        int inicial;
        int posFinal;
        boolean valido;
        int seleccionado;

        do {
            System.out.print("Introduzca la posicion inicial: (0-9): ");
            inicial = entrada.nextInt();

            System.out.print("Introduzca la posicion final: (0-9): ");
            posFinal = entrada.nextInt();

            valido = inicial < posFinal;

            if (!valido) {
                System.out.println("Inicial debe ser menor que final\n");
            }
        } while (!valido);

        seleccionado = vector[inicial];
        for (int i = inicial; i > 0  ; i--) {
            vector[i] = vector[i-1];
        }

        vector[0] = vector[vector.length - 1];

        for (int i = vector.length - 1;  i > posFinal ; i--) {
            vector[i] = vector[i-1];
        }

        vector[posFinal] = seleccionado;
    }
}