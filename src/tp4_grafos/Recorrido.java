package tp4_grafos;
import java.util.HashMap;
import java.util.Iterator;


public class Recorrido {
    private HashMap<Integer,String> verticesColores;

    public Recorrido(){
        this.verticesColores=new HashMap<>();
    }

    public void recorridoDepthFirstSearch(GrafoDirigido<Integer> grafo){//recorrido en amplitud
        Iterator<Integer> iterator=grafo.obtenerVertices();
        while(iterator.hasNext()){//copio todo mi grafo en el hash con clave el vertice copiado y value el color
            verticesColores.put(iterator.next(),"BLANCO");
        }
        Iterator<Integer> iteratorColores=verticesColores.keySet().iterator();//pido el iterator de mi nuevo hash de vertices,colores
        while(iteratorColores.hasNext()){
            Integer actual=iteratorColores.next();
            if (verticesColores.get(actual).equals("BLANCO")) {
                DFS(grafo,actual);
            }
        }

    }

    private void DFS(GrafoDirigido<Integer> grafo,Integer vertice){
        System.out.println(vertice);//imprimo cada vertices en orden que se visitan
        verticesColores.put(vertice,"AMARILLO");//piso mi vertice poniendole el color amarillo
        Iterator<Integer> adyacentes=grafo.obtenerAdyacentes(vertice);
        while(adyacentes.hasNext()){//recorro los adyacentes del vertice donde estoy
            int actual=adyacentes.next();
            if(verticesColores.get(actual).equals("BLANCO")){//si mi adyacente actual que es un vertice es blanco lo visito y hago todo sucesivamente
                DFS(grafo,actual);
            }
        }
        verticesColores.put(vertice,"NEGRO");//una vez que recorri todos mis adyacentes me pongo en negro  pisando nuevamente la clave
    }


}
