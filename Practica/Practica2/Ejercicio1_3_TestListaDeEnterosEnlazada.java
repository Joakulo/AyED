package ejercicio1;

import tp02.ejercicio1.*;

public class Ejercicio1_3_TestListaDeEnterosEnlazada {
	
	public static void main(String[] args) {

		ListaDeEnteros List = new ListaDeEnterosEnlazada();
		
		for (String s:args)
		{
			List.agregarFinal(Integer.parseInt(s));
		}
		
		List.comenzar();
		while (!List.fin())
		{
			System.out.println(List.proximo());
		}
		
		
	}

	
	
}
