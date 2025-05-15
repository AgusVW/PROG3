package tp4_grafos;

import java.util.HashMap;
import java.util.Iterator;

public class DFS implements Iterable<Integer>{
    private HashMap<Integer,String> verticesRecorridos;

    public DFS(){
        this.verticesRecorridos=new HashMap<>();
    }

    public void DFS(GrafoDirigido<Integer> grafo){//recorrido en profundidad
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

    public boolean hayCiclo(GrafoDirigido<Integer> g){
        verticesRecorridos.clear();
        for(Integer v:g){//agrego los vertices a mi verticesRecorridos
            verticesRecorridos.put(v,"BLANCO");
        }

        for(Integer vertice:this){
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

    @Override
    public Iterator<Integer> iterator() {//iterable para mis hash de la clase
        return this.verticesRecorridos.keySet().iterator();
    }
}
