package tp5_backtracking;

public class Posicion {
    private int valor;
    private boolean norte;
    private boolean sur;
    private boolean este;
    private boolean oeste;

    public Posicion(int valor, boolean norte, boolean sur, boolean este, boolean oeste) {
        if(valor<0) {
            throw new IllegalArgumentException("El valor debe ser mayor a 0,numero natural");
        }
        this.valor = valor;
        this.norte = norte;
        this.sur = sur;
        this.este = este;
        this.oeste = oeste;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public boolean isNorte() {
        return norte;
    }

    public void setNorte(boolean norte) {
        this.norte = norte;
    }

    public boolean isSur() {
        return sur;
    }

    public void setSur(boolean sur) {
        this.sur = sur;
    }

    public boolean isEste() {
        return este;
    }

    public void setEste(boolean este) {
        this.este = este;
    }

    public boolean isOeste() {
        return oeste;
    }

    public void setOeste(boolean oeste) {
        this.oeste = oeste;
    }

    @Override
    public String toString() {
        return "ValorNatural [valor=" + valor + "]";
    }

    
}
