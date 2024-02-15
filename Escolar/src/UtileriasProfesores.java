import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class UtileriasProfesores 
{
	// Método que recupere la información de la base dedatos, devolver en una lista
	public static List<Profesor> recuperaProfesores() 
	{
		List<Profesor> lista = new LinkedList<Profesor>();
		try 
		{
			Connection conexion = 
					DriverManager.getConnection("jdbc:mariadb://localhost:3306/escolar", "cliente","alfa12");


			if (conexion != null) 
			{
				System.out.println("Conectado a la base de datos");
				Statement st = conexion.createStatement();

				ResultSet tablaResultados = st.executeQuery("SELECT * FROM PROFESORES");

				while (tablaResultados.next()) 
				{
					String numEco = tablaResultados.getString("numEco");
					String nombre = tablaResultados.getString("nombre");
					

					Profesor profesor = new Profesor(numEco, nombre);
					lista.add(profesor);
				}
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	
	public static void imprimeLista(List<Profesor> lista)
	{
		Iterator iter = lista.iterator();
		
		while(iter.hasNext())
		{
			Profesor pro = (Profesor) iter.next();
			System.out.println(pro.toString());
		}
	}
	
	
	public static String registraProfesor(Profesor pro)
	{
		String res = "";
		try
		{
			Connection conexion = DriverManager.getConnection("jdbc:mariadb://localhost:3306/escolar", "cliente","alfa12");

			String instruccion = "insert into profesores values ('" +
									pro.getNumEco() + "', '" +
									pro.getNombre()  + "')";
			Statement st = conexion.createStatement();
			st.executeUpdate(instruccion);
			
			res = "Registro exitoso del profesor";
			
			st.close();
			conexion.close();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return res;
	}
	
	public static Profesor obtieneProfesor(String numEco)
	{
		Profesor buscado = null;
		
		try
		{
			Connection conexion = DriverManager.getConnection("jdbc:mariadb://localhost:3306/escolar", "cliente","alfa12");

			String query = "select * from profesores where numEco = '" + numEco + "'";
			
			Statement st = conexion.createStatement();
			ResultSet rs = st.executeQuery(query);
			
			if(rs.next())
			{
				buscado = new Profesor(rs.getString("numEco"),
									rs.getString("nombre"));
								
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return buscado;
	}
	
	public static String eliminarProfesor(String numEco)
	{
		String res = "";
		
		try
		{
			Connection conexion = DriverManager.getConnection("jdbc:mariadb://localhost:3306/escolar", "cliente","alfa12");

			
			String instruccion = "delete from profesores where numEco = '" + numEco + "'";
			Statement st = conexion.createStatement();
			st.executeUpdate(instruccion);
			res = "Alumno eliminado con exito";
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return res;
	}


	
}