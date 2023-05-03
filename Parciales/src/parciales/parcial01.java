package parciales;
import estructuras.*;

public class parcial01 {
	
	public ListaGenerica<ArbolGeneral<Integer>> devolverCamino (ArbolGeneral<Integer> arbol) {
		ListaGenerica<ArbolGeneral<Integer>> Lista = new ListaEnlazadaGenerica<>();
		Lista.agregarFinal(arbol);
		devolverCamino (arbol, Lista);
		return Lista;
	}
	
	private void devolverCamino (ArbolGeneral<Integer> arbol, ListaGenerica<ArbolGeneral<Integer>> Lista) {
		if (arbol.esHoja()) {
			Lista.agregarFinal(arbol);
		} else {
			ListaGenerica<ArbolGeneral<Integer>> hijos = arbol.getHijos();
			hijos.comenzar();
			for (int i = 1; i < arbol.getDato(); i++) {
				hijos.proximo();
			}
			Lista.agregarFinal(hijos.proximo());
			devolverCamino(Lista.elemento(Lista.tamanio()), Lista);
		}
	}
}
