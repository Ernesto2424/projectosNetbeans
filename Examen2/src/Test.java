
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Test {

public static void main(String[] args){
    Arma a1 = new Arma(85.0, "AK-47", "arma larga", 50.0);
    Potenciador p[ ]= new Potenciador[5];
    p[0]= new Potenciador(50, 80, 45, "mi potenciador", "la descripcion", 47);
    Jefe j1 = new Jefe(a1, "Jefe de jefes", 90, 75);
    
    Heroe h1 = new Heroe(50, 64, 54, 645, "max", 54, 45);
    h1.agregaItem(p[0]);
    
    
    Personaje per[] = new Personaje[2];
    per[0]= j1;
    per[1] = h1;
    
    System.out.println(j1);
    System.out.println(h1);
    
    try {
        FileWriter fw = new FileWriter("Miarchivo.txt");
        BufferedWriter bw = new BufferedWriter(fw);
        System.out.println("se intenta escribir en el archivo Miarchivo.txt");
        bw.write(j1.toString());
        bw.write("\n");
        bw.write("\n");
        bw.write(h1.toString());
        bw.close();
        fw.close();
    } catch (IOException ex) {
        Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
    }
    
 
}

    
}
