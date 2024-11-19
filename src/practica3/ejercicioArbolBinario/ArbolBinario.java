package practica3.ejercicioArbolBinario;

import practica1.ejercicio3.ColaGenerica;
import practica1.ejercicio3.ListaEnlazadaGenerica;
import practica1.ejercicio3.ListaGenerica;
import practica2.ejercicio3.ArbolGeneral;

public class ArbolBinario<T> {
	private T dato;
	private ArbolBinario<T> hijoIzquierdo;   
	private ArbolBinario<T> hijoDerecho; 

	
	public ArbolBinario() {
		super();
	}

	public ArbolBinario(T dato) {
		this.dato = dato;
	}




	public void entreNiveles(int n, int m){
		int i = 0;
		recorrerEntreNiveles(this, i, n, m);
	}

	public void recorrerEntreNiveles(ArbolBinario<T> nodoActual, int nivelActual, int nivelMin, int nivelMax){
		if (nivelActual >= nivelMin && nivelActual <= nivelMax){
			System.out.println(nodoActual.dato);
		}
		if (nivelActual < nivelMax){
			recorrerEntreNiveles(nodoActual.hijoIzquierdo, nivelActual +1, nivelMin, nivelMax);
			recorrerEntreNiveles(nodoActual.hijoDerecho, nivelActual +1, nivelMin, nivelMax);
		}
	}





	/*public ListaGenerica< Integer > numerosImparesMayoresQuePorNiveles(ArbolGeneral<Integer> a, Integer n) {
		ListaEnlazadaGenerica<Integer> listaNumeros = new ListaEnlazadaGenerica<>();
		ColaGenerica<ArbolGeneral<Integer>> cola = new ColaGenerica<>();

		cola.encolar(a);

		while (!cola.esVacia()){
			ArbolGeneral<Integer> nodoActual = cola.desencolar();
			if (esImparYMayorQue(nodoActual.getDato(), n)){
				listaNumeros.agregarFinal(nodoActual.getDato());
			}


			ListaGenerica<ArbolGeneral<Integer>> listaHijos = nodoActual.getHijos();
			listaHijos.comenzar();
			while (!listaHijos.fin()){
				cola.encolar(listaHijos.proximo());
			}
		}
		return listaNumeros;
	}*/




	public T getDato() {
		return dato;
	}

	public void setDato(T dato) {
		this.dato = dato;
	}
	
	/**
	 * Preguntar antes de invocar si tieneHijoIzquierdo()
	 * @return
	 */
	public ArbolBinario<T> getHijoIzquierdo() {
		return this.hijoIzquierdo;
	}

	public ArbolBinario<T> getHijoDerecho() {
		return this.hijoDerecho;

	}

	public void agregarHijoIzquierdo(ArbolBinario<T> hijo) {
		this.hijoIzquierdo = hijo;
	}

	public void agregarHijoDerecho(ArbolBinario<T> hijo) {
		this.hijoDerecho = hijo;
	}

	public void eliminarHijoIzquierdo() {
		this.hijoIzquierdo = null;
	}

	public void eliminarHijoDerecho() {
		this.hijoDerecho = null;
	}

	public boolean esVacio() {
		return this.getDato() == null && !this.tieneHijoIzquierdo() && !this.tieneHijoDerecho();
	}

	public boolean esHoja() {
		return (!this.tieneHijoIzquierdo() && !this.tieneHijoDerecho());

	}

	@Override
	public String toString() {
		return this.getDato().toString();
	}

	 
	public boolean tieneHijoIzquierdo() {
		return this.hijoIzquierdo!=null;
	}

	 
	public boolean tieneHijoDerecho() {
		return this.hijoDerecho!=null;
	}


	public int contarHojas() {
		int contador = 0;
		return contadorDeHojas(contador, this);

	}
	private int contadorDeHojas(int contador, ArbolBinario<T> nodo) {
		if (nodo.esHoja()){
			contador++;
		}
		if (nodo.tieneHijoIzquierdo()){
			contador = contadorDeHojas(contador, nodo.hijoIzquierdo);
		}
		if (nodo.tieneHijoDerecho()){
			contador = contadorDeHojas(contador, nodo.hijoDerecho);
		}
		return contador;
	}



	public ArbolBinario<T> espejo( ){
		if (this == null) {
			return null;
		}
		// Crear un nuevo nodo con el mismo dato
		ArbolBinario<T> arbolEspejo = new ArbolBinario<>(this.dato);
		// Recursivamente crear el espejo de los subárboles
		// e intercambiar izquierdo y derecho
		if (this.hijoIzquierdo != null){
			arbolEspejo.hijoDerecho = this.hijoIzquierdo.espejo();
		}
		else {
			arbolEspejo.hijoDerecho = null;
		}
		if (this.hijoDerecho != null){
			arbolEspejo.hijoIzquierdo = this.hijoDerecho.espejo();
		}else{
			arbolEspejo.hijoIzquierdo = null;
		}
		 return arbolEspejo;
	}

	public void preOrder(){
		System.out.println(dato);
		if (tieneHijoIzquierdo()){
			hijoIzquierdo.preOrder();
		}
		if (tieneHijoDerecho()){
			hijoDerecho.preOrder();
		}
	}





	

}
