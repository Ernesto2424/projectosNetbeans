
public class Salon {

	private String clavesal;
	private String nombre;
	
	public Salon(String clavesal, String nombre) {
		super();
		this.clavesal = clavesal;
		this.nombre = nombre;
	}
	public String getClaveSal() {
		return clavesal;
	}
	public void setClave(String clavesal) {
		this.clavesal = clavesal;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String toString() {
		return "Salon --> |Clave=" + clavesal + ", Nombre=" + nombre + " |";
	}
	
}
