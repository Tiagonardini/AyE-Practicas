package practica2.ejercicio4;
import practica1.ejercicio3.ColaGenerica;
import practica1.ejercicio3.ListaGenerica;
import practica2.ejercicio3.ArbolGeneral;


public class AnalizadorArbol {
     public int devolverMaximoPromedio(ArbolGeneral<AreaEmpresa> arbol) {
            if (arbol.esVacio()) { //verifico si el arbol esta vacio
                return 0; // en caso de estarlo el maximo promedio es cero
            }
            int maxPromedio = 0; // se inicializa en cero el maximo promedio
            ColaGenerica<ArbolGeneral<AreaEmpresa>> cola = new ColaGenerica<>();
            cola.encolar(arbol); // encolamos el nodo raiz

            cola.encolar(null); // encolamos null para determinar el final de un nivel

            int sumaNivel = 0; // suma nivel es el total de todos los valores del nivel
            int contadorNivel = 0;

            while (!cola.esVacia()) { // se recorre hasta que la cola se encuentre vacia
                ArbolGeneral<AreaEmpresa> nodoActual = cola.desencolar(); // el nodo actual toma el valor del ultimo nodo encolado
                if (nodoActual != null) { // si el nodo actual no es null -> final o separador
                    sumaNivel += nodoActual.getDato().getTiempoDeTransmision(); // se van sumando los valores del nodo
                    contadorNivel++; // se sube el nivel
                    ListaGenerica<ArbolGeneral<AreaEmpresa>> listaHijos = nodoActual.getHijos(); // le pasamos los hijos del nodo actual
                    listaHijos.comenzar(); // lo inicialiazamos
                    while (!listaHijos.fin()){ // mientras no sea el final de la lista de hijos
                        cola.encolar(listaHijos.proximo()); // se encolan todos los hijos
                    }
                } else { // si el nodo es null -> llego al final de la lista / separador (ES EL FIN DEL NIVEL)
                    if (contadorNivel > 0) {
                        int promedioNivel = sumaNivel / contadorNivel;
                        maxPromedio = Math.max(maxPromedio, promedioNivel); // -> APLICAR METODO PARA HACER EL CALCULO
                    }

                    // Preparar para el siguiente nivel
                    sumaNivel = 0;
                    contadorNivel = 0;

                    if (!cola.esVacia()) {
                        cola.encolar(null); // Marcador para el siguiente nivel
                    }
                }
            }

            return maxPromedio;
        }

        public static void main(String[] args) {
        var analizador = new AnalizadorArbol();

        ArbolGeneral<AreaEmpresa> arbol = new ArbolGeneral<>(new AreaEmpresa("M", 14));
        ArbolGeneral<AreaEmpresa> hijo1 = new ArbolGeneral<>(new AreaEmpresa("J", 13));
        ArbolGeneral<AreaEmpresa> hijo2 = new ArbolGeneral<>(new AreaEmpresa("K", 25));
        ArbolGeneral<AreaEmpresa> hijo3 = new ArbolGeneral<>(new AreaEmpresa("L", 10));
        ArbolGeneral<AreaEmpresa> hijo1_1 = new ArbolGeneral<>(new AreaEmpresa("A", 4));
        ArbolGeneral<AreaEmpresa> hijo1_2 = new ArbolGeneral<>(new AreaEmpresa("B", 7));
        ArbolGeneral<AreaEmpresa> hijo1_3 = new ArbolGeneral<>(new AreaEmpresa("C", 5));
        ArbolGeneral<AreaEmpresa> hijo2_1 = new ArbolGeneral<>(new AreaEmpresa("D", 6));
        ArbolGeneral<AreaEmpresa> hijo2_2 = new ArbolGeneral<>(new AreaEmpresa("E", 10));
        ArbolGeneral<AreaEmpresa> hijo2_3 = new ArbolGeneral<>(new AreaEmpresa("F", 18));
        ArbolGeneral<AreaEmpresa> hijo3_1 = new ArbolGeneral<>(new AreaEmpresa("G", 9));
        ArbolGeneral<AreaEmpresa> hijo3_2 = new ArbolGeneral<>(new AreaEmpresa("H", 12));
        ArbolGeneral<AreaEmpresa> hijo3_3 = new ArbolGeneral<>(new AreaEmpresa("I", 19));

        hijo1.agregarHijo(hijo1_1);
        hijo1.agregarHijo(hijo1_2);
        hijo1.agregarHijo(hijo1_3);

        hijo2.agregarHijo(hijo2_1);
        hijo2.agregarHijo(hijo2_2);
        hijo2.agregarHijo(hijo2_3);

        hijo3.agregarHijo(hijo3_1);
        hijo3.agregarHijo(hijo3_2);
        hijo3.agregarHijo(hijo3_3);


        arbol.agregarHijo(hijo1);
        arbol.agregarHijo(hijo2);
        arbol.agregarHijo(hijo3);

        var resultado = analizador.devolverMaximoPromedio(arbol);

        System.out.println("el promedio maximo es: "+resultado);
    }

}
