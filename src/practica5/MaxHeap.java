package practica5;

import practica1.ejercicio3.ListaGenerica;

public class MaxHeap <T extends Comparable<T>> implements ColaPrioridades<T>{
    private T[] datos;
    private Integer cantElem;

    public MaxHeap(){
        this.datos = (T[]) new Comparable[20];
        this.cantElem = 0;
    }

    public MaxHeap(ListaGenerica<T> listaGenerica){
        this.cantElem = listaGenerica.tamanio();
        this.datos = (T[]) new Comparable[cantElem + 1];  // +1 para ignorar índice 0
        listaGenerica.comenzar();
        for (int i = 1; i <= cantElem; i++) {
            this.datos[i] = listaGenerica.elemento(i - 1); // Copiar elementos
        }
        for (int i = cantElem / 2; i > 0; i--) {
            percolateDown(i);  // Asegurar propiedad de max-heap
        }
    }




    @Override
    public boolean esVacia() {
        return (cantElem == 0);
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
        if (cantElem >= datos.length - 1) {  // Verifica si hay espacio
            return false;  // No hay espacio para más elementos
        }
        cantElem++;
        datos[cantElem] = t;  // Agrega el nuevo elemento en la última posición
        percolateUp();  // Ajusta la posición para mantener la propiedad de MaxHeap
        return true;
    }

    private void percolateUp() {
        int posicionActual = cantElem;
        T elementoActual = datos[posicionActual];  // Inicia desde la última posición insertada

        while (posicionActual > 1 && elementoActual.compareTo(datos[posicionActual / 2]) > 0) {
            // Mover el elemento del padre hacia abajo
            datos[posicionActual] = datos[posicionActual / 2];
            // Subir una posición en el árbol
            posicionActual = posicionActual / 2;
        }
        datos[posicionActual] = elementoActual;
//        int posicionActual = cantElem;
//        T elementoActual = datos[posicionActual];  // Inicia desde la última posición insertada
//
//        while (posicionActual > 1 && elementoActual.compareTo(datos[posicionActual / 2]) > 0) {
//            // Compara el elemento actual con el padre
//            datos[posicionActual] = datos[posicionActual / 2];  // Subir el padre
//            posicionActual = posicionActual / 2;  // Mover hacia arriba en el árbol
//        }
//        datos[posicionActual] = elementoActual;  // Coloca el elemento en su posición correcta
    }
//    @Override
//    public boolean agregar(T t) {
//        if (this.cantElem >= this.datos.length -1){
//            return false;
//        }
//        this.cantElem++;
//        this.datos[cantElem] = t;
//        percolateUp();
//        return true;
//    }
//
//    private void percolateUp(){
//        int posicionActual = this.cantElem;
//        T elementoActual = this.datos[posicionActual]; //inicia desde la ultima posicion insertada
//
//        int posicionDelPadre = posicionActual/2;
//        T elementoDelPadre = this.datos[posicionDelPadre];
//
//        while (posicionActual > 1 && elementoActual.compareTo(elementoDelPadre) > 0){ // si la posicion actual no es la raiz y el elemento actual es menor al padre
//            datos[posicionActual] = elementoDelPadre;
//            posicionActual = posicionDelPadre;
//            posicionDelPadre = posicionActual/2;
//            elementoDelPadre = this.datos[posicionDelPadre];
//        }
//        datos[posicionActual] = elementoActual;
//    }

    private void percolateDown(int posicionActual) {
        T elementoActual = datos[posicionActual];
        int posicionHijoIzquierdo = posicionActual * 2;

        while (posicionHijoIzquierdo <= this.cantElem) {
            int posicionHijoMayor = obtenerHijoMayor(posicionActual);
            T elementoHijoMayor = datos[posicionHijoMayor];

            if (elementoActual.compareTo(elementoHijoMayor) < 0) {
                // Intercambiar el elemento actual con el hijo mayor
                datos[posicionActual] = elementoHijoMayor;
                posicionActual = posicionHijoMayor;
                posicionHijoIzquierdo = posicionActual * 2; // Actualizar posición del hijo izquierdo
            } else {
                break; // El elemento está en la posición correcta
            }
        }

        datos[posicionActual] = elementoActual;
    }

    private int obtenerHijoMayor(int posicionActual) {
        int hijoIzq = posicionActual * 2;
        int hijoDer = hijoIzq + 1;

        if (hijoDer > cantElem) {
            return hijoIzq; // Solo hay hijo izquierdo
        }
        return (datos[hijoIzq].compareTo(datos[hijoDer]) > 0) ? hijoIzq : hijoDer; // Retorna el hijo de mayor valor
    }


    public void recorrerHeap() {
        if (esVacia()) {
            System.out.println("El heap está vacío.");
            return;
        }

        System.out.println("Recorrido del MaxHeap:");
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
