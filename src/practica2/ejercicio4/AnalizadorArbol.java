package practica2.ejercicio4;
import practica1.ejercicio3.ColaGenerica;
import practica1.ejercicio3.ListaGenerica;
import practica2.ejercicio3.ArbolGeneral;


public class AnalizadorArbol {
    public int devolverMaximoPromedio(ArbolGeneral<AreaEmpresa> arbol) {
        if (arbol == null) {
            return 0;
        }

        ListaGenerica<ArbolGeneral<AreaEmpresa>> listaDeHijos;
        ColaGenerica<ArbolGeneral<AreaEmpresa>> cola = new ColaGenerica<>();
        cola.encolar(arbol);
        cola.encolar(null); // Usamos null como delimitador de nivel

        int sumaDeNivel = 0;
        int cantidadDeNodosNivel = 0;
        double maxPromedio = 0;

        while (!cola.esVacia()) {
            ArbolGeneral<AreaEmpresa> nodo = cola.desencolar();

            if (nodo == null) {
                // Fin del nivel actual
                double promedioNivel = sumaDeNivel / (double) cantidadDeNodosNivel;
                if (promedioNivel > maxPromedio) {
                    maxPromedio = promedioNivel;
                }

                // Reiniciar para el siguiente nivel
                sumaDeNivel = 0;
                cantidadDeNodosNivel = 0;

                // Si aún hay elementos en la cola, encolar el delimitador para el próximo nivel
                if (!cola.esVacia()) {
                    cola.encolar(null);
                }
            } else {
                // Procesar el nodo actual
                sumaDeNivel += nodo.getDato().getTiempoDeTransmision(); // Suponiendo que getValor() obtiene el valor del dato
                cantidadDeNodosNivel++;

                // Encolar los hijos del nodo actual
                if (nodo.tieneHijos()) {
                    listaDeHijos = nodo.getHijos();
                    listaDeHijos.comenzar();
                    while (!listaDeHijos.fin()) {
                        cola.encolar(listaDeHijos.proximo());
                    }
                }
            }
        }

        return (int) maxPromedio;
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
