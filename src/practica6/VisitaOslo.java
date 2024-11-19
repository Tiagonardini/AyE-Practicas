package practica6;

import practica6.tp01.ListaEnlazadaGenerica;
import practica6.tp01.ListaGenerica;
import practica6.tp06.Arista;
import practica6.tp06.Grafo;
import practica6.tp06.Vertice;

public class VisitaOslo {
    public ListaGenerica<String> paseoEnBici(Grafo<String> lugares, String destino, int maxTiempo, ListaGenerica<String> lugaresRestringidos){
       ListaGenerica<String> recorrido = new ListaEnlazadaGenerica<>();
       ListaGenerica<Vertice<String>> listaPermitidos = new ListaEnlazadaGenerica<>();
       ListaGenerica<Vertice<String>> listaLugares = lugares.listaDeVertices();

       Vertice<String> vAyuntamiento = null;
       Vertice<String> vDestino = null;

       while (!listaLugares.esVacia()){
           Vertice <String> verticeActual = listaLugares.proximo();
           if (!lugaresRestringidos.incluye(verticeActual.dato())){
               listaPermitidos.agregarFinal(verticeActual);
           } else if (verticeActual.equals("Ayuntamiento")) {
               vAyuntamiento = verticeActual;
           }else if (verticeActual.equals(destino)){
               vDestino = verticeActual;
           }
       }


//       while (!listaPermitidos.)


//       ListaGenerica<Vertice<String>> listaLugares = lugares.listaDeVertices();
//       ListaGenerica<Vertice<String>> lugaresPermitidos = new ListaEnlazadaGenerica<>();
//       listaLugares.comenzar();
//
//       Vertice<String> vAyuntamiento = null;
//       Vertice<String> vDestino = null;
//
//       for (int i =1; i<= listaLugares.tamanio(); i++){
//           Vertice<String> vertice = listaLugares.elemento(i);
//           if (!lugaresRestringidos.incluye(vertice.dato())){
//               lugaresPermitidos.agregarFinal(vertice);
//               if (vertice.dato().contains("Ayuntamiento")){
//                   vAyuntamiento = vertice;
//               } else if (vertice.dato().equals(destino)) {
//                   vDestino = vertice;
//               }
//           }
//       }
//
//       boolean [] verticesVisitados = new boolean[lugaresPermitidos.tamanio()+1];
//
//       if (vAyuntamiento != null && vDestino != null){
//           paseoEnBiciRecursivo(lugares, lugaresPermitidos, vAyuntamiento, destino, verticesVisitados, recorrido, maxTiempo, 0);
//       }
//       if (recorrido.incluye(destino)){
//           return recorrido;
//       }
       return new ListaEnlazadaGenerica<>();
    }

    private boolean paseoEnBiciRecursivo(Grafo<String> lugares, ListaGenerica<Vertice<String>> lugaresPermitidos,
                                         Vertice<String> verticeActual, String destino, boolean[] verticesVisitados,
                                         ListaGenerica<String> recorrido, int maxTiempo, int tiempoActual) {
        if (tiempoActual<= maxTiempo) {
            System.out.println(tiempoActual);
            verticesVisitados[verticeActual.getPosicion()] = true;
            recorrido.agregarFinal(verticeActual.dato());
        }
        if (recorrido.incluye(destino)){
            return true;
        }

        ListaGenerica<Arista<String>> adyacentes = lugares.listaDeAdyacentes(verticeActual);

        while (!adyacentes.fin()){
            Arista<String> arista = adyacentes.proximo();
            Vertice<String> verticeDestino = arista.verticeDestino();
            tiempoActual += arista.peso();
            if (!verticesVisitados[verticeDestino.getPosicion()]){
                if (lugaresPermitidos.incluye(verticeActual)){
                    paseoEnBiciRecursivo(lugares, lugaresPermitidos, verticeDestino, destino, verticesVisitados, recorrido, maxTiempo, tiempoActual);
                    return true;
                }
                // ACA ESTA EL ERROR
            }
        }
        return false;
    }
}
