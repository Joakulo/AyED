package ejercicio3;

import tp02.ejercicio2.*;

public class Ejercicio3_b_PilaGenerica<T> {

	private ListaGenerica<T> List = new ListaEnlazadaGenerica<T>();
	
	public void apilar(T x) {
		List.agregarFinal(x);
	}
	
	public T desapilar() {
		T x = this.tope();
		List.eliminarEn(List.tamanio());
		return x;
	}
	
	public T tope() {
		return List.elemento(List.tamanio());
	}
	
	public boolean esVacia() {
		return List.esVacia();
	}
}
