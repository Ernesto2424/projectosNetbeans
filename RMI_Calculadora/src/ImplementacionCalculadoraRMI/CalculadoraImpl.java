
package ImplementacionCalculadoraRMI;
import java.rmi.*;
import java.rmi.server.*;
/**
 *
 * @author Gutiérrez Ramos Alberto Daniel - 2182003623
 */
public class CalculadoraImpl extends UnicastRemoteObject implements Calculadora{
    
    //Para no ponerlo en la declaracion de la clase
    public CalculadoraImpl() throws RemoteException {
        super();
    }
    
    //Suma
    @Override
    public int suma(int a, int b) throws RemoteException {
        return a + b;
    }
    
    //Resta
    @Override
    public int resta(int a, int b) throws RemoteException {
        return a - b;
    }
    
    //Multiplicacion
    @Override
    public int multiplica(int a, int b) throws RemoteException {
        return a * b;
    }
    
    //Division
    @Override
    public int divide(int a, int b) throws RemoteException {
        return a / b;
    }
    
}
