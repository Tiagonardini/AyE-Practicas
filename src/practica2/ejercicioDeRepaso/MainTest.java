package practica2.ejercicioDeRepaso;

import practica2.ejercicio3.ArbolGeneral;

public class MainTest {
    public static void main (String []args){
        ArbolGeneral<Integer> raiz = new ArbolGeneral<>(1);

        ArbolGeneral<Integer> hijo1 = new ArbolGeneral<>(2);
        ArbolGeneral<Integer> hijo2 = new ArbolGeneral<>(3);
        raiz.agregarHijo(hijo1);
        raiz.agregarHijo(hijo2);

        ArbolGeneral<Integer> nieto1 = new ArbolGeneral<>(4);
        ArbolGeneral<Integer> nieto2 = new ArbolGeneral<>(5);
        hijo1.agregarHijo(nieto1);
        hijo1.agregarHijo(nieto2);

        ArbolGeneral<Integer> nieto3 = new ArbolGeneral<>(6);
        ArbolGeneral<Integer> nieto4 = new ArbolGeneral<>(7);
        hijo2.agregarHijo(nieto3);
        hijo2.agregarHijo(nieto4);

        Recorridos<Integer> recorrido = new Recorridos<>();
        System.out.println("ACA EMPIEZA EL RECORRIDO EN PRE ORDER");
        recorrido.recorridoPreOrder(raiz);

        System.out.println("ACA EMPIEZA EL RECORRIDO EN IN ORDER");
        recorrido.recorridoInOrder(raiz);

        System.out.println("ACA EMPIEZA EL RECORRIDO EN POS ORDER");
        recorrido.recorridoPostOrder(raiz);

        System.out.println("ACA EMPIEZA EL RECORRIDO EN POR NIVELES");
        recorrido.recorridoPorNiveles(raiz);

        System.out.println("ACA EMPIEZA EL RECORRIDO EN PRE ORDER, MOSTRANDO LOS NUMERO IMPARES MAYORES A 0");
        recorrido.numerosImparesMayoresQueEnRecorridoPreOrder(raiz, 0);

        System.out.println("ACA EMPIEZA EL RECORRIDO EN IN ORDER, MOSTRANDO LOS NUMERO IMPARES MAYORES A 0");
        recorrido.numerosImparesMayoresQueEnRecorridoInOrder(raiz, 0);

        System.out.println("ACA EMPIEZA EL RECORRIDO EN POST ORDER, MOSTRANDO LOS NUMERO IMPARES MAYORES A 0");
        recorrido.numerosImparesMayoresQueEnRecorridoPostOrder(raiz, 0);

        System.out.println("ACA EMPIEZA EL RECORRIDO EN POR NIVELES, MOSTRANDO LOS NUMERO IMPARES MAYORES A 0");
        recorrido.numerosImparesMayoresQueEnRecorridoPorNiveles(raiz, 0);
    }
}
