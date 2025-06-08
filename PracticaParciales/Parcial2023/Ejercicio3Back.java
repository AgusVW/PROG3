package Parcial2023;

import java.util.ArrayList;

public class Ejercicio3Back {
    private ArrayList<ArrayList<Integer>> solucion;
    private int sumaBuscada;

    private ArrayList<ArrayList<Integer>> backtracking(ArrayList<Integer> c1,ArrayList<Integer> c2,ArrayList<Integer> c3,ArrayList<Integer> c4,
                               int  s1,int   s2,int   s3,int   s4,int indice,ArrayList<Integer> conjunto){

        if(indice==conjunto.size()){
            if(hacerSumasSubConjuntos(c1,c2,c3,c4)==conjunto.size() && s1==sumaBuscada &&
                    s2==sumaBuscada && s3==sumaBuscada && s4==sumaBuscada){
                solucion.add(new ArrayList<>(c1));
                solucion.add(new ArrayList<>(c2));
                solucion.add(new ArrayList<>(c3));
                solucion.add(new ArrayList<>(c4));
                return solucion;
            }
        }
        else{
            c1.add(conjunto.get(indice));
            ArrayList<ArrayList<Integer>> tmp1=backtracking(c1,c2,c3,c4,s1+conjunto.get(indice),s2,s3,s4,indice+1,conjunto);
            c1.removeLast();
            if(tmp1!=null)
                return tmp1;

            c2.add(conjunto.get(indice));
            backtracking(c1,c2,c3,c4,s1,s2+conjunto.get(indice),s3,s4,indice+1,conjunto);
            c2.removeLast();

            c3.add(conjunto.get(indice));
            backtracking(c1,c2,c3,c4,s1,s2,s3+conjunto.get(indice),s4,indice+1,conjunto);
            c3.removeLast();

            c4.add(conjunto.get(indice));
            backtracking(c1,c2,c3,c4,s1,s2,s3,s4+conjunto.get(indice),indice+1,conjunto);
            c4.removeLast();

        }
        return null;
    }

    private int hacerSumasSubConjuntos(ArrayList<Integer> c1,ArrayList<Integer> c2,ArrayList<Integer> c3,ArrayList<Integer> c4){
        return c1.size()+c2.size()+c3.size()+c4.size();
    }

}
