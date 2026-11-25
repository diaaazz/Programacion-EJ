package Ejercicio44.clases;

public class Parcela {

    private final char ARBOL = 'T';
    private final char MATORRAL = 'm';
    private final char AGUA = 'a';
    private final char CORTAFUEGOS = '~';
    private final char ROCA = '^';

    private final char INTACTA = ' ';
    private final char ARDIENDO = '*';
    private final char CALCINADA = '#';

    private final char[] ESTADOS_POSIBLES = {'*', '#'};

    private char tipo;
    private char estado;
    private int combustible;
    private boolean proximamenteArdiendo;

    public Parcela() {
        this.tipo = seleccionarTipo();
        this.estado = INTACTA;

        if (this.tipo == ARBOL) {
            combustible = 3;
        } else if (this.tipo == MATORRAL) {
            combustible = 1;
        } else {
            combustible = 0;
        }

        proximamenteArdiendo = false;
    }

    private char seleccionarTipo() {
        char tipo;
        double random = Math.random();
        if ( random < 0.55) {
            tipo = ARBOL;
        }else if (random < 0.75) {
            tipo = MATORRAL;
        } else if (random < 0.85) {
            tipo = AGUA;
        } else if (random < 0.95) {
            tipo = CORTAFUEGOS;
        } else {
            tipo = ROCA;
        }

        return tipo;
    }

    public boolean esCombustible() {
        return this.combustible >= 1;
    }

    public boolean estaIntacta() {
        return this.estado == INTACTA;
    }

    public boolean estaArdiendo(){
        return this.estado == ARDIENDO;
    }

    public void prender(){
        if (esCombustible()){
            this.estado = ARDIENDO;
        }
    }

    public void marcaParaArder(){
        this.proximamenteArdiendo = true;
    }

    public void aplicarSiguienteEstado(){
        if ( this.proximamenteArdiendo ) {
            this.estado = ARDIENDO;
            this.proximamenteArdiendo = false;
        }

    }

    public void consumirTurno() {
        if (estaArdiendo()) {
            this.combustible--;

            if (this.combustible == 0) {
                this.estado = CALCINADA;
            }

        }
    }

    public void setTipo(char tipo){
        this.tipo = tipo;
    }

    public void setCombustible(int combustible) {
        this.combustible = combustible;
    }

    @Override
    public String toString() {
        String mostrar;

        if (estaIntacta()){
            mostrar = String.valueOf(tipo);
        }else {
            mostrar = String.valueOf(estado);
        }

        return mostrar;
    }
}
