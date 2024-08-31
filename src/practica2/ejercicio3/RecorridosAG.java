package practica2.ejercicio3;
import practica1.ejercicio3.ColaGenerica;
import practica1.ejercicio3.ListaEnlazadaGenerica;
import practica1.ejercicio3.ListaGenerica;

public class RecorridosAG {

    public ListaGenerica<Integer> numerosImparesMayoresQuePreOrden(ArbolGeneral<Integer> a, Integer n){
        ListaGenerica<ArbolGeneral<Integer>> listaHijos = new ListaEnlazadaGenerica<>();
        ListaEnlazadaGenerica<Integer> listaNumeros = new ListaEnlazadaGenerica<>();
        var dato = a.getDato();
//        if (esImparYMayorQue(n, dato)){
            listaNumeros.agregarInicio(dato);
//        }
        listaHijos = a.getHijos();
        listaHijos.comenzar();

        if (!listaHijos.esVacia()) { // Verificar que la lista no esté vacía antes de comenzar
            listaHijos.comenzar();
            while (!listaHijos.fin()) {
                ArbolGeneral<Integer> nodoArbol = listaHijos.proximo();
                agregarLista(numerosImparesMayoresQuePreOrden(nodoArbol, n), listaNumeros);
            }
        }
        return listaNumeros;
    }

    public ListaGenerica< Integer > numerosImparesMayoresQuePostOrden(ArbolGeneral <Integer> a, Integer n){
        ListaEnlazadaGenerica<Integer> listaNumeros = new ListaEnlazadaGenerica<>();
        ListaGenerica<ArbolGeneral<Integer>> listaHijos = a.getHijos();
        listaHijos.comenzar();
        while (!listaHijos.fin()){
            ArbolGeneral<Integer>nodoArbol = listaHijos.proximo();
            agregarLista(numerosImparesMayoresQuePostOrden(nodoArbol,n), listaNumeros);
        }

        //if (esImparYMayorQue(a.getDato(), n)){
            listaNumeros.agregarFinal(a.getDato());
        //}

        return listaNumeros;
    }

    public ListaGenerica<Integer> numerosImparesMayoresQueInOrder(ArbolGeneral<Integer> a, Integer n) {
        ListaEnlazadaGenerica<Integer> listaNumeros = new ListaEnlazadaGenerica<>();

        // 1. Recorrer el primer hijo (si existe)
        ListaGenerica<ArbolGeneral<Integer>> hijos = a.getHijos();
        hijos.comenzar();
        if (!hijos.fin()) {
            ArbolGeneral<Integer> primerHijo = hijos.proximo();
            agregarLista(numerosImparesMayoresQueInOrder(primerHijo, n), listaNumeros);
        }

        // 2. Procesar el nodo actual
//        if (esImparYMayorQue(a.getDato(), n)) {
            listaNumeros.agregarFinal(a.getDato());
//        }

        // 3. Recorrer los demás hijos (si existen)
        while (!hijos.fin()) {
            ArbolGeneral<Integer> otroHijo = hijos.proximo();
            agregarLista(numerosImparesMayoresQueInOrder(otroHijo, n), listaNumeros);
        }

        return listaNumeros;
    }



    public ListaGenerica< Integer > numerosImparesMayoresQuePorNiveles(ArbolGeneral <Integer> a, Integer n) {
         ListaEnlazadaGenerica<Integer>listaNumeros = new ListaEnlazadaGenerica<>();
         ColaGenerica<ArbolGeneral<Integer>> cola = new ColaGenerica<>();

         cola.encolar(a);

         while (!cola.esVacia()){
             ArbolGeneral<Integer> nodoActual = cola.desencolar();
             if (esImparYMayorQue(nodoActual.getDato(), n)){
                 listaNumeros.agregarFinal(nodoActual.getDato());
             }


             ListaGenerica<ArbolGeneral<Integer>> listaHijos = nodoActual.getHijos();
             listaHijos.comenzar();
             while (!listaHijos.fin()){
                 cola.encolar(listaHijos.proximo());
             }
         }
         return listaNumeros;
    }


    private boolean esImparYMayorQue(Integer dato, Integer n) {
        return dato % 2 != 0 && dato > n;
    }

    private void agregarLista(ListaGenerica<Integer> listaOrigen, ListaEnlazadaGenerica<Integer> listaDestino) {
        listaOrigen.comenzar();
        while (!listaOrigen.fin()) {
            listaDestino.agregarFinal(listaOrigen.proximo());
        }
    }





    public static void main(String[] args) {
        var recorridoAg = new RecorridosAG();

        ArbolGeneral<Integer> arbol = new ArbolGeneral<>(10);
        ArbolGeneral<Integer> hijo1 = new ArbolGeneral<>(5);
        ArbolGeneral<Integer> hijo2 = new ArbolGeneral<>(15);
        ArbolGeneral<Integer> hijo3 = new ArbolGeneral<>(20);
        ArbolGeneral<Integer> hijo1_1 = new ArbolGeneral<>(3);
        ArbolGeneral<Integer> hijo1_2 = new ArbolGeneral<>(7);
        ArbolGeneral<Integer> hijo2_1 = new ArbolGeneral<>(17);

        hijo1.agregarHijo(hijo1_1);
        hijo1.agregarHijo(hijo1_2);
        hijo2.agregarHijo(hijo2_1);

        arbol.agregarHijo(hijo1);
        arbol.agregarHijo(hijo2);
        arbol.agregarHijo(hijo3);

        var resultado = recorridoAg.numerosImparesMayoresQuePorNiveles(arbol, 10);

        resultado.comenzar();
        while (!resultado.esVacia()) {
            if(!resultado.fin()) {
                System.out.println(resultado.proximo());
            }
        }
    }

}
