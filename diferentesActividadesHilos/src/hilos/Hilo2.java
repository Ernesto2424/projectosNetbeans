package hilos;

import manejoArchivos.*;

public class Hilo2 extends Thread {

    /**
     * Un segundo hilo verifica que la palabra a agregar no se encuentre en el
     * archivo. Si es una nueva palabra, ésta es agregada al archivo; en caso
     * contrario, la palabra no se agrega. En ambos casos se debe indicar lo
     * sucedido.
     */
    @Override
    public void run() {
        
        //System.out.println("hola soy el hilo2");

        ManejoArchivos.leerArchivo("palabras.txt");
        ////System.out.println("hola soy el hilo2");

    }

}
