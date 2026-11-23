public class Ejercicio36 {
    private static final String[] PAISES = {"España", "Rusia", "Japón", "Australia"};
    private static final int COLUMNAS = 10;

    public static void main(String[] args) {
        int[][] alturas = new int[PAISES.length][COLUMNAS];


        inicializar(alturas);
        mostrar(alturas);
    }

    public static void inicializar(int[][] vector){
        for (int i = 0; i < PAISES.length ; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                vector[i][j] = (int) (Math.random() * 71 + 140);
            }
        }
    }

    public static void mostrar(int[][] vector){
        System.out.printf("%57s%4s%4s\n", "MED", "MIN", "MAX");
        for (int i = 0; i < PAISES.length ; i++) {
            System.out.printf("%10s:", PAISES[i]);
            for (int j = 0; j < COLUMNAS; j++) {
                System.out.printf("%4d", vector[i][j]);
            }
            System.out.printf(" |%4d%4d%4d\n", media(vector, i), min(vector, i), max(vector, i) );

        }
    }

    public static int media(int[][] vector, int fila) {
        int media = 0;
        for (int i = 0; i < COLUMNAS; i++) {
            media += vector[fila][i];
        }
        return media / COLUMNAS;
    }

    public static int min(int[][] vector, int fila) {
        int min = vector[fila][0];
        for (int i = 0; i < COLUMNAS; i++) {
            if (vector[fila][i] < min) {
                min = vector[fila][i];
            }
        }
        return min;
    }

    public static int max(int[][] vector, int fila) {
        int max = vector[fila][0];
        for (int i = 0; i < COLUMNAS; i++) {
            if (vector[fila][i] > max) {
                max = vector[fila][i];
            }
        }
        return max;
    }
}
