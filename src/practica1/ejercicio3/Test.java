package practica1.ejercicio3;

public class Test {

    public static void main(String[] args) {
        // Crear una nueva cola de enteros
        ColaGenerica<Integer> cola = new ColaGenerica<Integer>();

        // Encolar elementos
        cola.encolar(10);
        cola.encolar(20);
        cola.encolar(30);

        cola.tope();

        cola.desencolar();

        PilaGenerica<Integer> pila = new PilaGenerica<>();

        // Encolar elementos
        pila.apilar(10);
        pila.apilar(20);
        pila.apilar(30);

        pila.tope();

        pila.desapilar();
    }


}
