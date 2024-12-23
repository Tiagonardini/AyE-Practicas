package practica6.estructuras;

import practica6.tp06.Vertice;

public class VerticeImplMatrizAdy<T> implements Vertice<T> {
    private T dato;
    private int posicion;

    public VerticeImplMatrizAdy(T dato){
        this.dato = dato;
    }


    @Override
    public T dato() {
        return this.dato;
    }

    @Override
    public void setDato(T dato) {
        this.dato = dato;
    }

    @Override
    public int getPosicion() {
        return this.posicion;
    }
    @Override
    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

}
