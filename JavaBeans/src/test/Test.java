package test;

import domain.Persona;

public class Test {

    public static void main(String[] args) {
        
        Persona persona = new Persona();
        persona.setNombre("ERNESTO");
        persona.setApellido("FLORES");
        
        //System.out.println("persona = " + persona);
        System.out.println("Nombre:"+persona.getNombre() + " Apellido:" +persona.getApellido());
        
        
    }
    
}
