package Parcial2024;

import java.util.ArrayList;

public class Ejecutable {
    public static void main(String[] args){
        Tarea t1=new Tarea(1,10);
        Tarea t2=new Tarea(2,40);
        Tarea t3=new Tarea(6,30);
        Tarea t4=new Tarea(2,20);
        Tarea t5=new Tarea(3,10);

        ArrayList<Tarea> tareas=new ArrayList<>();
        tareas.add(t1);
        tareas.add(t2);
        tareas.add(t3);
        tareas.add(t4);
        tareas.add(t5);

        GreedyBack greedy=new GreedyBack();
        //System.out.println(greedy.greedy(tareas));

        ArrayList<Character> letras=new ArrayList<>();
        letras.add('a');
        letras.add('r');
        letras.add('o');

        System.out.println(greedy.backtracking(letras,3));


    }
}
