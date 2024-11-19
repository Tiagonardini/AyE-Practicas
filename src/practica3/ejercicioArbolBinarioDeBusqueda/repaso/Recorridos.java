package practica3.ejercicioArbolBinarioDeBusqueda.repaso;

import practica1.ejercicio3.ListaEnlazadaGenerica;
import practica1.ejercicio3.ListaGenerica;
import practica3.ejercicioArbolBinarioDeBusqueda.ArbolBinarioDeBusqueda;

public class Recorridos {
    public ListaGenerica<Integer> caminoRecorrido(ArbolBinarioDeBusqueda<Integer> nodoArbol, int nodoABuscar) {
        ListaGenerica<Integer> recorrido = new ListaEnlazadaGenerica<>();
        int raizDelArbol = nodoArbol.getDato();
        if (!nodoArbol.esVacio()){
            return caminoRecorridoRecursivo(nodoArbol, recorrido, nodoABuscar, raizDelArbol);
        }
        return recorrido;
    }

    private ListaGenerica<Integer> caminoRecorridoRecursivo(ArbolBinarioDeBusqueda<Integer> nodoArbol, ListaGenerica<Integer> recorrido, int nodoABuscar, int raiz) {
        if (nodoArbol.getDato() == nodoABuscar){
            return recorrido;
        }
        if (nodoABuscar < nodoArbol.getDato()){
            if (nodoArbol.tieneHijoIzquierdo()){
                if (nodoArbol.getDato().equals(raiz)){
                    recorrido.agregarFinal(nodoArbol.getDato());
                    caminoRecorridoRecursivo(nodoArbol.getHijoIzquierdo(), recorrido, nodoABuscar, raiz);
                }else {
                    recorrido.agregarFinal(-nodoArbol.getDato());
                    caminoRecorridoRecursivo(nodoArbol.getHijoIzquierdo(), recorrido, nodoABuscar, raiz);
                }
            }
        }
        else if (nodoABuscar > nodoArbol.getDato()){
            if (nodoArbol.tieneHijoDerecho()){
                recorrido.agregarFinal(nodoArbol.getDato());
                caminoRecorridoRecursivo(nodoArbol.getHijoDerecho(), recorrido, nodoABuscar,raiz);
            }
        }
        return recorrido;
    }

    public ArbolBinarioDeBusqueda<Integer> devolverMaximoNodoCercanoA(ArbolBinarioDeBusqueda<Integer> abb, int nodoABuscar){
        if (abb.getDato() == nodoABuscar){
            if (abb.tieneHijoDerecho()){
                return abb.getHijoDerecho();
            }else{
                return new ArbolBinarioDeBusqueda<>(-1);
            }
        }
        if (abb.getDato() < nodoABuscar){
            if (abb.tieneHijoDerecho()){
                return devolverMaximoNodoCercanoA(abb.getHijoDerecho(), nodoABuscar);
            }
        }
        if (abb.getDato() > nodoABuscar){
            if (abb.tieneHijoIzquierdo()) {
                return devolverMaximoNodoCercanoA(abb.getHijoIzquierdo(), nodoABuscar);
            }
        }


        return abb;
    }
}
