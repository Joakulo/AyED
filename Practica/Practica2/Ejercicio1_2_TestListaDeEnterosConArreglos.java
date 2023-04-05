package ejercicio1;

import tp02.ejercicio1.*;

public class Ejercicio1_2_TestListaDeEnterosConArreglos {
	
	

	public static void main(String[] args) {

		ListaDeEnterosConArreglos List = new ListaDeEnterosConArreglos();
		
		for (String s:args)
		{
			List.agregarFinal(Integer.parseInt(s));
		}
		
		List.comenzar();
		for (int i=0; i<List.tamanio(); i++)
		{
			System.out.println(List.proximo());
		}
	}

	
	
}
