package hilos;


    
    public class Hilo3 extends Thread {
        
        public static int numPalabras = 0;

    @Override
    public void run() {

        numPalabras = manejoArchivos.ManejoArchivos.leerArchivoContar("palabras.txt");
        System.out.println("numero de palabras en archivo: = " + numPalabras);

    }

}
    

