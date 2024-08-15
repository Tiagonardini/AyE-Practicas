package practica1.ejercicio3;

public class ColaGenerica<T> extends ListaGenerica<T> {
    private NodoGenerico<T> frente;
    private NodoGenerico<T> fondo;
    private int tamanio;

    public ColaGenerica(){
        this.frente = null;
        this.fondo = null;
        this.tamanio = 0;
    }

    public void encolar (T elem){
        NodoGenerico<T> nodoNuevo = new NodoGenerico<>(elem);
        if (this.fondo == null){
            this.frente = nodoNuevo;
            this.fondo = nodoNuevo;
        }else {
            this.fondo.setSiguiente(nodoNuevo);
            this.fondo = nodoNuevo;
        }
        tamanio++;
    }

    public T desencolar(){
        if(!esVacia()){
            throw new RuntimeException("No hay nodo en la cola para desencolar");
        }
        T dato = this.frente.getDato();
        this.frente = this.frente.getSiguiente();
        if (this.frente == null){
            this.fondo = null;
        }
        return dato;
    }

    public T tope(){
        if (esVacia()){
            throw new RuntimeException("error en la cola");
        }
        return this.frente.getDato();
    }
    @Override
    public boolean esVacia() {
        return this.frente == null;
    }

    @Override
    public void comenzar() {
        this.fondo = this.frente;
    }

    @Override
    public T proximo() {
        if (frente != null) {
            T dato = frente.getDato();
            frente = frente.getSiguiente();
            tamanio--;
            if (frente == null) {
                fondo = null;
            }
            return dato;
        }
        return null;
    }

    @Override
    public boolean fin() {
        return frente == null;
    }

    @Override
    public T elemento(int pos) {
        if (pos >= 0 && pos < tamanio) {
            NodoGenerico<T> actual = frente;
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
            nuevoNodo.setSiguiente(frente);
            frente = nuevoNodo;
            if (fondo == null) {
                fondo = frente;
            }
        } else {
            NodoGenerico<T> actual = frente;
            for (int i = 0; i < pos - 1; i++) {
                actual = actual.getSiguiente();
            }
            nuevoNodo.setSiguiente(actual.getSiguiente());
            actual.setSiguiente(nuevoNodo);
            if (nuevoNodo.getSiguiente() == null) {
                fondo = nuevoNodo;
            }
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
        NodoGenerico<T> nuevoNodo = new NodoGenerico<>(elem);
        if (fondo == null) {
            frente = nuevoNodo;
            fondo = nuevoNodo;
        } else {
            fondo.setSiguiente(nuevoNodo);
            fondo = nuevoNodo;
        }
        tamanio++;
        return true;
    }

    @Override
    public boolean eliminar(T elem) {
        if (frente == null) {
            return false;
        }

        if (frente.getDato().equals(elem)) {
            frente = frente.getSiguiente();
            tamanio--;
            if (frente == null) {
                fondo = null;
            }
            return true;
        }

        NodoGenerico<T> actual = frente;
        while (actual.getSiguiente() != null && !actual.getSiguiente().getDato().equals(elem)) {
            actual = actual.getSiguiente();
        }

        if (actual.getSiguiente() != null) {
            actual.setSiguiente(actual.getSiguiente().getSiguiente());
            tamanio--;
            if (actual.getSiguiente() == null) {
                fondo = actual;
            }
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
            frente = frente.getSiguiente();
            tamanio--;
            if (frente == null) {
                fondo = null;
            }
            return true;
        }

        NodoGenerico<T> actual = frente;
        for (int i = 0; i < pos - 1; i++) {
            actual = actual.getSiguiente();
        }

        actual.setSiguiente(actual.getSiguiente().getSiguiente());
        tamanio--;
        if (actual.getSiguiente() == null) {
            fondo = actual;
        }
        return true;
    }

    @Override
    public boolean incluye(T elem) {
        NodoGenerico<T> actual = frente;
        while (actual != null) {
            if (actual.getDato().equals(elem)) {
                return true;
            }
            actual = actual.getSiguiente();
        }
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

        NodoGenerico<T> actual = frente;
        for (int i = 0; i < pos; i++) {
            actual = actual.getSiguiente();
        }

        actual.setDato(elem);
        return true;
    }

    @Override
    public ListaGenerica<T> clonar() {
        ColaGenerica<T> nuevaCola = new ColaGenerica<>();
        NodoGenerico<T> actual = frente;
        while (actual != null) {
            nuevaCola.agregarFinal(actual.getDato());
            actual = actual.getSiguiente();
        }
        return nuevaCola;
    }

    @Override
    public boolean agregar(T[] arreglo) {
        for (T elem : arreglo) {
            agregarFinal(elem);
        }
        return true;
    }
}
