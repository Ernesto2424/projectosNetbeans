/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMI;

import java.rmi.*;

/**
 *
 * @author leond
 */
public interface Turismo extends Remote {
    
    //Skel de las funciones
    public String leerArchivoCadena(String nombre) throws RemoteException;
    
}
