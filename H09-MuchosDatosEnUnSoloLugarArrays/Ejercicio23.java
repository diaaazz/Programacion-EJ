import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio23 {
    public static void main(String[] args) {
        int[] numeros;
        Scanner entrada = new Scanner(System.in);

        try {
            numeros = inicializar(entrada);
            mostrar(numeros);
            ordenar(numeros);
            mostrar(numeros);
        }catch (InputMismatchException ime) {
            System.out.println("**ERROR: DATO INVALIDO");
        }

        entrada.close();
    }

    public static int[] inicializar(Scanner entrada) {
        int n;
        int[] vector;
        System.out.print("Introduzca el tamanio del array: ");
        n = entrada.nextInt();

        vector = new int[n];
        for (int i = 0; i < vector.length ; i++) {
            vector[i] = (int) (Math.random() * 201);
        }
        return vector;
    }

    public static void mostrar(int[] vector) {
        for (int i = 0; i < vector.length; i++) {
            System.out.printf("%d ", vector[i]);
        }
        System.out.println();
    }

    public static void ordenar(int[] vector) {
        int[] nuevo = new int[vector.length];
        int contador = 0;
        for (int i = 0; i < vector.length ; i++) {
            if (i % 2 == 0) {
                nuevo[contador] = vector[i];
            }else {
                nuevo[(vector.length - 1) - contador] = vector[i];
                contador++;
            }
        }

        for (int i = 0; i < vector.length; i++) {
            vector[i] = nuevo[i];
        }
    }
}
