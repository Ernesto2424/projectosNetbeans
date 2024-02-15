/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacion;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Personal
 */
public class Operacion extends UnicastRemoteObject implements interfaz{
    
    //Para no ponerlo en la declaracion de la clase
    public Operacion() throws RemoteException {
        super();
    }

    @Override
    public int suma(int op1, int op2) {
        return op1 + op2;
    }

    @Override
    public int resta(int op1, int op2) {
        return op1 - op2;
    }

    @Override
    public int multiplica(int op1, int op2) {
        return op1 * op2;
    }

    @Override
    public int divide(int op1, int op2) {
        return op1 / op2;
    }
    
}
