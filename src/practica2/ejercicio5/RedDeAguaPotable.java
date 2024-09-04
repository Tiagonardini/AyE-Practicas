package practica2.ejercicio5;
import practica1.ejercicio3.ListaEnlazadaGenerica;
import practica2.ejercicio3.ArbolGeneral;



public class RedDeAguaPotable {
    private ArbolGeneral<Double> red;
    private ListaEnlazadaGenerica<Double> listaNumeros;

    public RedDeAguaPotable(ArbolGeneral<Double> arbolGeneral){
        this.red = arbolGeneral;
        this.listaNumeros = new ListaEnlazadaGenerica<>();
    }


    public double minimoCaudal(double caudal) {
        if (red.esVacio()) {
            return 0;
        }
        var listaDeNodosHojas = recorrerRed(this.red, caudal, this.listaNumeros);
        var caudalMaschico = listaDeNodosHojas.proximo();
        listaDeNodosHojas.comenzar();
        while (!listaDeNodosHojas.esVacia() && !listaDeNodosHojas.fin()){
            var dato = listaDeNodosHojas.proximo();
            if (caudalMaschico > dato){
                caudalMaschico = dato;
            }
        }
        System.out.println("El caudal de aguas mas pequeño es: "+caudalMaschico);
        return caudalMaschico;
    }

    private ListaEnlazadaGenerica<Double> recorrerRed(ArbolGeneral<Double> red, double caudal, ListaEnlazadaGenerica<Double> listaNumeros) {
        var hijos = red.getHijos();

        var cantHijos = hijos.tamanio();
        var casaCaudal = cantHijos / caudal;

        if (red.esHoja()) {
          listaNumeros.agregarFinal(red.getDato());
        }
        hijos.comenzar();
        if (!hijos.esVacia()){
            while (!hijos.fin()){
                ArbolGeneral<Double> nodoActual = hijos.proximo();
                recorrerRed(nodoActual, casaCaudal, listaNumeros);
            }
        }


        return listaNumeros;
    }

    public static void main(String[] args) {


        ArbolGeneral<Double> arbol = new ArbolGeneral<>(1000.0);

        ArbolGeneral<Double> hijoB = new ArbolGeneral<>(250.0);
        ArbolGeneral<Double> hijoC = new ArbolGeneral<>(250.0);
        ArbolGeneral<Double> hijoD = new ArbolGeneral<>(250.0);
        ArbolGeneral<Double> hijoE = new ArbolGeneral<>(250.0);

        ArbolGeneral<Double> hijoF = new ArbolGeneral<>(125.0);
        ArbolGeneral<Double> hijoG = new ArbolGeneral<>(125.0);

        ArbolGeneral<Double> hijoH = new ArbolGeneral<>(50.0);
        ArbolGeneral<Double> hijoI = new ArbolGeneral<>(50.0);
        ArbolGeneral<Double> hijoJ = new ArbolGeneral<>(50.0);
        ArbolGeneral<Double> hijoK = new ArbolGeneral<>(50.0);
        ArbolGeneral<Double> hijoO = new ArbolGeneral<>(50.0);


        ArbolGeneral<Double> hijoL = new ArbolGeneral<>(125.0);
        ArbolGeneral<Double> hijoM = new ArbolGeneral<>(25.0);
        ArbolGeneral<Double> hijoN = new ArbolGeneral<>(25.0);

        hijoC.agregarHijo(hijoF);
        hijoC.agregarHijo(hijoG);

        hijoG.agregarHijo(hijoL);

        hijoD.agregarHijo(hijoH);
        hijoD.agregarHijo(hijoI);
        hijoD.agregarHijo(hijoJ);
        hijoD.agregarHijo(hijoK);

        hijoJ.agregarHijo(hijoM);
        hijoJ.agregarHijo(hijoN);


        arbol.agregarHijo(hijoB);
        arbol.agregarHijo(hijoC);
        arbol.agregarHijo(hijoD);
        arbol.agregarHijo(hijoE);

        var red = new RedDeAguaPotable(arbol);



        red.minimoCaudal(1000.0);
    }
}
