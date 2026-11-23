import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio34 {

    private static final int FILAS = 10;
    private static final int COLUMNAS = 10;

    public static void main(String[] args) {
        int[][] numeros = new int[FILAS][COLUMNAS];

        try {
            inicializar(numeros);
            mostrar(numeros);
            mostrarDiagonal(numeros);
        }catch (IndexOutOfBoundsException ioobe) {
            System.out.println("**ERROR: Sobrepasado los indices");
        }catch (InputMismatchException ime) {
            System.out.println("**ERROR: Tipo de dato equivocado introducido");
        }

    }

    public static void inicializar(int[][] vector) {

        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                vector[i][j] = (int) (Math.random() * 1001);
            }
        }

    }

    public static void mostrar(int[][] vector) {
        for (int i = 0; i < FILAS ; i++) {
            for (int j = 0; j < COLUMNAS ; j++) {
                System.out.printf("%5d ", vector[i][j]);
            }
            System.out.println();
        }
    }

    public static void mostrar(int[] vector) {
        for (int i = 0; i < vector.length; i++) {
            System.out.printf("%d ", vector[i]);
        }
        System.out.println();
    }

    public static void mostrarDiagonal(int[][] vector) {
        int contador = 0;
        int[] diagonal = new int[FILAS];
        for (int i = 0; i < diagonal.length; i++) {
            diagonal[contador] = vector[contador][contador];
            contador++;
        }
        mostrar(diagonal);
        min(diagonal);
        max(diagonal);
        media(diagonal);
    }

    public static void min(int[] vector) {
        int min = vector[0];

        for (int i = 0; i < vector.length ; i++) {
                if (vector[i]< min){
                    min = vector[i];

                }

        }

        System.out.printf("Minimo: %d\n", min);
    }

    public static void max(int[] vector) {
        int max = vector[0];

        for (int i = 0; i < vector.length ; i++) {
            if (vector[i] > max){
                max = vector[i];

            }

        }

        System.out.printf("Maximo: %d\n", max);
    }

    public static void media(int[] vector) {
        float media = 0;
        for (int i = 0; i < vector.length; i++) {
            media += vector[i];
        }

        System.out.printf("Media: %.2f", media / vector.length);;
    }

}
