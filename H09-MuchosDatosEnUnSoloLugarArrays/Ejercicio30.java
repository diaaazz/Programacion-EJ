import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio30 {

    private static final int FILAS = 4;
    private static final int COLUMNAS = 5;

    public static void main(String[] args) {
        int[][] numeros = new int[FILAS][COLUMNAS];


        Scanner entrada = new Scanner(System.in);

        try {
            inicializar(numeros, entrada);
            mostarSumas(numeros);
        }catch (IndexOutOfBoundsException ioobe) {
            System.out.println("**ERROR: Sobrepasado los indices");
        }catch (InputMismatchException ime) {
            System.out.println("**ERROR: Tipo de dato equivocado introducido");
        }

        entrada.close();
    }

    public static void inicializar(int[][] vector, Scanner entrada) {

        System.out.println("Por favor, introduzca los numeros (enteros) en el array");

        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                System.out.printf("Fila %d, columna %d: ", i, j);
                vector[i][j] = entrada.nextInt();
            }
        }

    }

    public static void mostarSumas(int[][] vector) {
        int suma;
        int sumaTotal = 0;
        for (int i = 0; i < FILAS; i++) {
            suma = 0;
            for (int j = 0; j < COLUMNAS ; j++) {
                System.out.printf("%7d", vector[i][j]);
                suma += vector[i][j];
            }

            System.out.printf(" |%7d\n", suma);
        }
        System.out.println("--------------------------------------------");

        for (int i = 0; i < COLUMNAS ; i++) {
            suma = 0;

            for (int j = 0; j < FILAS; j++) {
                suma += vector[j][i];
            }
            sumaTotal += suma;
            System.out.printf("%7d", suma);
        }
        System.out.printf(" |%7d\n", sumaTotal);

    }

}
