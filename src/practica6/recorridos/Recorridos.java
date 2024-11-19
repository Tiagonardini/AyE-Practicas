package practica6.recorridos;

import practica1.ejercicio3.ColaGenerica;
import practica6.tp01.ListaEnlazadaGenerica;
import practica6.tp01.ListaGenerica;
import practica6.tp06.Arista;
import practica6.tp06.Grafo;
import practica6.tp06.Vertice;


public class Recorridos<T> {
    public ListaGenerica<Vertice<T>> verticeMayorAOpcionB(Grafo<T>grafo, int cantidadVertices){
        ListaGenerica<Vertice<T>> verticesQueCumplenCondicion = new ListaEnlazadaGenerica<>();
        ListaGenerica<Vertice<T>> verticesDelGrafo = grafo.listaDeVertices();
        if (!verticesDelGrafo.esVacia()) {
            for (int pos = 1; pos <= verticesDelGrafo.tamanio(); pos++) {
                Vertice<T> verticeActual = verticesDelGrafo.elemento(pos);
                if (grafo.listaDeAdyacentes(verticeActual).tamanio() > cantidadVertices) {
                    verticesQueCumplenCondicion.agregarFinal(verticeActual);
                }
            }
        }else {
            return verticesQueCumplenCondicion;
        }
        return verticesQueCumplenCondicion;
    }

    public ListaGenerica<Vertice<T>> verticeMayorA(Grafo<T> grafo, int cantVertices){
        ListaGenerica<Vertice<T>> verticesConMasAdyacentes = new ListaEnlazadaGenerica<>();
        ListaGenerica<Vertice<T>> verticesDelGrafo = grafo.listaDeVertices();
        if (!verticesDelGrafo.esVacia()){
            boolean[] elVerticeFueVisitadoEn = new boolean[verticesDelGrafo.tamanio()+1];
            verticesDelGrafo.comenzar();
            for (int pos = 1; pos<=verticesDelGrafo.tamanio(); pos++){
                Vertice<T> verticeActual = verticesDelGrafo.elemento(pos);
                if (!elVerticeFueVisitadoEn[pos] && verticeActual!= null) {
                    verticeMayorARecursivo(grafo, verticeActual, verticesConMasAdyacentes, elVerticeFueVisitadoEn, cantVertices);
                }
            }
        }
        return verticesConMasAdyacentes;
    }

    private void verticeMayorARecursivo(Grafo<T> grafo, Vertice<T> verticeActual,  ListaGenerica<Vertice<T>> verticesConMasAdyacentes, boolean[] elVerticeFueVisitadoEn, int cantVertices) {
        ListaGenerica<Arista<T>> adyacentes = grafo.listaDeAdyacentes(verticeActual);
        elVerticeFueVisitadoEn[verticeActual.getPosicion()] = true;
        if (adyacentes.tamanio() > cantVertices) {
            verticesConMasAdyacentes.agregarFinal(verticeActual);
            for (int posicion = 1; posicion <= adyacentes.tamanio(); posicion++) {
                Arista<T> arista = adyacentes.elemento(posicion);
                if (arista.verticeDestino() != null) {
                    if (!elVerticeFueVisitadoEn[arista.verticeDestino().getPosicion()]) {
                        verticeMayorARecursivo(grafo, arista.verticeDestino(), verticesConMasAdyacentes, elVerticeFueVisitadoEn, cantVertices);
                    }
                }
            }
        }
    }
    private void dfsRecursivo(Grafo<T> grafo, Vertice<T> vertice, boolean[] elVerticeFueVisitadoEn, ListaGenerica<Vertice<T>> recorrido, int posicion) {
        elVerticeFueVisitadoEn[vertice.getPosicion()] = true;
        recorrido.agregarFinal(vertice);

        ListaGenerica<Arista<T>> adyacentesDelVertice = grafo.listaDeAdyacentes(vertice);

        for (int posicionAux = 1; posicionAux <= adyacentesDelVertice.tamanio(); posicionAux++) {
            Arista<T> arista = adyacentesDelVertice.elemento(posicionAux);
            int posicionVerticeArista = arista.verticeDestino().getPosicion();
            if (!elVerticeFueVisitadoEn[posicionVerticeArista] && arista != null) {
                dfsRecursivo(grafo, arista.verticeDestino(), elVerticeFueVisitadoEn, recorrido, posicionVerticeArista);
            }
        }
    }

    public ListaGenerica<Vertice<T>> dfs (Grafo<T> grafo){
        ListaGenerica<Vertice<T>> recorrido = new ListaEnlazadaGenerica<>();
        ListaGenerica<Vertice<T>> verticesDelGrafo = grafo.listaDeVertices();
        if (!verticesDelGrafo.esVacia()){
            boolean[] elVerticeFueVisitadoEn = new boolean[verticesDelGrafo.tamanio()+1];
            verticesDelGrafo.comenzar();
            for (int posicion = 1; posicion <= verticesDelGrafo.tamanio(); posicion++){
                Vertice<T> vertice = verticesDelGrafo.elemento(posicion);
                if (!elVerticeFueVisitadoEn[posicion] && vertice!=null){
                    System.out.println("Iniciando DFS en el vertice: "+vertice.dato());
                    dfsRecursivo(grafo, vertice, elVerticeFueVisitadoEn, recorrido, posicion);
                }
            }
        }else{
            return recorrido;
        }
        return recorrido;
    }



    public ListaGenerica<Vertice<T>> bfs (Grafo<T> grafo){
        ColaGenerica<Vertice<T>> cola = new ColaGenerica<>();
        ListaGenerica<Vertice<T>> recorrido = new ListaEnlazadaGenerica<>();
        boolean [] elVerticeFueVisitado = new boolean[grafo.listaDeVertices().tamanio()+1];
        for (int i = 1; i<=grafo.listaDeVertices().tamanio(); i++){
            grafo.listaDeVertices().comenzar();
            Vertice<T> vertice = grafo.vertice(i);
            if (!elVerticeFueVisitado[vertice.getPosicion()]){
                bfsAuxiliar(grafo, cola,vertice, elVerticeFueVisitado, recorrido);
            }
        }
        return recorrido;
    }

    private void bfsAuxiliar(Grafo<T> grafo, ColaGenerica<Vertice<T>> cola, Vertice<T> vertice, boolean[] elVerticeFueVisitado, ListaGenerica<Vertice<T>> recorrido) {
        cola.encolar(vertice);
        elVerticeFueVisitado[vertice.getPosicion()] = true;

        while (!cola.esVacia()){
            Vertice<T> verticeActual = cola.desencolar();
            recorrido.agregarFinal(verticeActual);
            for (int i = 1; i <= grafo.listaDeAdyacentes(verticeActual).tamanio(); i++){
                Arista<T> arista = grafo.listaDeAdyacentes(verticeActual).elemento(i);
                Vertice<T> destino = arista.verticeDestino();
                if (!elVerticeFueVisitado[destino.getPosicion()]){
                    cola.encolar(destino);
                    elVerticeFueVisitado[destino.getPosicion()] = true;
                }
            }
        }
    }



}
