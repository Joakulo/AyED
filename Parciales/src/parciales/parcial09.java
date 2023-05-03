package parciales;
import estructuras.*;

public class parcial09 {
	private ArbolGeneral<Integer> arbol;

	public ListaGenerica<Integer> devolverCamino () {
		ListaGenerica<Integer> camino = new ListaEnlazadaGenerica<>();
		ListaGenerica<Integer> aux = new ListaEnlazadaGenerica<>();
		devolverCamino(arbol, camino, aux);
		return camino;
	}
	
	private void devolverCamino (ArbolGeneral<Integer> arbol, ListaGenerica<Integer> camino, ListaGenerica<Integer> aux) {
		aux.agregarFinal(arbol.getDato());
		if (arbol.esHoja()) {
			if (aux.tamanio() > camino.tamanio()) {
				camino = aux.clonar();
			}
		} else {
			ListaGenerica<ArbolGeneral<Integer>> hijos = arbol.getHijos();
			hijos.comenzar();
			while (!hijos.fin()) {
				devolverCamino(hijos.proximo(), camino, aux);
				aux.eliminarEn(aux.tamanio());
			}
		}
	}
}
