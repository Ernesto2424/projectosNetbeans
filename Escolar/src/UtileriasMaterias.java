import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class UtileriasMaterias 
{
	// Método que recupere la información de la base dedatos, devolver en una lista
	public static List<Materia> recuperaMaterias() 
	{
		List<Materia> lista = new LinkedList<Materia>();
		try 
		{
			Connection conexion = 
					DriverManager.getConnection("jdbc:mariadb://localhost:3306/escolar", "cliente","alfa12");


			if (conexion != null) 
			{
				System.out.println("Conectado a la base de datos");
				Statement st = conexion.createStatement();

				ResultSet tablaResultados = st.executeQuery("SELECT * FROM MATERIAS");

				while (tablaResultados.next()) 
				{
					String clavemat = tablaResultados.getString("clavemat");
					String nombre = tablaResultados.getString("nombre");
					int creditos = tablaResultados.getInt("creditos");
					
					Materia materia = new Materia(clavemat, nombre, creditos);
					lista.add(materia);
				}
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	
	public static void imprimeLista(List<Materia> lista)
	{
		Iterator iter = lista.iterator();
		
		while(iter.hasNext())
		{
			Materia mat = (Materia) iter.next();
			System.out.println(mat.toString());
		}
	}
	
	
	public static String registraMateria(Materia mat)
	{
		String res = "";
		try
		{
			Connection conexion = DriverManager.getConnection("jdbc:mariadb://localhost:3306/escolar", "cliente","alfa12");

			String instruccion = "insert into materias values ('" +
									mat.getClaveMat() + "', '" +
									mat.getNombre() + "','" +
									mat.getCreditos()  + "')";
			Statement st = conexion.createStatement();
			st.executeUpdate(instruccion);
			
			res = "Registro exitoso de la materia";
			
			st.close();
			conexion.close();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return res;
	}
	public static Materia obtieneMateria(String clavemat)
	{
		Materia buscado = null;
		
		try
		{
			Connection conexion = DriverManager.getConnection("jdbc:mariadb://localhost:3306/escolar", "cliente","alfa12");

			String query = "select * from materias where clavemat= '" + clavemat + "'";
			
			Statement st = conexion.createStatement();
			ResultSet rs = st.executeQuery(query);
			
			if(rs.next())
			{
				buscado = new Materia(rs.getString("clavemat"),
									rs.getString("nombre"),
									rs.getInt("creditos"));
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return buscado;
	}
	
	public static String eliminarMateria(String clavemat)
	{
		String res = "";
		
		try
		{
			Connection conexion = DriverManager.getConnection("jdbc:mariadb://localhost:3306/escolar", "cliente","alfa12");

			
			String instruccion = "delete from materias where clavemat = '" + clavemat + "'";
			Statement st = conexion.createStatement();
			st.executeUpdate(instruccion);
			res = "Materia eliminado con exito";
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return res;
	}
}
