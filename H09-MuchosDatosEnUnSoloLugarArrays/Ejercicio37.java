import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio37 {

    private static final int FILAS = 6;
    private static final int COLUMNAS = 10;

    public static void main(String[] args) {
        int[][] numeros = new int[FILAS][COLUMNAS];


        Scanner entrada = new Scanner(System.in);

        try {
            inicializar(numeros);
            mostrar(numeros);
            min(numeros);
            max(numeros);
        }catch (IndexOutOfBoundsException ioobe) {
            System.out.println("**ERROR: Sobrepasado los indices");
        }catch (InputMismatchException ime) {
            System.out.println("**ERROR: Tipo de dato equivocado introducido");
        }

        entrada.close();
    }

    public static void inicializar(int[][] vector) {

        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {

                do {
                    vector[i][j] = (int) (Math.random() * 1001);

                } while (hayRepetido(vector, i, j));

            }
        }

    }

    public static boolean hayRepetido(int[][] vector, int fila, int col) {

        boolean repetido = false;
        int limite;
        for (int i = 0; i <= fila ; i++) {

            limite = (i == fila) ? col : COLUMNAS;
            for (int j = 0; j < limite; j++) {
                if (vector[fila][col] == vector[i][j]) {
                    repetido = true;
                }
            }
        }


        return repetido;
    }

    public static void mostrar(int[][] vector) {
        for (int i = 0; i < FILAS ; i++) {
            for (int j = 0; j < COLUMNAS ; j++) {
                System.out.printf("%5d ", vector[i][j]);
            }
            System.out.println();
        }
    }

    public static void min(int[][] vector) {
        int min = vector[0][0];
        int fila = 0;
        int columna = 0;
        for (int i = 0; i < FILAS ; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                if (vector[i][j] < min){
                    min = vector[i][j];
                    fila = i;
                    columna = j;
                }
            }
        }

        System.out.printf("El minimo es %d y esta en la fila %d, columna %d\n", min, fila, columna);
    }

    public static void max(int[][] vector) {
        int max = vector[0][0];
        int fila = 0;
        int columna = 0;
        for (int i = 0; i < FILAS ; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                if (vector[i][j] > max){
                    max = vector[i][j];
                    fila = i;
                    columna = j;
                }
            }
        }

        System.out.printf("El maximo es %d y esta en la fila %d, columna %d\n", max, fila, columna);
    }



}
