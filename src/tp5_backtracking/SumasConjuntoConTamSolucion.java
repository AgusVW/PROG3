package tp5_backtracking;

import java.util.ArrayList;

public class SumasConjuntoConTamSolucion {
    private ArrayList<Integer> conjunto;
    private int estadosGenerados;

    public SumasConjuntoConTamSolucion() {
        this.estadosGenerados = 0;
        conjunto = new ArrayList<>();
    }

    public ArrayList<ArrayList<Integer>> back(int sumaBuscada, int tamSubConjuntos) {
        ArrayList<ArrayList<Integer>> soluciones = new ArrayList<>();
        ArrayList<Integer> conjuntoTmp = new ArrayList<>();
        back(soluciones,0,0,conjuntoTmp,sumaBuscada,tamSubConjuntos);
        return soluciones;
    }

    private void back(ArrayList<ArrayList<Integer>> soluciones,int sumActual,int indice, ArrayList<Integer> conjuntoAct,int sumaBuscada,int tamSec) {
        estadosGenerados++;
        if(conjuntoAct.size()==tamSec){
            if(sumaBuscada == sumActual){
                soluciones.add(new ArrayList<>(conjuntoAct));
            }
        }
        else{
            for(int i=indice;i<conjunto.size();i++){
                conjuntoAct.add(conjunto.get(i));
                back(soluciones,sumActual+conjuntoAct.getLast(),i+1,conjuntoAct,sumaBuscada,tamSec);
                conjuntoAct.remove(conjuntoAct.size()-1);
            }
        }
    }

    public void add(int num){
        conjunto.add(num);
    }

    public int getEstadosGenerados() {
        return estadosGenerados;
    }
}
