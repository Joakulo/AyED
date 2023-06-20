package estructuras;

public class ArbolGeneral<T> {

	private T dato;

	private ListaGenerica<ArbolGeneral<T>> hijos = new ListaEnlazadaGenerica<ArbolGeneral<T>>();

	public T getDato() {
		return dato;
	}

	public void setDato(T dato) {
		this.dato = dato;
	}

	public void setHijos(ListaGenerica<ArbolGeneral<T>> hijos) {
		if (hijos==null)
			this.hijos = new ListaEnlazadaGenerica<ArbolGeneral<T>>();
		else
			this.hijos = hijos;
	}

	public ArbolGeneral(T dato) {
		this.dato = dato;
	}

	public ArbolGeneral(T dato, ListaGenerica<ArbolGeneral<T>> hijos) {
		this(dato);
		if (hijos==null)
			this.hijos = new ListaEnlazadaGenerica<ArbolGeneral<T>>();
		else
			this.hijos = hijos;
	}

	public ListaGenerica<ArbolGeneral<T>> getHijos() {
		return this.hijos;
	}

	public void agregarHijo(ArbolGeneral<T> unHijo) {

		this.getHijos().agregarFinal(unHijo);
	}

	public boolean esHoja() {

		return !this.tieneHijos();
	}
	
	public boolean tieneHijos() {
		return !this.hijos.esVacia();
	}
	
	public boolean esVacio() {

		return this.dato == null && !this.tieneHijos();
	}

	

	public void eliminarHijo(ArbolGeneral<T> hijo) {
		if (this.tieneHijos()) {
			ListaGenerica<ArbolGeneral<T>> hijos = this.getHijos();
			if (hijos.incluye(hijo)) 
				hijos.eliminar(hijo);
		}
	}
	
	public ListaEnlazadaGenerica<T> preOrden() {
		return null;
	}
	
	public Integer altura() {
		ColaGenerica<ArbolGeneral<T>> cola = new ColaGenerica<>();
		ArbolGeneral<T> aux;
		ListaGenerica<ArbolGeneral<T>> hijos;
		Integer altura = 0;
		
		cola.encolar(this);
		cola.encolar(null);
		
		while (!cola.esVacia()) {
			aux = cola.desencolar();
			if (aux == null) {					// Si llegue a la final de un nivel,
				if (!cola.esVacia()) {			// y quedan datos en la cola,
					altura++;					// aumento el nivel,
					cola.encolar(null);			// y marco otro cambio de nivel
				}
			} else if (aux.tieneHijos()) {
				hijos = aux.getHijos();
				hijos.comenzar();
				while (!hijos.fin()) {
					cola.encolar(hijos.proximo());
				}
			}
		}
		return altura;
	}
	
	public Integer nivel(T dato) {
		ColaGenerica<ArbolGeneral<T>> cola = new ColaGenerica<>();
		ArbolGeneral<T> aux = this;
		ListaGenerica<ArbolGeneral<T>> hijos;
		Integer nivel = 0;
		
		cola.encolar(this);
		cola.encolar(null);
		
		while (!cola.esVacia()) {
			aux = cola.desencolar();
			if (aux == null) {
				if (!cola.esVacia()) {			// Si saque un null y quedan datos,
					nivel++;					// sumo el nivel,
					cola.encolar(null);			// agrego otro null para marcar un cambio de nivel.
				}	
			} else {
				if (aux.getDato() == dato) {	// Si encontre el dato,
					return nivel;				// devuelvo el valor actual de nivel.
				}
				if (aux.tieneHijos()) {			// Si no lo encontre,
					hijos = aux.getHijos();		// sigo buscando en los hijos.
					hijos.comenzar();
					while (!hijos.fin()) {
						cola.encolar(hijos.proximo());
					}
				}
			}
		}
		return -1;		// Si llegue a este punto quiere decir que no encotro el dato, entonces devuelve -1
	}

