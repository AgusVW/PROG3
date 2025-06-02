package tp6_greedy;

public class Actividad implements Comparable<Actividad>{
    private int ini;
    private int fin;

    public Actividad(int ini, int fin) {
        this.ini = ini;
        this.fin = fin;;
    }

    public int getIni() {
        return ini;
    }

    public void setIni(int ini) {
        this.ini = ini;
    }

    public int getFin() {
        return fin;
    }

    public void setFin(int fin) {
        this.fin = fin;
    }

    public int getDuracion() {
        return this.fin-this.ini;
    }

    @Override
    public int compareTo(Actividad o) {
        return this.getIni()-o.getIni();
    }

    @Override
    public String toString() {
        return "Actividad [ini=" + ini + ", fin=" + fin + "]";
    }  

    

    
}
