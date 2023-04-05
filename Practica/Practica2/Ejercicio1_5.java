package ejercicio1;

import tp02.ejercicio1.*;

public class Ejercicio1_5 {

	public static void ImprimirRecursivo(ListaDeEnteros L, int t)
	{
		if (t > 0)
		{
			System.out.println(L.elemento(t));
			ImprimirRecursivo(L,--t);
		}
	}
	
	public static void main(String[] args) {
		
		ListaDeEnteros List = new ListaDeEnterosEnlazada();
		List.agregarFinal(1);
		List.agregarFinal(2);
		List.agregarFinal(3);
		List.agregarFinal(4);
		List.agregarFinal(5);
		List.agregarFinal(6);
		List.agregarFinal(7);
		List.agregarFinal(8);
		List.agregarFinal(9);
		List.agregarFinal(10);
		
		ImprimirRecursivo(List, List.tamanio());

	}

}
