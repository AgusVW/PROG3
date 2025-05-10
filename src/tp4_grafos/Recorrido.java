package tp4_grafos;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.Iterator;


public class Recorrido {
    private HashMap<Integer,String> verticesRecorridos;
    private LinkedList<Integer> fila;

    public Recorrido(){
        this.verticesRecorridos=new HashMap<>();
        this.fila=new LinkedList<>();
    }

    public void recorridoDepthFirstSearch(GrafoDirigido<Integer> grafo){//recorrido en profundidad
        verticesRecorridos.clear();
        Iterator<Integer> iterator=grafo.obtenerVertices();
        while(iterator.hasNext()){//copio todo mi grafo en el hash con clave el vertice copiado y value el color
            verticesRecorridos.put(iterator.next(),"BLANCO");
        }
        Iterator<Integer> iteratorColores=verticesRecorridos.keySet().iterator();//pido el iterator de mi nuevo hash de vertices,colores
        while(iteratorColores.hasNext()){
            Integer actual=iteratorColores.next();
            if (verticesRecorridos.get(actual).equals("BLANCO")) {
                DFS(grafo,actual);
            }
        }

    }

    private void DFS(GrafoDirigido<Integer> grafo,Integer vertice){
        System.out.println(vertice);//imprimo cada vertices en orden que se visitan
        verticesRecorridos.put(vertice,"AMARILLO");//piso mi vertice poniendole el color amarillo
        Iterator<Integer> adyacentes=grafo.obtenerAdyacentes(vertice);
        while(adyacentes.hasNext()){//recorro los adyacentes del vertice donde estoy
            int actual=adyacentes.next();
            if(verticesRecorridos.get(actual).equals("BLANCO")){//si mi adyacente actual que es un vertice es blanco lo visito y hago todo sucesivamente
                DFS(grafo,actual);
            }
        }
        verticesRecorridos.put(vertice,"NEGRO");//una vez que recorri todos mis adyacentes me pongo en negro  pisando nuevamente la clave
    }


    public void recorridoBreadthFirstSearch(GrafoDirigido<Integer> grafo){//recorrido en amplitud
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
        
    }


}
