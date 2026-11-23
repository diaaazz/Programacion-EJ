public class Ejercicio20 {
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
            if (esPrimo(vector[i])){
                nuevo[contador] = vector[i];
                contador++;
            }
        }

        for (int i = 0; i < vector.length; i++) {
            if (!esPrimo(vector[i])){
                nuevo[contador] = vector[i];
                contador++;
            }
        }


        // copio los valores
        for (int i = 0; i < vector.length; i++) {
            vector[i] = nuevo[i];
        }
    }

    public static boolean esPrimo(int numero) {
        boolean primo = true;
//
//        if (numero <= 1) {
//            primo = false;
//        }
//
//        if (numero % 2 == 0 && numero != 2) {
//            primo = false;
//        }
//
//        for (int i = 3; i < numero; i+= 2) {
//            if (numero % i == 0) {
//                primo = false;
//            }
//        }

        int i = 2;
        int mitad = numero / 2 + 1;

        while ((i < mitad) && (primo)){
            if (numero % i == 0) {
                primo = false;
            }
            i++;
        }


        return primo;
    }

}
