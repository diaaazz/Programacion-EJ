import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio4 {
    public static void main(String[] args) {

        int[] num = new int[10];
        Scanner entrada = new Scanner(System.in);

        try {
            inicializar(num, entrada);
            mostrar(num);
        }catch (InputMismatchException ime) {
            System.out.println("\033[31m**ERROR: TIPO DE DATO INCORRECTO\033[0m");
        }

        entrada.close();
    }

    public static void inicializar(int[] vector, Scanner entrada) {
        System.out.println("Pulse la tecla intro tras introducir cada numero");
        for (int i = 0; i < vector.length; i++) {
            vector[i] = entrada.nextInt();
        }
    }

    public static void mostrar(int[] vector) {
        for (int i = 0; i < vector.length ; i++) {
            System.out.printf("%d ", vector[i]);
        }
    }
}
