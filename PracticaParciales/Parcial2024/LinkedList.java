package Parcial2024;

import tp1.Node;
//HashTable
//hastable calcula el tamaño * 2 + 1 ----> el mas uno es parq que no sea potencia de 2 y no mande mayores elementos a la
//posicion 0 y se produzcan muchas colisiones

//el calculo para ver si se agranda es el tamaño del arreglo(default 11)*0,75(roh diseño)==8 elemento por default

//en el caso de hastable que el tamaño default es 11,el factor de carga es 8,
//pero sin embargo el arreglo se agranda size>cuando mi factor de carga por lo tanto cuando inserte el 9 elemento
public class LinkedList {
    private Node<String> root;
    private Node<String> last;

    public LinkedList() {
        this.root = null;
        this.last = null;
    }

    public void agregarAlPrincipio(String info){
        Node<String> node=new Node<String>(info,null);
        node.setNext(root);
        this.root=node;
        if(last==null)
            this.last=node;
    }

    public void agregarAlFinal(String info){
        if(root!=null){
            Node<String> nodo=new Node<String>(info,null);
            this.last.setNext(nodo);
            this.last=nodo;
        }else{
            this.agregarAlPrincipio(info);
        }
    }
}
