
public class Test {
    
    public static void main(String [] args){
        
        Cuentas c = new Cuentas();
        Cuentas c0 = new Cuentas("54168415452", "GOLD", 850);
        Clientes cli[] = new Clientes[2];
        cli[0] = new Clientes("ERNESTO", 19, "MI DIRECCION", "5571387805");
        cli[1] = new Clientes("PEDRO", 25, "MI DIRECCION2", "5611548515");
        cli[0].setCuenta(c0);
        cli[1].setCuenta(c);
        System.out.println(cli[0].convierteCadena());
        System.out.println("");
        System.out.println(cli[1].convierteCadena());
        System.out.println("");
       
    }
    
}
