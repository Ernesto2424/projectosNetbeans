
package uam.pvoe.excepciones.principal;
import java.util.*;




public class Principal {
    
    public static void primeraExepcion(){
        
        String dato ="";
        int convertido =0;
        Scanner sc = new Scanner(System.in);
        System.out.println("introduce un numero, lo leere como cadena y lo convertire");
        dato = sc.nextLine();
        
        try {
            convertido = Integer.parseInt(dato);
        } catch (Exception e) {
            System.out.println("ERROR, NO ES UN NUMERO");
        }finally{
            System.out.println("se ejecuta haya excepciones o no, puede servir"
                    + "para cerrar un archivo o una conexion a BD");
        }
        System.out.println("El dato convertido * 10 = "+convertido*10);
        

}
    
    public static void combinandoExcepciones(){
        String datoLeido = "";
        String datoAux = null;
        int datoConvertido;
        Scanner sc = new Scanner(System.in);
        datoLeido= sc.nextLine();
        
        if(datoLeido.length()>5){
            datoAux = "hola";
        }
        try {
            int longitud = datoAux.length();
            datoConvertido = Integer.parseInt(datoAux);
        } catch (NullPointerException e) {
            System.out.println("Trabajando con valor nulo");
        }catch(NumberFormatException e){
            System.out.println("No se pudo realizar la conversion");
        }
    }
    
    public static int convertir(String dato)throws NumberFormatException{
        int convertido = 0;
        convertido= Integer.parseInt(dato);
        return convertido;
    }
    
    public static void atrapandoExcepciones(){
        try {
            System.out.println("Convertido: " +convertir("palabra"));
        } catch (Exception e) {
            System.out.println("No puedo realizar la conversion");
        }
    }
    
    public static void main(String[] args) {
       // primeraExepcion();
        //combinandoExcepciones();
        
        atrapandoExcepciones();
        
        
        
    }
    
    
    
    
    
}
