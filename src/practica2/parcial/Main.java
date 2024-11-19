package practica2.parcial;

import practica2.ejercicio3.ArbolGeneral;

public class Main {

    public static void main (String []a){

        ArbolGeneral<String> juan = new ArbolGeneral<>("Juan");
        ArbolGeneral<String> pedrp = new ArbolGeneral<>("Pedro");
        ArbolGeneral<String> tobias = new ArbolGeneral<>("Tobias");
        ArbolGeneral<String> agustin = new ArbolGeneral<>("Agustin");
        ArbolGeneral<String> Tiago = new ArbolGeneral<>("Tiago");

        juan.agregarHijo(pedrp);
        juan.agregarHijo(tobias);
        pedrp.agregarHijo(agustin);


        Parcial<String> parcial = new Parcial<>();

        parcial.contarDescendientes(juan);

    }


}
