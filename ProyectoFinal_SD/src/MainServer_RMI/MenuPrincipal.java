
package MainServer_RMI;

import java.rmi.*;

/**
 *
 * @author leond
 */
public interface MenuPrincipal extends Remote {
    
    public String menu() throws RemoteException;
}
