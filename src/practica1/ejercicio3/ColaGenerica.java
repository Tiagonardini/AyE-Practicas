package practica1.ejercicio3;


public class ColaGenerica<T> {
    private ListaGenerica<T> datos;

    public ColaGenerica() {
        this.datos = new ListaEnlazadaGenerica<>();

    }

    public void encolar(T elem) {
        datos.agregarFinal(elem);

    }

    public T desencolar() {
        if (esVacia()) {
            return null; // O lanzar una excepción si prefieres
        }
        T elem = datos.elemento(1); // Obtiene el primer elemento
        datos.eliminarEn(1); // Elimina el primer elemento

        return elem;
    }

    public T tope() {
        if (esVacia()) {
            return null; // O lanzar una excepción si prefieres
        }
        T elem = datos.elemento(1); // Obtiene el primer elemento

        return elem;
    }

    public boolean esVacia() {
        boolean vacia = datos.esVacia();

        return vacia;
    }
}
