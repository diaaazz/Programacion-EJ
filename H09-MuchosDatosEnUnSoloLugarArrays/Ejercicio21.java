import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Ejercicio21 {
    public static void main(String[] args) {
        String[] reyes;
        Scanner entrada = new Scanner(System.in);

        try {
            reyes = inicializar(entrada);
            mostrar(reyes);
        } catch (InputMismatchException ime) {
            System.out.println("Tipo de dato incorrecto");
        }

        entrada.close();
    }

    public static String[] inicializar(Scanner entrada) {
        int n;
        String[] vector;
        System.out.print("Numero de reyes: ");
        n = entrada.nextInt();

        vector = new String[n];

        System.out.println("Vaya introduciendo nombre de reyes y pulsando INTRO.");
        for (int i = 0; i < vector.length; i++) {
            vector[i] = entrada.next();
        }

        return vector;
    }

    public static void mostrar(String[] vector) {
        int contador;
        for (int i = 0; i < vector.length; i++) {
            contador = 1;
            for (int j = 0; j < i; j++) {
                if (vector[i].toUpperCase().equals(vector[j].toUpperCase())) {
                    contador++;
                }
            }
            System.out.printf("%s %do\n", vector[i], contador);

        }
    }
}
