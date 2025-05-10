package tp4_grafos;
import java.util.HashMap;
import java.util.Iterator;


public class Recorrido {
    private HashMap<Integer,String> verticesColores;

    public Recorrido(){
        this.verticesColores=new HashMap<>();
    }

    public void recorridoDepthFirstSearch(GrafoDirigido grafo){
        Iterator<Integer> iterator=grafo.obtenerVertices();
        while(iterator.hasNext()){
            verticesColores.put(iterator.next(),"BLANCO");
        }
        Iterator<Integer> iteratorColores=verticesColores.keySet().iterator();
        while(iteratorColores.hasNext()){
            Integer actual=iteratorColores.next();
            if (verticesColores.get(actual).equals("BLANCO")) {
                DFS(grafo,actual);
            }
        }

    }

    private void DFS(GrafoDirigido grafo,Integer vertice){
        System.out.println(vertice);
        verticesColores.put(vertice,"AMARILLO");
        Iterator<Integer> adyacentes=grafo.obtenerAdyacentes(vertice);
        while(adyacentes.hasNext()){
            int actual=adyacentes.next();
            if(verticesColores.get(actual).equals("BLANCO")){
                DFS(grafo,actual);
            }
        }
        verticesColores.put(vertice,"NEGRO");
    }


}
