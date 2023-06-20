package ejercicio6;
import estructuras.*;
import grafos.*;

public class VisitaOslo {

	public ListaGenerica<String> paseoEnBici(Grafo<String> lugares, String destino, int maxTiempo, ListaGenerica<String> lugaresRestringidos){
		ListaGenerica<String> camino = new ListaEnlazadaGenerica<>();
		if (!lugares.esVacio()) {
			if ((!lugaresRestringidos.incluye(destino)) && (!lugaresRestringidos.incluye("Ayuntamiento"))) {
				int i = buscarCiudades(lugares, "Ayuntamiento", destino);
				if (i != -1) {
					boolean[] marca = new boolean[lugares.listaDeVertices().tamanio() + 1];
					marca = marcarCiudades(lugares, marca, lugaresRestringidos);
					ListaGenerica<String> lista = new ListaEnlazadaGenerica<>();
					paseoEnBici(lugares, i, camino, lista, marca, destino, maxTiempo, 0);
				}
			}
		}
		return camino;
	}
	
	private void paseoEnBici(Grafo<String> lugares, int i, ListaGenerica<String> camino, ListaGenerica<String> lista, boolean[] marca, String destino, int maxTiempo, int tiempoActual) {
		marca[i] = true;
		Vertice<String> v = lugares.vertice(i);
		if (v.dato().equals(destino)) {
			copiar(camino, lista);
		} else {
			ListaGenerica<Arista<String>> ady = lugares.listaDeAdyacentes(v);
			ady.comenzar();
			while ((!ady.fin()) && (camino.esVacia())) {
				Arista<String> ari = ady.proximo();
				Vertice<String> sig = ari.verticeDestino();
				int j = sig.getPosicion();
				if ((!marca[j]) && (tiempoActual + ari.peso() < maxTiempo)) {
					lista.agregarFinal(sig.dato());
					paseoEnBici(lugares, j, camino, lista, marca, destino, maxTiempo, tiempoActual);
					lista.eliminarEn(lista.tamanio());
				}
			}
			
		}
	}
	
	private int buscarCiudades(Grafo<String> lugares, String inicio, String destino) {
		int c1 = -1, c2 = -1;
		ListaGenerica<Vertice<String>> vertices = lugares.listaDeVertices();
		Vertice<String> city;
		vertices.comenzar();
		while ((!vertices.fin()) && (c1 == -1 || c2 == -1)) {
			city = vertices.proximo();
			if (city.dato().equals(inicio)) {
				c1 = city.getPosicion();
			} else if (city.dato().equals(destino)) {
				c2 = 1;
			}
		}
		if (c1 != -1 && c2 != -1) {
			return c1;
		}
		return -1;
	}
	
	private boolean[] marcarCiudades(Grafo<String> lugares, boolean[] marca, ListaGenerica<String> lugaresRestringidos) {
		ListaGenerica<Vertice<String>> vertices = lugares.listaDeVertices();
		lugaresRestringidos.comenzar();
		while (!lugaresRestringidos.fin()) {
			String lugar = lugaresRestringidos.proximo();
			vertices.comenzar();
			while (!vertices.fin()) {
				Vertice<String> v = vertices.proximo();
				if (v.dato().equals(lugar)) {
					marca[v.getPosicion()] = true;
				}
			}
		}
		return marca;
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
}
