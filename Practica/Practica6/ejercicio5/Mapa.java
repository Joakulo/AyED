package ejercicio5;
import estructuras.*;
import grafos.*;

public class Mapa {

	private Grafo<String> mapaCiudades;
	
	private int buscarCiudades (String ciudad1, String ciudad2) {
		int c1 = -1, c2 = -1;
		ListaGenerica<Vertice<String>> vertices = mapaCiudades.listaDeVertices();
		Vertice<String> city;
		vertices.comenzar();
		while (!vertices.fin()) {
			city = vertices.proximo();
			if (city.dato().equals(ciudad1)) {
				c1 = city.getPosicion();
			} else if (city.dato().equals(ciudad2)) {
				c2 = 1;
			}
		}
		if ((c1 != -1) && (c2 != -1)) {
			return c1;
		}
		return -1;	
	}
	
	private void copiar(ListaGenerica<String> camino, ListaGenerica<String> lista) {
		camino.comenzar();
		while (!camino.fin()) {
			camino.eliminarEn(camino.tamanio());
		}
		lista.comenzar();
		while (!lista.fin()) {
			camino.agregarFinal(lista.proximo());
		}
	}
	
	//==============================================================================
	
	public ListaGenerica<String> devolverCamino(String ciudad1, String ciudad2) {
		ListaGenerica<String> camino = new ListaEnlazadaGenerica<>();
		if (!mapaCiudades.esVacio()) {
			int i = buscarCiudades(ciudad1, ciudad2);
			if (i != -1) {
				boolean[] marca = new boolean[mapaCiudades.listaDeVertices().tamanio() + 1];
				ListaGenerica<String> lista = new ListaEnlazadaGenerica<>();
				lista.agregarFinal(ciudad1);
				devolverCamino(i, camino, lista, marca, ciudad2);
			}
		}
		return camino;
	}
	
	private void devolverCamino(int i, ListaGenerica<String> camino, ListaGenerica<String> lista, boolean[] marca, String ciudad2) {
		marca[i] = true;
		Vertice<String> v = mapaCiudades.vertice(i);
		if (v.dato().equals(ciudad2)) {
			copiar(camino, lista);
		}
		if (camino.esVacia()) {
			ListaGenerica<Arista<String>> ady = mapaCiudades.listaDeAdyacentes(v);
			ady.comenzar();
			while ((!ady.fin()) & (camino.esVacia())) {
				Vertice<String> sig = ady.proximo().verticeDestino();
				int j = sig.getPosicion();
				if (!marca[j]) {
					lista.agregarFinal(sig.dato());
					devolverCamino(j,camino,lista,marca,ciudad2);
					lista.eliminarEn(lista.tamanio());
				}
			}
		}
	}
	
	//======================================================================================
	
	public ListaGenerica<String> devolverCaminoExceptuando(String ciudad1, String ciudad2, ListaGenerica<String> ciudades){
		ListaGenerica<String> camino = new ListaEnlazadaGenerica<>();
		if (!mapaCiudades.esVacio()) {
			int i = buscarCiudades(ciudad1, ciudad2);
			if (i != -1) {
				boolean[] marca = new boolean[mapaCiudades.listaDeVertices().tamanio() + 1];
				marca = marcarCiudades(marca, ciudades);
				ListaGenerica<String> lista = new ListaEnlazadaGenerica<>();
				lista.agregarFinal(ciudad1);
				devolverCaminoExceptuando(i, camino, lista, marca, ciudad2);
			}
		}
		return camino;
	}
	
	private boolean[] marcarCiudades(boolean[] marca, ListaGenerica<String> ciudades) {
		ListaGenerica<Vertice<String>> vertices = mapaCiudades.listaDeVertices();
		ciudades.comenzar();
		while (!ciudades.fin()) {
			String city = ciudades.proximo();
			vertices.comenzar();
			while (!vertices.fin()) {
				Vertice<String> v = vertices.proximo();
				if (city.equals(v.dato())) {
					marca[v.getPosicion()] = true;
				}
			}
		}
		return marca;
	}
	
	//Igual que el devolverCamino
	private void devolverCaminoExceptuando(int i, ListaGenerica<String> camino, ListaGenerica<String> lista, boolean[] marca, String ciudad2) {
		marca[i] = true;
		Vertice<String> v = mapaCiudades.vertice(i);
		if (v.dato().equals(ciudad2)) {
			copiar(camino, lista);
		} else if (camino.esVacia()){
			ListaGenerica<Arista<String>> ady = mapaCiudades.listaDeAdyacentes(v);
			ady.comenzar();
			while ((!ady.fin()) && (camino.esVacia())) {
				Vertice<String> sig = ady.proximo().verticeDestino();
				int j = sig.getPosicion();
				if (!marca[j]) {
					lista.agregarFinal(sig.dato());
					devolverCaminoExceptuando(i, camino, lista, marca, ciudad2);
					lista.eliminarEn(lista.tamanio());
				}
			}
		}
	}
	
	//============================================================================
	
