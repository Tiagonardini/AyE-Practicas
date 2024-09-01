package practica2.ejercicio4;

public class AreaEmpresa {
    private String nombreDeArea;
    private int tiempoDeTransmision;

    public AreaEmpresa (String nombreDeArea, int tiempoDeTransmision){
        this.nombreDeArea = nombreDeArea;
        this.tiempoDeTransmision = tiempoDeTransmision;
    }
    public String getNombreDeArea() {
        return nombreDeArea;
    }
    public int getTiempoDeTransmision() {
        return tiempoDeTransmision;
    }

}
