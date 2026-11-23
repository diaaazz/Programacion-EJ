import java.util.Scanner;

public class Ejercicio16 {
    private static final String[] MESES = new String[] {"enero", "febrero", "marzo", "abril", "mayo", "junio", "julio", "agosto", "septiembre", "octubre", "noviembre", "diciembre"};

    public static void main(String[] args) {

        int[] tempMeses = new int[12];
        Scanner entrada = new Scanner(System.in);

        inicializar(tempMeses, entrada);
        System.out.println();
        mostrar(tempMeses);

        entrada.close();
    }

    private static void mostrar(int[] vector) {
        for (int i= 0; i < vector.length; i++){
            System.out.printf("%10s |", MESES[i]);
            for (int copiaTemp = vector[i]; copiaTemp > 0; copiaTemp--){
                System.out.print("\u2584");
            }
            System.out.printf(" %dºC\n", vector[i]);
        }
    }

    private static void inicializar(int[] vector, Scanner entrada){
        for (int i = 0; i < vector.length; i++) {
            System.out.printf("Introduce la temperatura media de %s: ", MESES[i]);
            vector[i] = entrada.nextInt();
        }
    }
}
