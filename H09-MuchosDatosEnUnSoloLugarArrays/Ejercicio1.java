public class Ejercicio1 {
    public static void main(String[] args) {
        int[] num = new int[12];

        incializar(num);
        mostrar(num);

    }

    public static void incializar(int[] vector) {
        vector[0] = 39;
        vector[1] = -2;
        vector[4] = 0;
        vector[6] = 14;
        vector[8] = 5;
        vector[9] = 120;
    }

    public static void mostrar(int[] vector) {
        for (int i = 0; i < vector.length ; i++) {
            System.out.printf("%d ", vector[i]);
        }
    }

}
