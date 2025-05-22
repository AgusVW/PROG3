package tp5_backtracking;

import java.util.ArrayList;

public class Laberinto {
    private ArrayList<Posicion> caminoMasEfectivo;
    private int n;
    private Posicion[][] laberinto;

    public Laberinto(int n){
        this.n=n;
        this.laberinto=new Posicion[n][n];
        this.caminoMasEfectivo=new ArrayList<>();
    }

    

}
