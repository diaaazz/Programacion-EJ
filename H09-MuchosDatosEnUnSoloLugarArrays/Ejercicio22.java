import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio22 {

    private static final String[] COLORES = {"verde", "rojo", "azul", "amarillo", "naranja", "rosa", "negro", "blanco"};
    public static void main(String[] args) {
        String[] palabras = new String[8];
        Scanner entrada = new Scanner(System.in);

        try {
            inicializar(palabras, entrada);
            ordenar(palabras);
            mostrar(palabras);
        } catch (InputMismatchException ime) {
            System.out.println("**ERROR: DATO INVALIDO");
        }

        entrada.close();
    }

    public static void inicializar(String[] vector, Scanner entrada) {
        System.out.println("Introduzca 8 palabras, vaya pulsando intro entre una y otra: ");
        for (int i = 0; i < vector.length ; i++) {
            vector[i] = entrada.next();
        }
    }

    public static void mostrar(String[] vector) {
        for (int i = 0; i < vector.length; i++) {
            System.out.printf("%s ", vector[i]);
        }
        System.out.println();
    }

    public static void ordenar(String[] vector) {
        String[] nuevo = new String[vector.length];
        int contador = 0;

        for (int i = 0; i < vector.length; i++) {
            if (esColor(vector[i])){
                nuevo[contador] = vector[i];
                contador++;
            }
        }

        for (int i = 0; i < vector.length; i++) {
            if (!esColor(vector[i])){
                nuevo[contador] = vector[i];
                contador++;
            }
        }


        // copio los valores
        for (int i = 0; i < vector.length; i++) {
            vector[i] = nuevo[i];
        }
    }

    public static boolean esColor(String cadena) {
        boolean color = false;
        int contador = 0;

        while (!color &&  contador < COLORES.length) {
            color = cadena.equals(COLORES[contador]);
            contador++;
        }

        return color;
    }

}
