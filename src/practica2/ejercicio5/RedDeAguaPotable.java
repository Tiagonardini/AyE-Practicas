package practica2.ejercicio5;
import practica1.ejercicio3.ListaEnlazadaGenerica;
import practica1.ejercicio3.ListaGenerica;
import practica2.ejercicio3.ArbolGeneral;



public class RedDeAguaPotable {



    public RedDeAguaPotable( ){

     }


    public double minimoCaudal(double caudal, ArbolGeneral<String> nodoArbol) {
        if (nodoArbol.esHoja()){
            return caudal;
        }
        ListaGenerica<ArbolGeneral<String>> lHijos = nodoArbol.getHijos();
        double caudalPorHijo = caudal/lHijos.tamanio();
        double minCaudal = 0;

        lHijos.comenzar();
        while (!lHijos.fin()){
            ArbolGeneral<String> hijo = lHijos.proximo();
            minCaudal = minimoCaudal(caudalPorHijo, hijo);
            if (caudalPorHijo < minCaudal){
                minCaudal = caudalPorHijo;
            }
        }
        return minCaudal;

        }


    public static void main(String[] args) {


        ArbolGeneral<String> arbol = new ArbolGeneral<>("A");

        ArbolGeneral<String> hijoB = new ArbolGeneral<>("B");
        ArbolGeneral<String> hijoC = new ArbolGeneral<>("C");
        ArbolGeneral<String> hijoD = new ArbolGeneral<>("D" );
        ArbolGeneral<String> hijoE = new ArbolGeneral<>("E" );

        ArbolGeneral<String> hijoF = new ArbolGeneral<>("F");
        ArbolGeneral<String> hijoG = new ArbolGeneral<>("G");

        ArbolGeneral<String> hijoH = new ArbolGeneral<>("H");
        ArbolGeneral<String> hijoI = new ArbolGeneral<>("I");
        ArbolGeneral<String> hijoJ = new ArbolGeneral<>( "J");
        ArbolGeneral<String> hijoK = new ArbolGeneral<>( "K");
        ArbolGeneral<String> hijoO = new ArbolGeneral<>( "O");


        ArbolGeneral<String> hijoL = new ArbolGeneral<>( "L");
        ArbolGeneral<String> hijoM = new ArbolGeneral<>( "M");
        ArbolGeneral<String> hijoN = new ArbolGeneral<>( "N");

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

        var red = new RedDeAguaPotable();



        System.out.println(red.minimoCaudal(1000.0, arbol));
    }
}
