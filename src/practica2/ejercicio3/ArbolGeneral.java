package practica2.ejercicio3;

import practica1.ejercicio3.ColaGenerica;
import practica1.ejercicio3.ListaEnlazadaGenerica;
import practica1.ejercicio3.ListaGenerica;
import practica2.ejercicio4.AreaEmpresa;

public class ArbolGeneral<T> {

	private T dato;

	private ListaGenerica<ArbolGeneral<T>> hijos = new ListaEnlazadaGenerica<ArbolGeneral<T>>();

	public T getDato() {
		return dato;
	}

	public void setDato(T dato) {
		this.dato = dato;
	}

	public void setHijos(ListaGenerica<ArbolGeneral<T>> hijos) {
		if (hijos==null)
			this.hijos = new ListaEnlazadaGenerica<ArbolGeneral<T>>();
		else
			this.hijos = hijos;
	}

	public ArbolGeneral(T dato) {
		this.dato = dato;
	}

	public ArbolGeneral(T dato, ListaGenerica<ArbolGeneral<T>> hijos) {
		this(dato);
		if (hijos==null)
			this.hijos = new ListaEnlazadaGenerica<ArbolGeneral<T>>();
		else
			this.hijos = hijos;
	}

	public ListaGenerica<ArbolGeneral<T>> getHijos() {
		return this.hijos;
	}

	public void agregarHijo(ArbolGeneral<T> unHijo) {

		this.getHijos().agregarFinal(unHijo);
	}

	public boolean esHoja() {

		return !this.tieneHijos();
	}
	
	public boolean tieneHijos() {
		return !this.hijos.esVacia();
	}
	
	public boolean esVacio() {

		return this.dato == null && !this.tieneHijos();
	}

	

	public void eliminarHijo(ArbolGeneral<T> hijo) {
		if (this.tieneHijos()) {
			ListaGenerica<ArbolGeneral<T>> hijos = this.getHijos();
			if (hijos.incluye(hijo)) 
				hijos.eliminar(hijo);
		}
	}
	
	public ListaEnlazadaGenerica<T> preOrden() {
		return null;
	}

	public Integer altura() {
		var altura = 0;
		if(!esHoja()){
			altura--;
			ListaGenerica<ArbolGeneral<T>> hijos = getHijos();
			hijos.comenzar();
			while (!hijos.fin()){
				ArbolGeneral<T> nodoHijo = hijos.proximo();
				int alturaDelHijo = nodoHijo.altura();
				if (alturaDelHijo > altura){
					altura = alturaDelHijo;
				}
			}
		}else{
			return altura;
		}
		return altura +1;
	}



	public Integer nivel(T dato) {
		int contadorNivel = 0;
		if (this.dato.equals(dato)){
			return 0;
		}
		ColaGenerica<ArbolGeneral<T>> cola = new ColaGenerica<>();
		cola.encolar(this);
		cola.encolar(null);

		while (!cola.esVacia()) {
			ArbolGeneral<T> nodoActual = cola.desencolar();
			if (nodoActual == null) {
				if (!cola.esVacia()){
					contadorNivel++;
					cola.encolar(null);
				}
			} else {
				if (nodoActual.dato.equals(dato)){
					return contadorNivel;
				}
				ListaGenerica<ArbolGeneral<T>> hijos = nodoActual.getHijos();
				hijos.comenzar();
				while (!hijos.fin()) {
					cola.encolar(hijos.proximo());
				}
			}
		}

		return -1;
	}



	public Integer ancho() {
		var contadorNivel = 0;
		var maxAncho = 0;

		ColaGenerica<ArbolGeneral<T>> cola = new ColaGenerica<>();
		cola.encolar(this);
		cola.encolar(null);

		while (!cola.esVacia()) {
			ArbolGeneral<T> nodoActual = cola.desencolar();
			if (nodoActual == null) {
				if (contadorNivel > maxAncho){
					maxAncho = contadorNivel;
				}
				contadorNivel = 0;
				if (!cola.esVacia()) {
					cola.encolar(null);
				}
			} else {
				contadorNivel++;
				ListaGenerica<ArbolGeneral<T>> hijos = nodoActual.getHijos();
				hijos.comenzar();
				while (!hijos.fin()) {
					cola.encolar(hijos.proximo());
				}
			}
		}
		return maxAncho;
	}


//	public boolean esAncestro(T a, T b) {
//
//	}


	public boolean esLleno( ) {
		if (this.esHoja()) {
			return true;
		}

		ListaGenerica<ArbolGeneral<T>> hijos = this.getHijos();
		int cantidadHijos = hijos.tamanio();

		// Un nodo en un árbol lleno debe tener 0 o 2 hijos
		if (cantidadHijos != 2 && cantidadHijos != 0) {
			return false;
		}

		// Revisar recursivamente todos los hijos
		hijos.comenzar();
		while (!hijos.fin()) {
			if (!hijos.proximo().esLleno()) {
				return false;
			}
		}

		return true;
	}


	public boolean esCompleto(){
		ColaGenerica<ArbolGeneral<T>> cola = new ColaGenerica<>();
		cola.encolar(this);
		boolean nivelIncompleto = false;

		while (!cola.esVacia()) {
			ArbolGeneral<T> nodoActual = cola.desencolar();
			ListaGenerica<ArbolGeneral<T>> hijos = nodoActual.getHijos();

			hijos.comenzar();
			while (!hijos.fin()) {
				ArbolGeneral<T> hijo = hijos.proximo();

				if (hijo != null) {
					if (nivelIncompleto) {
						// Si encontramos un nodo después de haber detectado un nivel incompleto, no es un árbol completo
						return false;
					}
					cola.encolar(hijo);
				} else {
					// Si encontramos un hijo nulo, marcamos que el siguiente nivel debe estar incompleto
					nivelIncompleto = true;
				}
			}
		}

		return true;
	}


}