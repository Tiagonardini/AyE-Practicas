package practica6.estructuras;

import practica6.tp01.ListaEnlazadaGenerica;
import practica6.tp01.ListaGenerica;
import practica6.tp06.Arista;
import practica6.tp06.Grafo;
import practica6.tp06.Vertice;

public class GrafoImplListaAdy<T> implements Grafo<T> {
    private ListaGenerica<Vertice<T>> listaDeVertices;


    public GrafoImplListaAdy(){
        this.listaDeVertices = new ListaEnlazadaGenerica<>();
    }

    private VerticeImplListaAdy<T> buscarVertice(Vertice<T> v) {
        for (int i = 0; i < listaDeVertices.tamanio(); i++) {
            Vertice<T> verticeActual = listaDeVertices.elemento(i);
            if (verticeActual.equals(v)) {
                return (VerticeImplListaAdy<T>) verticeActual; // Se realiza un cast al tipo específico de vértice
            }
        }
        return null; // Si no se encuentra el vértice, se retorna null
    }


    @Override
    public void agregarVertice(Vertice<T> v) {
        if (!listaDeVertices().incluye(v)){
            v.setPosicion(listaDeVertices().tamanio());
            listaDeVertices().agregarFinal(v);
        }
    }

    @Override
    public void eliminarVertice(Vertice<T> v) { // se encarga de eliminar el nodo de la lista y de desconectar los vertices adyacentes que pertenecen a v
        if (listaDeVertices().incluye(v)){
            VerticeImplListaAdy<T> verticeAux = buscarVertice(v);
            for (int i = 0; i<verticeAux.getAdyacentes().tamanio(); i++){
                Vertice<T> verticeADesconectar = verticeAux.getAdyacentes().elemento(i).verticeDestino();
                desConectar(verticeAux, verticeADesconectar);
            }
            listaDeVertices().eliminar(v);
        }
    }

    @Override
    public void conectar(Vertice<T> origen, Vertice<T> destino) {
        if (listaDeVertices().incluye(origen) && listaDeVertices().incluye(destino)){
            VerticeImplListaAdy<T> origenAux = buscarVertice(origen);
            VerticeImplListaAdy<T> destinoAux = buscarVertice(origen);
            origenAux.conectar(destinoAux);
        }


    }

    @Override
    public void conectar(Vertice<T> origen, Vertice<T> destino, int peso) {
        if (listaDeVertices().incluye(origen) && listaDeVertices().incluye(destino)){
            VerticeImplListaAdy<T> origenAux = buscarVertice(origen);
            VerticeImplListaAdy<T> destinoAux = buscarVertice(origen);
            origenAux.conectar(destinoAux,peso);
        }
    }

    @Override
    public void desConectar(Vertice<T> origen, Vertice<T> destino) {
        if (listaDeVertices().incluye(origen) && listaDeVertices().incluye(destino)){
            VerticeImplListaAdy<T> origenAux = buscarVertice(origen);
            VerticeImplListaAdy<T> destinoAux = buscarVertice(origen);
            origenAux.desconectar(destinoAux);
        }
    }

    @Override
    public boolean esAdyacente(Vertice<T> origen, Vertice<T> destino) {
        if (listaDeVertices().incluye(origen) && listaDeVertices().incluye(destino)){
            VerticeImplListaAdy<T> origenAux = buscarVertice(origen);
            VerticeImplListaAdy<T> destinoAux = buscarVertice(origen);
            return origenAux.esAdyacente(destinoAux);
        }
        return false;
    }

    @Override
    public int peso(Vertice<T> origen, Vertice<T> destino) {
        if (listaDeVertices().incluye(origen) && listaDeVertices().incluye(destino)){
            VerticeImplListaAdy<T> origenAux = buscarVertice(origen);
            VerticeImplListaAdy<T> destinoAux = buscarVertice(origen);
            return origenAux.peso(destinoAux);
        }
        return 0;
    }

    @Override
    public boolean esVacio() {
        return listaDeVertices().esVacia();
    }

    @Override
    public ListaGenerica<Vertice<T>> listaDeVertices() {
        return this.listaDeVertices;
    }

    @Override
    public ListaGenerica<Arista<T>> listaDeAdyacentes(Vertice<T> v) {
        ListaGenerica<Arista<T>> listaAdyacentes = new ListaEnlazadaGenerica<>();
        if (listaDeVertices().incluye(v)){
            VerticeImplListaAdy<T> verticeAux = buscarVertice(v);
            listaAdyacentes = verticeAux.getAdyacentes();
        }
        return listaAdyacentes;
    }

    @Override
    public Vertice<T> vertice(int posicion) {
        return listaDeVertices().elemento(posicion);
    }
}
