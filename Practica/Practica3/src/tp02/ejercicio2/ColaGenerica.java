package tp02.ejercicio2;

public class ColaGenerica<T> {
	private ListaGenerica<T> List = new ListaEnlazadaGenerica<T>();
	
	public void encolar(T elem) {
		List.agregarFinal(elem);
	}
	
	public T desencolar() {
			List.eliminarEn(1);
			return this.tope();
	}
	
	public T tope() {
		return List.elemento(1);
	}
	
	public boolean esVacia() {
		return List.esVacia();
	}
}
