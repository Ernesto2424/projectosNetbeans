package accesoDatos;

public class Implementacion implements AccesoDatos{

    @Override
    public void insertar() {
        System.out.println("insertar desde MySQL");
    }

    @Override
    public void listar() {
         System.out.println("listar desde MySQL");
    }

    @Override
    public void actualizar() {
         System.out.println("actualizar desde MySQL");
    }

    @Override
    public void eliminar() {
         System.out.println("eliminar desde MySQL");
    }



    
}
