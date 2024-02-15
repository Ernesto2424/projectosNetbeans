

public class Test {

    public static void main(String[] args) {
        String estados = manejoArchivos.ManejoArchivos.leerArchivoCadena("ESTADOS.txt");
        
        System.out.println("estados = " + estados);
        
       manejoArchivos.ManejoArchivos.leerArchivo("ESTADOS.txt");
    }
    
}
