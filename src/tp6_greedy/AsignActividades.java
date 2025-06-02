package tp6_greedy;

/*Ejercicio 3
Maximizar el número de actividades compatibles. Se tienen n actividades que necesitan utilizar un
recurso, tal como una sala de conferencias, en exclusión mutua. Cada actividad i tiene asociado un
tiempo de comienzo ci y un tiempo de finalización fi de utilización del recurso, con ci < fi. Si la
actividad i es seleccionada se llevará a cabo durante el intervalo [ci, fi). Las actividades i y j son
compatibles si los intervalos [ci, fi) y [cj, fj) no se superponen (es decir, ci > fj o cj > fi). El problema
consiste en encontrar la cantidad máxima de actividades compatibles entre sí.
 */

import java.util.ArrayList;
import java.util.Collections;

public class AsignActividades {

    public ArrayList<Actividad> greedy(ArrayList<Actividad> elementos){
        ArrayList<Actividad> solucion=new ArrayList<>();
        Collections.sort(elementos);
        while(!elementos.isEmpty() && !solucion(elementos)){
            Actividad candidato=seleccionar(elementos);
            elementos.remove(candidato);
            if(esFactible(solucion,candidato))
                solucion.add(candidato);
        }
        if(solucion(elementos))
            return solucion;
        return null;
    }

    private boolean solucion(ArrayList<Actividad> elementosRestantes){
        return elementosRestantes.isEmpty();
    }

    private Actividad seleccionar(ArrayList<Actividad> restantes){
        return restantes.get(0);
    }

    public boolean esFactible(ArrayList<Actividad> solucion,Actividad candidato){
        if(solucion.isEmpty() || candidato.getIni()>=solucion.get(0).getFin())
            return true;
        return false;
    }
}
