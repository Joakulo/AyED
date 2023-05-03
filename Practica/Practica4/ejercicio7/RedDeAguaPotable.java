package ejercicio7;

import estructuras.*;

public class RedDeAguaPotable {
	
	private ArbolGeneral<Double> arbol;
	
	public RedDeAguaPotable () {
		
	}
	
	public <T> RedDeAguaPotable (ArbolGeneral<Double> arbol) {
		this.arbol = arbol;
	}

	public double minimoCaudal(double caudal) {
		
		Double min = 99999.9;
		
		if (arbol.esHoja()) {
			return arbol.getDato();		// Caso base
		} else {
			ListaGenerica<ArbolGeneral<Double>> hijos = arbol.getHijos();
			
			Double caudalHijos = caudal / hijos.tamanio();		// Saco un promedio del caudal pasado
			for (int i = 1; i <= hijos.tamanio(); i++) {		// como parametro,
				hijos.elemento(i).setDato(caudalHijos);			// y se lo asigno a cada hijo
			}
			
			hijos.comenzar();
			while (!hijos.fin()) {															// Recupero el dato de cada nodo hijo,
				RedDeAguaPotable arbolHijos = new RedDeAguaPotable(hijos.proximo());		// y lo voy comparando con el resto,
				min = Math.min(arbolHijos.minimoCaudal(caudalHijos), min);					// para que min se vaya actualizando.
			}
						
			return min;
		}
	}

}
