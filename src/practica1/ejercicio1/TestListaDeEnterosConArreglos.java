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

       listaDeEnteros.comenzar();
       recorrerALaInversa(listaDeEnteros);
    }

    public static void recorrerALaInversa(ListaDeEnterosConArreglos lista) {
        if (!lista.fin()) {
            System.out.printf(lista.elemento(lista.tamanio()).toString());
            lista.eliminar(lista.tamanio());
            recorrerALaInversa(lista);
        }
    }
}
