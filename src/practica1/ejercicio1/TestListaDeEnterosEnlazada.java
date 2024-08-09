package practica1.ejercicio1;

public class TestListaDeEnterosEnlazada {
    public static void main(String[] args) {
        var listaDeEnteros = new ListaDeEnterosEnlazada();

        listaDeEnteros.agregarFinal(1);
        listaDeEnteros.agregarFinal(2);
        listaDeEnteros.agregarFinal(3);
        listaDeEnteros.agregarFinal(4);
        listaDeEnteros.agregarFinal(5);

        listaDeEnteros.comenzar();
        while (!listaDeEnteros.fin()) {
            System.out.printf(listaDeEnteros.proximo().toString());
        }
    }
}
