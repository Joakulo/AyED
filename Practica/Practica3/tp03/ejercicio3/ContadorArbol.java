package tp03.ejercicio3;

import tp02.ejercicio2.*;
import tp03.ejercicio1.*;

public class ContadorArbol {

	ArbolBinario<Integer> arbol = new ArbolBinario<Integer>();
	
	private ListaEnlazadaGenerica<Integer> numerosParesInOrden(ArbolBinario<Integer> arbol, ListaEnlazadaGenerica<Integer> Lista){
		if (arbol.tieneHijoIzquierdo()) {
			numerosParesInOrden(arbol.getHijoIzquierdo(), Lista);
		}
		if (arbol.getDato() % 2 == 0){
			Lista.agregarFinal(arbol.getDato());
		}
		if (arbol.tieneHijoDerecho()) {
			numerosParesInOrden(arbol.getHijoDerecho(), Lista);
		}
		return Lista;
	}
	
	private ListaEnlazadaGenerica<Integer> numerosParesInOrden(){
		ListaEnlazadaGenerica<Integer> Lista = new ListaEnlazadaGenerica<Integer>();
		numerosParesInOrden(arbol, Lista);
		return Lista;
	}
	
	private ListaEnlazadaGenerica<Integer> numerosParesPostOrden(ArbolBinario<Integer> arbol, ListaEnlazadaGenerica<Integer> Lista){
		if (arbol.tieneHijoIzquierdo()) {
			numerosParesInOrden(arbol.getHijoIzquierdo(), Lista);
		}
		if (arbol.tieneHijoDerecho()) {
			numerosParesInOrden(arbol.getHijoDerecho(), Lista);
		}
		if (arbol.getDato() % 2 == 0){
			Lista.agregarFinal(arbol.getDato());
		}
		return Lista;
	}
	
	private ListaEnlazadaGenerica<Integer> numerosParesPostOrden(){
		ListaEnlazadaGenerica<Integer> Lista = new ListaEnlazadaGenerica<Integer>();
		numerosParesPostOrden(arbol, Lista);
		return Lista;
	}
}
