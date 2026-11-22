public class Ejercicio10 {
    public static void main(String[] args) {

        int[] numeros = new int[10];

        inicializar(numeros);
        mostrar(numeros);
        System.out.printf("El numero mas grande es %d", max(numeros));
    }

    public static void inicializar(int[] vector) {
        for (int i = 0; i < vector.length; i++) {
            vector[i] = (int) (Math.random() * 100 + 1);
        }
    }

    public static void mostrar(int[] vector) {
        for (int i = 0; i < vector.length ; i++) {
            System.out.printf("%d ", vector[i]);
        }
        System.out.println();
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
