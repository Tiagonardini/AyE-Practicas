package practica6;

import practica6.estructuras.GrafoImplMatrizAdy;
import practica6.estructuras.VerticeImplMatrizAdy;
import practica6.tp01.ListaEnlazadaGenerica;
import practica6.tp01.ListaGenerica;

public class MainParcial {
    public static void main(String[] args) {
//        // Crear el grafo con el tamaño adecuado (11 vértices)
//        GrafoImplMatrizAdy<String> grafo = new GrafoImplMatrizAdy<>(12);
//
//        // Crear los vértices
//        VerticeImplMatrizAdy<String> laPlata = new VerticeImplMatrizAdy<>("La Plata");
//        VerticeImplMatrizAdy<String> pinamar = new VerticeImplMatrizAdy<>("Pinamar");
//        VerticeImplMatrizAdy<String> quilmes = new VerticeImplMatrizAdy<>("Quilmes");
//        VerticeImplMatrizAdy<String> moreno = new VerticeImplMatrizAdy<>("Moreno");
//        VerticeImplMatrizAdy<String> abasto = new VerticeImplMatrizAdy<>("Abasto");
//        VerticeImplMatrizAdy<String> caniuelas = new VerticeImplMatrizAdy<>("Cañuelas");
//        VerticeImplMatrizAdy<String> carlosKeen = new VerticeImplMatrizAdy<>("Carlos Keen");
//        VerticeImplMatrizAdy<String> suipacha = new VerticeImplMatrizAdy<>("Suipacha");
//        VerticeImplMatrizAdy<String> navarro = new VerticeImplMatrizAdy<>("Navarro");
//        VerticeImplMatrizAdy<String> saladillo = new VerticeImplMatrizAdy<>("Saladillo");
//        VerticeImplMatrizAdy<String> lobos = new VerticeImplMatrizAdy<>("Lobos");
//
//        // Agregar los vértices al grafo
//        grafo.agregarVertice(laPlata);
//        grafo.agregarVertice(pinamar);
//        grafo.agregarVertice(quilmes);
//        grafo.agregarVertice(moreno);
//        grafo.agregarVertice(abasto);
//        grafo.agregarVertice(caniuelas);
//        grafo.agregarVertice(carlosKeen);
//        grafo.agregarVertice(suipacha);
//        grafo.agregarVertice(navarro);
//        grafo.agregarVertice(saladillo);
//        grafo.agregarVertice(lobos);
//
//        // Conectar los vértices
//        grafo.conectar(laPlata, pinamar);
//        grafo.conectar(laPlata, quilmes);
//        grafo.conectar(quilmes, moreno);
//        grafo.conectar(quilmes, abasto);
//        grafo.conectar(moreno, caniuelas);
//        grafo.conectar(abasto, carlosKeen);
//        grafo.conectar(caniuelas, suipacha);
//        grafo.conectar(carlosKeen, suipacha);
//        grafo.conectar(suipacha, navarro);
//        grafo.conectar(navarro, saladillo);
//        grafo.conectar(saladillo, lobos);
//
//        // Ahora puedes usar tu grafo y buscar caminos
//        Parcial<String> parcial = new Parcial<>();
//        ListaGenerica<String> camino = parcial.buscarCamino(grafo, "La Plata", "Abasto", "Quilmes");
//
//        // Imprimir el camino encontrado
//        camino.comenzar();
//        for (int i = 1; i <= camino.tamanio(); i++){
//            System.out.println(camino.elemento(i));
//        }




            // Crear el grafo con el tamaño adecuado (10 vértices)
            GrafoImplMatrizAdy<String> grafo = new GrafoImplMatrizAdy<>(11);

            // Crear los vértices
            VerticeImplMatrizAdy<String> ayuntamiento = new VerticeImplMatrizAdy<>("Ayuntamiento");
            VerticeImplMatrizAdy<String> elTigre = new VerticeImplMatrizAdy<>("El Tigre");
            VerticeImplMatrizAdy<String> museoMunch = new VerticeImplMatrizAdy<>("Museo Munch");
            VerticeImplMatrizAdy<String> parqueBotanico = new VerticeImplMatrizAdy<>("Parque Botánico");
            VerticeImplMatrizAdy<String> galeriaNacional = new VerticeImplMatrizAdy<>("Galería Nacional");
            VerticeImplMatrizAdy<String> parqueVigeland = new VerticeImplMatrizAdy<>("Parque Vigeland");
            VerticeImplMatrizAdy<String> folkMuseum = new VerticeImplMatrizAdy<>("FolkMuseum");
            VerticeImplMatrizAdy<String> museoFram = new VerticeImplMatrizAdy<>("Museo Fram");
            VerticeImplMatrizAdy<String> museoBarcoPolar = new VerticeImplMatrizAdy<>("Museo del Barco Polar");
            VerticeImplMatrizAdy<String> museoVikingo = new VerticeImplMatrizAdy<>("Museo Vikingo");

            // Agregar los vértices al grafo
            grafo.agregarVertice(ayuntamiento);
            grafo.agregarVertice(elTigre);
            grafo.agregarVertice(museoMunch);
            grafo.agregarVertice(parqueBotanico);
            grafo.agregarVertice(galeriaNacional);
            grafo.agregarVertice(parqueVigeland);
            grafo.agregarVertice(folkMuseum);
            grafo.agregarVertice(museoFram);
            grafo.agregarVertice(museoBarcoPolar);
            grafo.agregarVertice(museoVikingo);

            // Conectar los vértices con los tiempos de viaje (en minutos)
            grafo.conectar(ayuntamiento, elTigre, 10);
            grafo.conectar(elTigre, museoMunch, 15);
            grafo.conectar(museoMunch, parqueBotanico, 20);
            grafo.conectar(parqueBotanico, galeriaNacional, 5);
            grafo.conectar(galeriaNacional, parqueVigeland, 30);
            grafo.conectar(parqueVigeland, folkMuseum, 10);
            grafo.conectar(folkMuseum, museoFram, 25);
            grafo.conectar(museoFram, museoBarcoPolar, 1);
            grafo.conectar(museoBarcoPolar, museoVikingo, 15);

            // Lista de lugares restringidos
            ListaGenerica<String> lugaresRestringidos = new ListaEnlazadaGenerica<>();
            lugaresRestringidos.agregarFinal("Akker Brigge");
            lugaresRestringidos.agregarFinal("Palacio Real");

            // Buscar el camino desde Ayuntamiento hasta Museo Vikingo en menos de 120 minutos
            VisitaOslo visitaOslo = new VisitaOslo();
            ListaGenerica<String> camino = visitaOslo.paseoEnBici(grafo, "Museo Vikingo", 150, lugaresRestringidos);

            // Imprimir el camino encontrado
            if (camino.esVacia()) {
                System.out.println("No se encontró un camino que cumpla con las restricciones.");
            } else {
                System.out.println("Camino encontrado:");
                camino.comenzar();
                while (!camino.fin()) {
                    System.out.println(camino.proximo());
                }
            }
        }
    }


