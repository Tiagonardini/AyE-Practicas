package practica3.ejercicioArbolBinarioDeBusqueda;


import practica1.ejercicio3.ListaEnlazadaGenerica;
import practica1.ejercicio3.ListaGenerica;

public class ArbolBinarioDeBusqueda<T extends Comparable<T>>{
    private T dato;
    private ArbolBinarioDeBusqueda<T> hijoIzquierdo;
    private ArbolBinarioDeBusqueda<T> hijoDerecho;

    // Constructor por defecto
    public ArbolBinarioDeBusqueda() {
        super();
    }

    // Constructor con dato inicial
    public ArbolBinarioDeBusqueda(T dato) {
        this.dato = dato;
    }

    // Getters y setters para el dato
    public T getDato() {
        return dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }

    // Preguntar antes de invocar si tieneHijoIzquierdo()
    public ArbolBinarioDeBusqueda<T> getHijoIzquierdo() {
        return this.hijoIzquierdo;
    }

    public ArbolBinarioDeBusqueda<T> getHijoDerecho() {
        return this.hijoDerecho;
    }

    // Setters privados para los hijos izquierdo y derecho
    private void setHijoIzquierdo(ArbolBinarioDeBusqueda<T> hijo) {
        this.hijoIzquierdo = hijo;
    }

    private void setHijoDerecho(ArbolBinarioDeBusqueda<T> hijo) {
        this.hijoDerecho = hijo;
    }

    // Verifica si el árbol incluye un dato
    public boolean incluye(Comparable<T> dato) {
        return this.buscar(dato, this) != null;
    }

    // Metodo para buscar un dato en el árbol
    public ArbolBinarioDeBusqueda<T> buscar(Comparable<T> x, ArbolBinarioDeBusqueda<T> arbol) {
        if (arbol != null) {
            if (x.compareTo(arbol.getDato()) < 0) {
                arbol = this.buscar(x, arbol.getHijoIzquierdo());
            } else if (x.compareTo(arbol.getDato()) > 0) {
                arbol = this.buscar(x, arbol.getHijoDerecho());
            }
            // Si los valores son iguales, se ha encontrado el dato
            return arbol;
        } else {
            return null; // No se encontró el dato
        }
    }

    // Metodo para agregar un dato al árbol
    public void agregar(Comparable<T> dato) {
        agregar(dato, this);
    }

    // Metodo privado para agregar un dato en una posición específica del árbol
    private void agregar(Comparable<T> dato, ArbolBinarioDeBusqueda<T> arbol) {
        if (arbol.dato == null) {
            arbol.dato = (T) dato;
        } else {
            if (dato.compareTo(arbol.dato) < 0) { // indica que el parametro es mayor que el objeto recepetor
                if (arbol.hijoIzquierdo == null) {
                    arbol.hijoIzquierdo = new ArbolBinarioDeBusqueda<>((T) dato);
                } else {
                    arbol.hijoIzquierdo.agregar(dato);
                }
            } else if (dato.compareTo(arbol.dato) > 0) {
                if (arbol.hijoDerecho == null) {
                    arbol.hijoDerecho = new ArbolBinarioDeBusqueda<>((T) dato);
                } else {
                    arbol.hijoDerecho.agregar(dato);
                }
            }
        }
    }

    // Buscar el mayor de los menores en el árbol
    public ArbolBinarioDeBusqueda<T> buscarMayorDeLosMenores(ArbolBinarioDeBusqueda<T> arbol) {
        if (arbol.tieneHijoIzquierdo()) {
            return buscarMayor(arbol.getHijoIzquierdo());
        }
        return arbol;
    }

    // Buscar el mayor valor en el árbol
    public ArbolBinarioDeBusqueda<T> buscarMayor(ArbolBinarioDeBusqueda<T> arbol) {
        if (!arbol.tieneHijoDerecho()) {
            return arbol;
        }
        return buscarMayor(arbol.getHijoDerecho());
    }

