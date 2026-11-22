import java.util.Scanner;

public class Ejercicio13 {
    public static void main(String[] args) {

        int[] numeros = new int[15];
        Scanner entrada = new Scanner(System.in);

        inicializar(numeros);
        mostrar(numeros);
        redondear(numeros);
        mostrar(numeros);
        entrada.close();
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

    public static void redondear(int[] vector) {
        for (int i = 0; i < vector.length ; i++) {
            while (vector[i] % 5 != 0) {
                vector[i]++;
            }
        }
    }

}
