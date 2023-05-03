package ejercicio5;

import estructuras.*;

public class AnalizadorArbol {

	public int devolverMaximoPromedio (ArbolGeneral<AreaEmpresa> arbol) {
		
		ColaGenerica<ArbolGeneral<AreaEmpresa>> cola = new ColaGenerica<>();
		ListaGenerica<ArbolGeneral<AreaEmpresa>> hijos;
		ArbolGeneral<AreaEmpresa> aux;
		
		int ancho = 0, promActual = 0, promMax = -1;
		
		cola.encolar(arbol);
		cola.encolar(null);
		
		while (!cola.esVacia()) {
			aux = cola.desencolar();
			if (aux != null) {
				ancho++;
				promActual += aux.getDato().getTardanza();
				if (aux.tieneHijos()) {
					hijos = aux.getHijos();
					hijos.comenzar();
					while (!hijos.fin()) {
						cola.encolar(hijos.proximo());
					}
				}
			} else {
				promActual /= ancho;
				promMax = Math.max(promActual, promMax);
				if (!cola.esVacia()) {
					cola.encolar(null);
					ancho = 0;
					promActual = 0;
				}
			}
		}
		
		return promMax;
	}
	
}
