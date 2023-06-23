package parcialesGrafos;
import estructuras.*;
import grafos.*;

public class programacionT2 {

	public ListaGenerica<ListaGenerica<String>> resolver(Grafo<String> ciudades, String origen, String destino, ListaGenerica<String> evitarPasandoPor){
		ListaGenerica<ListaGenerica<String>> caminos = new ListaEnlazadaGenerica<>();
		if (!ciudades.esVacio()) {
			int i = buscarCiudades(ciudades.listaDeVertices(), origen, destino);
			if (i != -1) {
				ListaGenerica<String> lista = new ListaEnlazadaGenerica<>();
				boolean[] marca = new boolean[ciudades.listaDeVertices().tamanio() + 1];
				marcarCiudades(ciudades.listaDeVertices(), marca, evitarPasandoPor);
				resolver(i, ciudades, caminos, lista, marca, destino, evitarPasandoPor);
			}
		}
		return caminos;
	}
	
	private void resolver(int i, Grafo<String> ciudades, ListaGenerica<ListaGenerica<String>> caminos, ListaGenerica<String> lista, boolean[] marca, String destino, ListaGenerica<String> prohibidos) {
		marca[i] = true;
		Vertice<String> v = ciudades.vertice(i);
		if (v.dato().equals(destino)) {
			caminos.agregarFinal(lista.clonar());
		} else {
			ListaGenerica<Arista<String>> ady = ciudades.listaDeAdyacentes(v);
			ady.comenzar();
			while (!ady.fin()) {
				Arista<String> ari = ady.proximo();
				Vertice<String> sig = ari.verticeDestino();
				int j = sig.getPosicion();
				if (!marca[j]) {
					lista.agregarFinal(sig.dato());
					resolver(j, ciudades, caminos, lista, marca, destino, prohibidos);
					lista.eliminarEn(lista.tamanio());
				}
			}
		}
		marca[i] = false;
	}
	
	private void marcarCiudades(ListaGenerica<Vertice<String>> vertices, boolean[] marca, ListaGenerica<String> prohibidos) {
		prohibidos.comenzar();
		while(!prohibidos.fin()) {
			vertices.comenzar();
			String v1 = prohibidos.proximo();
			while (!vertices.fin()) {
				Vertice<String> v = vertices.proximo();
				if (v1.equals(v.dato())) {
					marca[v.getPosicion()] = true;
				}
			}
		}
	}
	
	private int buscarCiudades(ListaGenerica<Vertice<String>> vertices, String origen, String destino) {
		int c1 = -1, c2 = -1;
		vertices.comenzar();
		while (!vertices.fin()) {
			Vertice<String> city = vertices.proximo();
			if (city.dato().equals(origen)) {
				c1 = city.getPosicion();
			} else if (city.dato().equals(destino)){
				c2 = 0;
			}
		}
		if (c2 != -1) {
			return c1;
		}
		return -1;
	}
	
	
}
