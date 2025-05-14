package tp4_grafos;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Iterator;


public class Recorrido implements Iterable<Integer>{
    private HashMap<Integer,String> verticesRecorridos;
    private LinkedList<Integer> fila;
    private ArrayList<Integer> caminoMasLargo;

    public Recorrido(){
        this.verticesRecorridos=new HashMap<>();
        this.fila=new LinkedList<>();
        this.caminoMasLargo=new ArrayList<>();
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

    public boolean hayCiclo(GrafoDirigido<Integer> g){
        verticesRecorridos.clear();
        for(Integer v:g){//agrego los vertices a mi verticesRecorridos
            verticesRecorridos.put(v,"BLANCO");
        }

        for(Integer vertice:Recorrido.this){
            boolean hayCiclo=false;//guardo el hay ciclo en variable pq nose si voy a tener que recorrer todos los vertices separados o no
            if(verticesRecorridos.get(vertice).equals("BLANCO")){
                hayCiclo=buscarCiclo(g,vertice);
            }
            if(hayCiclo)//si hayciclo se vuelve true ya lo retorno
                return true;
        }
        return false;//si en ningun momento se volvio true quiere decir que es false
    }

    private boolean buscarCiclo(GrafoDirigido<Integer> g,int vertice){
        verticesRecorridos.put(vertice,"AMARILLO");
        Iterator<Integer> adyacentes=g.obtenerAdyacentes(vertice);
        boolean hayCiclo=false;
        while(adyacentes.hasNext()){
            int actual=adyacentes.next();
            if(hayCiclo)
                return true;
            else if(verticesRecorridos.get(actual).equals("BLANCO")){
                return buscarCiclo(g,actual);
            }
            else if(verticesRecorridos.get(actual).equals("AMARILLO")){//si es amarillo quiere decir que es un ancestro mio,ya que todavia no se puso en color negro
                return true;
            }
        }
        verticesRecorridos.put(vertice,"NEGRO");
        return false;
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

    private void buscarCaminoMasLargo(GrafoDirigido<Integer> grafo,ArrayList<Integer> caminoActual,int origen,int destino){
        if(origen==destino){
            if(caminoActual.size()>caminoMasLargo.size()){
                caminoMasLargo.clear();
                caminoMasLargo.addAll(caminoActual);
            }
        }
        else{
            Iterator<Integer> listaAdyacentes=grafo.obtenerAdyacentes(origen);
            while(listaAdyacentes.hasNext()){
                int adyActual=listaAdyacentes.next();
                if(!caminoActual.contains(adyActual)){
                    caminoActual.add(adyActual);
                    buscarCaminoMasLargo(grafo, caminoActual, adyActual, destino);
                    caminoActual.remove(adyActual);
                }
            }
        }
    }


    @Override
    public Iterator<Integer> iterator() {//iterable para mis hash de la clase
        return this.verticesRecorridos.keySet().iterator();
    }
}
