package practica3.ejercicioArbolBinarioDeBusqueda;


public class TestMainABB {
    public static void main(String[] args) {
        ArbolBinarioDeBusqueda<Integer> arbol = new ArbolBinarioDeBusqueda<>();


        // Agregar nodos al árbol binario de búsqueda
        arbol.agregar(50); // Nodo raíz
        arbol.agregar(30); // Hijo izquierdo de la raíz
        arbol.agregar(70); // Hijo derecho de la raíz
        arbol.agregar(20); // Hijo izquierdo de 30
        arbol.agregar(40); // Hijo derecho de 30
        arbol.agregar(60); // Hijo izquierdo de 70
        arbol.agregar(80); // Hijo derecho de 70


//       System.out.println(arbol.incluye(80));
        imprimirEnOrden(arbol);


////      System.out.println(arbol.buscarMayorDeLosMenores(arbol).getDato()); //imprime 40
////      System.out.println(arbol.buscarMayor(arbol).getDato()); //tiene que imprimir 80
//        System.out.println(arbol.buscarMenorDeLosMayores(arbol).getDato()); //tiene que imprimir 60
//        System.out.println(arbol.buscarMenor(arbol).getDato()); //tiene que imprimir 20

    }

    private static void imprimirEnOrden(ArbolBinarioDeBusqueda<Integer> arbol) {
        if (arbol != null) {
            if (arbol.getHijoIzquierdo() != null) {
                imprimirEnOrden(arbol.getHijoIzquierdo());
            }
            System.out.println(arbol.getDato());
            if (arbol.getHijoDerecho() != null) {
                imprimirEnOrden(arbol.getHijoDerecho());
            }
        }
    }
}
