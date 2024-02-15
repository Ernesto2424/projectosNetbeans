import java.util.List;
import java.util.Scanner;

public class MenuMaterias 
{

	public static void main(String[] args) 
	{
		int opc = 0;
		do {
			System.out.println("1. Registro de materia");
			System.out.println("2. Eliminación de materia");
			System.out.println("3. Consulta de materia");
			System.out.println("4. Listado de los materias");
			System.out.println("5. Salir");
			System.out.println("Selecciona una opcion");

			opc = LeeInt();

			switch (opc) 
			{
			case 1:
				System.out.println("\nSeleccionó registrar una materia");
				System.out.println("Proporciona la clave");
				String clavemat = LeeCadena();
				System.out.println("Proporciona el nombre");
				String nombre = LeeCadena();
				System.out.println("Proporciona el numero de creditos");
				int creditos = LeeInt();
				Materia nuevo = new Materia(clavemat, nombre, creditos);
				System.out.println(UtileriasMaterias.registraMateria(nuevo));
				break;

			case 2:
				System.out.println("\nSeleccionó eliminar una materia");
				System.out.println("Proporciona la clave de la materia");
				clavemat = LeeCadena();
				System.out.println(UtileriasMaterias.eliminarMateria(clavemat));
				
				break;
			case 3:
				System.out.println("\nSeleccionó consultar una materia");
				System.out.println("Proporciona la clave");
				clavemat = LeeCadena();
				Materia recuperado = UtileriasMaterias.obtieneMateria(clavemat);
				System.out.println("\nDatos de la materia encontrados");
				System.out.println(recuperado.toString());
				break;

			case 4:
				System.out.println("\n Listado de todos las materias");
				List<Materia> lista = UtileriasMaterias.recuperaMaterias();
				UtileriasMaterias.imprimeLista(lista);
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

