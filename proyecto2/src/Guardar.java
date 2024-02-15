
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Guardar {
    
    public void guarda(ArrayList<Personaje> per){
        try {
            FileWriter fw = new FileWriter("heroe.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(per.toString());
            bw.write("\n");
            bw.close();
            fw.close();
        } catch (IOException ex) {
           
            Logger.getLogger(Guardar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
