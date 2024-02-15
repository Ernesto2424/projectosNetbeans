/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cliente;

import java.rmi.Naming;
import java.util.Scanner;
import operacion.interfaz;

/**
 *
 * @author Personal
 */
public class Cliente {
    
    public void IniciarCliente(){
         // TODO code application logic here
        
        //DEBE de estar rodeado de un try y catch para evitar poner los throws
        try{
            //Al objeto calc lo localizamos por el nombre que le dimos
            interfaz calc = (interfaz) Naming.lookup("rmi://localhost/ServicioCalculadora");
            
            //Para lectura de teclado
            Scanner scan = new Scanner(System.in);
            
            //Lectura de operandos
            System.out.println("[*] Ingresa el primer operando: ");
            int op1 = scan.nextInt();
            
            System.out.println("[*] Ingresa el segundo operando: ");
            int op2 = scan.nextInt();
            
            //Respuestas del servicio de la calculadora
            System.out.println("[*] La suma es: " + calc.suma(op1, op2));
            System.out.println("[*] La resta es: " + calc.resta(op1, op2));
            System.out.println("[*] La multiplicacion es: " + calc.multiplica(op1, op2));
            System.out.println("[*] La division es: " + calc.divide(op1, op2));
        }
        catch(Exception e){
            System.err.println("[!] Error al realizar la operacion: " + e);
            e.printStackTrace();
        }
    }
    
    
    
    
    
}
