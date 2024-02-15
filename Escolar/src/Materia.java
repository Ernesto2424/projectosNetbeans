public class Materia {

	private String clavemat;
	private String nombre;
	private int Creditos;
	
	public Materia(String clavemat, String nombre, int creditos) {
		super();
		this.clavemat = clavemat;
		this.nombre = nombre;
		Creditos = creditos;
	}
	
	public String getClaveMat() {
		return clavemat;
	}
	public void setClavemat(String clavemat) {
		this.clavemat = clavemat;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getCreditos() {
		return Creditos;
	}
	public void setCreditos(int creditos) {
		Creditos = creditos;
	}
	
	public String toString() {
		return "Materia --> |Clave=" + clavemat + ", Nombre=" + nombre + ", Creditos=" + Creditos + "|";
	}
	
}
