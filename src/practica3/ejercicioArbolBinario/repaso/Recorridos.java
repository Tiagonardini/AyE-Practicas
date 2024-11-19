package practica3.ejercicioArbolBinario.repaso;

import practica1.ejercicio3.ColaGenerica;
import practica3.ejercicioArbolBinario.ArbolBinario;

public class Recorridos<T> {

    public void recorridoPreOrder(ArbolBinario<T> ab){
        System.out.println(ab.getDato());
        if (ab.tieneHijoIzquierdo()){
            recorridoPreOrder(ab.getHijoIzquierdo());
        }
        if (ab.tieneHijoDerecho()){
            recorridoPreOrder(ab.getHijoDerecho());
        }
    }

    public void recorridoInOrder(ArbolBinario<T> ab){
        if (ab.tieneHijoIzquierdo()){
            recorridoInOrder(ab.getHijoIzquierdo());
        }
        System.out.println(ab.getDato());
        if (ab.tieneHijoDerecho()){
            recorridoInOrder(ab.getHijoDerecho());
        }
    }
    public void recorridoPostOrder(ArbolBinario<T> ab){
        if (ab.tieneHijoIzquierdo()){
            recorridoInOrder(ab.getHijoIzquierdo());
        }
        if (ab.tieneHijoDerecho()){
            recorridoInOrder(ab.getHijoDerecho());
        }
        System.out.println(ab.getDato());
    }

    public void recorridoPorNiveles(ArbolBinario<T> ab){
        ColaGenerica<ArbolBinario<T>> cola = new ColaGenerica<>();
        cola.encolar(ab);
        while (!cola.esVacia()) {
            ArbolBinario<T> abAux = cola.desencolar();
            System.out.println(abAux.getDato());
            if (abAux.tieneHijoIzquierdo()){
                cola.encolar(abAux.getHijoIzquierdo());
            }
            if (abAux.tieneHijoDerecho()){
                cola.encolar(abAux.getHijoDerecho());
            }
        }
    }



}
