
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Guarda_Jefe {
     public void guarda(ArrayList<Personaje> per){
        try {
            FileWriter fw = new FileWriter("jefe.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(per.toString());
            bw.close();
            fw.close();
        } catch (IOException ex) {
            ex.printStackTrace();
            Logger.getLogger(Guardar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
