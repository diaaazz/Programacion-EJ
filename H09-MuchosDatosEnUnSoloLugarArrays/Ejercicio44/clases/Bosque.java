package Ejercicio44.clases;

public class Bosque {

    private Parcela[][] mapa;

    public Bosque(int filas, int columnas) {
        mapa = new Parcela[filas][columnas];
        generarEcosistema();

    }

    public void generarEcosistema() {

        for (int i = 0; i < this.mapa.length; i++) {
            for (int j = 0; j < this.mapa[i].length ; j++) {
                this.mapa[i][j] = new Parcela();
            }
        }


    }

    public boolean iniciarIncendio(int fila, int col) {
        boolean posible = false;
        if (fila < this.mapa.length &&  fila >= 0 && col < this.mapa[fila].length &&  col >= 0 && this.mapa[fila][col].esCombustible()) {
            this.mapa[fila][col].prender();
            posible = true;
        }
        return posible;
    }

    public void avanzarCiclo() {

        int n;
        int s;
        int e;
        int o;

        for (int i = 0; i < this.mapa.length; i++) {
            for (int j = 0; j < this.mapa[i].length ; j++) {

                if (this.mapa[i][j].estaArdiendo()) {
                    n = i-1;
                    s = i+1;
                    e = j+1;
                    o = j-1;

                    if (n >= 0 && this.mapa[n][j].estaIntacta() && this.mapa[n][j].esCombustible()) {
                        this.mapa[n][j].marcaParaArder();
                    }

                    if (s < this.mapa.length && this.mapa[s][j].estaIntacta() && this.mapa[s][j].esCombustible()) {
                        this.mapa[s][j].marcaParaArder();
                    }

                    if (o >= 0 && this.mapa[i][o].estaIntacta() && this.mapa[i][o].esCombustible()) {
                        this.mapa[i][o].marcaParaArder();
                    }

                    if (e < this.mapa[i].length && this.mapa[i][e].estaIntacta() && this.mapa[i][e].esCombustible()) {
                        this.mapa[i][e].marcaParaArder();
                    }


                }

            }



        }

        for (int i = 0; i < this.mapa.length ; i++) {
            for (int j = 0; j < this.mapa[i].length ; j++) {

                if (this.mapa[i][j].estaArdiendo()) {
                    this.mapa[i][j].consumirTurno();
                }

            }
        }

        for (int i = 0; i < this.mapa.length ; i++) {
            for (int j = 0; j < this.mapa[i].length ; j++) {

                if (this.mapa[i][j].estaProximamenteArdiendo()) {
                    this.mapa[i][j].aplicarSiguienteEstado();
                }

            }
        }

    }

    public int contarFocosActivos() {
        int contador = 0;
        for (int i = 0; i < this.mapa.length ; i++) {
            for (int j = 0; j < this.mapa[i].length ; j++) {

                if (this.mapa[i][j].estaArdiendo()) {
                    contador++;
                }

            }
        }

        return contador;

    }

    public void crearCortaFuegos(int fila, int col) {
        if (fila < this.mapa.length &&  fila >= 0 && col < this.mapa[fila].length &&  col >= 0 && this.mapa[fila][col].estaIntacta()) {
            this.mapa[fila][col].setTipo('~');
            this.mapa[fila][col].setCombustible(0);

        }
    }

    public void mostrarMapa() {
        System.out.print("   ");
        for (int i = 0; i < this.mapa[0].length; i++) {
            System.out.printf("%2d", i);
        }

        System.out.println();
        System.out.print("  +");
        for (int i = 0; i < this.mapa[0].length; i++) {
            System.out.print("--");
        }
        System.out.println();

        for (int i = 0; i < this.mapa.length; i++) {

            System.out.printf("%-2d| ", i);
            for (int j = 0; j < this.mapa[i].length ; j++) {
                System.out.printf("%-2s", this.mapa[i][j]);
            }
            System.out.println();

        }
    }

    public void mostrarInformeFinal() {

        float porcentaje;
        int calcinadas = 0;
        int barreras = 0;
        int salvadas = 0;
        int total = this.mapa.length * this.mapa[0].length;

        for (int i = 0; i < this.mapa.length ; i++) {
            for (int j = 0; j < this.mapa[i].length; j++) {

                if (!this.mapa[i][j].estaIntacta()) {
                    calcinadas++;
                }else if ( this.mapa[i][j].esCombustible() ){
                    salvadas++;
                }else {
                    barreras++;
                }




            }
        }

        porcentaje = 100f * calcinadas / total;

        System.out.println("\n=== INFORME FINAL DEL ECOSISTEMA ===");
        //System.out.printf("- Duración total del incendio: %d ciclos \n", );
        System.out.printf("- Superficie calcinada: %d parcelas (%.1f%%)\n", calcinadas, porcentaje);
        System.out.printf("- Bosque intacto: %d parcela combustible salvada\n", salvadas);
        System.out.printf("- Barreras naturales y artificiales (Agua/Cortafuegos/Roca): %d parcelas\n", barreras);
    }

    public Parcela[][] getMapa() {
        return mapa;
    }
}