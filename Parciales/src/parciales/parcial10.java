package parciales;
import estructuras.*;

public class parcial10 {
	public ListaGenerica<Integer> resolver (ArbolBinario<Integer> arbol) {
		ListaGenerica<Integer> Lista = new ListaEnlazadaGenerica<>();
		resolver(arbol, Lista);
		return Lista;
	}
	
	private int resolver(ArbolBinario<Integer> arbol, ListaGenerica<Integer> Lista) {
		int cantHI = 0, cantHD = 0;
		
		if (!arbol.esHoja()) {
			if (arbol.tieneHijoIzquierdo()) {
				cantHI += resolver(arbol.getHijoIzquierdo(), Lista);
			}
			if (arbol.tieneHijoDerecho()) {
				cantHD += resolver(arbol.getHijoDerecho(), Lista);
			}
		}
		if (cantHI == cantHD) {
			Lista.agregarFinal(arbol.getDato());
		}
		return cantHI + cantHD + 1;
	}
}
