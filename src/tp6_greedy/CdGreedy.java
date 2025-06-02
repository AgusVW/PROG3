package tp6_greedy;

import java.util.ArrayList;
import java.util.Collections;

/*Ejercicio 7
Armando CDs. Dado un conjunto de archivos de canciones, donde cada uno tiene la información de
nombre, género, duración del tema, y tamaño en kilobytes, se desea grabar un disco CD (que tiene
una capacidad máxima de M kilobytes) de modo tal de:
● Variante A: Maximizar la capacidad ocupada del disco CD.
● Variante B: Maximizar la cantidad de canciones que se pueden grabar en el CD.
Para ambas variantes se quiere, además, que el CD no contenga más de 3 canciones de un mismo
género.
 */

public class CdGreedy {
    private int capacidad;
    private final static int MAXPORGENERO=3;

    public CdGreedy(int capacidad){
        this.capacidad=capacidad;
    }

    public ArrayList<Cancion> greedy(ArrayList<Cancion> canciones){
        ArrayList<Cancion> solucion=new ArrayList<>();
        Collections.sort(canciones);
        while(!canciones.isEmpty() && solucion(solucion)){
            Cancion candidato=seleccionar(canciones);
            canciones.remove(candidato);
            if(esFactible(solucion,candidato))
                solucion.add(candidato);
        }
        if(solucion(solucion))
            return solucion;
        return null;
    }

    public boolean esFactible(ArrayList<Cancion> solucion,Cancion candidato){
        int contGenero=0;
        int pesoTotalActual=0;
        for(Cancion cancion:solucion){
            pesoTotalActual+=cancion.getPeso();
            if(cancion.getGenero().equals(candidato.getGenero()))
                contGenero++;
        }
        return contGenero<=MAXPORGENERO && (pesoTotalActual+candidato.getPeso()) <= this.capacidad;
    }

    private Cancion seleccionar(ArrayList<Cancion> canciones){
        return canciones.get(0);
    }

    private boolean solucion(ArrayList<Cancion> solucion){
        int suma=0;
        for(Cancion cancion:solucion)
            suma+=cancion.getPeso();

        return suma==this.capacidad;
    }
}
