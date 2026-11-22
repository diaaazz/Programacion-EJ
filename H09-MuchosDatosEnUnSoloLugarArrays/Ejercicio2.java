public class Ejercicio2 {
    public static void main(String[] args) {
        char[] num = new char[10];

        incializar(num);
        mostrar(num);

    }

    public static void incializar(char[] vector) {
        vector[0] = 'a';
        vector[1] = 'x';
        vector[4] = '@';
        vector[6] = '\'';
        vector[7] = '+';
        vector[8] = 'Q';
    }

    public static void mostrar(char[] vector) {
        for (int i = 0; i < vector.length ; i++) {
            System.out.printf("%c ", vector[i]);
        }
    }

}
