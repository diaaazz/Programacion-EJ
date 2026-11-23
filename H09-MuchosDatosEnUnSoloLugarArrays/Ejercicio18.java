import java.util.Scanner;

public class Ejercicio18 {
    public static void main(String[] args) {
        int[] numeros = new int[12];
        Scanner entrada = new Scanner(System.in);

        inicializar(numeros);
        mostrar(numeros);
        cambiar(numeros, entrada);
        mostrar(numeros);

        entrada.close();
    }

    public static void mostrar(int[] vector){
        System.out.printf("%-10s","Indice ");
        for (int i = 0; i < vector.length; i++){
            System.out.printf("%5d", i);
        }

        System.out.println();

        System.out.printf("%-10s","Valor ");
        for (int i = 0; i < vector.length; i++){
            System.out.printf("%5d", vector[i]);
        }

        System.out.println();
        System.out.println();
    }

    public static void inicializar(int[] vector){
        for (int i = 0; i < vector.length; i++) {
            vector[i] = (int) (Math.random() * 201);
        }
    }

    public static void cambiar(int[] vector, Scanner entrada){
        int sustitucion;
        int elegido;

        System.out.print("Introduzca el numero que quiere insertar: ");
        sustitucion = entrada.nextInt();

        System.out.print("Introduzca el indice donde lo quiere insertar (0-11): ");
        elegido = entrada.nextInt();

        for (int j = vector.length - 1; j > elegido ; j--) {
            vector[j] = vector[j-1];
        }

        vector[elegido] = sustitucion;

    }

}
