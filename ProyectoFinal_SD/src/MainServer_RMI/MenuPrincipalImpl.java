/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainServer_RMI;

import java.rmi.*;
import java.rmi.server.*;

/**
 *
 * @author leond
 */
public class MenuPrincipalImpl extends UnicastRemoteObject implements MenuPrincipal{
    protected MenuPrincipalImpl() throws RemoteException {
        super();
    }
    
    @Override
    public String menu(){
        
        return "¿Que servidor deseas activar? \n"
                + "1.Socket\n"
                + "2.RPC\n"
                + "3.RMI\n"
                + "4.Salir";
    }
}
