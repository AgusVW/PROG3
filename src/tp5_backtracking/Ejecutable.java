package tp5_backtracking;

public class Ejecutable {
    public static void main(String[] args){
        SumaSubConjuntos sumaConjunto=new SumaSubConjuntos(4,9);
        sumaConjunto.addElemArr(5);
        sumaConjunto.addElemArr(3);
        sumaConjunto.addElemArr(4);
        sumaConjunto.addElemArr(1);


        //System.out.println(sumaConjunto.sumaBackTracking(9));

        SumasConjuntoConTamSolucion sumasConjunto=new SumasConjuntoConTamSolucion();
        sumasConjunto.add(-7);
        sumasConjunto.add(-3);
        sumasConjunto.add(-2);
        sumasConjunto.add(-1);
        sumasConjunto.add(5);
        sumasConjunto.add(8);
        //sumasConjunto.add(3);

        System.out.println(sumasConjunto.back(0,3));
        System.out.println(sumasConjunto.getEstadosGenerados());

    }
}
