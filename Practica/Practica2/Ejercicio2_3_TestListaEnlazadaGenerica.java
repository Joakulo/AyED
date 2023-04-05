package ejercicio2;

import tp02.ejercicio2.*;

public class Ejercicio2_3_TestListaEnlazadaGenerica {

	public static void main(String[] args) {
		
		ListaEnlazadaGenerica<Estudiante> List = new ListaEnlazadaGenerica<Estudiante>();
		
		List.agregarFinal(new Estudiante("Joaquin", "Santa Cruz", 1, "algunmail@gmail.com", "Calle Falsa 123"));
		List.agregarFinal(new Estudiante("Pancho", "Menes", 2, "menesmufa@gmail.com", "Mufa 456"));
		List.agregarFinal(new Estudiante("Dron", "04", 2, "cosoarcoiris@gmail.com", "Plaz Moreno"));
		List.agregarFinal(new Estudiante("Ratipe", "Pelegrini", 2, "ratipe@gmail.com", "Cueva"));
	
		List.comenzar();
        for (int i = 1; i <= List.tamanio(); i++){
            System.out.println(List.elemento(i).tusDatos());
            System.out.println("---------------");
        } 
		
	}

}
