package practica5;

public class MainTest {
    public static void main(String[]args){
//        MinHeap<Integer>minHeap = new MinHeap<Integer>();
//        minHeap.agregar(10);
//        minHeap.agregar(5);
//        minHeap.agregar(20);
//        minHeap.agregar(30);
//        minHeap.agregar(15);
//        minHeap.agregar(8);
//        minHeap.agregar(2);
//
//        minHeap.tope();
//        minHeap.recorrerHeap();
//
//        minHeap.eliminar();
//        minHeap.tope();
//
//        minHeap.recorrerHeap();
//
//        minHeap.eliminar();
//        minHeap.tope();
//
//        minHeap.recorrerHeap();  Funciona correctamente


        MaxHeap<Integer> maxHeap = new MaxHeap<>();
        maxHeap.agregar(1);
        maxHeap.agregar(2);
        maxHeap.agregar(3);
        maxHeap.agregar(4);
        maxHeap.agregar(5);
        maxHeap.agregar(6);
        maxHeap.agregar(7);

        maxHeap.tope();
        maxHeap.recorrerHeap();
    }
}
