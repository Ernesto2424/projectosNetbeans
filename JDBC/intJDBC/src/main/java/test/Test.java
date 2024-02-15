package test;

import java.sql.*;



public class Test {

    public static void main(String[] args) {
        var url = "jdbc:mysql://localhost:3306/test?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
        try {
            //esta linea de abajo solo se hace para apps web
           // Class.forName("com.mysql.cj.jdbc.Driver");
           
           //se va a obtener la conexion a la BD
        Connection conexion = DriverManager.getConnection(url, "root", "010324");
       //se declara para poder ejecutar sentencias
        Statement instruccion = conexion.createStatement();
       var sql = "SELECT * FROM persona";
       ResultSet resultado = instruccion.executeQuery(sql);
       
       //next nos va a indicar si tenemos aun elementos por iterar
       while(resultado.next()){
           /* se puede recuperar el id pasasndo el nombre de la columna o el indice de la misma
           **NOTAL: de preferencia el nombre de la columna*/
            System.out.print("ID persona:"+resultado.getInt("idpersona") +" ");
            System.out.print("Nombre:"+resultado.getString("nombre")+" ");
            System.out.print("Apellido:"+resultado.getString("apellido")+" ");
            System.out.print("Correo:"+resultado.getString("email")+" ");
            System.out.print("Telefono:"+resultado.getString("telefono")+" ");
            System.out.println("");
       }
       //cerrar de forma inversa lo que se ha ocupado
       resultado.close();
       instruccion.close();
       conexion.close();
       
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }

    
}
