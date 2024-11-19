package practica2.ejercicio4;
import practica1.ejercicio3.ColaGenerica;
import practica1.ejercicio3.ListaGenerica;
import practica2.ejercicio3.ArbolGeneral;


public class AnalizadorArbol {
    public int devolverMaximoPromedio(ArbolGeneral<AreaEmpresa> nodoArbol) {
        int contadorDeNodos =0;
        int totalNivel = 0;
        int maxProm =0;
        int nivelProm= 0;
        int nivel = 0;
        // INICIALIZO LOS CONTADORES QUE VOY A UTILIZAR

        ColaGenerica<ArbolGeneral<AreaEmpresa>> cola = new ColaGenerica<>();
        cola.encolar(nodoArbol);
        cola.encolar(null);

        while (!cola.esVacia()){
            ArbolGeneral<AreaEmpresa> nodoAux = cola.desencolar();
            if (nodoAux == null){
                nivelProm =  totalNivel /  contadorDeNodos;
                System.out.println("El promedio: "+nivelProm+" pertenece al nivel: "+nivel);
                if (maxProm < nivelProm){
                    maxProm = nivelProm;
                }
                contadorDeNodos =0;
                nivelProm = 0;
                nivel++;
                if (!cola.esVacia()){
                    cola.encolar(null);
                }
            }else{
                totalNivel += nodoAux.getDato().getTiempoDeTransmision();
                ListaGenerica<ArbolGeneral<AreaEmpresa>> listaDeHijos = nodoAux.getHijos();
                contadorDeNodos++;
                while (!listaDeHijos.fin()){
                    cola.encolar(listaDeHijos.proximo());
                }
            }

        }


        return (int) maxProm;



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

        System.out.println("El promedio maximo es: "+resultado);
    }

}
