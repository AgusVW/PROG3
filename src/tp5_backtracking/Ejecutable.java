package tp5_backtracking;

public class Ejecutable {
    public static void main(String[] args){
        SumaSubConjuntos sumaConjunto=new SumaSubConjuntos(4,9);
        sumaConjunto.addElemArr(2);
        sumaConjunto.addElemArr(3);
        sumaConjunto.addElemArr(4);
        sumaConjunto.addElemArr(5);


        System.out.println(sumaConjunto.sumaBackTracking(9));
    }
}
