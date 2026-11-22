import java.util.Scanner;

public class Ejercicio11 {
    public static void main(String[] args) {

        int[] numeros = new int[100];
        Scanner entrada = new Scanner(System.in);

        inicializar(numeros);
        mostrar(numeros);
        sustituir(numeros, entrada);

        entrada.close();
    }

    public static void inicializar(int[] vector) {
        for (int i = 0; i < vector.length; i++) {
            vector[i] = (int) (Math.random() * 21);
        }
    }

    public static void mostrar(int[] vector) {
        for (int i = 0; i < vector.length ; i++) {
            System.out.printf("%d ", vector[i]);
        }
        System.out.println();
    }

    public static void sustituir(int[] vector, Scanner entrada) {
        int elegido;
        int sustitucion;

        System.out.print("Elige un numero de los mostrados: ");
        elegido = entrada.nextInt();

        System.out.print("Elige un numero para sustituirlo: ");
        sustitucion = entrada.nextInt();

        for (int i = 0; i < vector.length ; i++) {

            if (vector[i] == elegido) {
                vector[i] = sustitucion;
                System.out.printf("\'%d\' ", vector[i]);
            }else {
                System.out.printf("%d ",vector[i]);
            }

        }
    }

}
