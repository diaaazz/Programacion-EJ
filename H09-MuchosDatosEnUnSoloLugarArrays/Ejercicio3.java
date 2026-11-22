public class Ejercicio3 {
    public static void main(String[] args) {

        int[] num = new int[10];

        inicializar(num);
        mostrar(num);
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
    }
}
