package practica3.ejercicioArbolBinario.repaso;

import practica3.ejercicioArbolBinario.ArbolBinario;

public class Test {
    public static void main(String[] args) {
        // Crear los nodos del árbol binario
        ArbolBinario<Integer> arbol = new ArbolBinario<>(1);
        ArbolBinario<Integer> nodo2 = new ArbolBinario<>(2);
        ArbolBinario<Integer> nodo3 = new ArbolBinario<>(3);
        ArbolBinario<Integer> nodo4 = new ArbolBinario<>(4);
        ArbolBinario<Integer> nodo5 = new ArbolBinario<>(5);
        ArbolBinario<Integer> nodo6 = new ArbolBinario<>(6);
        ArbolBinario<Integer> nodo7 = new ArbolBinario<>(7);

        // Construir el árbol binario
        arbol.agregarHijoIzquierdo(nodo2);
        arbol.agregarHijoDerecho(nodo3);
        nodo2.agregarHijoIzquierdo(nodo4);
        nodo2.agregarHijoDerecho(nodo5);
        nodo3.agregarHijoIzquierdo(nodo6);
        nodo3.agregarHijoDerecho(nodo7);

        Recorridos<Integer> recorridos = new Recorridos<>();
        System.out.println("ACA EMPIEZA EL RECORRIDO PRE ORDER");
        recorridos.recorridoPreOrder(arbol);

        System.out.println("ACA EMPIEZA EL RECORRIDO IN ORDER");
        recorridos.recorridoInOrder(arbol);

        System.out.println("ACA EMPIEZA EL RECORRIDO POST ORDER");
        recorridos.recorridoPostOrder(arbol);


        System.out.println("ACA EMPIEZA EL RECORRIDO POR NIVELES");
        recorridos.recorridoPorNiveles(arbol);







        // ARBOLES BINARIOS DE BUSQUEDA


    }
}
