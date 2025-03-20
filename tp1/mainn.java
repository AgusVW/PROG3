
public class mainn {
    public static void main(String[] args) {
        MySimpleLinkedList<Integer> lista=new MySimpleLinkedList<>();
        lista.insertFront(10);
        lista.insertFront(20);
        lista.insertFront(30);

        //System.out.println(lista.extractFront());
        lista.insertFound(40);
        System.out.println(lista.get(3));
        //System.out.println(lista.extractIndex(3));
        //System.out.println(lista.toString());
        System.out.println(lista.getPorInfo(450));
    }
}
