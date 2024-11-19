package practica2.parcial;

import practica1.ejercicio3.ListaGenerica;
import practica2.ejercicio3.ArbolGeneral;

public class Parcial<T> {


    public void contarDescendientes(ArbolGeneral<T> abb){
        int contador = 0;
        ListaGenerica<ArbolGeneral<T>>listaHijos  = abb.getHijos();
        listaHijos.comenzar();
        if (!listaHijos.esVacia()){
            while (!listaHijos.fin()){
                contarDescendientes(listaHijos.proximo());
                contador++;
            }
        }
        System.out.println(abb.getDato()+" tiene: "+contador+" descendientes");
    }
}
