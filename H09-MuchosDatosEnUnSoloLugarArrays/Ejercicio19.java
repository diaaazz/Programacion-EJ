public class Ejercicio19 {
    public static void main(String[] args) {
        int[] numeros = new int[20];

        inicializar(numeros);
        mostrar(numeros);
        ordenar(numeros);
        mostrar(numeros);
    }

    public static void inicializar(int[] vector) {
        for (int i = 0; i < vector.length; i++) {
            vector[i] = (int) (Math.random() * 101);
        }
    }

    public static void mostrar(int[] vector) {
        for (int i = 0; i < vector.length; i++) {
            System.out.printf("%d ", vector[i]);
        }
        System.out.println();
    }

    public static void ordenar(int[] vector) {
        int[] nuevo = new int[vector.length];
        int contador = 0;
        for (int i = 0; i < vector.length; i++) {
            if (vector[i] % 2 ==0){
                nuevo[contador] = vector[i];
                contador++;
            }
        }

        for (int i = 0; i < vector.length; i++) {
            if (vector[i] % 2 !=0){
                nuevo[contador] = vector[i];
                contador++;
            }
        }


        // copio los valores
        for (int i = 0; i < vector.length; i++) {
            vector[i] = nuevo[i];
        }
    }

}
