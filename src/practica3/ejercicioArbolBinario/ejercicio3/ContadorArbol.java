package practica3.ejercicioArbolBinario.ejercicio3;

import practica1.ejercicio3.ListaEnlazadaGenerica;
import practica1.ejercicio3.ListaGenerica;
import practica3.ejercicioArbolBinario.ArbolBinario;

public class ContadorArbol<T> {
    private ArbolBinario<T> arbol;

    public ContadorArbol(ArbolBinario<T>arbol){
        this.arbol = arbol;
    }



    public ListaGenerica<Integer> numeroPares(){
        return recorrerArbol(new ListaEnlazadaGenerica<Integer>(), this.arbol );
    }

    private ListaGenerica<Integer> recorrerArbol(ListaEnlazadaGenerica<Integer> listaNumeros, ArbolBinario<T> arbol) {
        if (this.arbol == null){
            return listaNumeros;
        }
        int datoNodo = (int) arbol.getDato();
        if (datoNodo % 2 == 0){
            listaNumeros.agregarFinal(datoNodo);
        }
        if (arbol.tieneHijoIzquierdo()){
            recorrerArbol(listaNumeros, arbol.getHijoIzquierdo());
        }
        if (arbol.tieneHijoDerecho()){
            recorrerArbol(listaNumeros, arbol.getHijoDerecho());
        }

        return listaNumeros;
    }

    public void inOrder(ArbolBinario<T>arbol){
        if (arbol.tieneHijoIzquierdo()){
            inOrder(arbol.getHijoIzquierdo());
        }

        System.out.println(arbol.getDato());

        if (arbol.tieneHijoDerecho()){
            inOrder(arbol.getHijoDerecho());
        }
    }
    public void postOrder(ArbolBinario<T>arbol){
        if (arbol.tieneHijoIzquierdo()){
            inOrder(arbol.getHijoIzquierdo());
        }
        if (arbol.tieneHijoDerecho()){
            inOrder(arbol.getHijoDerecho());
        }
        System.out.println(arbol.getDato());
    }
}
