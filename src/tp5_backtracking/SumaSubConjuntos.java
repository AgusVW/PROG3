package tp5_backtracking;

import java.util.ArrayList;

/*Ejercicio 3
Suma de subconjuntos. Dados n números positivos distintos, se desea encontrar todas las
combinaciones de esos números tal que la suma sea igual a M.
 */

public class SumaSubConjuntos {
    private Integer[] conjunto;
    private ArrayList<ArrayList<Integer>> sumasAllegadas;
    private int M;

    public SumaSubConjuntos(int n,int m){
        this.conjunto=new Integer[n];
        this.sumasAllegadas=new ArrayList<>();
        this.M=m;
    }
    
    public ArrayList<ArrayList<Integer>> sumaBackTracking(int M){
        sumasAllegadas.clear();
        ArrayList<Integer> caminoActual=new ArrayList<>();
        backtracking(caminoActual, 0, 0);
        return sumasAllegadas;
    }

    private void backtracking(ArrayList<Integer> caminoActual,int sumaActual,int indice){
        if(this.M==sumaActual){
            sumasAllegadas.add(caminoActual);
        }
        if(sumaActual>M || indice>= conjunto.length){
            return;
        }
        else{
            sumaActual+=conjunto[indice];
            for(int i=indice;i < conjunto.length;i++){
                caminoActual.add(conjunto[i]);
                backtracking(caminoActual, sumaActual, i+1);
                caminoActual.removeLast();
            }
        }
    }

}
