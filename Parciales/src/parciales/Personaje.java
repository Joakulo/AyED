package parciales;

public class Personaje {
	private String tipo;
	
	public String getTipo() {
		return tipo;
	}
	
	 public boolean esDragon(){
		 return this.getTipo().equals("Dragon");
	 }
	
	 public boolean esPrincesa(){
		 return this.getTipo().equals("Princesa");
	 }
}
