import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio29 {

    private static final int FILAS = 4;
    private static final int COLUMNAS = 5;
    public static void main(String[] args) {
        int[][] numeros = new int[FILAS][COLUMNAS];
        Scanner entrada = new Scanner(System.in);

        try {
            inicializar(numeros);
            mostrar(numeros);
            mostrarPosicion(numeros, entrada);
        }catch (InputMismatchException ime) {
            System.out.println("**ERROR: TIPO DE DATO INCORRECTO");
        }
    }

    public static void inicializar(int[][] vector) {
        for (int i = 0; i < FILAS ; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                vector[i][j] = (int) (Math.random() * 101 + 1);
            }
        }


    }

    public static void mostrar(int[][] vector){
        System.out.print("  ");
        for (int i = 0; i < COLUMNAS; i++) {
            System.out.printf("%5d ",i);
        }
        System.out.println();

        for (int i = 0; i < FILAS ; i++) {
            System.out.printf("%d", i);
            for (int j = 0; j < COLUMNAS; j++) {
                System.out.printf("%6d", vector[i][j]);
            }
            System.out.println();
        }
    }

    public static void mostrarPosicion(int[][] vector, Scanner entrada) {
        int fila = 0;
        int columna = 0;
        int posicion;

        System.out.printf("Introduzca una posicion (1 - %d): ", FILAS * COLUMNAS);
        posicion = entrada.nextInt();


        fila = (posicion - 1) / COLUMNAS;
        columna = (posicion - 1) % COLUMNAS;

        System.out.printf("Fila: %d\n", fila );
        System.out.printf("Columna: %d\n", columna );
        System.out.printf("Valor: %d", vector[fila][columna]);
    }
}
