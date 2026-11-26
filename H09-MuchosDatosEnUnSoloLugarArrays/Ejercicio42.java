import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio42 {

    private static final int ALMACENES = 4;
    private static final int PRODUCTOS = 5;

    public static void main(String[] args) {
        int[][] empresa = new int[ALMACENES][PRODUCTOS];
        int opcion;

        Scanner entrada = new Scanner(System.in);


        try {
            inicializar(empresa);
            do {

                System.out.println("=== GESTIÓN DE INVENTARIO ===");
                System.out.println("1. Mostrar inventario completo");
                System.out.println("2. Consultar stock de un almacen");
                System.out.println("3. Consultar stock de un producto");
                System.out.println("4. Alertas de stock bajo (< 5 uds)");
                System.out.println("5. Estadisticas generales");
                System.out.println("6. Traspaso entre almacenes");
                System.out.println("0. Salir");
                System.out.print("Elegir una opcion: ");
                opcion = entrada.nextInt();

                switch (opcion) {
                    case 0 -> {
                        break;
                    }
                    case 1 -> mostrarInventario(empresa);
                    case 2 -> consultarStockAlmacen(empresa, entrada);
                    case 3 -> consultarStockProducto(empresa, entrada);
                    case 4 -> alertasBajoStock(empresa);
                    case 5 -> estadisticasGenerales(empresa);
                    case 6 -> traspasoEntreAlmacenes(empresa, entrada);
                    default -> System.out.println("Esa opcion no es valida.");



                }

            }while (opcion != 0);
            System.out.println("Saliendo del programa...");

        }catch (InputMismatchException ime) {
            System.out.println("**ERROR: TIPO DATO INCORRECTO");
        }

        entrada.close();

    }

    private static void inicializar(int[][] vector) {
        for (int i = 0; i < ALMACENES ; i++) {
            for (int j = 0; j < PRODUCTOS ; j++) {
                vector[i][j] = (int) (Math.random() * 51);
            }
        }
    }

    private static void mostrarInventario(int[][] vector) {
        System.out.print("        ");
        for (int i = 0; i < PRODUCTOS ; i++) {
            System.out.printf("P%-4d", i);
        }
        System.out.println();

        System.out.print("      +-");
        for (int i = 0; i <= PRODUCTOS ; i++) {
            System.out.print("----");
        }
        System.out.println();

        for (int i = 0; i < ALMACENES ; i++) {
            System.out.printf("Alm %-2d|", i);
            for (int j = 0; j < PRODUCTOS ; j++) {
                System.out.printf("%3d  ", vector[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }


    private static void consultarStockAlmacen(int[][] vector, Scanner entrada) {
        int alm;
        int total = 0;
        System.out.printf("Introduce el numero de almacen (0-%d): ", ALMACENES - 1);
        alm = entrada.nextInt();

        System.out.printf("--> Almacen %d : ", alm);
        for (int i = 0; i < PRODUCTOS ; i++) {
            System.out.printf("P%d (%d) %s ", i, vector[alm][i], (i == (PRODUCTOS - 1)) ? "" : "|");
            total += vector[alm][i];
        }
        System.out.printf("\n--> Total almacenado: %d", total);


        System.out.println();
    }

    private static void consultarStockProducto(int[][] vector, Scanner entrada) {
        int pro;
        int total = 0;
        System.out.printf("Introduce el codigo de producto (0-%d): ", PRODUCTOS - 1);
        pro = entrada.nextInt();

        System.out.printf("--> Producto %d : ", pro);
        for (int i = 0; i < ALMACENES ; i++) {
            System.out.printf("Alm %d (%d) %s ", i, vector[i][pro], (i == (ALMACENES - 1)) ? "" : "|");
            total += vector[i][pro];
        }
        System.out.printf("\n--> Total almacenado: %d", total);


        System.out.println();
    }

    private static void alertasBajoStock(int[][] vector) {
        for (int i = 0; i < ALMACENES ; i++) {
            for (int j = 0; j < PRODUCTOS ; j++) {

                if (vector[i][j] < 5) {
                    System.out.printf("[ALERTA] Alm %d - Producto %d: %d uds. %s\n", i, j, vector[i][j], vector[i][j] == 0 ? "(AGOTADO)" : "");
                }

            }
        }


    }

    private static void estadisticasGenerales(int[][] vector) {
        int saturado = 0;
        int sumaMaxAlm = 0;
        int sumaAct;

        int abundante = 0;
        int sumaMaxPro = 0;

        float media = 0;

        for (int i = 0; i < ALMACENES ; i++) {
           sumaAct = 0;
            for (int j = 0; j < PRODUCTOS ; j++) {
                sumaAct += vector[i][j];
            }

            sumaMaxAlm = sumaAct > sumaMaxAlm ? sumaAct : sumaMaxAlm;
            saturado = sumaAct == sumaMaxAlm ? i : saturado;
        }

        for (int i = 0; i < PRODUCTOS ; i++) {
            sumaAct = 0;
            for (int j = 0; j < ALMACENES ; j++) {
                sumaAct += vector[j][i];
            }

            sumaMaxPro = sumaAct > sumaMaxPro ? sumaAct : sumaMaxPro;
            abundante = sumaAct == sumaMaxPro ? i : abundante;
        }

        for (int i = 0; i < ALMACENES ; i++) {
            for (int j = 0; j < PRODUCTOS ; j++) {

                media += vector[i][j];

            }
        }


        System.out.println("=== ESTADISTICAS DE RED ===");
        System.out.printf("- Almacen más saturado: Almacen %d (%d uds)\n", saturado, sumaMaxAlm);
        System.out.printf("- Producto mas abundante: Producto %d (%d uds)\n", abundante, sumaMaxPro);
        System.out.printf("- Media de stock por celda: %.1f unidades\n", media / (ALMACENES * PRODUCTOS) );
        System.out.printf("- Ocupación global de almacenes: %.1f%%\n", (100 * media) / ((ALMACENES * PRODUCTOS) * 50) );


    }

    private static void traspasoEntreAlmacenes(int[][] vector, Scanner entrada) {
        int producto;
        int origen;
        int destino;
        int cantidad;

        System.out.printf("Producto (0-%d): ", PRODUCTOS - 1);
        producto = entrada.nextInt();

        System.out.printf("Almacen origen (0-%d): ", ALMACENES - 1);
        origen = entrada.nextInt();

        System.out.printf("Almacen destino (0-%d): ", ALMACENES - 1);
        destino = entrada.nextInt();

        System.out.print("Cantidad a mover: ");
        cantidad = entrada.nextInt();

        if ((origen > 0) && (origen < ALMACENES) && (destino > 0) && (destino < ALMACENES) && (cantidad < vector[origen][producto])) {

            vector[origen][producto] -= cantidad;
            vector[destino][producto] += cantidad;

        }else {
            System.out.println("No se pudo realizar el traspaso.");
        }
    }

}
