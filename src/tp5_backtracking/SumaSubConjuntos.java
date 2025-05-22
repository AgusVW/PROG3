package tp5_backtracking;

import java.util.ArrayList;

/*Ejercicio 3
Suma de subconjuntos. Dados n números positivos distintos, se desea encontrar todas las
combinaciones de esos números tal que la suma sea igual a M.
 */

public class SumaSubConjuntos {
    private int[] conjunto;
    private ArrayList<ArrayList<Integer>> sumasAllegadas;
    private int cantidad;

    public SumaSubConjuntos(int n,int m){
        this.conjunto=new int[n];
        this.sumasAllegadas=new ArrayList<>();
        this.cantidad=0;
    }
    
    public ArrayList<ArrayList<Integer>> sumaBackTracking(int M){
        sumasAllegadas.clear();
        ArrayList<Integer> caminoActual=new ArrayList<>();
        backtracking(caminoActual, 0, 0,M);
        return sumasAllegadas;
    }

    private void backtracking(ArrayList<Integer> caminoActual,int sumaActual,int indice,int M){
        if(sumaActual > M || indice > conjunto.length){
            return;
        }
        if(M==sumaActual){
            sumasAllegadas.add(new ArrayList<>(caminoActual));
        }
        else{
            for(int i=indice;i < conjunto.length;i++){
                caminoActual.add(conjunto[i]);
                backtracking(caminoActual, sumaActual+conjunto[i], i+1,M);
                caminoActual.removeLast();
            }
        }
    }

    public void addElemArr(int num){
        if(cantidad<conjunto.length){
            conjunto[cantidad]=num;
            cantidad++;
        }
        else
            System.out.println("El array ya esta lleno");
    }

}
