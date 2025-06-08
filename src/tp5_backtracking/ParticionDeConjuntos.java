package tp5_backtracking;

import java.util.ArrayList;

public class ParticionDeConjuntos {
    private ArrayList<ArrayList<Integer>> solucion;

    public ArrayList<ArrayList<Integer>> particionBack(ArrayList<Integer> conjunto){
        int contador=0;
        for(int i=0;i<conjunto.size();i++){
            contador+=conjunto.get(i);
        }
        if(contador%2==1)
            return solucion;

        ArrayList<Integer> conjunto1=new ArrayList<>();
        ArrayList<Integer> conjunto2=new ArrayList<>();
        backtracking(conjunto1,conjunto2,0,0,0,conjunto);
        return solucion;
    }

    public void backtracking(ArrayList<Integer> conjunto1,ArrayList<Integer> conjunto2,int suma1,int suma2,int indice,ArrayList<Integer> conjunto){
        if(indice==conjunto.size()){
            if(suma1==suma2){
                solucion.add(new ArrayList<>(conjunto1));
                solucion.add(new ArrayList<>(conjunto2));
            }
        }
        else{
            conjunto1.add(conjunto.get(indice));
            backtracking(conjunto1,conjunto2,suma1+conjunto.get(indice),suma2,indice+1,conjunto);
            conjunto1.removeLast();

            conjunto2.add(conjunto.get(indice));
            backtracking(conjunto1,conjunto2,suma1,suma2+conjunto.get(indice),indice+1,conjunto);
            conjunto2.removeLast();
        }
    }
}
