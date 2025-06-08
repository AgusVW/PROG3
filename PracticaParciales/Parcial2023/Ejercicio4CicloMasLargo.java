package Parcial2023;

import tp4_grafos.GrafoDirigido;

import java.util.ArrayList;
import java.util.Iterator;

public class Ejercicio4CicloMasLargo {
    private ArrayList<Integer> caminoMasLargo=new ArrayList<>();

    public ArrayList<Integer> buscarCicloMasLargoDesdeOrigen(GrafoDirigido<Integer> g, int origen){
        this.caminoMasLargo.clear();
        ArrayList<Integer> caminoActual=new ArrayList<>();
        caminoActual.add(origen);
        buscarCicloMasLargo(g,caminoActual,origen,origen);
        return this.caminoMasLargo;
    }

    public ArrayList<Integer> buscarCicloMasLargoEnGrafo(GrafoDirigido<Integer> g){
        this.caminoMasLargo.clear();
        ArrayList<Integer> caminoActual=new ArrayList<>();
        for(Integer vertice:g){
            caminoActual.add(vertice);
            buscarCicloMasLargo(g, caminoActual, vertice, vertice);
            caminoActual.removeLast();
        }
        return this.caminoMasLargo;
    }

    public void buscarCicloMasLargo(GrafoDirigido<Integer> g,ArrayList<Integer> caminoActual,int origen,int actual){
        if(origen==actual && caminoActual.size()>1){
            if(caminoActual.size()>caminoMasLargo.size()){
                caminoMasLargo.clear();
                caminoMasLargo.addAll(caminoActual);
            }
        }else{
            Iterator<Integer> it=g.obtenerAdyacentes(actual);
            while(it.hasNext()){
                Integer adyActual=(Integer)it.next();
                if(!caminoActual.contains(adyActual) || adyActual==origen) {
                    caminoActual.add(adyActual);
                    buscarCicloMasLargo(g, caminoActual, origen, adyActual);
                    caminoActual.removeLast();
                }
            }
        }
    }///parcial 2023 ejercicio 4
}
