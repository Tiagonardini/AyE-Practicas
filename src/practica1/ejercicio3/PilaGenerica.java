package practica1.ejercicio3;

public class PilaGenerica<T> extends ListaGenerica<T> {
    private NodoGenerico<T> tope;
    private int tamanio;

    public PilaGenerica() {
        this.tope = null;
        this.tamanio = 0;
    }

    @Override
    public void comenzar() {
        // Resetea el tope para comenzar desde el inicio
        // en un recorrido o iteración.
    }

    @Override
    public T proximo() {
        if (tope != null) {
            T dato = tope.getDato();
            tope = tope.getSiguiente();
            return dato;
        }
        return null;
    }

    @Override
    public boolean fin() {
        return tope == null;
    }

    @Override
    public T elemento(int pos) {
        if (pos >= 0 && pos < tamanio) {
            NodoGenerico<T> actual = tope;
            for (int i = 0; i < pos; i++) {
                actual = actual.getSiguiente();
            }
            return actual.getDato();
        }
        return null;
    }

    @Override
    public boolean agregarEn(T elem, int pos) {
        if (pos < 0 || pos > tamanio) {
            return false;
        }

        NodoGenerico<T> nuevoNodo = new NodoGenerico<>(elem);
        if (pos == 0) {
            nuevoNodo.setSiguiente(tope);
            tope = nuevoNodo;
        } else {
            NodoGenerico<T> actual = tope;
            for (int i = 0; i < pos - 1; i++) {
                actual = actual.getSiguiente();
            }
            nuevoNodo.setSiguiente(actual.getSiguiente());
            actual.setSiguiente(nuevoNodo);
        }
        tamanio++;
        return true;
    }

    @Override
    public boolean agregarInicio(T elem) {
        return agregarEn(elem, 0);
    }

    @Override
    public boolean agregarFinal(T elem) {
        return agregarEn(elem, tamanio);
    }

    @Override
    public boolean eliminar(T elem) {
        if (tope == null) {
            return false;
        }

        if (tope.getDato().equals(elem)) {
            tope = tope.getSiguiente();
            tamanio--;
            return true;
        }

        NodoGenerico<T> actual = tope;
        while (actual.getSiguiente() != null && !actual.getSiguiente().getDato().equals(elem)) {
            actual = actual.getSiguiente();
        }

        if (actual.getSiguiente() != null) {
            actual.setSiguiente(actual.getSiguiente().getSiguiente());
            tamanio--;
            return true;
        }
        return false;
    }

    @Override
    public boolean eliminarEn(int pos) {
        if (pos < 0 || pos >= tamanio) {
            return false;
        }

        if (pos == 0) {
            tope = tope.getSiguiente();
            tamanio--;
            return true;
        }

        NodoGenerico<T> actual = tope;
        for (int i = 0; i < pos - 1; i++) {
            actual = actual.getSiguiente();
        }

        actual.setSiguiente(actual.getSiguiente().getSiguiente());
        tamanio--;
        return true;
    }

    @Override
    public boolean incluye(T elem) {
        NodoGenerico<T> actual = tope;
        while (actual != null) {
            if (actual.getDato().equals(elem)) {
                return true;
            }
            actual = actual.getSiguiente();
        }
        return false;
    }

    @Override
    public boolean esVacia() {
        return false;
    }

    @Override
    public int tamanio() {
        return this.tamanio;
    }

    @Override
    public boolean reemplazarEn(T elem, int pos) {
        if (pos < 0 || pos >= tamanio) {
            return false;
        }

        NodoGenerico<T> actual = tope;
        for (int i = 0; i < pos; i++) {
            actual = actual.getSiguiente();
        }

        actual.setDato(elem);
        return true;
    }

    @Override
    public ListaGenerica<T> clonar() {
        PilaGenerica<T> nuevaPila = new PilaGenerica<>();
        NodoGenerico<T> actual = tope;
        while (actual != null) {
            nuevaPila.agregarFinal(actual.getDato());
            actual = actual.getSiguiente();
        }
        return nuevaPila;
    }

    @Override
    public boolean agregar(T[] arreglo) {
        for (T elem : arreglo) {
            agregarFinal(elem);
        }
        return true;
    }
}
