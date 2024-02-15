
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class test {
    public static void main(String[] args) throws IOException {
        
        //solamente se han creado los archivos
        File archivoOriginal = new File("canciones.txt");
        File archivoCopia = new File("copia.txt");
        
        
            
            FileReader lectura = new FileReader(archivoOriginal);
            FileWriter escritura = new FileWriter(archivoCopia);
            
            int c;
            while( (c = lectura.read()) !=-1 ){
                  escritura.write(c);
                  
               
            }
            lectura.close();
               escritura.close();
        
        
        
    }
    
}
