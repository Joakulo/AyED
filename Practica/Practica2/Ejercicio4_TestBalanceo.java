package ejercicio3;

import java.util.Scanner;
import tp02.ejercicio2.*;

public class Ejercicio4_TestBalanceo {
	
    public static boolean balanceo(String s) {
        ListaGenerica<Character> apertura = new ListaEnlazadaGenerica<Character>();
        apertura.agregarFinal('(');
        apertura.agregarFinal('[');
        apertura.agregarFinal('{');

        ListaGenerica<Character> cierre = new ListaEnlazadaGenerica<Character>();
        cierre.agregarFinal(')');
        cierre.agregarFinal(']');
        cierre.agregarFinal('}');

        Ejercicio3_b_PilaGenerica<Character> pila = new Ejercicio3_b_PilaGenerica<Character>();
        
        Character act,x;

        for (int i=0; i<s.length(); i++) {
        	act = s.charAt(i);
        	if (apertura.incluye(act)) {
        		pila.apilar(act);
        	} else {
        		x = pila.desapilar();
        		if (apertura.elemento(x) != cierre.elemento(act)) {
        			return false;
        		}
        	}

        }
        return pila.esVacia();
	}
    
    public static void main(String[] args) {
    	Scanner scan = new Scanner(System.in);
    	System.out.println("Ingrese los caracteres {}[]() en el orden deseado.");
    	String s = scan.nextLine();
    	scan.close();
  
    	if (balanceo(s)) {
    		System.out.println("Balanceada.");
    	} else {
    		System.out.println("Desbalanceada." );
    	}
	}

	
	
}
