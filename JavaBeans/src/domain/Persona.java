package domain;

import java.io.Serializable;
import java.util.Objects;

public class Persona implements Serializable{
    
    /*
    para que se considere un java bean se dene cumplir con los siguientes
    requisitos:
    
    -implementar de la clase Serializable
    -atributos privados
    -constructor vacio
    -metodos get & set
    
    
    */

private String nombre;
private String apellido;

public Persona(){}

public Persona(String nombre, String apellido){
    this.nombre= nombre;
    this.apellido=apellido;
}

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return this.apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Override
    public String toString() {
        return "Persona{" + "nombre=" + nombre + ", apellido=" + apellido + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + Objects.hashCode(this.nombre);
        hash = 47 * hash + Objects.hashCode(this.apellido);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Persona other = (Persona) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.apellido, other.apellido)) {
            return false;
        }
        return true;
    }
    
    



    
}
