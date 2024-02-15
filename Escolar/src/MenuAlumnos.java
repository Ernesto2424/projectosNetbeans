import java.util.List;
import java.util.Scanner;

public class MenuAlumnos 
{

	public static void main(String[] args) 
	{
		int opc = 0;
		do {
			System.out.println("1. Registro de alumno");
			System.out.println("2. Eliminación de alumno");
			System.out.println("3. Consulta de alumno");
			System.out.println("4. Listado de los alumnos");
			System.out.println("5. Salir");
			System.out.println("Selecciona una opcion");

			opc = LeeInt();

			switch (opc) 
			{
			case 1:
				System.out.println("\nSeleccionó registrar un alumno");
				System.out.println("Proporciona la matricula");
				String matricula = LeeCadena();
				System.out.println("Proporciona el nombre");
				String nombre = LeeCadena();
				System.out.println("Proporciona la edad");
				int edad = LeeInt();
				System.out.println("Proporciona el genero");
				String genero = LeeCadena();
				Alumno nuevo = new Alumno(matricula, nombre, edad, genero);
				System.out.println(UtileriasAlumnos.registraAlumno(nuevo));
				break;

			case 2:
				System.out.println("\nSeleccionó eliminar un alumno");
				System.out.println("Proporciona la matricula del alumno a eliminar");
				matricula = LeeCadena();
				System.out.println(UtileriasAlumnos.eliminarAlumno(matricula));
				
				break;
			case 3:
				System.out.println("\nSeleccionó consultar un alumno");
				System.out.println("Proporciona la matricula");
				matricula = LeeCadena();
				Alumno recuperado = UtileriasAlumnos.obtieneAlumno(matricula);
				System.out.println("\nDatos del alumno encontrado");
				System.out.println(recuperado.toString());
				break;

			case 4:
				System.out.println("\n Listado de todos los alumnos");
				List<Alumno> lista = UtileriasAlumnos.recuperaAlumnos();
				UtileriasAlumnos.imprimeLista(lista);
				break;
				
			case 5:
				System.out.println("sesión finalizada");
				break;
				
			default:
				System.out.println("Opción seleccionada fuera del rango: 1 al 5");
				break;
			}

		} while (opc != 5);

	}//Fin del método main

	
	public static String LeeCadena() 
	{
		Scanner teclado = new Scanner(System.in);
		String cadena = teclado.nextLine();
		return cadena;
	}

	public static int LeeInt() 
	{
		Scanner scan = new Scanner(System.in);
		int numero = scan.nextInt();
		return numero;
	}

	public static float LeeFloat() 
	{
		Scanner scan = new Scanner(System.in);
		float numero = scan.nextFloat();
		return numero;
	}

	}

