public class Ejercicio28 {

    private static final int FILAS = 3;
    private static final int COLUMNAS = 6;
    public static void main(String[] args) {
        int[][] numeros = new int[FILAS][COLUMNAS];

        inicializar(numeros);
        mostrar(numeros);

    }

    public static void inicializar(int[][] vector) {
        vector[0][0] = 0;
        vector[0][1] = 30;
        vector[0][2] = 2;
        vector[0][5] = 5;

        vector[1][0] = 75;
        vector[1][4] = 0;

        vector[2][2] = -2;
        vector[2][3] = 9;
        vector[2][5] = 11;


    }

    public static void mostrar(int[][] vector){
        System.out.print("         ");
        for (int i = 0; i < COLUMNAS; i++) {
            System.out.printf("%s%d ", "Columna ", i);
        }
        System.out.println();

        for (int i = 0; i < FILAS ; i++) {
            System.out.printf("%s%d", "fila", i);
            for (int j = 0; j < COLUMNAS; j++) {
                System.out.printf("%10d", vector[i][j]);
            }
            System.out.println();
        }
    }
}
