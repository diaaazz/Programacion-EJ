import java.util.Scanner;

public class Ejercicio25 {
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
            vector[i] = (int) (Math.random() * 101);
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
        System.out.println();
    }

    public static void cambiar(int[] vector, Scanner entrada) {
        boolean esta = false;
        int num;
        int indice = 0;

        // pide número hasta que exista dentro del array
        while (!esta) {
            System.out.print("Introduzca uno de los números del array: ");
            num = entrada.nextInt();

            for (int i = 0; i < vector.length && !esta; i++) {
                if (vector[i] == num) {
                    indice = i;
                    esta = true;
                }
            }

            if (!esta) {
                System.out.println("Ese número no se encuentra en el array.");
            }
        }

        // rotar a la izquierda 'indice' veces
        for (int i = 0; i < indice; i++) {
            int primero = vector[0];
            for (int j = 0; j < vector.length - 1; j++) {
                vector[j] = vector[j+1];
            }
            vector[vector.length-1] = primero;
        }
    }
}