package practica2.ejercicioDeRepaso;

import practica1.ejercicio3.ColaGenerica;
import practica1.ejercicio3.ListaEnlazadaGenerica;
import practica1.ejercicio3.ListaGenerica;
import practica2.ejercicio3.ArbolGeneral;

public class Recorridos<T> {
    public void recorridoPreOrder(ArbolGeneral<T> arbol){
        System.out.println(arbol.getDato());
        ListaGenerica<ArbolGeneral<T>> hijos = arbol.getHijos();
        if (!hijos.esVacia()){
            hijos.comenzar();
            while (!hijos.fin()){
                ArbolGeneral<T> nodoHijo = hijos.proximo();
                recorridoPreOrder(nodoHijo);
            }
        }
    }

    public void recorridoInOrder(ArbolGeneral<T> nodoArbol){
        ListaGenerica<ArbolGeneral<T>> hijos = nodoArbol.getHijos();
        hijos.comenzar();
        if(!hijos.fin()){
            recorridoInOrder(hijos.proximo());
        }
        System.out.println(nodoArbol.getDato());
        while (!hijos.fin()){
            recorridoInOrder(hijos.proximo());
        }
    }
    public void recorridoPostOrder(ArbolGeneral<T> nodoArbol){
        ListaGenerica<ArbolGeneral<T>> hijos = nodoArbol.getHijos();
        if (!hijos.esVacia()){
            hijos.comenzar();
            while (!hijos.fin()){
                ArbolGeneral<T> nodoHijo = hijos.proximo();
                recorridoPostOrder(nodoHijo);

            }
        }
        System.out.println(nodoArbol.getDato());
    }
    public void recorridoPorNiveles(ArbolGeneral<T> nodoArbol){
        ListaGenerica<ArbolGeneral<T>> listaHijos = new ListaEnlazadaGenerica<>();
        ColaGenerica<ArbolGeneral<T>> colaDeNodosDeArboles = new ColaGenerica<>();
        colaDeNodosDeArboles.encolar(nodoArbol);
        while (!colaDeNodosDeArboles.esVacia()){
            ArbolGeneral<T> nodoActual = colaDeNodosDeArboles.desencolar();
            System.out.println(nodoActual.getDato());
            listaHijos = nodoActual.getHijos();
            listaHijos.comenzar();
            while (!listaHijos.fin()){
                colaDeNodosDeArboles.encolar(listaHijos.proximo());
            }
        }
//        ColaGenerica<ArbolGeneral<T>> cola = new ColaGenerica<>();
//        cola.encolar(nodoArbol);
    }
    public ListaGenerica<Integer> numerosImparesMayoresQueEnRecorridoPreOrder(ArbolGeneral<Integer> arbol, Integer numero){
        ListaGenerica<Integer> listaDeNumerosMayoresQueNumero = new ListaEnlazadaGenerica<>();
        int dato = arbol.getDato();

        if (dato > numero && dato % 2 != 0 ){
            listaDeNumerosMayoresQueNumero.agregarFinal(dato);
            System.out.println("El numero agregado: "+dato);
        }

        ListaGenerica<ArbolGeneral<Integer>> listaDeLosHijosDelNodo = arbol.getHijos();
        if (!listaDeLosHijosDelNodo.esVacia()){
            listaDeLosHijosDelNodo.comenzar();
            while (!listaDeLosHijosDelNodo.fin()){
                numerosImparesMayoresQueEnRecorridoPreOrder(listaDeLosHijosDelNodo.proximo(), numero);
            }
        }
        return listaDeNumerosMayoresQueNumero;
    }

    public ListaGenerica<Integer>  numerosImparesMayoresQueEnRecorridoInOrder(ArbolGeneral<Integer> arbol, Integer numero){
        ListaGenerica<ArbolGeneral<Integer>> listaDeHijos = arbol.getHijos();
        ListaGenerica<Integer> listaARetornar = new ListaEnlazadaGenerica<>();
        listaDeHijos.comenzar();

        if (!listaDeHijos.esVacia()){
            numerosImparesMayoresQueEnRecorridoInOrder(listaDeHijos.proximo(), numero);
        }
        int dato = arbol.getDato();
        if (dato > numero && dato % 2 != 0 ){
            listaARetornar.agregarFinal(dato);
            System.out.println("El numero agregado: "+dato);
        }

        while (!listaDeHijos.fin()){
            numerosImparesMayoresQueEnRecorridoInOrder(listaDeHijos.proximo(), numero);
        }

        return listaARetornar;
    }

    public ListaGenerica<Integer> numerosImparesMayoresQueEnRecorridoPostOrder(ArbolGeneral<Integer> arbol, Integer numero){
        ListaGenerica<Integer> listaDeNumerosMayoresQueNumero = new ListaEnlazadaGenerica<>();
        ListaGenerica<ArbolGeneral<Integer>> listaDeLosHijosDelNodo = arbol.getHijos();
        if (!listaDeLosHijosDelNodo.esVacia()){
            listaDeLosHijosDelNodo.comenzar();
            while (!listaDeLosHijosDelNodo.fin()){
                numerosImparesMayoresQueEnRecorridoPostOrder(listaDeLosHijosDelNodo.proximo(), numero);
            }
        }
        int dato = arbol.getDato();

        if (dato > numero && dato % 2 != 0 ){
            listaDeNumerosMayoresQueNumero.agregarFinal(dato);
            System.out.println("El numero agregado: "+dato);
        }
        return listaDeNumerosMayoresQueNumero;
    }
    public ListaGenerica<Integer> numerosImparesMayoresQueEnRecorridoPorNiveles(ArbolGeneral<Integer> arbol, Integer numero) {
        ListaGenerica<Integer> listaDeNumerosMayoresQueNumero = new ListaEnlazadaGenerica<>();
        ListaGenerica<ArbolGeneral<Integer>> listaHijos = new ListaEnlazadaGenerica<>();
        ColaGenerica<ArbolGeneral<Integer>> cola = new ColaGenerica<>();
        cola.encolar(arbol);
        while (!cola.esVacia()) {
            ArbolGeneral<Integer> nodoArbol = cola.desencolar();
            int dato = nodoArbol.getDato();
            if (dato > numero && dato % 2 != 0) {
                listaDeNumerosMayoresQueNumero.agregarFinal(dato);
                System.out.println("El numero agregado: " + dato);
            }
            listaHijos = nodoArbol.getHijos();
            listaHijos.comenzar();
            while (!listaHijos.fin()) {
                cola.encolar(listaHijos.proximo());
            }


        }
        return listaDeNumerosMayoresQueNumero;
    }

}
