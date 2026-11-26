import java.util.Scanner;

public class Candado {
    private static final int N = 4;
    private static final int INTENTOS = 10;

    public static void main(String[] args) {
        int[][] panel = new int[N][N];
        Scanner entrada = new Scanner(System.in);
        int intentos = 0;

        int fila;
        int col;

        System.out.println("=== CANDADO MATRICIAL ===");
        System.out.printf("Tu objetivo es dejar todas las celdas en 0 antes de agotar los %d intentos.", INTENTOS);

        inicializar(panel);
        establecerEstadoInicial(panel);

        do {
            mostrarPanel(panel);

            System.out.printf("Intentos: %d/%d\n", intentos, INTENTOS);

            System.out.print("Fila: ");
            fila = entrada.nextInt();

            System.out.print("Columna: ");
            col = entrada.nextInt();

            System.out.printf("--> Pulsando nodo [%d, %d]\n", fila, col);
            pulsarCelda(fila, col, panel);

            intentos++;

        } while (intentos < INTENTOS && !estaDesbloqueado(panel));


    }

    public static void inicializar(int[][] vector) {
        for (int i = 0; i < N ; i++) {
            for (int j = 0; j < N ; j++) {
                vector[i][j] = 0;
            }
        }
    }

    public static void establecerEstadoInicial(int[][] vector) {
        int fila;
        int columna;
        for (int i = 0; i < N ; i++) {
            fila = (int) (Math.random() * N);
            columna = (int) (Math.random() * N);
            pulsarCelda(fila, columna, vector);
        }
    }

    public static void mostrarPanel(int[][] vector) {
        System.out.print("   ");
        for (int i = 0; i < N ; i++) {
            System.out.printf("%2d", i);
        }
        System.out.print("\n  +");

        for (int i = 0; i < N ; i++) {
            System.out.print("--");
        }
        System.out.println();



        for (int i = 0; i < N; i++) {
            System.out.printf("%d |", i);
            for (int j = 0; j < N; j++) {
                System.out.printf("%2d", vector[i][j]);
            }
            System.out.println("");
        }
        System.out.println();
    }

    public static void pulsarCelda(int fila, int columna, int[][] vector) {

        int valorInicial = vector[fila][columna];

        //cambiar fila
        for (int i = 0; i < N; i++) {
            vector[fila][i] = vector[fila][i] == 2 ? 0 : vector[fila][i] + 1;
        }

        //cambiar columna
        for (int i = 0; i < N; i++) {
            vector[i][columna] = vector[i][columna] == 2 ? 0 : vector[i][columna] + 1;
        }

        vector[fila][columna] = valorInicial == 2 ? 0 : valorInicial + 1;
    }

    public static boolean estaDesbloqueado(int[][] vector) {
        boolean desbloqueado = true;

        int fil = 0;

        while (desbloqueado && fil < N){

            for (int col = 0; col <N ; col++) {
                if (vector[fil][col] != 0) {
                    desbloqueado = false;
                }
            }

            fil++;
        }



        return desbloqueado;
    }



}
