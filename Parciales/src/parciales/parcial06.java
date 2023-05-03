package parciales;
import estructuras.*;

public class parcial06 {

	ArbolBinario<Integer> arbol;
	
	public ArbolBinario<Integer> minEnNivelAB(int n) {
		ColaGenerica<ArbolBinario<Integer>> cola = new ColaGenerica<>();
		ArbolBinario<Integer> aux, Min = null;
		Integer min = -1;
		int nivel = 0;
		
		cola.encolar(arbol);
		cola.encolar(null);
		
		while (!cola.esVacia()) {
			aux = cola.desencolar();
			if (aux != null) {
				if ((nivel == n) && (aux.esHoja())) {
					min = Math.max(aux.getDato(), min);
					Min = aux;
				}
				if (aux.tieneHijoIzquierdo()) {
					cola.encolar(aux.getHijoIzquierdo());
				}
				if (aux.tieneHijoDerecho()) {
					cola.encolar(aux.getHijoDerecho());
				}
			} else {
				nivel++;
				if (nivel > n) {
					return Min;
				}
				cola.encolar(null);
			}
		}
		return Min;
	}
}