package practica1.ejercicio3;


public class ColaGenerica<T> {
    private ListaGenerica<T> datos;

    public ColaGenerica() {
        this.datos = new ListaEnlazadaGenerica<>();
        System.out.println("Lista inicializada: " + datos);
    }

    public void encolar(T elem) {
        datos.agregarFinal(elem);
        System.out.println("Encolado: " + elem + ", Estado de la lista: " + datos);
    }

    public T desencolar() {
        if (esVacia()) {
            return null; // O lanzar una excepción si prefieres
        }
        T elem = datos.elemento(1); // Obtiene el primer elemento
        datos.eliminarEn(1); // Elimina el primer elemento
        System.out.println("Desencolado: " + elem + ", Estado de la lista: " + datos);
        return elem;
    }

    public T tope() {
        if (esVacia()) {
            return null; // O lanzar una excepción si prefieres
        }
        T elem = datos.elemento(1); // Obtiene el primer elemento
        System.out.println("Tope de la cola: " + elem + ", Estado de la lista: " + datos);
        return elem;
    }

    public boolean esVacia() {
        boolean vacia = datos.esVacia();
        System.out.println("¿Está vacía la cola?: " + vacia);
        return vacia;
    }
}
