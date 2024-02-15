
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Operacion {
    
    public LinkedList almacena(String archivo, LinkedList lista){
        
        String cadenaleida="";
        FileReader fr;
        
        try{
            fr = new FileReader(archivo);
            BufferedReader archivolectura = new BufferedReader(fr);
            Alumno alumno;
           // System.out.println("los alumnos son:\n");
            cadenaleida = archivolectura.readLine();
            while(cadenaleida != null){
                alumno = new Alumno();
                StringTokenizer st = new StringTokenizer(cadenaleida, ",");
                alumno.setMatricula(st.nextToken());
                alumno.setNombre(st.nextToken());
                alumno.setPaterno(st.nextToken());
                alumno.setMaterno(st.nextToken());
                alumno.setLicenciatura(st.nextToken());
                alumno.setGenero(st.nextToken());
                
                lista.add(alumno);
                
               // System.out.println(alumno.toString());
                
                cadenaleida = archivolectura.readLine();
                
            }
            archivolectura.close();
        }catch(FileNotFoundException e){
            System.out.println("file not found");
            e.printStackTrace();
        }catch(IOException e){
            System.out.println("file not read");
            e.printStackTrace();
        }  
        return lista;
} 
    
    
    public int busquedaMatricula(LinkedList lista, String matricula){
        int posicion = -1;
        for(int i=0; i<lista.size(); ++i){
            Alumno al = (Alumno) lista.get(i);
            if(al.getMatricula().compareTo(matricula) == 0 ){
                posicion = i;
                System.out.println(lista.get(i).toString()+"\n");
                break;
            }else if (i == lista.size()-1){
                System.out.println("MATRICULA INEXISTENTE\n");
            }
        }
        
        return posicion;
    }
    
    public void eliminarMatricula(LinkedList lista, String matricula){
        int posicion = -1;
        for(int i=0; i<lista.size(); ++i){
            Alumno al = (Alumno) lista.get(i);
            if(al.getMatricula().compareTo(matricula) == 0 ){
                posicion = i;
                lista.remove(i);
                System.out.println("ELIMINADO EXITOSAMENTE\n");
                break;
            }else if (i == lista.size()-1){
                System.out.println("MATRICULA INEXISTENTE\n");
            }
        }
        
    }
    
    public int busquedaLicenciatura(LinkedList lista, String licenciatura){
        int pos = -1;
        for(int i=0; i<lista.size(); ++i){
            Alumno al = (Alumno) lista.get(i);
            if(al.getLicenciatura().compareTo(licenciatura)==0){
                pos = i;
                System.out.println(lista.get(i).toString());
            }
        }
        System.out.println("\n");
        
        return 0;
        
    }
    
    public int busquedaGenero(LinkedList lista, String genero){
        int po = -1;
        for(int i=0; i<lista.size(); ++i){
            Alumno al = (Alumno) lista.get(i);
            if(al.getGenero().compareTo(genero)==0){
                po = i;
                System.out.println(lista.get(i).toString());
            }
        }
        System.out.println("\n");
        return 0;
        
    }
    
    
    
    
    
}