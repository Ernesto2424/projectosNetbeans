import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class PruebaConexion 
{
	public static void main(String[] args)  
	{
		try
		{
			List <Alumno> lista = new LinkedList<Alumno>();
			
		  Connection conexion = DriverManager.getConnection("jdbc:mariadb://localhost:3306/escolar", "cliente", "alfa12");

		  if (conexion != null) 
		  {
			System.out.println("Conectado a la base de datos");
			Statement st = conexion.createStatement();

			ResultSet tablaResultados = st.executeQuery("select *from alumnos");
			
			while(tablaResultados.next())
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
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}

	}

