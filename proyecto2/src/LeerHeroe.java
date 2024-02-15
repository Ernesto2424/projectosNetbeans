
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class LeerHeroe {
    
    public void leeHeroe(ArrayList<Personaje> per) {

		try {
			FileReader fr= new FileReader("heroe.txt");
			BufferedReader br= new BufferedReader(fr);
			String linea= br.readLine();
			System.out.println(linea);
			String sub=linea;
			System.out.println("Nombre:"+(sub.substring(sub.indexOf(':')+1,sub.indexOf(","))));
			sub=sub.substring(sub.indexOf(",")+1);
			
			System.out.println("Salud: "+(sub.substring(sub.indexOf(':')+1,sub.indexOf(","))));
			sub=sub.substring(sub.indexOf(",")+1);
			
			System.out.println("Habilidad: "+(sub.substring(sub.indexOf(':')+1,sub.indexOf(","))));
			sub=sub.substring(sub.indexOf(",")+1);
			
			System.out.println("Velocidad: "+(sub.substring(sub.indexOf(':')+1,sub.indexOf(","))));
			sub=sub.substring(sub.indexOf(",")+1);
			
			System.out.println("Fuerza: "+(sub.substring(sub.indexOf(':')+1,sub.indexOf(","))));
			sub=sub.substring(sub.indexOf(",")+1);
			
			System.out.println("NumVidas: "+(sub.substring(sub.indexOf(':')+1,sub.indexOf("}"))));
			System.out.println();
			
			fr.close();
			br.close();
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("");
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		catch(IndexOutOfBoundsException e) {
			System.out.print("Error");
		}
	}

    
}