    // Buscar el menor de los mayores en el árbol
    public ArbolBinarioDeBusqueda<T> buscarMenorDeLosMayores(ArbolBinarioDeBusqueda<T> arbol) {
        if (!arbol.tieneHijoDerecho()) {
            return arbol;
        }
        return buscarMenor(arbol.getHijoDerecho());
    }

    // Buscar el menor valor en el árbol
    public ArbolBinarioDeBusqueda<T> buscarMenor(ArbolBinarioDeBusqueda<T> arbol) {
        if (!arbol.tieneHijoIzquierdo()) {
            return arbol;
        }
        return buscarMenor(arbol.getHijoIzquierdo());
    }

    // Metodo toString para representar el árbol
    @Override
    public String toString() {
        return this.getDato().toString();
    }

    // Verifica si el árbol está vacío
    public boolean esVacio() {
        return this.getDato() == null && !this.tieneHijoIzquierdo() && !this.tieneHijoDerecho();
    }

    // Verifica si el nodo es una hoja (no tiene hijos)
    public boolean esHoja() {
        return (!this.tieneHijoIzquierdo() && !this.tieneHijoDerecho());
    }

    public boolean tieneHijoIzquierdo() {
        return this.hijoIzquierdo != null;
    }

    public boolean tieneHijoDerecho() {
        return this.hijoDerecho != null;
    }

    //-------------------- a partir de aca metodos del ejercicio 9 para adelante -------------------
    // CONSULTAR CON GUILLE Y EL PROFE O LOS CHICOS
    public ListaGenerica<Integer> caminoRecorrido(ArbolBinarioDeBusqueda<Integer> nodoArbol, int nodoABuscar) {
        ListaGenerica<Integer> recorrido = new ListaEnlazadaGenerica<>();
        if (!nodoArbol.esVacio()){
            return caminoRecorridoRecursivo(nodoArbol, recorrido, nodoABuscar);
        }
        return null;
    }

    private ListaGenerica<Integer> caminoRecorridoRecursivo(ArbolBinarioDeBusqueda<Integer> nodoArbol, ListaGenerica<Integer> recorrido, int nodoABuscar) {
        if (!nodoArbol.esVacio()){
            if (nodoArbol.getDato() == nodoABuscar){
                return recorrido;
            }
            if (nodoArbol.tieneHijoIzquierdo()){
                recorrido.agregarFinal(-nodoArbol.getDato());
                caminoRecorridoRecursivo(nodoArbol.getHijoIzquierdo(), recorrido, nodoABuscar);
            }
            if (nodoArbol.tieneHijoIzquierdo()){
                recorrido.agregarFinal(nodoArbol.getDato());
                caminoRecorridoRecursivo(nodoArbol.getHijoDerecho(), recorrido, nodoABuscar);
            }
        }
        return null;
    }


//----------- EJERCICIO 10--------------------

//    public ArbolBinarioDeBusqueda<Integer> devolverNodoMayorInmediato(ArbolBinarioDeBusqueda<Integer> abb, Integer valorABuscar){
//
//    }
//    public ArbolBinarioDeBusqueda<Integer> devolverNodoMayorInmediatoAux(ArbolBinarioDeBusqueda<Integer> abb, Integer valorABuscar){
////        Integer comparacion = abb.getDato().compareTo(valorABuscar);
////
////        if (comparacion < 0){
////            if (tieneHijoDerecho()){
////                return devolverNodoMayorInmediatoAux(abb.getHijoDerecho(), valorABuscar);
////            }
////        }else if (comparacion > 0){
////            if (tieneHijoIzquierdo()){
////                return devolverNodoMayorInmediatoAux(abb.getHijoIzquierdo(), valorABuscar);
////            }
////        }if (comparacion == 0){
////            if (tieneHijoDerecho()){
////                return abb.getHijoDerecho();
////            }
////        }
////
////
////        return abb;
//    }
}
