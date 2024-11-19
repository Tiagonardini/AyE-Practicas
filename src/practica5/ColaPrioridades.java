package practica5;

public interface ColaPrioridades <T>{
    boolean esVacia();
    void eliminar();
    boolean agregar(T t);
    void tope();
}