	public Integer ancho() {
		ColaGenerica<ArbolGeneral<T>> cola = new ColaGenerica<>();
		ArbolGeneral<T> aux;
		ListaGenerica<ArbolGeneral<T>> hijos;
		Integer ancho = 0, max = -1;

		cola.encolar(this);
		cola.encolar(null);

		while (!cola.esVacia()) {
			aux = cola.desencolar();
			if (aux != null) {					// Si saque un dato,
				ancho++;						// aumento el ancho del nivel actual
				if (aux.tieneHijos()) {
					hijos = aux.getHijos();		// Meto hijos a la cola*
					hijos.comenzar();
					while (!hijos.fin()) {
						cola.encolar(hijos.proximo());
					}
				}
			} else {							// Si saque un null hago 3 cosas:
				if (!cola.esVacia()) {			// 1.  Si quedan datos,
					cola.encolar(null);			//	agrego otro null para marcar un cambio de nivel.
				}

				if (ancho > max) {				// 2.  Comparo la cantidad de datos del nivel que
					max = ancho;				// 	acabo de leer, si es mayor a max, actualizo.
				}
				ancho = 0;						// 3.  Reseteo el ancho para el nuevo nivel
			}
		}
		
		return max;
	}
	
	public boolean esAncestro(T a, T b) {
        ArbolGeneral<T> aux = buscarAncestro(a);		// Toma el arbol/subarbol A y lo guarda en aux.
        if(aux == null) {								// Si no encontro el dato A, devuelve false.
            return false;
        }    
        else {											// Si lo encontro, busca desde el arbol A,
            if(aux.buscarAncestro(b) != null){			// el dato B, si lo encuentre, devuelve true,
                return true;
            }
        }
        return false;									// si no lo encuentra, devuelve false.
    }
	
    private ArbolGeneral<T> buscarAncestro(T dato){
    	if (this.esVacio()) {							// Si el arbol no tiene datos,
            return null;								// devuelve null.
        }
        if(this.getDato().equals(dato)) {				// Si el dato actual equivale al que estamos
            return this;								// buscando, devuelve el nodo.
        }
        
        ArbolGeneral<T> aux;
        ListaGenerica<ArbolGeneral<T>> hijos = this.getHijos();
        hijos.comenzar();
        while(!hijos.fin()) {
        	aux = hijos.proximo().buscarAncestro(dato);		// Llama al metodo desde todos los hijos
            if(aux != null) {							// Si se devolvio algo != null, quiere decir que
                return aux;								// encontro el dato, asi que lo devuelve	
             }
        }
        return null;
    }
    
    public ArbolGeneral<T> esCreciente () {
    	ColaGenerica<ArbolGeneral<T>> cola = new ColaGenerica<>();
    	ListaGenerica<ArbolGeneral<T>> hijos;
    	ArbolGeneral<T> aux, max = null;
    	int cantHijosActual = 0, cantHijosMax = 0, nivel = 0, nodos = 0;
    	
    	cola.encolar(this);
    	cola.encolar(null);
    	
    	while (!cola.esVacia()) {
    		aux = cola.desencolar();
    		if (aux != null) {
    			nodos++;
    			if (aux.tieneHijos()) {
    				hijos = aux.getHijos();
    				hijos.comenzar();
    				while (!hijos.fin()) {
    					cola.encolar(hijos.proximo());
    					cantHijosActual++;
    				}
    				if (cantHijosActual > cantHijosMax) {
						cantHijosMax = cantHijosActual;
						max = aux; 
					}
    				cantHijosActual = 0;
    			}
    		} else {
    			if (!cola.esVacia()) {
    				if (nivel + 1 != nodos) {
    					return null;
    				}
    				cola.encolar(null);
    				nivel++;
    				nodos = 0;
    			}
    		}
    	}
    	return max;
    }
    
    /*
    public void ImprimirPorNiveles () {
    	ColaGenerica<ArbolGeneral<T>> cola = new ColaGenerica<>();
    	ListaGenerica<ArbolGeneral<T>> hijos;
    	ArbolGeneral<T> aux;
    	
    	cola.encolar(this);
    	cola.encolar(null);
    	
    	while (!cola.esVacia()) {
    		aux = cola.desencolar();
    		if (aux != null) {
    			System.out.println(aux.getDato().toString() + " ");
    			if (aux.tieneHijos()) {
    				hijos = aux.getHijos();
    				hijos.comenzar();
    				while (!hijos.fin()) {
    					cola.encolar(hijos.proximo());
    				}
    			}
    		} else {
    			if (!cola.esVacia()) {
    				System.out.println();
    				cola.encolar(null);
    			}
    		}
    	}
    }
    */
}