/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMI;

import java.rmi.*;
import java.rmi.server.*;
import java.io.*;

/**
 *
 * @author leond
 */
public class TurismoImpl extends UnicastRemoteObject implements Turismo {
    
    protected TurismoImpl() throws RemoteException {
        super();
    }
    
    /**
     * Funcion para leer los archivos
     * @param nombre nombre del archivo
     * @return lugares turisticos de la ciudad pedida
     */
    @Override
    public String leerArchivoCadena(String nombre){
        String resultado = "";
        File archivo = new File(nombre);
        try {
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            String lectura = entrada.readLine();
            resultado = "[*] Los lugares son: " ;
            while(lectura != null){
                resultado += lectura;
                lectura = entrada.readLine();
            }
            entrada.close();
        } catch (FileNotFoundException ex) {
            //ex.printStackTrace(System.out);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
        if("".equals(resultado)){
            resultado = "[!] INGRESE UN ESTADO EXISTENTE";
        }
        return resultado;

    }
    
}
