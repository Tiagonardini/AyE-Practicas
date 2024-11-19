package practica6;

import practica6.tp01.ListaEnlazadaGenerica;
import practica6.tp01.ListaGenerica;
import practica6.tp06.Arista;
import practica6.tp06.Grafo;
import practica6.tp06.Vertice;

public class Parcial <T>{
    public ListaGenerica<String> buscarCamino(Grafo<String> grafo, String origen, String destino, String pasandoPor){

        // Trabajo con una lista de ciudades inicializada
        ListaGenerica<Vertice<String>> ciudades = grafo.listaDeVertices();
        ciudades.comenzar();

        //Creamos los vertices de cada ciudad pasada por parametro en null, ya que no sabemos si se encuentra dentro de la lista de ciudades
        Vertice<String> verticeOrigen = null;
        Vertice<String> verticeDestino = null;
        Vertice<String> verticePasandoPor = null;


        //recorremos la lista de vertices para verificar que se encuentren los datos
        for (int i = 1; i<=ciudades.tamanio(); i++){
            Vertice<String> vertice = ciudades.elemento(i);
            if (vertice.dato().equals(origen)){
                verticeOrigen = vertice;
            }else if (vertice.dato().equals(destino)){
                verticeDestino = vertice;
            } else if (vertice.dato().equals(pasandoPor)) {
                verticePasandoPor = vertice;
            }
        }

        //generamos un booleano (para saber si ya se paso por ahi) y una lista a devolver
        ListaGenerica<String> camino = new ListaEnlazadaGenerica<>();
        boolean[] visitados = new boolean[ciudades.tamanio()+1];


        //logica del problema (pide que si no se encuentra ninguno de los pasados por parametros en el grafo se devuelve vacia)
        if (verticeOrigen != null && verticeDestino != null && verticePasandoPor != null){
            buscarCaminoRecursivo(grafo, verticeOrigen, destino, pasandoPor, visitados, camino);
        }else{
            camino.agregarFinal("No hay en la lista");
        }

        return camino;
    }

    private boolean buscarCaminoRecursivo(Grafo<String> grafo, Vertice<String> actual,  String destino, String pasandoPor, boolean[] visitados, ListaGenerica<String> camino) {
        visitados[actual.getPosicion()] = true;
        camino.agregarFinal(actual.dato());

        ListaGenerica<Arista<String>> adyacentes = grafo.listaDeAdyacentes(actual);
        adyacentes.comenzar();

        while (!adyacentes.fin()) {
            Arista<String> arista = adyacentes.proximo();
            Vertice<String> verticeDestino = arista.verticeDestino();
            if (!visitados[verticeDestino.getPosicion()]) {
                if (buscarCaminoRecursivo(grafo, verticeDestino, destino, pasandoPor, visitados, camino)) {
                    return true;
                }
            }
        }
        return false;

    }


}


