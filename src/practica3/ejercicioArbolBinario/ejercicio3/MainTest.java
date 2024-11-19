package practica3.ejercicioArbolBinario.ejercicio3;

import practica1.ejercicio3.ListaGenerica;
import practica3.ejercicioArbolBinario.ArbolBinario;

public class MainTest {
    public static void main (String [] args){
        ArbolBinario<Integer> raiz = new ArbolBinario<>(10);

        ArbolBinario<Integer> hijo1 = new ArbolBinario<>(5);

        ArbolBinario<Integer> hijo2 = new ArbolBinario<>(15);

        ArbolBinario<Integer> nieto1_1 = new ArbolBinario<>(2);
        ArbolBinario<Integer> nieto1_2 = new ArbolBinario<>(7);
        ArbolBinario<Integer> nieto2_1 = new ArbolBinario<>(14);
        ArbolBinario<Integer> nieto2_2 = new ArbolBinario<>(16);

        hijo1.agregarHijoIzquierdo(nieto1_1);
        hijo1.agregarHijoDerecho(nieto1_2);

        hijo2.agregarHijoIzquierdo(nieto2_1);
        hijo2.agregarHijoDerecho(nieto2_2);

        raiz.agregarHijoIzquierdo(hijo1);
        raiz.agregarHijoDerecho(hijo2);


//        System.out.println("Cantidad De Hojas: "+raiz.contarHojas());

//        ArbolBinario<Integer> arbolEspejo = raiz.espejo();
//        arbolEspejo.preOrder();

//        raiz.entreNiveles(2,2);

        ContadorArbol cArbol = new ContadorArbol(raiz);
        ListaGenerica<Integer> listaNumerosPares = cArbol.numeroPares();

        for (int i = 1; i <= listaNumerosPares.tamanio(); i++){
            System.out.println(listaNumerosPares.elemento(i));
        }


    }
}
