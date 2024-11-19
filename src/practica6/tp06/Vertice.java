package practica6.tp06;

/**
 * Representa una Vertice de un grafo.
 * 
 *
 */
public interface Vertice<T> {
	
	public T dato();
	public void setDato(T dato);
	public int getPosicion();
	void setPosicion(int posicion);
}
