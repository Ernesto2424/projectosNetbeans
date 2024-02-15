package accesoDatos;

public class ImplementacionOracle implements AccesoDatos{

    
    
    
    @Override
    public void insertar() {
        System.out.println("insertar desde ORACLE");
    }

    @Override
    public void listar() {
        System.out.println("lsitar desde ORACLE");
    }

    @Override
    public void actualizar() {
        System.out.println("actualizar desde ORACLE");
    }

    @Override
    public void eliminar() {
         System.out.println("eliminar desde ORACLE");
    }

    
    
}
