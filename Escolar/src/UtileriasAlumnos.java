import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class UtileriasAlumnos 
{
	// Método que recupere la información de la base dedatos, devolver en una lista
	public static List<Alumno> recuperaAlumnos() 
	{
		List<Alumno> lista = new LinkedList<Alumno>();
		try 
		{
			Connection conexion = 
					DriverManager.getConnection("jdbc:mariadb://localhost:3306/escolar", "cliente","alfa12");


			if (conexion != null) 
			{
				System.out.println("Conectado a la base de datos");
				Statement st = conexion.createStatement();

				ResultSet tablaResultados = st.executeQuery("SELECT * FROM ALUMNOS");

				while (tablaResultados.next()) 
				{
					String matricula = tablaResultados.getString("matricula");
					String nombre = tablaResultados.getString("nombre");
					int edad = tablaResultados.getInt("edad");
					String genero = tablaResultados.getString("genero");

					Alumno alumno = new Alumno(matricula, nombre, edad, genero);
					lista.add(alumno);
				}
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	
	public static void imprimeLista(List<Alumno> lista)
	{
		Iterator iter = lista.iterator();
		
		while(iter.hasNext())
		{
			Alumno alu = (Alumno) iter.next();
			System.out.println(alu.toString());
		}
	}
	
	
	public static String registraAlumno(Alumno alu)
	{
		String res = "";
		try
		{
			Connection conexion = DriverManager.getConnection("jdbc:mariadb://localhost:3306/escolar", "cliente","alfa12");

			String instruccion = "insert into alumnos values ('" +
									alu.getMatricula() + "', '" +
									alu.getNombre() + "'," +
									alu.getEdad() + ",'" +
									alu.getGenero() + "')";
			Statement st = conexion.createStatement();
			st.executeUpdate(instruccion);
			
			res = "Registro exitoso del alumno";
			
			st.close();
			conexion.close();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return res;
	}
	
	public static Alumno obtieneAlumno(String matricula)
	{
		Alumno buscado = null;
		
		try
		{
			Connection conexion = DriverManager.getConnection("jdbc:mariadb://localhost:3306/escolar", "cliente","alfa12");

			String query = "select * from alumnos where matricula = '" + matricula + "'";
			
			Statement st = conexion.createStatement();
			ResultSet rs = st.executeQuery(query);
			
			if(rs.next())
			{
				buscado = new Alumno(rs.getString("matricula"),
									rs.getString("nombre"),
									rs.getInt("edad"),
									rs.getString("genero"));
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return buscado;
	}
	
	public static String eliminarAlumno(String matricula)
	{
		String res = "";
		
		try
		{
			Connection conexion = DriverManager.getConnection("jdbc:mariadb://localhost:3306/escolar", "cliente","alfa12");

			
			String instruccion = "delete from alumnos where matricula = '" + matricula + "'";
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
