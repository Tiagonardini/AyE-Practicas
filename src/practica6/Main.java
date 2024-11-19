package practica6;

import practica6.estructuras.GrafoImplMatrizAdy;
import practica6.estructuras.VerticeImplMatrizAdy;

import practica6.recorridos.Recorridos;
import practica6.tp01.ListaEnlazadaGenerica;
import practica6.tp01.ListaGenerica;
import practica6.tp06.Vertice;

import java.util.List;

public class Main {
    public static void main(String[] s) {
        GrafoImplMatrizAdy<Integer> grafo = new GrafoImplMatrizAdy<>(10);

        Vertice<Integer> v1 = new VerticeImplMatrizAdy<>(1);
        Vertice<Integer> v2 = new VerticeImplMatrizAdy<>(2);
        Vertice<Integer> v3 = new VerticeImplMatrizAdy<>(3);
        Vertice<Integer> v4 = new VerticeImplMatrizAdy<>(4);
        Vertice<Integer> v5 = new VerticeImplMatrizAdy<>(5);


        grafo.agregarVertice(v1);
        grafo.agregarVertice(v2);
        grafo.agregarVertice(v3);
        grafo.agregarVertice(v4);
        grafo.agregarVertice(v5);

        grafo.conectar(v1, v5);
        grafo.conectar(v2, v3);
        grafo.conectar(v2, v1);
        grafo.conectar(v3, v1);
        grafo.conectar(v3, v2);
        grafo.conectar(v4, v5);

        Recorridos<Integer> recorridos = new Recorridos<>();
        ListaGenerica<Vertice<Integer>> listaDFS = recorridos.dfs(grafo);
//
//        for (int i = 1; i<=listaDFS.tamanio(); i++){
//            System.out.println(listaDFS.elemento(i).dato());
//        }
//
//        ListaGenerica<Vertice<Integer>> listaBFS = recorridos.bfs(grafo);
//
//        for (int i = 1; i<=listaBFS.tamanio(); i++){
//            System.out.println(listaBFS.elemento(i).dato());
//        }

        ListaGenerica<Vertice<Integer>> lista = recorridos.verticeMayorAOpcionB(grafo, 1);

        for (int i = 1; i<=lista.tamanio(); i++) {
            System.out.println(lista.elemento(i).dato());
        }
    }

}


        // System.out.println(grafo.esAdyacente(v1,v2)); // la conexion entre vertices es correcta
//
//        grafo.mostrarVertices();
//        Recorridos<Integer> recorridos = new Recorridos<>();
//        recorridos.dfs(grafo);
//        ListaEnlazadaGenerica <Integer> lista = (ListaEnlazadaGenerica<Integer>) recorridos.dfs(grafo);
//
//        for (int i = 0; i<lista.tamanio(); i++){
//            System.out.println(lista.elemento(i));
//        }
//
//    }
/*ListaGenerica<T> resumen = new ListaEnlazadaGenerica<>();
        ListaGenerica<Vertice<T>> vertices = grafo.listaDeVertices();
        if (vertices.esVacia()){
            return resumen;
        }else {
            boolean[] visitados = new boolean[vertices.tamanio() + 1];
            vertices.comenzar();

            System.out.println(vertices.elemento(1).dato());
            System.out.println(vertices.elemento(2).dato());
            System.out.println(vertices.elemento(3).dato());
            System.out.println(vertices.elemento(4).dato());
            System.out.println(vertices.elemento(5).dato());

            for (int i = 1 ; i<= vertices.tamanio(); i++){
                Vertice<T> vertice = vertices.elemento(i);
                if (vertice != null && !visitados[i]){
                    System.out.println("Iniciando DFS en el vértice: " + vertice.dato());
                    dfsRecursivo(i,visitados,resumen,grafo, vertice);
                }else if (vertice == null) {
                    System.out.println("Vértice en la posición " + i + " es null");
                }
            }
        }
    return resumen;
    }

    private void dfsRecursivo (int posicion, boolean [] visitado, ListaGenerica<T> listaQueSeDevuelve, Grafo<T> grafo, Vertice<T> vertice){
        visitado[posicion] = true;
        listaQueSeDevuelve.agregarFinal(grafo.vertice(posicion).dato());

        ListaGenerica<Arista<T>> adyacentes = grafo.listaDeAdyacentes(grafo.vertice(posicion));

        System.out.println(adyacentes.esVacia());
//
//        for (int j = 1; j<=adyacentes.tamanio(); j++){
//            Arista<T> arista = adyacentes.elemento(j);
//            int posicionDelVerticeDes = arista.verticeDestino().getPosicion();
//            if (!visitado[posicionDelVerticeDes]){
//                dfsRecursivo(posicionDelVerticeDes, visitado, listaQueSeDevuelve, grafo, arista.verticeDestino());
//            }
//        }
    }*/
//}
