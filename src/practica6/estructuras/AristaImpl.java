package practica6.estructuras;

import practica6.tp06.Arista;
import practica6.tp06.Vertice;

public class AristaImpl<T> implements Arista<T> {
    private Vertice<T> destino;
    private int peso;

    public AristaImpl(Vertice<T> destino, int peso){
        this.destino = destino;
        this.peso = peso;
    }


    @Override
    public Vertice<T> verticeDestino() {
        return this.destino;
    }

    @Override
    public int peso() {
        return this.peso;
    }
}
