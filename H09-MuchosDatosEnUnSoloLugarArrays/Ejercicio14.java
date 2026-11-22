import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio14 {
    public static void main(String[] args) {

        int[] numeros = new int[10];
        Scanner entrada = new Scanner(System.in);

        try {
            inicializar(numeros, entrada);
            System.out.println();
            mostrar(numeros);
        }catch (InputMismatchException ime) {
            System.out.println("**ERROR: Tipo de dato incorrecto");
        }

    }

    public static void inicializar(int[] vector, Scanner entrada) {
        System.out.println("Introduce numeros enteros y pulse intro: ");
        for (int i = 0; i < vector.length; i++) {
            vector[i] = entrada.nextInt();
        }
    }

    public static void mostrar(int[] vector) {
        int min = min(vector);
        int max = max(vector);

        for (int i = 0; i < vector.length ; i++) {
            System.out.printf("%d ", vector[i]);
            if (vector[i] == min) {
                System.out.print("minimo");
            }

            if (vector[i] == max) {
                System.out.print("maximo");
            }

            System.out.println();
        }
        System.out.println();
    }

    public static int min(int[] vector) {
        int min = vector[0];
        for (int i = 1; i < vector.length; i++) {
            if (vector[i] < min) {
                min = vector[i];
            }
        }

        return min;
    }

    public static int max(int[] vector) {
        int max = vector[0];
        for (int i = 1; i < vector.length; i++) {
            if (vector[i] > max) {
                max = vector[i];
            }
        }

        return max;
    }

}
