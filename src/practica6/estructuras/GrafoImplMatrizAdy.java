package practica6.estructuras;

import practica6.tp01.ListaEnlazadaGenerica;
import practica6.tp01.ListaGenerica;
import practica6.tp06.Arista;
import practica6.tp06.Grafo;
import practica6.tp06.Vertice;

public class GrafoImplMatrizAdy<T> implements Grafo<T> {
    private int maxVertices;
    private ListaGenerica<Vertice<T>> listaDeVertices;
    private int [][] matrizAdy;

    public GrafoImplMatrizAdy(int maxVertices){
        this.maxVertices = maxVertices;
        this.listaDeVertices = new ListaEnlazadaGenerica<>();
        this.matrizAdy = new int [maxVertices][maxVertices];

        for (int i = 0; i < maxVertices; i++) { // se inicializa la matriz vacia
            for (int j = 0; j < maxVertices; j++) {
                matrizAdy[i][j] = 0;
            }
        }

    }

    @Override
    public void agregarVertice(Vertice<T> v) {
        if (v == null) {
            System.out.println("Error: El vértice es nulo.");
            return;
        }
        if (listaDeVertices.tamanio() < maxVertices && !listaDeVertices.incluye(v)) {
            v.setPosicion(listaDeVertices.tamanio() + 1); // Comenzar posiciones desde 1
            listaDeVertices.agregarFinal(v);
            System.out.println("El nodo: " + v.dato() + " se encuentra en la posición: " + v.getPosicion());

            // Imprimir todos los vértices después de la adición, empezando desde 1
            System.out.print("Lista de vértices: ");
            for (int i = 1; i < listaDeVertices.tamanio() + 1; i++) {
                Vertice<T> vertice = listaDeVertices.elemento(i);
                if (vertice != null) {
                    System.out.print(vertice.dato() + " ");
                } else {
                    System.out.print("null ");
                }
            }
            System.out.println();
        } else {
            System.out.println("Error: El vértice ya existe o se alcanzó el límite máximo.");
        }
    }





    @Override
    public void eliminarVertice(Vertice<T> v) {
        if (listaDeVertices().incluye(v)){

            listaDeVertices().eliminar(v);
        }
    }

    @Override
    public void conectar(Vertice<T> origen, Vertice<T> destino) {
        if (listaDeVertices().incluye(origen) && listaDeVertices().incluye(destino)) {
            int i = origen.getPosicion();
            int j = destino.getPosicion();
            matrizAdy[i][j] = 1;
            System.out.println("Conectado: " + origen.dato() + " -> " + destino.dato());
        } else {
            System.out.println("Error: Uno o ambos vértices no existen en el grafo.");
        }
    }

    @Override
    public void conectar(Vertice<T> origen, Vertice <T>destino, int peso) {
        if (listaDeVertices().incluye(origen) && listaDeVertices().incluye(destino)){
            int i = origen.getPosicion();
            int j = destino.getPosicion();
            matrizAdy[i][j] = peso;
        }
    }

    @Override
    public void desConectar(Vertice<T> origen, Vertice<T>destino) {
        if (listaDeVertices().incluye(origen) && listaDeVertices().incluye(destino)){
            int i = origen.getPosicion();
            int j = destino.getPosicion();
            matrizAdy[i][j] = 0;
        }
    }

    @Override
    public boolean esAdyacente(Vertice<T> origen, Vertice<T> destino) {
        if (listaDeVertices().incluye(origen) && listaDeVertices().incluye(destino)){
            int i = origen.getPosicion();
            int j = destino.getPosicion();
            return matrizAdy[i][j] != 0;
        }
        return false;
    }

    @Override
    public int peso(Vertice<T> origen, Vertice<T> destino) {
        if (listaDeVertices().incluye(origen) && listaDeVertices().incluye(destino)){
            int i = origen.getPosicion();
            int j = destino.getPosicion();
            return matrizAdy[i][j];
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
        ListaGenerica<Arista<T>> listasDeAristasDeUnVertice = new ListaEnlazadaGenerica<>();
        if (v == null) {
            System.out.println("Error: el vértice proporcionado es nulo.");
            return listasDeAristasDeUnVertice;
        }
        int i = v.getPosicion();
        for (int j = 0; j < maxVertices; j++) {
            if (this.matrizAdy[i][j] != 0) { // Hay una conexión válida
                Vertice<T> verticeDestino = listaDeVertices.elemento(j);
                if (verticeDestino != null) {
                    int peso = this.matrizAdy[i][j];
                    Arista<T> arista = new AristaImpl<>(verticeDestino, peso);
                    listasDeAristasDeUnVertice.agregarFinal(arista);
                    System.out.println("Conexión encontrada: " + v.dato() + " -> " + verticeDestino.dato() + " con peso " + peso);
                }
            }
        }
        return listasDeAristasDeUnVertice;
    }



    @Override
    public Vertice<T> vertice(int posicion) {
        return listaDeVertices().elemento(posicion) ;
    }

    public void mostrarVertices() {
        System.out.println("Lista de vértices en el grafo:");
        for (int i = 1; i < listaDeVertices.tamanio() + 1; i++) {
            Vertice<T> vertice = listaDeVertices.elemento(i);
            if (vertice != null) {
                System.out.println("Posición " + i + ": " + vertice.dato());
            } else {
                System.out.println("Posición " + i + ": null");
            }
        }
    }

}
