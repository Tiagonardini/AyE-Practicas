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

    }

}
