import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio15 {
    public static void main(String[] args) {

        int[] numeros = new int[500];
        Scanner entrada = new Scanner(System.in);

        try {
            inicializar(numeros);
            mostrar(numeros);
            System.out.println();
            mostrarMinMax(numeros, entrada);
        }catch (InputMismatchException ime) {
            System.out.println("**ERROR: Tipo de dato erroneo");
        }


    }

    public static void inicializar(int[] vector) {
        for (int i = 0; i < vector.length; i++) {
            vector[i] = (int) (Math.random() * 501);
        }
    }

    public static void mostrar(int[] vector) {
        for (int i = 0; i < vector.length ; i++) {
            System.out.printf("%d ", vector[i]);
        }
        System.out.println();
    }

    public static void mostrarMinMax(int[] vector, Scanner entrada) {
        int min = min(vector);
        int max = max(vector);
        int opcion;

        System.out.print("Que quiere destacar? (1 - minimo, 2 - maximo): ");
        opcion = entrada.nextInt();

        switch (opcion) {
            case 1:
                for (int i = 0; i < vector.length; i++) {
                    if (vector[i] == min) {
                        System.out.printf("**%d** ", min);
                    }else {
                        System.out.printf("%d ", vector[i]);
                    }
                }
                break;
            case 2:
                for (int i = 0; i < vector.length; i++) {
                    if (vector[i] == max) {
                        System.out.printf("**%d** ", max);
                    }else {
                        System.out.printf("%d ", vector[i]);
                    }
                }
                break;
            default:
                System.out.println("OPCION INVALIDA");
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
