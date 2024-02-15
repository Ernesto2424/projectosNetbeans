/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

/**
 *
 * @author Ernesto F.
 */
public class Alumno {
    
    private String nombre;
    private String matricula;
    private double notaFinal;

    public Alumno(){}
    
    public Alumno(String nombre, String matricula, double notaFinal) {
        this.nombre = nombre;
        this.matricula = matricula;
        this.notaFinal = notaFinal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public double getNotaFinal() {
        return notaFinal;
    }

    public void setNotaFinal(double notaFinal) {
        this.notaFinal = notaFinal;
    }

    @Override
    public String toString() {
        return "Alumno{" + "nombre=" + nombre + ", matricula=" + matricula + ", notaFinal=" + notaFinal + '}';
    }
    
    
    
    
    
}
