package practica1.ejercicio2;

import practica1.ejercicio1.ListaDeEnterosConArreglos;

public class TestListaEnlazadaGenerica {
    public static void main(String[] args) {
        var estudiante1 = new Estudiante("Tiago ", "Nardini ", 123);
        var estudiante2 = new Estudiante("Sofia ", "Villegas ", 456);
        var estudiante3 = new Estudiante("Felipe ", "Elbert ", 890);
        var estudiante4 = new Estudiante("Liliana ", "Sancho ", 100);

        var listaGenerica = new ListaEnlazadaGenerica<Estudiante>();

        listaGenerica.agregarInicio(estudiante1);
        listaGenerica.agregarInicio(estudiante2);
        listaGenerica.agregarInicio(estudiante3);
        listaGenerica.agregarInicio(estudiante4);

        listaGenerica.comenzar();
        while (!listaGenerica.fin()){
            listaGenerica.proximo().tusDatos();
        }

    }
}
