package practica3.ejercicioArbolBinario.ejercicio4;

import practica1.ejercicio3.ListaGenerica;
import practica3.ejercicioArbolBinario.ArbolBinario;
import practica3.ejercicioArbolBinario.ejercicio3.ContadorArbol;

public class MainTest {
    public static void main(String[] args) {
        ArbolBinario<Integer> raiz = new ArbolBinario<>(0);

        ArbolBinario<Integer> hijo1 = new ArbolBinario<>(16);

        ArbolBinario<Integer> hijo2 = new ArbolBinario<>(14);

        ArbolBinario<Integer> nieto1_1 = new ArbolBinario<>(7);
        ArbolBinario<Integer> nieto1_2 = new ArbolBinario<>(89);
        ArbolBinario<Integer> nieto2_1 = new ArbolBinario<>(15);
        ArbolBinario<Integer> nieto2_2 = new ArbolBinario<>(455);

        hijo1.agregarHijoIzquierdo(nieto1_1);
        hijo1.agregarHijoDerecho(nieto1_2);

        hijo2.agregarHijoIzquierdo(nieto2_1);
        hijo2.agregarHijoDerecho(nieto2_2);

        raiz.agregarHijoIzquierdo(hijo1);
        raiz.agregarHijoDerecho(hijo2);

        RedBinariaLlena rBL = new RedBinariaLlena();

        rBL.retardoDeEnvio(raiz);
    }
}