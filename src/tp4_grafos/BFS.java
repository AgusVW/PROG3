package tp4_grafos;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class BFS {
    private HashMap<Integer,String> verticesRecorridos;
    private LinkedList<Integer> fila;

    public BFS(){
        this.verticesRecorridos=new HashMap<>();
        this.fila=new LinkedList<>();
    }

    public void BFS(GrafoDirigido<Integer> grafo){//recorrido en amplitud
        this.fila.clear();//siempre vacio la fila
        this.verticesRecorridos.clear();//vacio mi hash
        Iterator<Integer> verticesGrafo=grafo.obtenerVertices();
        while(verticesGrafo.hasNext()){//completo mi hash de verticeRecorridos como DFS
            verticesRecorridos.put(verticesGrafo.next(),"NO VISITADO");
        }
        Iterator<Integer> verticesArecorrer=verticesRecorridos.keySet().iterator();
        while (verticesArecorrer.hasNext()) {//recorro mis verticesRecorridos
            int actual=verticesArecorrer.next();
            if(verticesRecorridos.get(actual).equals("NO VISITADO")){//si el vertice actual es no visitado lo visito(BFS)
                BFS(grafo,actual);
            }
        }
    }

    private void BFS(GrafoDirigido<Integer> g,int vertice){
        verticesRecorridos.put(vertice,"VISITADO");//marco el vertice actual visitado
        fila.add(vertice);//agrego a la fila el primer vertice
        while(!fila.isEmpty()){//mientras la fila no quede vacia no paro
            int verticeActual=fila.removeFirst();//remuevo el primero de la fila a recorrer de los adyacentes
            System.out.println(verticeActual);//imprimo el vertice cuando lo saco de la fila
            Iterator<Integer> adyacentes=g.obtenerAdyacentes(verticeActual);//traigo los adyacentes
            while(adyacentes.hasNext()){
                int adyacenteActual=adyacentes.next();
                if(verticesRecorridos.get(adyacenteActual).equals("NO VISITADO")){
                    verticesRecorridos.put(adyacenteActual,"VISITADO");//marco el adyacente como visitado
                    fila.add(adyacenteActual);//lo agrego a la fila para luego recorrer sus adyacentes desde la fila
                }
            }
        }
    }
}
