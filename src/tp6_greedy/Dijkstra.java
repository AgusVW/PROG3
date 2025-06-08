package tp6_greedy;

import tp4_grafos.GrafoDirigido;

import java.util.*;

public class Dijkstra {
    private Map<Integer,Integer> distancias;
    private Map<Integer,Integer> padres;
    private Set<Integer> S;

    public Map<Integer,Integer> Dijkstra(GrafoDirigido<Integer> G,int origen){
        distancias=new HashMap<>();//arranco arreglo de distancias
        padres=new HashMap<>();//arranco arreglo de padres
        for(Integer vertice:G){
            distancias.put(vertice,Integer.MAX_VALUE);//a cada vertice del grafo lo meto a mi arreeglo de distancias con el valor maximos de distancia
            padres.put(vertice,null);//a cada vertice del grafo lo meto a mi arreeglo de padres con padre null
        }
        distancias.put(origen,0);//a mi origen lo meto a mi arreglo de distancias con distancia 0

        S=new HashSet<>();

        while(S.size() < distancias.size()){
            Integer vertice=obtenerVerticeDeMinimaDistancia(G);

            S.add(vertice);//agrego al conjunto de vertices visitados el vertice que tiene la minima distancia

            Iterator<Integer> adyacentes=G.obtenerAdyacentes(vertice);//obtengo los adyacentes del vertice actual,con menor distancia
            while(adyacentes.hasNext()){//recorro todos sus adyacentes
                Integer adyacente=adyacentes.next();

                //veo la nueva distancia que tengo con la distancia que tengo hacia mi mismo + la que tengo hacia el arco adyacente actual
                int nuevaDistancia=distancias.get(vertice)+obtenerDistancia(G,vertice,adyacente);

                //si mi nuevaDistancia es menor a la distancia de mi adayacente en mi arreglo de distancias,
                // actualizo la distancia y el padre del adyacente
                if(nuevaDistancia < distancias.get(adyacente)){
                    distancias.put(adyacente,nuevaDistancia);//actulizo la distancia del adyacente
                    padres.put(adyacente,vertice);//actualizo el padre del adyacente poniendo el vertice actual de donde vengo que es el de MINIMA DISTANCIA
                }
            }
        }

        return padres;
    }

    public int obtenerVerticeDeMinimaDistancia(GrafoDirigido<Integer> grafo){
        int minVertice=-1;
        int minDistancia=Integer.MAX_VALUE;
        for(Integer vertice:grafo){
            if(!S.contains(vertice) && distancias.get(vertice)<minDistancia){//si mi arreglo de vertices visitados no contiene
                minVertice=vertice;//actualizo mi verticeMasChico           //el vertice actual y la distancia de ese vertice es menor
                minDistancia=distancias.get(vertice);                       //a la minima distancia,entra al if
            }
        }
        return minVertice;//retorno el vertice que tiene la minima distancia
    }

    public int obtenerDistancia(GrafoDirigido<Integer> grafo,int vertice1,int vertice2){
        return grafo.obtenerArco(vertice1, vertice2).getEtiqueta();
    }
}
