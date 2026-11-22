public class Ejercicio17 {
    public static void main(String[] args) {
        int[] numeros = new int[] {15,14,86,3,77,43,75,44,78,234,65,24,21};
        mostrar(numeros);
        rotar(numeros);
        mostrar(numeros);

    }

    public static void rotar(int[] vector) {
        int primero = vector[0];;
        for (int i = 0; i < vector.length - 1; i++) {
            vector[i] = vector[i + 1];
        }
        vector[vector.length - 1] = primero;
    }

    public static void mostrar(int[] vector) {
        for (int i = 0; i < vector.length; i++) {
            System.out.printf("%d ", vector[i]);
        }
        System.out.println();
    }
}
