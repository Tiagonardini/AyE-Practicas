package practica2.ejercicio6;

import practica2.ejercicio3.ArbolGeneral;

public class Main {
    public static void main(String[] args) {
        // Crear un árbol que es tanto lleno como completo
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

        System.out.println("Árbol lleno: " + raiz.esLleno());     // Debería devolver true
        System.out.println("Árbol completo: " + raiz.esCompleto()); // Debería devolver true

        // Crear un árbol que es lleno pero no completo
        ArbolGeneral<Integer> raiz2 = new ArbolGeneral<>(1);

        ArbolGeneral<Integer> hijo21 = new ArbolGeneral<>(2);
        ArbolGeneral<Integer> hijo22 = new ArbolGeneral<>(3);
        raiz2.agregarHijo(hijo21);
        raiz2.agregarHijo(hijo22);

        ArbolGeneral<Integer> nieto21 = new ArbolGeneral<>(4);
        ArbolGeneral<Integer> nieto22 = new ArbolGeneral<>(5);
        hijo21.agregarHijo(nieto21);
        hijo21.agregarHijo(nieto22);

        // Añadir un tercer nivel incompleto
        ArbolGeneral<Integer> bisnieto1 = new ArbolGeneral<>(8);
        nieto21.agregarHijo(bisnieto1);

        System.out.println("Árbol lleno (con nivel incompleto): " + raiz2.esLleno());     // Debería devolver false
        System.out.println("Árbol completo (con nivel incompleto): " + raiz2.esCompleto()); // Debería devolver false

        // Crear un árbol que es completo pero no lleno
        ArbolGeneral<Integer> raiz3 = new ArbolGeneral<>(1);

        ArbolGeneral<Integer> hijo31 = new ArbolGeneral<>(2);
        ArbolGeneral<Integer> hijo32 = new ArbolGeneral<>(3);
        raiz3.agregarHijo(hijo31);
        raiz3.agregarHijo(hijo32);

        ArbolGeneral<Integer> nieto31 = new ArbolGeneral<>(4);
        hijo31.agregarHijo(nieto31);

        System.out.println("Árbol lleno (no lleno): " + raiz3.esLleno());     // Debería devolver false
        System.out.println("Árbol completo (completo): " + raiz3.esCompleto());
    }
}
