package practica3.ejercicioArbolBinarioDeBusqueda.ejercicio9;

import practica1.ejercicio3.ListaEnlazadaGenerica;
import practica1.ejercicio3.ListaGenerica;

import practica3.ejercicioArbolBinarioDeBusqueda.ArbolBinarioDeBusqueda;
import practica3.ejercicioArbolBinarioDeBusqueda.repaso.Recorridos;

public class TestMain {
    public static void main(String[] args) {
        ArbolBinarioDeBusqueda<Integer> arbol = new ArbolBinarioDeBusqueda<>();


        // Agregar nodos al árbol binario de búsqueda
        arbol.agregar(100); // Nodo raíz
        arbol.agregar(20); // Hijo izquierdo de la raíz
        arbol.agregar(300); // Hijo derecho de la raíz
        arbol.agregar(4); // Hijo izquierdo de 20
        arbol.agregar(30); // Hijo derecho de 20
        arbol.agregar(40); // Hijo derecho de 30
        arbol.agregar(150); // Hijo izquierdo de 300
        arbol.agregar(25); // Hijo izquierdp de 30
        arbol.agregar(23); // Hijo izquierdo de 25

        Recorridos recorridos = new Recorridos();

//        ListaGenerica<Integer> lista = recorridos.caminoRecorrido(arbol,25);
//        lista.comenzar();
//        for (int i = 1; i<= lista.tamanio(); i++){
//            System.out.println(lista.elemento(i));
//        }

        System.out.println(recorridos.devolverMaximoNodoCercanoA(arbol,30));
    }

}
