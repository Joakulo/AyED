package tp03.ejercicio4;

import tp03.ejercicio1.*;

public class RedBinariaLlena {
		
	public static int retardoReenvio(ArbolBinario<Integer> arbol) {
		int max, HI, HD;
		if (arbol.esHoja()) {			// Si llegó a una hoja, devuelve su dato
			return arbol.getDato();
		} else {
			HI = retardoReenvio(arbol.getHijoIzquierdo());		// Va a guardar todo lo que encuentre en la izquierda
			HD = retardoReenvio(arbol.getHijoDerecho());		// Va a guardar todo lo que encuentre en la derecha
			max = Math.max(HI, HD);				// Se queda con el maximo entre lo que encontro en la izquierda y en la derecha
			return max+arbol.getDato();			// Devuelve ese maximo de los hijos + la raíz (dato del nodo actual)
		}
	}
}
