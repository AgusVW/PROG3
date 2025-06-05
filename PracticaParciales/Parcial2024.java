import tp1.Node;

public class Parcial2024 {
    private Node<String> root;
    private Node<String> last;

    public Parcial2024() {
        this.root = null;
        this.last = null;
    }

    public void agregarAlPrincipio(String info){
        Node<?> node=new Node(info,null);
        node.setNext(root);
    }
}
