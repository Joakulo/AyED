package ejercicio1;

import tp02.ejercicio1.*;

public class Ejercicio1_6 {

	public int calculo (int n){
		if (n > 1){
			if (n % 2 == 0) {
				n = n / 2;
			} else {
				n = n*3 + 1;
			}
		}
		return n;
	}
	
	public ListaDeEnterosEnlazada calcularSucesion (int n) {
		ListaDeEnterosEnlazada L = null; 
		if (n > 1) {
			calcularSucesion(calculo(n));
		} else {
			L = new ListaDeEnterosEnlazada(); 
		}
		L.agregarFinal(n);
		return L;
		}
	
	
	public static void main(String[] args) {
		Ejercicio1_6 f = new Ejercicio1_6();
		ListaDeEnterosEnlazada L = f. calcularSucesion(4);
		L.comenzar();
        while (!L.fin()) {
            System.out.println(L.proximo());
        }
	}

}
