
public class Alumno {
    private String matricula;
    private String nombre;
    private String apellidoP;
    private String apellidoM;
    private int edad;
    private String genero;
    private String division;
    private String actividades;
    
    /* metodo constructor */
    public Alumno(){}
    
    public Alumno(String matricula, String nombre, String apellidoP, String apellidoM, int edad, String genero, String division, String actividades){
        this.matricula = matricula;
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.edad = edad;
        this.genero = genero;
        this.division= division;
        this.actividades = actividades;
        
    }
    
    public void setMatricula(String matricula){
        this.matricula = matricula;
    }
    public String getMatricula(){
        return this.matricula;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public String getNombre(){
        return this.nombre;
    }
    
    public void setApellidoP(String apellidoP){
        this.apellidoP = apellidoP;
    }
    public String getApellidoP(){
        return this.apellidoP;
    }
    
    public void setApellidoM(String apellidoM){
        this.apellidoM = apellidoM;
    }
    public String getApellidoM(){
        return this.apellidoM;
    }
    
    public void setEdad(int edad){
        this.edad = edad;
    }
    public int getEdad(){
        return this.edad;
    }
    
    public void setGenero(String genero){
        this.genero = genero;
    }
    public String getGenero(){
        return this.genero;
    }
    
    public void setDivision(String division){
        this.division = division;
    }
    public String getDivision(){
        return this.division;
    }
    
    public void setActividades(String actividades){
        this.actividades = actividades;
    }
    public String getActividades(){
        return this.actividades;
    }

    @Override
    public String toString() {
        return     this.matricula + ", " + this.nombre + ", " + this.apellidoP + ", " + this.apellidoM + ", " + this.edad + ", " + this.genero + ", " + this.division + ", " + this.actividades ;
    }
    
    
    
}
