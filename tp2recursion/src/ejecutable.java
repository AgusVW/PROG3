public class ejecutable {
    public static void main(String[] args) {
        int[] arrOrd={10,20,30,40};
        int[] arrDesord={10,30,20,10};
        //System.out.println(buscarDato(arrOrd,0,2));
        System.out.println(decimalAbinario(26));
    }

    // 1. ¿Qué complejidad O tiene? (La complejidad en el peor caso)->O(n)
    // 2. ¿Trae algún problema hacerlo recursivo? ¿Cuál?->que el arreglo tiene que venir ya ordenado
    // 3. ¿Qué cambiaría si la estructura fuera una lista en lugar de un arreglo?->que en vez seguir por index va por nodo
    public static boolean estaOrdenado(int[] arr,int indice){
        if (arr[indice]>arr[indice+1])
            return false;
        else if (indice < arr.length-2)
            return estaOrdenado(arr,indice+1);
        return true;
    }

    public static int buscarDato(int[] arr,int indice,int info){
        if (info<arr[indice])
            return -1;

        if (arr[indice]==info)
            return indice;

        if (indice<arr.length-1)
            return buscarDato(arr,indice+1,info);
        return -1;
    }

    public static String decimalAbinario(int decimal){
        String res="";
        if (decimal>1) {
            int bin=decimal%2;
            decimal = decimal / 2;
            res+=bin;
            res+=decimalAbinario(decimal);
        }
        else if (decimal==1)
            res+="1";

        return res;
    }


}
