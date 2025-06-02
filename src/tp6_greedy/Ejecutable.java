package tp6_greedy;

import java.util.ArrayList;

public class Ejecutable {
    public static void main(String[] args){
        /*Ejercicio1_monedas monedas=new Ejercicio1_monedas(645);
        ArrayList<Integer> billetes=new ArrayList<>();
        billetes.add(100);
        billetes.add(25);
        billetes.add(10);
        billetes.add(5);

        System.out.println(monedas.greedy(billetes));*/

        Actividad a1 = new Actividad(15,18);
        Actividad a2 = new Actividad(9,15);
        Actividad a3 = new Actividad(12,20);
        Actividad a4 = new Actividad(18, 20);

        ArrayList<Actividad> lista=new ArrayList<>();
        lista.add(a1);        
        lista.add(a2);
        lista.add(a3);
        lista.add(a4);

        AsignActividades asignar=new AsignActividades();
        System.out.println(asignar.greedy(lista));
        
    }
}
