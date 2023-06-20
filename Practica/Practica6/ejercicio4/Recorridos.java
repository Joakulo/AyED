package ejercicio4;

import estructuras.*;
import grafos.*;

public class Recorridos<T> {

	public ListaGenerica<T> dfs (Grafo<T> grafo){
		ListaGenerica<T> camino = new ListaEnlazadaGenerica<>();
		if (!grafo.esVacio()) {
			boolean[] marca = new boolean[grafo.listaDeVertices().tamanio() + 1];
			for (int i = 1; i<= grafo.listaDeVertices().tamanio() + 1; i++) {
				dfs(i, camino, marca, grafo);
			}
				
		}
		return camino;
	}
	
	private void dfs (int i, ListaGenerica<T> camino, boolean[] marca, Grafo<T> grafo) {
		marca[i] = true;
		Vertice<T> v = grafo.vertice(i);
		ListaGenerica<Arista<T>> ady = grafo.listaDeAdyacentes(v);
		ady.comenzar();
		while (!ady.fin()) {
			Vertice<T> sig = ady.proximo().verticeDestino();
			int j = sig.getPosicion();
			if (!marca[j]) {
				camino.agregarFinal(sig.dato());
				dfs(j, camino, marca, grafo);
			}
		}
	}
	

	public void bfs(Grafo<T> grafo) {
		boolean[] marca = new boolean[grafo.listaDeVertices().tamanio()+1];
		for (int i = 1; i <= marca.length; i++) {
			if (!marca[i])
			this.bfs(i, grafo, marca);
		}
	}
	
	private void bfs (int i, Grafo<T> grafo, boolean[] marca) {
		ListaGenerica<Arista<T>> ady = null;
		ColaGenerica<Vertice<T>> cola = new ColaGenerica<>();
		Vertice<T> v;
		
		cola.encolar(grafo.vertice(i));
		marca[i] = true;
		
		while (!cola.esVacia()) {
			v = cola.desencolar();
			System.out.println(v.dato());
			ady = grafo.listaDeAdyacentes(v);
			ady.comenzar();
			while (!ady.fin()) {
				Arista<T> arista = ady.proximo();
				int j = arista.verticeDestino().getPosicion();
				if (!marca[j]) {
					marca[j] = true;
					cola.encolar(arista.verticeDestino());
				}
			}
		}
		
	}
}
