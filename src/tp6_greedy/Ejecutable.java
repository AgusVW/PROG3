package tp6_greedy;

import java.util.ArrayList;

public class Ejecutable {
    public static void main(String[] args){
        Ejercicio1_monedas monedas=new Ejercicio1_monedas(645);
        ArrayList<Integer> billetes=new ArrayList<>();
        billetes.add(100);
        billetes.add(25);
        billetes.add(10);
        billetes.add(5);

        System.out.println(monedas.greedy(billetes));
    }
}
