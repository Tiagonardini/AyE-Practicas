package practica6.estructuras;

import practica6.tp01.ListaEnlazadaGenerica;
import practica6.tp01.ListaGenerica;
import practica6.tp06.Arista;
import practica6.tp06.Vertice;

public class VerticeImplListaAdy<T> implements Vertice<T> {
    private T dato;
    private int posicion;
    private ListaGenerica<Arista<T>> adyacentes;

    public VerticeImplListaAdy(T dato) {
        this.dato = dato;
        this.adyacentes = new ListaEnlazadaGenerica<>();
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

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    public ListaGenerica<Arista<T>> getAdyacentes() {
        return this.adyacentes;
    }

    public void conectar(Vertice<T> destino) {
        this.adyacentes.agregarFinal(new AristaImpl<>(destino, 1));  // Conexión sin peso específico
    }

    public void conectar(Vertice<T> destino, int peso) {
        this.adyacentes.agregarFinal(new AristaImpl<>(destino, peso));  // Conexión con peso específico
    }

    public void desconectar(Vertice<T> destino) {
        for (int i = 0; i < adyacentes.tamanio(); i++) {
            if (adyacentes.elemento(i).verticeDestino().equals(destino)) {
                adyacentes.eliminarEn(i);
            }
        }
    }

    public boolean esAdyacente(Vertice<T> destino) {
        for (int i = 0; i < adyacentes.tamanio(); i++) {
            if (adyacentes.elemento(i).verticeDestino().equals(destino)) {
                return true;
            }
        }
        return false;
    }

    public int peso(Vertice<T> destino) {
        for (int i = 0; i < adyacentes.tamanio(); i++) {
            Arista<T> arista = adyacentes.elemento(i);
            if (arista.verticeDestino().equals(destino)) {
                return arista.peso();
            }
        }
        return 0;
    }

    public Arista<T> obtenerArista(Vertice<T> destino) {
        for (int i = 0; i < adyacentes.tamanio(); i++) {
            Arista<T> arista = adyacentes.elemento(i);
            if (arista.verticeDestino().equals(destino)) {
                return arista;
            }
        }
        return null;
    }
}
