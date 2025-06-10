package tp4_grafos;

import java.util.Iterator;

public class Main {

	public static void main(String[] args) {
		GrafoDirigido<Integer> g1=new GrafoDirigido<>();
		g1.agregarVertice(6);
		g1.agregarVertice(5);
		g1.agregarVertice(3);
		g1.agregarVertice(4);
		g1.agregarVertice(2);
		g1.agregarVertice(15);

		g1.agregarArco(2,3,null);
		g1.agregarArco(3,4,null);
		g1.agregarArco(5,2,null);
		g1.agregarArco(4,5,null);
		g1.agregarArco(5,6,null);



		Recorrido recorrido=new Recorrido();
		DFS dfs=new DFS();
		//recorrido.recorridoDepthFirstSearch(g1);

		GrafoDirigido<Integer> g2=new GrafoDirigido<>();
		g2.agregarVertice(2);
		g2.agregarVertice(3);
		g2.agregarVertice(4);
		g2.agregarVertice(5);
		g2.agregarVertice(7);

		g2.agregarArco(2,4,null);
		g2.agregarArco(3,5,null);
		g2.agregarArco(7,3,null);
		g2.agregarArco(4,5,null);

		//recorrido.recorridoBreadthFirstSearch(g2);
		//System.out.println(recorrido.hayCiclo(g1));

		//System.out.println(g1.cantidadArcos());
		//g1.borrarVertice(2);
		//System.out.println(g1.cantidadArcos());
		//imprimirAdyacentes(g1,5);
		//System.out.println();
		//System.out.println(recorrido.buscarCaminoMasLargo(g1, 2, 5));
		//System.out.println(recorrido.verticesConCaminoA(g2,2));

		//System.out.println(recorrido.buscarCaminoMasCorto(g1,3,4));

		System.out.println();

		GrafoDirigido<Integer> g3=new GrafoDirigido<>();
		g3.agregarVertice(1);
		g3.agregarVertice(2);
		g3.agregarVertice(3);
		g3.agregarVertice(4);
		g3.agregarVertice(5);

		g3.agregarArco(1,2,null);
		g3.agregarArco(2,4,null);
		g3.agregarArco(4,1,null);
		g3.agregarArco(1,5,null);
		g3.agregarArco(5,4,null);
		g3.agregarArco(4,3,null);
		g3.agregarArco(3,2,null);
		g3.agregarArco(2,1,null);
		//System.out.println(recorrido.buscarCicloMasLargoEnGrafo(g3));
		System.out.println(dfs.hayCiclo(g3));

	}

	public static void imprimirArcos(GrafoDirigido<Integer> grafito) {
		Iterator<Arco<Integer>> iterator=grafito.obtenerArcos();
		while(iterator.hasNext()){
			Arco<Integer> arco=iterator.next();
			System.out.println(arco + ", ");
		}

	}

	public static void imprimirAdyacentes(GrafoDirigido<Integer> g,int vertice){
		Iterator<Integer> it=g.obtenerAdyacentes(vertice);
		while(it.hasNext()){
			int ady=it.next();
			System.out.print(ady+", ");
		}
	}

}
