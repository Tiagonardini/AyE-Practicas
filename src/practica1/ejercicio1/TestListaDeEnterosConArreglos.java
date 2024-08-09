package practica1.ejercicio1;

public class TestListaDeEnterosConArreglos {
    public static void main(String[] args) {
       var listaDeEnteros = new ListaDeEnterosConArreglos();

       listaDeEnteros.agregarFinal(1);
       listaDeEnteros.agregarFinal(2);
       listaDeEnteros.agregarFinal(3);
       listaDeEnteros.agregarFinal(4);
       listaDeEnteros.agregarFinal(5);

       for (int i = 0; i < listaDeEnteros.tamanio(); i++){
           System.out.printf(listaDeEnteros.proximo().toString());
       }
        System.out.printf("\n");

       recorrerALaInversa(listaDeEnteros, listaDeEnteros.tamanio());
    }

    public static void recorrerALaInversa(ListaDeEnterosConArreglos lista, int indice) {
        if (indice > 0) {
            System.out.printf(lista.elemento(indice).toString());
            recorrerALaInversa(lista, indice - 1);
        }
    }
}
