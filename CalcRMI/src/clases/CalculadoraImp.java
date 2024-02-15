package clases;

import interfaces.Calculadora;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CalculadoraImp extends UnicastRemoteObject implements Calculadora {

    protected CalculadoraImp() throws RemoteException {
        super();
    }

    @Override
    public int suma(int a, int b) throws RemoteException {

        return a + b;

    }

    @Override
    public int resta(int a, int b) throws RemoteException {

        return a - b;

    }

    @Override
    public int mul(int a, int b) throws RemoteException {

        return a * b;

    }

    @Override
    public int div(int a, int b) throws RemoteException {

        return a / b;

    }

}
