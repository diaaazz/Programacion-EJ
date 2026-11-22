import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Ejercicio38 {

    private static final int FILAS = 8;
    private static final int COLUMNAS = 8;
    private static final char[] COLUMNA_LETRAS = {'A', 'B', 'C','D', 'E', 'F', 'G', 'H'};

    public static void main(String[] args) {
        int[][] tablero = new int[FILAS][COLUMNAS];


        Scanner entrada = new Scanner(System.in);
        try {
            comprobar(entrada);
        }catch (InputMismatchException ime){
            System.out.println("Tipo de dato incorrecto");
        }
    }

    public static void comprobar(Scanner entrada){
        String posicion;
        int fila;
        int columna = 0;

        System.out.print("Introduzca la posicion del alfil, ej e2: ");
        posicion = entrada.nextLine();
        fila = Integer.parseInt( String.valueOf(posicion.charAt(1)) );
        for (int i = 0; i < COLUMNAS; i++) {
            if (posicion.toUpperCase().charAt(0) == COLUMNA_LETRAS[i]){
                columna = i;
            }
        }

        for (int i = FILAS; i > 0 ; i--) {
            for (int j = 0 ; j < COLUMNAS  ; j++) {

                if ( i == fila && j == columna ) {
                    System.out.print("\033[31m\u2588\033[0m  ");
                } else if (Math.abs(fila - i)  == Math.abs(columna - j)) {
                    System.out.print("\u2588  ");
                } else {
                    System.out.print("\u2591  ");
                }

            }
            System.out.println("\n");
        }

    }

}
