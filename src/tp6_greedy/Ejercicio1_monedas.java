package tp6_greedy;
/*Cambio de monedas: Dado un conjunto C de N tipos de monedas con un número ilimitado de
ejemplares de cada tipo, se requiere formar, si se puede, una cantidad M empleando el mínimo
número de ellas.
Por ejemplo, un cajero automático dispone de billetes de distintos valores: 100$, 25$, 10$, 5$ y 1$,
si se tiene que pagar 289$, la mejor solución consiste en dar 10 billetes: 2 de 100$, 3 de 25$, 1 de
10$ y 4 de 1$.
 */

import java.util.ArrayList;

public class Ejercicio1_monedas {
    private int objetivo;

    public Ejercicio1_monedas(int objetivo){
        this.objetivo=objetivo;
    }

    public ArrayList<Integer> greedy(ArrayList<Integer> billetes){
        ArrayList<Integer> solucion=new ArrayList<>();
        while(!billetes.isEmpty() && !solucion(solucion)){
            int candidato=seleccionar(billetes);
            billetes.remove(Integer.valueOf(candidato));
            while(esFactible(solucion,candidato)){
                solucion.add(candidato);
            }
        }
        if(solucion(solucion))
            return solucion;
        else
            return null;
    }

    public int seleccionar(ArrayList<Integer> billetes){
        int billete=0;
        for(Integer num:billetes){
            if(num<=this.objetivo)
                return billete=num;
        }
        return billete;
    }

    public boolean solucion(ArrayList<Integer> solucion){
        int suma=0;
        for(Integer num:solucion)
            suma+=num;

        return suma==this.objetivo;
    }

    public boolean esFactible(ArrayList<Integer> solucion,int candidatoActual){
        int suma=0;
        for(Integer num:solucion)
            suma+=num;

        return (suma+candidatoActual)<=this.objetivo;
    }
}
