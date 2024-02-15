
public class Alumno {
    
    private String matricula;
    private String nombre;
    private String paterno;
    private String materno;
    private String licenciatura;
    private String genero;
    
    public Alumno(){}
    public Alumno(String matricula, String nombre, String paterno, String materno, String licenciatura, String genero) {
        this.matricula = matricula;
        this.nombre = nombre;
        this.paterno = paterno;
        this.materno = materno;
        this.licenciatura = licenciatura;
        this.genero = genero;
    }
    
    public String getMatricula(){
        return this.matricula;
    }
    
    public void setMatricula(String matricula){
        this.matricula=matricula;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPaterno() {
        return this.paterno;
    }

    public void setPaterno(String paterno) {
        this.paterno = paterno;
    }

    public String getMaterno() {
        return this.materno;
    }

    public void setMaterno(String materno) {
        this.materno = materno;
    }

    public String getLicenciatura() {
        return this.licenciatura;
    }

    public void setLicenciatura(String licenciatura) {
        this.licenciatura = licenciatura;
    }

    public String getGenero() {
        return this.genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        return    this.matricula + " " + this.nombre + " " + this.paterno + " " + this.materno + " " + this.licenciatura + " " + this.genero;
    }
    
    
    
    
    
}
