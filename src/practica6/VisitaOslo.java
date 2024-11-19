package practica6;

import practica6.tp01.ListaEnlazadaGenerica;
import practica6.tp01.ListaGenerica;
import practica6.tp06.Arista;
import practica6.tp06.Grafo;
import practica6.tp06.Vertice;

public class VisitaOslo {
    public ListaGenerica<String> paseoEnBici(Grafo<String> lugares, String destino, int maxTiempo, ListaGenerica<String> lugaresRestringidos){
       ListaGenerica<String> recorrido = new ListaEnlazadaGenerica<>();
       ListaGenerica<Vertice<String>> listaLugares = lugares.listaDeVertices();

       Vertice<String> vAyuntamiento = null;
       Vertice<String> vDestino = null;

       while (!listaLugares.fin()){
           Vertice <String> verticeActual = listaLugares.proximo();
           if (verticeActual.dato().contains("Ayuntamiento")) {
               vAyuntamiento = verticeActual;
           }else if (verticeActual.dato().contains(destino)){
               vDestino = verticeActual;
           }
       }

       boolean []visitados = new boolean[listaLugares.tamanio()+1];

       if (vAyuntamiento != null && vDestino != null){
           paseoEnBiciRecursivo(lugares, vAyuntamiento, vDestino, maxTiempo, 0, visitados, recorrido, lugaresRestringidos);
       }

       if (!recorrido.incluye(destino)){ // VERIFICO SI EN LA LISTA ESTA EL DESTINO PORQUE SI NO NO TIENE SENTIDO DEVOLVER EL RECORRIDO DE UN GRAFO SI NO LLEGO AL DESTINO
           return new ListaEnlazadaGenerica<>(); // ES UNA MALA PRACTICA ?
       }
       return recorrido;
    }

    private void paseoEnBiciRecursivo(Grafo<String> lugares, Vertice<String> actual, Vertice<String> destino, int maxTiempo, int tiempoActual, boolean [] visitados, ListaGenerica<String> recorrido, ListaGenerica<String> lugaresRestringiidos) {
        System.out.println(tiempoActual);
        if (tiempoActual < maxTiempo){
            visitados [actual.getPosicion()] = true;
            recorrido.agregarFinal(actual.dato());
        }

        ListaGenerica<Arista<String>> adyacentes = lugares.listaDeAdyacentes(actual);
        adyacentes.comenzar();
        while (!adyacentes.fin()){
            Arista<String> arista = adyacentes.proximo();
            Vertice<String> vertice = arista.verticeDestino();
            tiempoActual += arista.peso();
            if (!visitados[vertice.getPosicion()] && !lugaresRestringiidos.incluye(vertice.dato()) && !recorrido.incluye(destino.dato())){
                paseoEnBiciRecursivo(lugares, vertice, destino, maxTiempo, tiempoActual, visitados, recorrido ,lugaresRestringiidos);
            }
        }
    }
}
