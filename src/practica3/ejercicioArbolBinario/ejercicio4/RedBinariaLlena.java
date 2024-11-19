package practica3.ejercicioArbolBinario.ejercicio4;
import java.lang.Integer;
import practica1.ejercicio3.ListaEnlazadaGenerica;
import practica3.ejercicioArbolBinario.ArbolBinario;

public class RedBinariaLlena<T> {
    private ListaEnlazadaGenerica<Integer> listaDeRetardo;

    public int retardoDeEnvio (ArbolBinario<Integer> arbolCompleto){
        int retardo = arbolCompleto.getDato();
        int retardoMAX = 0;
        this.listaDeRetardo = new ListaEnlazadaGenerica<>();
        listaDeRetardo.comenzar();

        investigarMayorRecorrido(arbolCompleto, retardo);

        listaDeRetardo.comenzar();
        retardo = listaDeRetardo.proximo();
        while (!listaDeRetardo.fin()){
            retardoMAX = listaDeRetardo.proximo();
            if (retardo < retardoMAX){
                retardo = retardoMAX;
            }
        }
        System.out.println("El maximo retardo es: "+retardo);
        return retardo;
    }

    private void investigarMayorRecorrido(ArbolBinario<Integer> arbolCompleto, Integer retardoAcumulado) {
        listaDeRetardo.agregarFinal(retardoAcumulado);
        if (arbolCompleto.tieneHijoIzquierdo()){
            retardoAcumulado = arbolCompleto.getHijoIzquierdo().getDato();
            investigarMayorRecorrido(arbolCompleto.getHijoIzquierdo(), retardoAcumulado);
        }
        if (arbolCompleto.tieneHijoDerecho()){
            retardoAcumulado = arbolCompleto.getHijoDerecho().getDato();
            investigarMayorRecorrido(arbolCompleto.getHijoDerecho(), retardoAcumulado);
        }
    }


}
