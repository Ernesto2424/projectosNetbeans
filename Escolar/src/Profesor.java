
public class Profesor {

	private String numEco;
	private String nombre;
		
	public Profesor(String numEco, String nombre) {
		super();
		this.numEco = numEco;
		this.nombre = nombre;

	}
	public String getNumEco() {
		return numEco;
	}
	public void setNumEco(String numEco) {
		this.numEco = numEco;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String toString() {
		return "Profesor --> |NumEco=" + numEco + ", <-->Nombre=" + nombre + " |";
	}

}

