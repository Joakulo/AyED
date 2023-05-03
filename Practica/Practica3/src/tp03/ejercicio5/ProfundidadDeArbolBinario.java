package tp03.ejercicio5;

import tp02.ejercicio2.*;
import tp03.ejercicio1.*;

public class ProfundidadDeArbolBinario {

	ArbolBinario<Integer> arbol = new ArbolBinario<>();
	
	public int sumaElementosProfundidad(int p) {
		ColaGenerica<ArbolBinario<Integer>> cola = new ColaGenerica<>();
		ArbolBinario<Integer> aux;
		int nivelActual = 0, suma = 0;
		cola.encolar(arbol);		// Encola la raíz
		cola.encolar(null); 		// Marca un cambio de nivel
		
		while (!cola.esVacia()) {
			aux = cola.desencolar();
			if (aux != null) {			// Se mete si desencola un dato
				if (nivelActual == p) {				// Se mete si llegó al nivel pedido
					while (aux != null) {			// Lee y suma todos los datos restantes de la cola
						suma += aux.getDato();
						aux = cola.desencolar();
					}
				} else {				// Se mete si todavia no llego al nivel pedido y encola los hijos
					if (aux.tieneHijoIzquierdo()) {
						cola.encolar(aux.getHijoIzquierdo());
					}
					if (aux.tieneHijoDerecho()) {
						cola.encolar(aux.getHijoDerecho());
					}
				}
			} else if (!cola.esVacia()) {			// Llega si desencoló un null
				nivelActual++;						// Se mete si quedan datos por leer
				cola.encolar(null);					// Marca un cambio de nivel
			}
		}
		return suma;
	}
}
