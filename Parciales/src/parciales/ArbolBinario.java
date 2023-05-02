package parciales;

import estructuras.*;

public class ArbolBinario<T> {
	private T dato;
	private ArbolBinario<T> hijoIzquierdo;   
	private ArbolBinario<T> hijoDerecho; 
	
	public ArbolBinario() {
		super();
	}

	public ArbolBinario(T dato) {
		this.dato = dato;
	}

	/*
	 * getters y setters
	 * 
	 */
	public T getDato() {
		return dato;
	}

	public void setDato(T dato) {
		this.dato = dato;
	}
	
	/**
	 * Preguntar antes de invocar si tieneHijoIzquierdo()
	 * @return
	 */
	public ArbolBinario<T> getHijoIzquierdo() {
		return this.hijoIzquierdo;
	}

	public ArbolBinario<T> getHijoDerecho() {
		return this.hijoDerecho;

	}

	public void agregarHijoIzquierdo(ArbolBinario<T> hijo) {
		this.hijoIzquierdo = hijo;
	}

	public void agregarHijoDerecho(ArbolBinario<T> hijo) {
		this.hijoDerecho = hijo;
	}

	public void eliminarHijoIzquierdo() {
		this.hijoIzquierdo = null;
	}

	public void eliminarHijoDerecho() {
		this.hijoDerecho = null;
	}

	public boolean esVacio() {
		return this.getDato() == null && !this.tieneHijoIzquierdo() && !this.tieneHijoDerecho();
	}

	public boolean esHoja() {
		return (!this.tieneHijoIzquierdo() && !this.tieneHijoDerecho());

	}

	@Override
	public String toString() {
		return this.getDato().toString();
	}

	 
	public boolean tieneHijoIzquierdo() {
		return this.hijoIzquierdo!=null;
	}

	 
	public boolean tieneHijoDerecho() {
		return this.hijoDerecho!=null;
	}

	public int contarHojas() {
		int HHD = 0;
		int HHI = 0;
		
		if (this.esHoja()) {
			return 1;				
		} else {
			if (this.tieneHijoIzquierdo()) {
				HHI = this.getHijoIzquierdo().contarHojas();
			}
			if (this.tieneHijoDerecho()) {
				HHD = this.getHijoDerecho().contarHojas();
			}
		}
		
		return HHI + HHD;		// Cada vez que retorne, va a devolver las Hojas de Hijo Izquierdo + las Hojas del Dijo Derecho
	}
	

    public ArbolBinario<T> espejo() {
		ArbolBinario<T> aEspejo = new ArbolBinario<T>();
		if (this.tieneHijoIzquierdo()) {			// Si el arbol original tiene hijo izquierdo,
			aEspejo.agregarHijoDerecho(this.getHijoIzquierdo().espejo());		// lo inserta como derecho en el nuevo
		}
		if (this.tieneHijoDerecho()) {				// Si el arbol original tiene hijo derecho,
			aEspejo.agregarHijoIzquierdo(this.getHijoDerecho().espejo());		// lo inserta como izquierdo en el nuevo
		}
		return aEspejo;
	}

	
	public void entreNiveles(int n, int m) {
		int nivelActual = 0;
		ColaGenerica<ArbolBinario<T>> cola = new ColaGenerica<>();
		ArbolBinario<T> arbol;
		cola.encolar(this);
		cola.encolar(null);
		
		if ((n >= 0) && (m <= nivelActual)) {		// Valida los datos
			while (!cola.esVacia()) {
				arbol = cola.desencolar();
				if (arbol == null) {			// Se mete si llega a un final de nivel
					if (!cola.esVacia()) {		// Si quedan datos en la cola,
						cola.encolar(null);		//   encola null para marca el fin de ese nivel
						nivelActual++;
					}
				} else {
					if (n <= nivelActual && nivelActual <= m) {		// Si el nivel actual esta entre los parametros,
						System.out.println(arbol.getDato());		// imprime el dato.
					}
					if (arbol.tieneHijoIzquierdo()) {
						cola.encolar(arbol.getHijoIzquierdo());
					}
					if (arbol.tieneHijoDerecho()) {
						cola.encolar(arbol.getHijoDerecho());
					}
				}
			}
		}
	}
	
	public Personaje princesaAccesible() {
		Personaje p = princesaAccesible2();
		if (p.esPrincesa()) {
			return p;
		} else {
			return null;
		}
	}
	
	private Personaje princesaAccesible2() {
		Personaje p = (Personaje) this.getDato();
		if (p.esPrincesa()) {
			return p;
		}
		if ((this.tieneHijoIzquierdo()) && (!((Personaje) this.getHijoIzquierdo().getDato()).esDragon())) {
			p = this.getHijoIzquierdo().princesaAccesible();
		}
		
		if ((this.tieneHijoDerecho()) && (!((Personaje) this.getHijoDerecho().getDato()).esDragon())) {
			p = this.getHijoDerecho().princesaAccesible();
		}
		return p;
	}
	
	

	

}
