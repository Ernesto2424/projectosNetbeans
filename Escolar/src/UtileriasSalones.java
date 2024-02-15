import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class UtileriasSalones 
{
	// Método que recupere la información de la base dedatos, devolver en una lista
	public static List<Salon> recuperaSalones() 
	{
		List<Salon> lista = new LinkedList<Salon>();
		try 
		{
			Connection conexion = 
					DriverManager.getConnection("jdbc:mariadb://localhost:3306/escolar", "cliente","alfa12");


			if (conexion != null) 
			{
				System.out.println("Conectado a la base de datos");
				Statement st = conexion.createStatement();

				ResultSet tablaResultados = st.executeQuery("SELECT * FROM SALONES");

				while (tablaResultados.next()) 
				{
					String clavesal = tablaResultados.getString("clavesal");
					String nombre = tablaResultados.getString("nombre");
					

					Salon salon = new Salon(clavesal, nombre);
					lista.add(salon);
				}
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	
	
	public static void imprimeLista(List<Salon> lista)
	{
		Iterator iter = lista.iterator();
		
		while(iter.hasNext())
		{
		Salon sal = (Salon) iter.next();
			System.out.println(sal.toString());
		}
	}
	
	
	public static String registraSalon(Salon sal)
	{
		String res = "";
		try
		{
			Connection conexion = DriverManager.getConnection("jdbc:mariadb://localhost:3306/escolar", "cliente","alfa12");

			String instruccion = "insert into salones values ('" +
									sal.getClaveSal() + "', '" +
									sal.getNombre()  + "')";
			Statement st = conexion.createStatement();
			st.executeUpdate(instruccion);
			
			res = "Registro exitoso del salon";
			
			st.close();
			conexion.close();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return res;
	}
	
	public static Salon obtieneSalon(String clavesal)
	{
		Salon buscado = null;
		
		try
		{
			Connection conexion = DriverManager.getConnection("jdbc:mariadb://localhost:3306/escolar", "cliente","alfa12");

			String query = "select * from salones where clavesal = '" + clavesal + "'";
			
			Statement st = conexion.createStatement();
			ResultSet rs = st.executeQuery(query);
			
			if(rs.next())
			{
				buscado = new Salon(rs.getString("clavesal"),
									rs.getString("nombre"));
								
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return buscado;
	}
	
	public static String eliminarSalon(String clavesal)
	{
		String res = "";
		
		try
		{
			Connection conexion = DriverManager.getConnection("jdbc:mariadb://localhost:3306/escolar", "cliente","alfa12");

			
			String instruccion = "delete from salones where clavesal = '" + clavesal + "'";
			Statement st = conexion.createStatement();
			st.executeUpdate(instruccion);
			res = "Salon eliminado con exito";
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return res;
	}


	
	
}