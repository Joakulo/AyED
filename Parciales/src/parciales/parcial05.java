package parciales;
import estructuras.*;

public class parcial05 {

	public ListaGenerica<ListaGenerica<Character>> caminosPares(ArbolGeneral<Character> arbol) {
		ListaGenerica<ListaGenerica<Character>> ListaGeneral = new ListaEnlazadaGenerica<ListaGenerica<Character>>();
		int nodos = 0;
		ListaGenerica<Character> lista = new ListaEnlazadaGenerica<Character>();
		lista.agregarFinal(arbol.getDato());
		caminosPares(arbol, ListaGeneral, lista, nodos);
		return ListaGeneral;
	}
	
	private void caminosPares (ArbolGeneral<Character> arbol, ListaGenerica<ListaGenerica<Character>> ListaGeneral, ListaGenerica<Character> lista, int nodos) {
		nodos++;
		if ((arbol.esHoja()) && (nodos % 2 == 0)) {
			ListaGeneral.agregarFinal(lista.clonar());
		}
		if (arbol.tieneHijos()) {
			ListaGenerica<ArbolGeneral<Character>> hijos = arbol.getHijos();
			hijos.comenzar();
			while (!hijos.fin()) {
				ArbolGeneral<Character> proximo = hijos.proximo();
				lista.agregarFinal(proximo.getDato());
				caminosPares(arbol, ListaGeneral, lista, nodos);
				lista.eliminarEn(lista.tamanio());
			}
		}
	}
}
