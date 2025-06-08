package tp4_grafos;
import java.util.*;

public class Recorrido{
    private ArrayList<Integer> caminoMasLargo;
    private ArrayList<Integer> caminoMasCorto;

    public Recorrido(){
        this.caminoMasLargo=new ArrayList<>();
        this.caminoMasCorto=new ArrayList<>();
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

    public ArrayList<Integer> verticesConCaminoA(GrafoDirigido<Integer> g,int destino){
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

    public ArrayList<Integer> buscarCaminoMasCorto(GrafoDirigido<Integer> g,int origen,int destino){
        ArrayList<Integer> caminoActual=new ArrayList<>();
        if(!g.contieneVertice(origen) || !g.contieneVertice(destino)) {
            return caminoMasCorto;
        }
        caminoActual.add(origen);
        if(g.contieneAdyacenteDirecto(origen,destino)){
            caminoActual.add(destino);
            caminoMasCorto.clear();
            caminoMasCorto.addAll(caminoActual);
            return caminoMasCorto;
        }

        buscarCaminoMasCorto(g,caminoActual,origen,destino);
        return this.caminoMasCorto;
    }

    private void buscarCaminoMasCorto(GrafoDirigido<Integer> g,ArrayList<Integer> caminoActual,int actual,int destino){
        if(actual==destino){
            if(caminoActual.size()<caminoMasCorto.size() || caminoMasCorto.isEmpty()){
                caminoMasCorto.clear();
                caminoMasCorto.addAll(caminoActual);
            }
        }
        else{
            Iterator<Integer> it=g.obtenerAdyacentes(actual);
            while(it.hasNext()){
                int adyActual=it.next();
                if(!caminoActual.contains(adyActual)){
                    caminoActual.add(adyActual);
                    buscarCaminoMasCorto(g,caminoActual,adyActual,destino);
                    caminoActual.remove(Integer.valueOf(adyActual));
                }
            }
        }
    }

    public ArrayList<ArrayList<Integer>> buscarCaminosAlternativosEntreDosVertices(GrafoDirigido g,int origen,int destino){
        ArrayList<ArrayList<Integer>> caminosAlternativos=new ArrayList<>();
        ArrayList<Integer> caminoActual=new ArrayList<>();
        buscarTodosLosCaminos(g,caminoActual,caminosAlternativos,origen,destino);
        return caminosAlternativos;
    }

    private void buscarTodosLosCaminos(GrafoDirigido g,ArrayList<Integer> caminoActual,ArrayList<ArrayList<Integer>> caminosAlternativos,int actual,int destino){
        if(actual==destino){
            caminosAlternativos.add(caminoActual);
        }
        else{
            Iterator<Integer> it=g.obtenerAdyacentes(actual);
            while(it.hasNext()){
                int adyActual=it.next();
                if(!caminoActual.contains(adyActual)){
                    caminoActual.add(adyActual);
                    buscarTodosLosCaminos(g,caminoActual,caminosAlternativos,adyActual,destino);
                    caminoActual.remove(Integer.valueOf(adyActual));
                }
            }
        }
    }

    public ArrayList<Integer> buscarCicloMasLargoDesdeUnOrigen(GrafoDirigido<Integer> g,int origen){
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
