import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class UtileriasHorarios 
{

	
	public static List<Horario> recuperaHorarios() 
	{
		List<Horario> lista = new LinkedList<Horario>();
		try 
		{
			Connection conexion = 
					DriverManager.getConnection("jdbc:mariadb://localhost:3306/escolar", "cliente","alfa12");

			if (conexion != null) 
			{
				System.out.println("Conectado a la base de datos");
				Statement st = conexion.createStatement();

				ResultSet tablaResultados = st.executeQuery("select * from horarios");

				while (tablaResultados.next()) 
				{
					String clavehorario = tablaResultados.getString("clavehorario");
					String horas = tablaResultados.getString("horas");
					String dias = tablaResultados.getString("dias");
					String clavemat = tablaResultados.getString("clavemat");//Presentar el nombre de la materia
					String clavesal = tablaResultados.getString("clavesal");
					String numecopro = tablaResultados.getString("numecopro");//Presentar el nombre del profesor
					Horario horario = new Horario(clavehorario, horas, dias, clavemat, clavesal, numecopro);
					lista.add(horario);
				}
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	
	public static void imprimeLista(List<Horario> lista)
	{
		Iterator iter = lista.iterator();
		
		while(iter.hasNext())
		{
			Horario horario = (Horario) iter.next();
			System.out.println(horario.toString());
		}
	}
	
	
	public static String registraHorario(Horario horario)
	{
		String res = "";
		try
		{
			Connection conexion = 
					DriverManager.getConnection("jdbc:mariadb://localhost:3306/escolar", "cliente","alfa12");
			String instruccion = "insert into horarios values ('" +
									horario.getClaveHorario() + "', '" +
									horario.getHoras() + "', '" +
									horario.getDias() + "','" +
									horario.getClaveMat() + "','" +
									horario.getClaveSal() + "','" +
									horario.getNumEcopro() + "')";
			Statement st = conexion.createStatement();
			st.executeUpdate(instruccion);
			
			res = "Registro exitoso del horario";
			st.close();
			conexion.close();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return res;
	}
	
	public static Horario obtieneHorario(String clavehorario)
	{
		Horario buscado = null;
		try
		{
			Connection conexion = 
					DriverManager.getConnection("jdbc:mariadb://localhost:3306/escolar", "cliente","alfa12");
			String query = "select * from horarios where clavehorario = '" + clavehorario + "'";
			Statement st = conexion.createStatement();
			ResultSet rs = st.executeQuery(query);
			
			if(rs.next())
			{
				buscado = new Horario(rs.getString("clavehorario"),
									rs.getString("horas"),
									rs.getString("dias"),
									rs.getString("clavemat"),
									rs.getString("clavesal"),
									rs.getString("numecopro"));
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return buscado;
	}
	
	//Método para recuperar el objeto Profesor a partir de su numEco
		public static Profesor obtieneProfesor(String numEconomico)
		{
			Profesor buscado = null;
			try
			{
				Connection conexion = 
						DriverManager.getConnection("jdbc:mariadb://localhost:3306/escolar", "cliente","alfa12");
				String query = "select * from profesores where numEco = '" + numEconomico + "'";
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
		
		//Método para recuperar el objeto Materia dada la clave
		public static Materia obtieneMateria(String claveMateria)
		{
			Materia buscada = null;
			try
			{
				Connection conexion = 
						DriverManager.getConnection("jdbc:mariadb://localhost:3306/escolar", "cliente","alfa12");
				String query = "select * from materias where claveMat = '" + claveMateria + "'";
				Statement st = conexion.createStatement();
				ResultSet rs = st.executeQuery(query);
				
				if(rs.next())
				{
					buscada = new Materia(rs.getString("clavemat"),
										rs.getString("nombre"),
										rs.getInt("creditos"));
				}
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
			return buscada;
		}
		
		
		public static String eliminarHorario(String claveHorario)
		{
			String res = "";
			
			try
			{
				Connection conexion = 
						DriverManager.getConnection("jdbc:mariadb://localhost:3306/escolar", "cliente","alfa12");
				String instruccion = "delete from horarios where clavehorario = '" + claveHorario + "'";
				Statement st = conexion.createStatement();
				st.executeUpdate(instruccion);
				res = "Horario eliminado con exito";
				
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
			
			return res;
		}
		
		public static void imprimeHorarios()
		{
			try
			{
				Connection conexion = 
						DriverManager.getConnection("jdbc:mariadb://localhost:3306/escolar", "cliente","alfa12");
				String query = "select * from horarios";
				Statement st = conexion.createStatement();
				ResultSet rs = st.executeQuery(query);
				
				System.out.println("Clave   \tHoras \tSalon \tCreditos    \tMateria           \tProfesor   \t \tDias");
				System.out.println("============================================================================================================================================");
				while(rs.next())
				{
					Materia mat = obtieneMateria(rs.getString("clavemat"));
					Profesor prof = obtieneProfesor(rs.getString("numecopro"));
					System.out.print(rs.getString("clavehorario"));
					System.out.print("\t " + rs.getString("horas"));
					System.out.print("\t " + rs.getString("clavesal"));
					System.out.print("\t  "+   mat.getCreditos());
					System.out.print("\t " + mat.getNombre());
					System.out.print("\t  " + prof.getNombre());
					System.out.println("\t " + rs.getString("dias"));
					System.out.println("_____________________________________________________________________________________________________________________________________ ");
				}
				System.out.println();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
	}

