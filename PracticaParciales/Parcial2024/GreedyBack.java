package Parcial2024;

import java.util.ArrayList;
import java.util.Collections;

public class GreedyBack {

    public ArrayList<ArrayList<Character>> backtracking(ArrayList<Character> letras,int largo){
        if(letras.isEmpty())
            return new ArrayList<>();
        ArrayList<ArrayList<Character>> solucion=new ArrayList<>();
        ArrayList<Character> solucionTemporal=new ArrayList<>();
        backtracking(letras,largo,solucionTemporal,solucion);
        return solucion;
    }

    public void backtracking(ArrayList<Character> letras,int largo,ArrayList<Character> solucionTemporal,ArrayList<ArrayList<Character>> solucion){
        if(solucionTemporal.size()==largo){
            solucion.add(new ArrayList<>(solucionTemporal));
        }
        else{
            for(Character letra:letras){
                if(!poda(solucionTemporal,largo) && !solucionTemporal.contains(letra)){
                    solucionTemporal.add(letra);
                    backtracking(letras,largo,solucionTemporal,solucion);
                    solucionTemporal.removeLast();
                }
            }
        }
    }

    private boolean poda(ArrayList<Character> actual,int largo){
        return actual.size()>=largo || esVocal(actual);
    }

    public boolean esVocal(ArrayList<Character> letras){
        if(letras.isEmpty())
            return false;
        return letras.getFirst().equals('a') || letras.getFirst().equals('e') || letras.getFirst().equals('i') || letras.getFirst().equals('o') || letras.getFirst().equals('u');
    }

    public ArrayList<Tarea> greedy(ArrayList<Tarea> tareas){
        ArrayList<Tarea> solucion=new ArrayList<>();
        Collections.sort(tareas);
        int caducidadAct=0;
        while(!tareas.isEmpty()){
            Tarea candidato=seleccionar(tareas);
            if(esFactible(candidato,caducidadAct)){
                solucion.add(candidato);
                caducidadAct=candidato.getCaducidad();
            }
        }
        if(solucion(solucion))
            return solucion;
        return null;
    }

    public boolean esFactible(Tarea candidato,int caducidadAct){
        return candidato.getCaducidad()>caducidadAct;
    }

    public Tarea seleccionar(ArrayList<Tarea> tareas){
        return tareas.removeFirst();
    }

    public boolean solucion(ArrayList<Tarea> solucion){
        return !solucion.isEmpty();
    }
}
