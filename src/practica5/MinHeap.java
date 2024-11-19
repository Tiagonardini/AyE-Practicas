package practica5;

import practica1.ejercicio3.ListaGenerica;

public class MinHeap <T extends Comparable<T>> implements ColaPrioridades<T>{
    private T[] datos;
    private Integer cantElem;

    public MinHeap(){
        this.datos = (T[]) new Comparable[20];
        this.cantElem = 0;
    }

    public MinHeap(ListaGenerica<T>listaGenerica){
        this.cantElem = listaGenerica.tamanio();
        this.datos = (T[]) new Comparable[cantElem + 1];  // +1 para ignorar índice 0
        listaGenerica.comenzar();
        for (int i = 1; i <= cantElem; i++) {
            this.datos[i] = listaGenerica.elemento(i - 1); // Copiar elementos
        }
        for (int i = cantElem / 2; i > 0; i--) {
            percolateDown(i);  // Asegurar propiedad de min-heap
        }
    }



    @Override
    public boolean esVacia() {
        return this.cantElem == 0;
    }

    @Override
    public void eliminar() {
        if (!esVacia()){
            T ultimoElemento = this.datos[cantElem];
            this.datos[1] = ultimoElemento;
            this.cantElem--;
            percolateDown(1);
        }
    }
    @Override
    public boolean agregar(T t) {
        if (this.cantElem >= this.datos.length -1){
            return false;
        }
        this.cantElem++;
        this.datos[cantElem] = t;
        percolateUp();
        return true;
    }
    private void percolateUp(){
        int posicionActual = this.cantElem;
        T elementoActual = this.datos[posicionActual]; //inicia desde la ultima posicion insertada

        int posicionDelPadre = posicionActual/2;
        T elementoDelPadre = this.datos[posicionDelPadre];

        while (posicionActual > 1 && elementoActual.compareTo(elementoDelPadre) < 0){ // si la posicion actual no es la raiz y el elemento actual es menor al padre
            datos[posicionActual] = elementoDelPadre;
            posicionActual = posicionDelPadre;
            posicionDelPadre = posicionActual/2;
            elementoDelPadre = this.datos[posicionDelPadre];
        }
        datos[posicionActual] = elementoActual;

    }

    private void percolateDown(int posicionActual){
        boolean bajar = true;
        T elementoActual = datos[posicionActual];
        while (bajar && (posicionActual * 2) <= this.cantElem){
            int posNodoMasChico = cualEsLaPosicionDelHijoMasChico(posicionActual);
            if (elementoActual.compareTo(this.datos[posNodoMasChico]) > 0){
                this.datos[posicionActual] = this.datos[posNodoMasChico];
                posicionActual = posNodoMasChico;
            }else{

                bajar = false;
            }
        }
        this.datos[posicionActual] = elementoActual;
    }

    private int cualEsLaPosicionDelHijoMasChico(int posicion) {
        int hijoIzq = posicion * 2;
        int hijoDer = hijoIzq + 1;


        if (hijoDer > cantElem) {
            return hijoIzq;
        }


        if (datos[hijoIzq].compareTo(datos[hijoDer]) <= 0) {
            return hijoIzq;
        } else {
            return hijoDer;
        }
    }

    public void recorrerHeap() {
        if (esVacia()) {
            System.out.println("El heap está vacío.");
            return;
        }

        System.out.println("Recorrido del MinHeap:");
        recorrerHeapAux(1);
        System.out.println();
    }

    private void recorrerHeapAux(int posicion) {
        if (posicion > cantElem) {
            return;
        }

        // Imprimir el elemento actual
        System.out.print(datos[posicion] + " ");

        // Recorrer los hijos
        int hijoIzq = posicion * 2;
        int hijoDer = hijoIzq + 1;

        recorrerHeapAux(hijoIzq);
        recorrerHeapAux(hijoDer);
    }



    @Override
    public void tope() {
        System.out.println("Tope de la heap:\n"+this.datos[1]);
    }
}
