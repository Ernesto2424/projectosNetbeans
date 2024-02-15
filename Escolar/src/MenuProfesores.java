import java.util.List;
import java.util.Scanner;

public class MenuProfesores 
{

	public static void main(String[] args) 
	{
		int opc = 0;
		do {
			System.out.println("1. Registro de profesor");
			System.out.println("2. Eliminación de profesor");
			System.out.println("3. Consulta de profesor");
			System.out.println("4. Listado de los profesores");
			System.out.println("5. Salir");
			System.out.println("Selecciona una opcion");

			opc = LeeInt();

			switch (opc) 
			{
			case 1:
				System.out.println("\nSeleccionó registrar un profesor");
				System.out.println("Proporciona la numero economico");
				String numEco = LeeCadena();
				System.out.println("Proporciona el nombre");
				String nombre = LeeCadena();
				Profesor nuevo = new Profesor(numEco, nombre);
				System.out.println(UtileriasProfesores.registraProfesor(nuevo));
				break;

			case 2:
				System.out.println("\nSeleccionó eliminar un profesor");
				System.out.println("Proporciona el numero economico a eliminar");
				numEco = LeeCadena();
				System.out.println(UtileriasProfesores.eliminarProfesor(numEco));
				
				break;
			case 3:
				System.out.println("\nSeleccionó consultar un profesor");
				System.out.println("Proporciona la numero economico");
				numEco = LeeCadena();
				Profesor recuperado = UtileriasProfesores.obtieneProfesor(numEco);
				System.out.println("\nDatos del profesor encontrado");
				System.out.println(recuperado.toString());
				break;

			case 4:
				System.out.println("\n Listado de todos los profesores");
				List<Profesor> lista = UtileriasProfesores.recuperaProfesores();
				UtileriasProfesores.imprimeLista(lista);
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

