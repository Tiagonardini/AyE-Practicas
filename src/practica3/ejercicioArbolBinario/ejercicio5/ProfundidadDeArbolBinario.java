package practica3.ejercicioArbolBinario.ejercicio5;

import practica1.ejercicio3.ListaEnlazadaGenerica;
import practica3.ejercicioArbolBinario.ArbolBinario;

public class ProfundidadDeArbolBinario {



    public int sumaElementosProfundidad(ArbolBinario<Integer> arbol ){
        int nodoBase = arbol.getDato();
        ListaEnlazadaGenerica<Integer> listaDeEnteros = new ListaEnlazadaGenerica<>();
        listaDeEnteros.comenzar();
        recorrerSumarNodos(nodoBase, listaDeEnteros, arbol);

        listaDeEnteros.comenzar();
        nodoBase = 0;
        for (int i = 1; i < listaDeEnteros.tamanio(); i++){
            nodoBase = nodoBase + listaDeEnteros.elemento(i);
        }
        System.out.println("El total de la suma de todos los nodos del arbol es: "+nodoBase);
        return nodoBase;

    }

    private void recorrerSumarNodos(int nodoBase, ListaEnlazadaGenerica<Integer> listaEnteros, ArbolBinario<Integer> arbolBinarioDeEnteros) {
        listaEnteros.agregarFinal(nodoBase);
        if (arbolBinarioDeEnteros.tieneHijoIzquierdo()) {
            nodoBase = arbolBinarioDeEnteros.getHijoIzquierdo().getDato();
            recorrerSumarNodos(nodoBase, listaEnteros, arbolBinarioDeEnteros.getHijoIzquierdo());
        }
        if (arbolBinarioDeEnteros.tieneHijoDerecho()){
            nodoBase = arbolBinarioDeEnteros.getHijoDerecho().getDato();
            recorrerSumarNodos(nodoBase, listaEnteros, arbolBinarioDeEnteros.getHijoDerecho());
        }
    }

}
