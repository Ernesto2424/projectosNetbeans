
package ImplementacionCalculadoraRMI;
import java.rmi.*;
/**
 *
 * @author Gutiérrez Ramos Alberto Daniel - 2182003623
 */
public interface Calculadora extends Remote{
    //Skel de las funciones de la calculadora
    public int suma(int a, int b) throws RemoteException;
    public int resta(int a, int b) throws RemoteException;
    public int multiplica(int a, int b) throws RemoteException;
    public int divide(int a, int b) throws RemoteException;
    
}
