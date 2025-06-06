package Parcial2024;

public class Tarea implements Comparable<Tarea>{
    private int caducidad;
    private int puntaje;

    public Tarea(int caducidad, int puntaje){
        this.caducidad=caducidad;
        this.puntaje=puntaje;
    }

    public int getCaducidad(){return caducidad;}
    public int getPuntaje(){return puntaje;}

    @Override
    public int compareTo(Tarea t){
        int caducidad=Integer.compare(this.getCaducidad(),t.getCaducidad());
        if(caducidad!=0)
            return caducidad;
        return Integer.compare(t.getPuntaje(),this.getPuntaje());
    }

    public String toString(){return "Tarea [caducidad=" + caducidad + ", puntaje=" + puntaje + "]";}
}
