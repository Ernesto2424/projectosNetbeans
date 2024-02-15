/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uam.pvoe.sw.tablaObjetos.modelo;

/**
 *
 * @author
 */
public class Promedio {
    
    private String matriculaAlumno;
    private String promedio;

    public String getMatriculaAlumno() {
        return matriculaAlumno;
    }

    public void setMatriculaAlumno(String matriculaAlumno) {
        this.matriculaAlumno = matriculaAlumno;
    }

    public String getPromedio() {
        return promedio;
    }

    public void setPromedio(String promedio) {
        this.promedio = promedio;
    }
    
    public String toString(){
        return promedio;
    }
    
}
