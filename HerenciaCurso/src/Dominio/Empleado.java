package Dominio;

public class Empleado extends Persona{
    
    private int idempleado;
    private double sueldo;
    private static int contadorEmpleado;
    
    public Empleado(){}

    public Empleado(String nombre, double sueldo) {
        super(nombre);
//        this.idempleado = ++Empleado.contadorEmpleado;
//          this es para el objeto y Empleado es para la clase (uso de static)
        this.idempleado = ++Empleado.contadorEmpleado;
        this.sueldo = sueldo;
    }
    
    
    
    

    //public Empleado(String nombre, char genero, int edad, String direccion) {
        //super se usa para inicalizar los atributos de la clase Padre
        //debiido a que los constructores no se heredan
      //  super(nombre, genero, edad, direccion);
    //}

    public int getIdempleado() {
        return this.idempleado;
    }

    

    public double getSueldo() {
        return this.sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    @Override
    public String toString() {
        return "Empleado{" + "idempleado=" + idempleado + " Persona="+super.toString() + ", sueldo=" + sueldo + '}';
    }
    
    
    
}
