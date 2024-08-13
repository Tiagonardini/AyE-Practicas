package practica1.ejercicio1;

public class TestListaDeEnterosEnlazada {
    public static void main(String[] args) {
        var listaDeEnteros = new ListaDeEnterosEnlazada();

        int inicioLista = listaDeEnteros.tamanio() + 1; // charlar con guille

        listaDeEnteros.agregarFinal(1);
        listaDeEnteros.agregarFinal(2);
        listaDeEnteros.agregarFinal(3);
        listaDeEnteros.agregarFinal(4);
        listaDeEnteros.agregarFinal(5);

        listaDeEnteros.comenzar();
        while (!listaDeEnteros.fin()) {
            System.out.printf(listaDeEnteros.proximo().toString());
        }


        recorrerALaInversa(listaDeEnteros, inicioLista);
    }

    public static void recorrerALaInversa(ListaDeEnterosEnlazada lista, int pos){
        if (pos <= lista.tamanio()){
            recorrerALaInversa(lista, pos + 1);
            System.out.printf(" "+lista.elemento(pos).toString());
        }

    }

}
