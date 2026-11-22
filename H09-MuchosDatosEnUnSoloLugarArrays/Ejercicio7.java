public class Ejercicio7 {

    public static void main(String[] args) {

        int[] numero = new int[20];
        int[] cuadrado = new int[20];
        int[] cubo = new int[20];

        inicializar(numero, cuadrado, cubo);
        mostrar(numero, cuadrado, cubo);

    }

    public static void inicializar(int[] vector, int[] vectorCuadrado, int[] vectorCubo) {
        for (int i = 0; i < vector.length; i++) {
            vector[i] = (int) (Math.random() * 101);
            vectorCuadrado[i] = vector[i] * vector[i];
            vectorCubo[i] = vectorCuadrado[i] * vector[i];
        }
    }

    public static void mostrar(int[] vector, int[] vectorCuadrado, int[] vectorCubo) {
        System.out.printf("    n    |    n2   |    n3  \n");
        System.out.printf("----------------------------\n");
        for (int i = 0; i < vector.length; i++) {
            System.out.printf("%8d |%8d |%8d\n", vector[i], vectorCuadrado[i], vectorCubo[i]);
        }
    }

}
