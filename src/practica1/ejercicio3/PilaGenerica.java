package practica1.ejercicio3;

public class PilaGenerica<T>  {
    private ListaGenerica<T> datos;

    public PilaGenerica() {
        this.datos = new ListaEnlazadaGenerica<>();
        System.out.println("Pila inicializada: " + datos);
    }

    public void apilar(T elem) {
        datos.agregarInicio(elem);
        System.out.println("Apilado: " + elem + ", Estado de la pila: " + datos);
    }

    public T desapilar() {
        if (esVacia()) {
            return null; // O lanzar una excepción si prefieres
        }
        T elem = datos.elemento(1); // Obtiene el primer elemento
        datos.eliminarEn(1); // Elimina el primer elemento
        System.out.println("Desapilado: " + elem + ", Estado de la pila: " + datos);
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
