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
		g1.agregarArco(3,5,null);
		g1.agregarArco(5,2,null);
		g1.agregarArco(4,6,null);
		//g1.agregarArco(6,6,null);


		Recorrido recorrido=new Recorrido();
		//recorrido.recorridoDepthFirstSearch(g1);

		GrafoDirigido<Integer> g2=new GrafoDirigido<>();
		g2.agregarVertice(2);
		g2.agregarVertice(3);
		g2.agregarVertice(4);
		g2.agregarVertice(15);
		g2.agregarVertice(10);

		g2.agregarArco(2,3,null);
		g2.agregarArco(2,4,null);
		g2.agregarArco(3,15,null);
		g2.agregarArco(3,10,null);

		//recorrido.recorridoBreadthFirstSearch(g2);
		System.out.println(recorrido.hayCiclo(g1));
	}

	public static void imprimirArcos(GrafoDirigido<Float> grafito) {
		Iterator<Arco<Float>> iterator=grafito.obtenerArcos();
		while(iterator.hasNext()){
			Arco<Float> arco=iterator.next();
			System.out.println(arco + ", ");
		}

	}

}
