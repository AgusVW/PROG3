package tp4_grafos;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Recorrido{
    private ArrayList<Integer> caminoMasLargo;

    public Recorrido(){
        this.caminoMasLargo=new ArrayList<>();
    }

    /*Ejercicio 4 tp grafos
    Escribir un algoritmo que, dado un grafo dirigido y dos vértices i, j de este grafo, devuelva el
    camino simple (sin ciclos) de mayor longitud del vértice i al vértice j. Puede suponerse que el
    grafo de entrada es acíclico. */
    public ArrayList<Integer> buscarCaminoMasLargo(GrafoDirigido<Integer> grafo,int origen,int destino){
        ArrayList<Integer> caminoActual=new ArrayList<>();
        caminoActual.add(origen);
        buscarCaminoMasLargo(grafo, caminoActual, origen, destino);
        return this.caminoMasLargo;
    }

    private void buscarCaminoMasLargo(GrafoDirigido<Integer> g,ArrayList<Integer> caminoActual,int origen,int destino){
        if(origen==destino){
            if(caminoActual.size()>caminoMasLargo.size()){
                caminoMasLargo.clear();
                caminoMasLargo.addAll(caminoActual);
            }
        }
        else{
            Iterator<Integer> adyacentes=g.obtenerAdyacentes(origen);
            while(adyacentes.hasNext()){
                int adyActual=adyacentes.next();
                if(!caminoActual.contains(adyActual)){
                    caminoActual.add(adyActual);
                    buscarCaminoMasLargo(g, caminoActual, adyActual, destino);
                    caminoActual.remove(Integer.valueOf(adyActual));
                }
            }
        }
    }

    /*Ejercicio 5 tp Grafos
    Escriba un algoritmo que dado un grafo G y un vértice v de dicho grafo, devuelva una lista
    con todos los vértices a partir de los cuales exista un camino en G que termine en v.*/

    public ArrayList<Integer> caminosAvertice(GrafoDirigido<Integer> g,int destino){
        ArrayList<Integer> verticesQueLlegan=new ArrayList<>();
        ArrayList<Integer> caminoTemporal=new ArrayList<>();
        for(Integer vertice:g){
            if(!verticesQueLlegan.contains(vertice) ){
                caminoTemporal.add(vertice);
                buscarCaminosAvertice(g, caminoTemporal, verticesQueLlegan, vertice, destino);
                caminoTemporal.clear();
            }
        }
        return verticesQueLlegan;
    }

    private void buscarCaminosAvertice(GrafoDirigido<Integer> g,ArrayList<Integer> caminoTemporal,ArrayList<Integer> verticesQueLlegan,int actual,int destino){
        if(actual==destino){
            for(Integer vertice:caminoTemporal){
                if(!verticesQueLlegan.contains(vertice))
                    verticesQueLlegan.add(vertice);
            }
            verticesQueLlegan.removeLast();
        }
        else{
            Iterator<Integer> adyacentes=g.obtenerAdyacentes(actual);
            while(adyacentes.hasNext()){
                int adyActual=adyacentes.next();
                if(!caminoTemporal.contains(adyActual)){
                    caminoTemporal.add(adyActual);
                    buscarCaminosAvertice(g,caminoTemporal,verticesQueLlegan,adyActual,destino);
                    caminoTemporal.remove(Integer.valueOf(adyActual));
                }
            }
        }
    }
}
