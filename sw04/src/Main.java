
import java.util.LinkedList;


public class Main {
    
    public static void main(String[] args) {
        Alumno al, alu ;
        al = new Alumno("matricula", "nombre", "apellidoP", "apellidoM", 20, "genero", "CBI", "actividades1 actividades2 actividades3");
        alu = new Alumno("matricula2", "nombre2", "apellidoP2", "apellidoM2", 10, "genero2", "csh", "actividades12 actividades22 actividades32");
        LinkedList lista = new LinkedList();
        lista.add(al);
        lista.add(alu);
        System.out.println(lista.getFirst());
        System.out.println(lista.getLast());
    }
    
}
