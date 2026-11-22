import java.util.Scanner;

public class Ejercicio26 {
    public static void main(String[] args) {
        int[] numeros = new int[10];

        Scanner entrada = new Scanner(System.in);

        inicializar(numeros);
        mostrar(numeros);
        System.out.println("ORDENADOS");
        ordenar(numeros);

        entrada.close();
    }

    public static void inicializar(int[] vector) {
        for (int i = 0; i < vector.length; i++) {
            vector[i] = (int) (Math.random() * 201);
        }
    }

    public static void mostrar(int[] vector) {
        System.out.printf("%-10s", "INDICES");
        for (int i = 0; i < vector.length; i++) {
            System.out.printf("%5d", i);
        }
        System.out.println();

        System.out.printf("%-10s", "VALORES");
        for (int i = 0; i < vector.length; i++) {
            System.out.printf("%5d", vector[i]);
        }
        System.out.println();
    }

    public static void ordenar(int[] vector) {
        int[] resultado = new int[vector.length];
        int menor = 0;   // posición desde la que busco el siguiente <= 100
        int mayor = 0;   // posición desde la que busco el siguiente > 100
        boolean tocaMenor = true;
        boolean hayMenor;
        boolean hayMayor;

        for (int i = 0; i < vector.length; i++) {

            while (menor < vector.length && vector[menor] > 100){
                menor++;
            }

            while (mayor < vector.length && vector[mayor] <= 100){
                mayor++;
            }

            hayMenor = menor < vector.length;
            hayMayor = mayor < vector.length;

            if ((tocaMenor && hayMenor) || !hayMayor) {
                resultado[i] = vector[menor++];
                tocaMenor = false;
            }else {
                resultado[i] = vector[mayor++];
                tocaMenor = true;
            }

        }

        mostrar(resultado);


    }

}