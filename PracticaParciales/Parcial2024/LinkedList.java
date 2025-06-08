package Parcial2024;

import tp1.Node;

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
