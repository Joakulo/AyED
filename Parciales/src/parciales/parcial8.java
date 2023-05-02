package parciales;
import estructuras.*;

public class parcial8 {

		ArbolGeneral<Integer> arbol;
		
		public ListaGenerica<Integer> resolver() {
			ListaGenerica<Integer> Lista = new ListaEnlazadaGenerica<>();
			resolver(Lista, arbol);
			return Lista;
		}
		
		private void resolver(ListaGenerica<Integer> Lista, ArbolGeneral<Integer> aux) {
			if (arbol.tieneHijos()) {
				ListaGenerica<ArbolGeneral<Integer>> hijos = arbol.getHijos();
				hijos.comenzar();
				while (!hijos.fin()) {
					resolver(Lista, hijos.proximo());
				}
				
				if (hijos.tamanio() % 2 == 1) {
					hijos.comenzar();
					Integer suma = 0;
					while (!hijos.fin()) {
						suma += hijos.proximo().getDato();
					}
					Lista.agregarFinal(suma);
				}
			}
		}
}
