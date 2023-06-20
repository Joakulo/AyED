package ejercicio5;
import estructuras.*;

public class Minimo<T> {

	private int minimo;
	private ListaGenerica<T> lista;
	
	public void setMinimo(int i) {
		minimo = i;
	}
	
	public int getMinimo() {
		return minimo;
	}
	
	public void setLista(ListaGenerica<T> l) {
		lista = l;
	}
	
	public ListaGenerica<T> getLista(){
		return lista;
	}
}
