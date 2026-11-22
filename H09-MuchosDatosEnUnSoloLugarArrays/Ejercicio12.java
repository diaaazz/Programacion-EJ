import java.util.Scanner;

public class Ejercicio12 {
    public static void main(String[] args) {

        int[] numeros = new int[20];
        Scanner entrada = new Scanner(System.in);

        inicializar(numeros);
        mostrar(numeros);
        resaltar(numeros, entrada);

        entrada.close();
    }

    public static void inicializar(int[] vector) {
        for (int i = 0; i < vector.length; i++) {
            vector[i] = (int) (Math.random() * 401);
        }
    }

    public static void mostrar(int[] vector) {
        for (int i = 0; i < vector.length ; i++) {
            System.out.printf("%d ", vector[i]);
        }
        System.out.println();
    }

    public static void resaltar(int[] vector, Scanner entrada) {
        int elegido;

        System.out.println("Que numeros quieres resaltar?");
        System.out.print("(1 - los multiplos de 5, 2 - los muttiplos de 7): ");
        elegido = entrada.nextInt();

        switch (elegido) {
            case 1:
                for (int i = 0; i < vector.length; i++) {
                    System.out.printf("%s%d%s ", vector[i] % 5 == 0 ? "[" : "", vector[i], vector[i] % 5 == 0 ? "]" : "");
                }
                break;
            case 2:
                for (int i = 0; i < vector.length; i++) {
                    System.out.printf("%s%d%s ", vector[i] % 7 == 0 ? "[" : "", vector[i], vector[i] % 7 == 0 ? "]" : "");
                }
                break;
            default:
                System.out.println("**ERROR: OPCION INVALIDA");
        }

    }

}
