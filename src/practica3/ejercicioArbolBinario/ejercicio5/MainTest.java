package practica3.ejercicioArbolBinario.ejercicio5;

import practica3.ejercicioArbolBinario.ArbolBinario;

public class MainTest {
    public static void main(String[] args) {
        ArbolBinario<Integer> raiz = new ArbolBinario<>(1);

        ArbolBinario<Integer> hijo1 = new ArbolBinario<>(2);

        ArbolBinario<Integer> hijo2 = new ArbolBinario<>(3);

        ArbolBinario<Integer> nieto1_1 = new ArbolBinario<>(4);
        ArbolBinario<Integer> nieto1_2 = new ArbolBinario<>(5);
        ArbolBinario<Integer> nieto2_1 = new ArbolBinario<>(6);
        ArbolBinario<Integer> nieto2_2 = new ArbolBinario<>(7);

        hijo1.agregarHijoIzquierdo(nieto1_1);
        hijo1.agregarHijoDerecho(nieto1_2);

        hijo2.agregarHijoIzquierdo(nieto2_1);
        hijo2.agregarHijoDerecho(nieto2_2);

        raiz.agregarHijoIzquierdo(hijo1);
        raiz.agregarHijoDerecho(hijo2);

        ProfundidadDeArbolBinario aBC = new ProfundidadDeArbolBinario();

        aBC.sumaElementosProfundidad(raiz);
    }
}