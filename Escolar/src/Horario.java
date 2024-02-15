
public class Horario 
{
	private String clavehorario;
	private String horas;
	private String dias;
	private String clavemat;
	private String clavesal;
	private String numecopro;
	
	public Horario(String clavehorario, String horas, String dias, String clavemat, String clavesal,
			String numecopro) 
	{
		this.clavehorario = clavehorario;
		this.horas = horas;
		this.dias = dias;
		this.clavemat = clavemat;
		this.clavesal = clavesal;
		this.numecopro = numecopro;
	}

	public String getClaveHorario() {
		return clavehorario;
	}

	public void setClaveHorario(String claveHorario) {
		this.clavehorario = claveHorario;
	}

	public String getHoras() {
		return horas;
	}

	public void setHoras(String horas) {
		this.horas = horas;
	}

	public String getDias() {
		return dias;
	}

	public void setDias(String dias) {
		this.dias = dias;
	}

	public String getClaveMat() {
		return clavemat;
	}

	public void setClaveMat(String clavemat) {
		this.clavemat = clavemat;
	}

	public String getClaveSal() {
		return clavesal;
	}

	public void setClaveSal(String clavesal) {
		this.clavesal = clavesal;
	}

	public String getNumEcopro() {
		return numecopro;
	}

	public void setNumEcopro(String numecopro) {
		this.numecopro = numecopro;
	}

	@Override
	public String toString() {
		return "Horario [claveHorario=" + clavehorario + " |院 Horas=" + horas + " |院 Dias=" + dias + " |院 clave Mat="
				+ clavemat + " |院 clave Salon=" + clavesal + " |院 Numero Economico de Profesor=" + numecopro + "]";
	}

	
	
	}

	

