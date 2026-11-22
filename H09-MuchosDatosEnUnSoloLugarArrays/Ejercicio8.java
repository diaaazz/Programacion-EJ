public class Ejercicio8 {
    public static void main(String[] args) {

        int[] numeros = new int[10];

        inicializar(numeros);
        mostrar(numeros);
        System.out.printf("La media de los numeros es %.2f", media(numeros));
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

    public static float media(int[] vector) {
        float media = 0;
        for (int i = 0; i < vector.length; i++) {
            media += vector[i];
        }

        return media / vector.length;
    }
}
