package parciales;

public class parcial7 {

		public Integer sumaImparesPosOrdenMayorA (ArbolBinario<Integer> ab, int limite) {
			Integer suma = 0;
			
			if (ab.tieneHijoIzquierdo()) {
				suma += sumaImparesPosOrdenMayorA(ab.getHijoIzquierdo(), limite);
			}
			if (ab.tieneHijoDerecho()) {
				suma += sumaImparesPosOrdenMayorA(ab.getHijoDerecho(), limite);
			}
			if ((ab.getDato() % 2 == 1) && (ab.getDato() > limite)) {
				return suma + ab.getDato();
			}
			return suma;
		}
}
