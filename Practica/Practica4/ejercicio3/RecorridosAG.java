package ejercicio3;

import estructuras.*;

public class RecorridosAG {

	public ListaGenerica<Integer> numerosImparesMayoresQuePreOrden (ArbolGeneral<Integer> a, Integer n) {
		ListaEnlazadaGenerica<Integer> Lista = new ListaEnlazadaGenerica<>();
		numerosImparesMayoresQuePreOrden(Lista, a, n);
		return Lista;
	}

	private void numerosImparesMayoresQuePreOrden (ListaGenerica<Integer> Lista, ArbolGeneral<Integer> a, Integer n) {
		
		if ((a.getDato() % 2 == 1) & (a.getDato() > n)) {
			Lista.agregarFinal(a.getDato());
		}
		
		if (a.tieneHijos()) {
			ListaGenerica<ArbolGeneral<Integer>> listaHijos = a.getHijos();
			listaHijos.comenzar();
			while (!listaHijos.fin()) {
				numerosImparesMayoresQuePreOrden(Lista, listaHijos.proximo(), n);
			}
		}
	}

	public ListaGenerica<Integer> numerosImparesMayoresQueInOrden (ArbolGeneral <Integer> a, Integer n) {
		ListaEnlazadaGenerica<Integer> Lista = new ListaEnlazadaGenerica<>();
		numerosImparesMayoresQueInOrden(Lista, a, n);
		return Lista;
	}
	
	
	private void numerosImparesMayoresQueInOrden (ListaGenerica<Integer> Lista, ArbolGeneral <Integer> a, Integer n) {
		
		if (a.tieneHijos()) {
			ListaGenerica<ArbolGeneral<Integer>> listaHijos = a.getHijos();
			listaHijos.comenzar();
			numerosImparesMayoresQueInOrden(Lista, listaHijos.proximo(), n);
		}
		
		if ((a.getDato() % 2 == 1) & (a.getDato() > n)) {
			Lista.agregarFinal(a.getDato());
		}
		
		if (a.tieneHijos()) {
			ListaGenerica<ArbolGeneral<Integer>> listaHijos = a.getHijos();
			listaHijos.comenzar();
			listaHijos.proximo();
			while (!listaHijos.fin()) {
				numerosImparesMayoresQueInOrden(Lista, listaHijos.proximo(), n);
			}
		}
	}

	
	public ListaGenerica<Integer> numerosImparesMayoresQuePostOrden (ArbolGeneral<Integer> a, Integer n) {
		ListaEnlazadaGenerica<Integer> Lista = new ListaEnlazadaGenerica<>();
		numerosImparesMayoresQuePostOrden(Lista, a, n);
		return Lista;
	}

	private void numerosImparesMayoresQuePostOrden (ListaGenerica<Integer> Lista, ArbolGeneral<Integer> a, Integer n) {
		
		if (a.tieneHijos()) {
			ListaGenerica<ArbolGeneral<Integer>> listaHijos = a.getHijos();
			listaHijos.comenzar();
			while (!listaHijos.fin()) {
				numerosImparesMayoresQuePostOrden(Lista, listaHijos.proximo(), n);
			}
		}
		
		if ((a.getDato() % 2 == 1) & (a.getDato() > n)) {
			Lista.agregarFinal(a.getDato());
		}
	}
	
	public ListaGenerica<Integer> numerosImparesMayoresQuePorNiveles(ArbolGeneral <Integer> a, Integer n) {
		ColaGenerica<ArbolGeneral<Integer>> cola = new ColaGenerica<>();
		ArbolGeneral<Integer> aux;
		ListaGenerica<ArbolGeneral<Integer>> hijos;
		ListaEnlazadaGenerica<Integer> Lista = new ListaEnlazadaGenerica<>();
		
		cola.encolar(a);
		
		while (!cola.esVacia()) {
			aux = cola.desencolar();
			
			if ((aux.getDato() % 2 == 1) & (aux.getDato() > n)) {
				Lista.agregarFinal(aux.getDato());
			}
			
			if (aux.tieneHijos()) {
				hijos = aux.getHijos();
				hijos.comenzar();
				while (!hijos.fin()) {
					cola.encolar(hijos.proximo());
				}
			}
		}
		
		return Lista;
	}
}
