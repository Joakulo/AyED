package parcialesGrafos;
import estructuras.*;
import grafos.*;

public class programacionT1 {

	public ListaGenerica<ListaGenerica<String>> resolver (Grafo<String> ciudades, String origen, String destino, int maxKilometros){
		ListaGenerica<ListaGenerica<String>> caminos = new ListaEnlazadaGenerica<>();
		if (!ciudades.esVacio()) {
			int i = buscarCiudades(ciudades, origen, destino);
			if (i != -1) {
				ListaGenerica<String> lista = new ListaEnlazadaGenerica<>();
				boolean[] marca = new boolean[ciudades.listaDeVertices().tamanio() + 1];
				resolver(i, ciudades, caminos, lista, marca, destino, maxKilometros, 0);
			}
		}
		return caminos;
	}
	
	private void resolver(int i, Grafo<String> ciudades, ListaGenerica<ListaGenerica<String>> caminos, ListaGenerica<String> lista, boolean[] marca, String destino, int maxK, int actK) {
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
				if ((!marca[j]) && (actK + ari.peso() <= maxK)) {
					lista.agregarFinal(sig.dato());
					resolver(j, ciudades, caminos, lista, marca, destino, maxK, actK + ari.peso());
					lista.eliminarEn(lista.tamanio());
				}
			}
		}
		marca[i] = false;
	}
	
	private int buscarCiudades(Grafo<String> ciudades, String origen, String destino) {
		int c1 = -1, c2 = -1;
		ListaGenerica<Vertice<String>> vertices = ciudades.listaDeVertices();
		vertices.comenzar();
		Vertice<String> city;
		while (!vertices.fin()) {
			city = vertices.proximo();
			if (city.dato().equals(origen)) {
				c1 = city.getPosicion();
			} else if (city.dato().equals(destino)) {
				c2 = 0;
			}
		}
		if (c2 != -1) {
			return c1;
		}
		return -1;
	}
}
