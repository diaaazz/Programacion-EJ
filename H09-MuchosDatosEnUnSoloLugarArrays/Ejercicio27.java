import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio27 {
    private static final int MAXIMO = 4;
    public static void main(String[] args) {
        int[] mesas = new int[10];
        int cantidad;

        Scanner entrada = new Scanner(System.in);

        try {
            inicializar(mesas);

            do {

                mostrar(mesas);
                System.out.println("Cuantos son? (Introduzca -1 para salir del programa): ");
                cantidad = entrada.nextInt();

                gestionar(mesas,cantidad);
            }while (cantidad != -1);
        } catch (InputMismatchException ime) {
            System.out.println("**ERROR: DATO ERRONEO");
        }

        entrada.close();
    }

    public static void inicializar(int[] vector) {
        for (int i = 0; i < vector.length; i++) {
            vector[i] = (int) (Math.random() * (MAXIMO + 1));
        }
    }

    public static void mostrar(int[] vector) {
        System.out.printf("%-10s", "MESA");
        for (int i = 0; i < vector.length; i++) {
            System.out.printf("%5d", i + 1);
        }
        System.out.println();

        System.out.printf("%-10s", "VALORES");
        for (int i = 0; i < vector.length; i++) {
            System.out.printf("%5d", vector[i]);
        }
        System.out.println("\n");
    }

    public static void gestionar(int[] vector,int cantidad) {
        boolean encontrada = false;
        int contador = 0;


        if (cantidad > MAXIMO) {
            System.out.printf("Lo siento, no admitimos grupos de %d, haga grupos de %d como maximo e intente de nuevo\n", cantidad, MAXIMO);
            encontrada = true;
        }

        while (!encontrada && contador < vector.length) {

            if (vector[contador] == 0) {
                vector[contador] += cantidad;
                System.out.printf("Por favor, sientese en la mesa %d\n", contador + 1);
                encontrada = true;
            }

            contador++;
        }

        contador = 0;
        while (!encontrada && contador < vector.length ) {
            if (vector[contador] + cantidad <= MAXIMO) {
                vector[contador] += cantidad;
                System.out.printf("Por favor, sientese en la mesa %d\n", contador + 1);
                encontrada = true;
            }

            contador++;
        }

        if (!encontrada) {
            System.out.println("Lo sentimos, no tenemos espacio suficiente");
        }

    }
}
