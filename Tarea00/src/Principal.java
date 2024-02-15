
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Principal {
    
public  static void main(String[] args) {
        
         Scanner sc = new Scanner(System.in);
    
        LinkedList lista = new LinkedList();
        Operacion op = new Operacion();
        op.almacena("alumnos.dat",lista);
        
        int respuesta;
        boolean r = false;
        
        while (r==false){
            System.out.println("Seleccione una opcion:\n"
                            + "1. Buscar alumno por matricula\n"
                            + "2. Buscar alumnos por licenciatura\n"
                            + "3. Buscar alumnos por genero\n"
                            + "4. Borrar alumno por matricula\n"
                            + "5. Salir");
            respuesta = sc.nextInt();
            if(respuesta==5){
                r = true;
            }else if(respuesta ==4){
                System.out.print("INGRESE MATRICULA: ");
                String a;
                a = sc.next();
                Operacion b = new Operacion(); b.eliminarMatricula(lista, a);
            }else if(respuesta ==3){
                
                System.out.print("INGRESE EL GENERO: ");
                String bb;
                bb=sc.next();
                Operacion z = new Operacion();
                z.busquedaGenero(lista, bb);
                
                
                
            }else if(respuesta == 2){
                
                System.out.print("INGRESE LICENCIATURA: ");
                String b = sc.next();
                Operacion o = new Operacion();
                o.busquedaLicenciatura(lista, b);
                        
                
                
            }else if(respuesta == 1){
                
                System.out.print("INGRESE MATRICULA: ");
                String a;
                a = sc.next();
                Operacion b = new Operacion(); b.busquedaMatricula(lista, a);
            }else{
                System.out.println("¡INGRESE UNA OPCION VALIDA!\n");
            }
        }
        
        
       
        
        
        
        
        
    }
    
}