	public ListaGenerica<String> caminoMasCorto(String ciudad1, String ciudad2) {
		Minimo<String> min = new Minimo<>();
		if (!mapaCiudades.esVacio()) {
			int i = buscarCiudades(ciudad1, ciudad2);
			if (i != -1) {
				min.setMinimo(9999);
				boolean[] marca = new boolean[mapaCiudades.listaDeVertices().tamanio() + 1];
				ListaGenerica<String> lista = new ListaEnlazadaGenerica<>();
				lista.agregarFinal(ciudad1);
				caminoMasCorto(i, min, lista, marca, ciudad2, 0);
			}
		}
		return min.getLista();
	}
	
	private void caminoMasCorto(int i, Minimo<String> min, ListaGenerica<String> lista, boolean[] marca, String ciudad2, int distancia) {
		marca[i] = true;
		Vertice<String> v = mapaCiudades.vertice(i);
		if ((v.dato().equals(ciudad2)) && (distancia < min.getMinimo())) {
			copiar(min.getLista(), lista);
			min.setMinimo(distancia);
		} else {
			ListaGenerica<Arista<String>> ady = mapaCiudades.listaDeAdyacentes(v);
			ady.comenzar();
			while (!ady.fin()) {
				Arista<String> ari = ady.proximo();
				Vertice<String> sig = ari.verticeDestino();
				int j = sig.getPosicion();
				if (!marca[j]) {
					lista.agregarFinal(sig.dato());
					caminoMasCorto(i, min, lista, marca, ciudad2, distancia + ari.peso());
					lista.eliminarEn(lista.tamanio());
				}
			}
		}
		marca[i] = false;
	}
	
	//=============================================================================
	
	public ListaGenerica<String> caminoSinCargarCombustible(String ciudad1, String ciudad2, int tanqueAuto){
		ListaGenerica<String> camino = new ListaEnlazadaGenerica<>();
		if (!mapaCiudades.esVacio()) {
			int i = buscarCiudades(ciudad1, ciudad2);
			if (i != -1) {
				boolean[] marca = new boolean[mapaCiudades.listaDeVertices().tamanio() + 1];
				ListaGenerica<String> lista = new ListaEnlazadaGenerica<>();
				lista.agregarFinal(ciudad1);
				caminoSinCargarCombustible(i, camino, lista, marca, ciudad2, tanqueAuto);
			}
		}
		return camino;
	}
	
	private void caminoSinCargarCombustible(int i, ListaGenerica<String> camino, ListaGenerica<String> lista, boolean[] marca, String ciudad2, int tanqueAuto) {
		marca[i] = true;
		Vertice<String> v = mapaCiudades.vertice(i);
		if (v.dato().equals(ciudad2)) {
			copiar(camino, lista);
		} else if (camino.esVacia()){
			ListaGenerica<Arista<String>> ady = mapaCiudades.listaDeAdyacentes(v);
			ady.comenzar();
			while (!ady.fin() && (camino.esVacia())) {
				Arista<String> ari = ady.proximo();
				Vertice<String> sig = ari.verticeDestino();
				int j = sig.getPosicion();
				if ((!marca[j]) && (tanqueAuto - ari.peso() >= 0)) {
					lista.agregarFinal(sig.dato());
					caminoSinCargarCombustible(j, camino, lista, marca, ciudad2, tanqueAuto-ari.peso());
					lista.eliminarEn(lista.tamanio());
				}
			}
		}
	}
	
	//=======================================================================
	
	public ListaGenerica<String> caminoConMenorCargaDeCombustible(String ciudad1, String ciudad2, int tanqueAuto) {
		Minimo<String> min = new Minimo<>();
		if (!mapaCiudades.esVacio()) {
			int i = buscarCiudades(ciudad1, ciudad2);
			if (i != -1) {
				min.setMinimo(9999);
				boolean[] marca = new boolean[mapaCiudades.listaDeVertices().tamanio() + 1];
				ListaGenerica<String> lista = new ListaEnlazadaGenerica<>();
				lista.agregarFinal(ciudad1);
				caminoConMenorCargaDeCombustible(i, min, lista, marca, ciudad2, tanqueAuto, tanqueAuto, 0);
			}
		}
		return min.getLista();
	}
	
	private void caminoConMenorCargaDeCombustible(int i, Minimo<String> min, ListaGenerica<String> lista, boolean[] marca, String ciudad2, int tanqueFull, int tanqueActual, int cantCargas) {
		marca[i] = true;
		Vertice<String> v = mapaCiudades.vertice(i);
		if (v.dato().equals(ciudad2)) {
			copiar(min.getLista(), lista);
			min.setMinimo(cantCargas);
		} else {
			ListaGenerica<Arista<String>> ady = mapaCiudades.listaDeAdyacentes(v);
			ady.comenzar();
			while (!ady.fin()) {
				Arista<String> ari = ady.proximo();
				Vertice<String> sig = ari.verticeDestino();
				int j = sig.getPosicion();
				if ((!marca[j]) && (cantCargas < min.getMinimo())) {
					lista.agregarFinal(sig.dato());
					if (tanqueActual - ari.peso() >= 0) {
						caminoConMenorCargaDeCombustible(j, min, lista, marca, ciudad2, tanqueFull, tanqueActual - ari.peso(), cantCargas);
					} else {
						caminoConMenorCargaDeCombustible(j, min, lista, marca, ciudad2, tanqueFull, tanqueFull, cantCargas + 1);
					}
					lista.eliminarEn(lista.tamanio());
				}
			}
		}
		marca[i] = false;
	}
}
