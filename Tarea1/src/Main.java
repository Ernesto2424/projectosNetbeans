
import java.util.*;
import javax.swing.JOptionPane;
public class Main {
 
    public static void main(String[] args){
        
           Pasajero microbus = new Pasajero("MICROBUS", "DFD7845", 0, 0);
           Pasajero automovil = new Pasajero("AUTOMOVIL", "HRE457", 0, 0);
           
           Carga camion = new Carga("CAMION", "CLP7845", 0, 0);
           Carga camioneta = new Carga("CAMIONETA", "VCR0964", 0);
           
        int opcion;  String op ="";
        op=JOptionPane.showInputDialog("Selecione una opcion: \n"
        + "1. Transporte de carga\n"
        + "2. Transporte de Persona\n");
        
        opcion = Integer.parseInt(op);
        
        if(opcion==1){
            int op1; String carga="";
            carga = JOptionPane.showInputDialog("1. Camion\n"
                                               +"2. Camioneta\n");
            op1 = Integer.parseInt(carga);
            if(op1==1){
                int tone; String ton=""; int dca; String ldca="";
                ton=JOptionPane.showInputDialog("INGRESE EL NUMERO DE TONELADAS");
                tone=Integer.parseInt(ton);
                camion.setToneladas(tone);
                ldca=JOptionPane.showInputDialog("INGRESE EL NUMERO DE DIAS");
                dca=Integer.parseInt(ldca);
                camion.setDias(dca);
                JOptionPane.showMessageDialog(null,camion.toString() +"PRECIO BASE: $" +camion.getDias()*800+"\n" + "PRECIO TOTAL: $"+camion.precioCamion());
                
            }else if(op1==2){
                int dcamio; String ldcamio="";
                ldcamio=JOptionPane.showInputDialog("INGRESE EL NUMERO DE DIAS");
                dcamio=Integer.parseInt(ldcamio);
                camioneta.setDias(dcamio);
                JOptionPane.showMessageDialog(null, camioneta.toString2() +"PRECIO BASE: $"+camioneta.getDias()*800+ "\n" +"PRECIO TOTAL: $"+camioneta.precioCamioneta());
                
            }
            
            
        }else if(opcion == 2){
            int op2; String persona="";
            persona = JOptionPane.showInputDialog("1. Automovil\n"
                                               +"2. Microbus\n");
            op2 = Integer.parseInt(persona);
            if(op2==1){
                int acientos; String aci=""; int dm; String ldm="";
                ldm=JOptionPane.showInputDialog("INGRESE EL NUMERO DE DIAS");
                dm = Integer.parseInt(ldm);
                automovil.setDias(dm);
                aci=JOptionPane.showInputDialog("INGRESE EL NUMERO DE ACIENTOS");
                acientos = Integer.parseInt(aci);
                automovil.setAcientos(acientos);
                JOptionPane.showMessageDialog(null, automovil.toString() + "\n" +"PRECIO BASE: $"+automovil.getDias()*800 +"\n"+"PRECIO TOTAL: $"  + automovil.precioMovil());
                
            }else if(op2==2){
                int acientos2; String aci2=""; int dia2; String d2;
                aci2=JOptionPane.showInputDialog("INGRESE EL NUMERO DE ACIENTOS");
                acientos2 = Integer.parseInt(aci2);
                microbus.setAcientos(acientos2);
                d2=JOptionPane.showInputDialog("INGRESE EL NUMERO DE DIAS A OCUPAR");
                dia2=Integer.parseInt(d2);
                microbus.setDias(dia2);
                JOptionPane.showMessageDialog(null, microbus.toString() +"PRECIO BASE: $"+microbus.getDias() * 800 + "\n TOTAL A PAGAR: $"
                        + ""+microbus.preciomicro()); 
            }
            
        }
        
    }
    
}

