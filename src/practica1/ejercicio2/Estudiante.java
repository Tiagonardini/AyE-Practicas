package practica1.ejercicio2;

public class Estudiante {
    private String nombre;
    private String apellido;
    private int legajo;

    public Estudiante (String nombre, String apellido, int legajo){
        this.nombre = nombre;
        this.apellido = apellido;
        this.legajo = legajo;
    }

    public void tusDatos(){
        System.out.println(nombre+apellido+legajo);
    }
}
