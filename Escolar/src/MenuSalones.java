import java.util.List;
import java.util.Scanner;

public class MenuSalones 
{

	public static void main(String[] args) 
	{
		int opc = 0;
		do {
			System.out.println("1. Registro de salon");
			System.out.println("2. Eliminación de salon");
			System.out.println("3. Consulta de salones");
			System.out.println("4. Listado de los salones");
			System.out.println("5. Salir");
			System.out.println("Selecciona una opcion");

			opc = LeeInt();

			switch (opc) 
			{
			case 1:
				System.out.println("\nSeleccionó registrar un salon");
				System.out.println("Proporciona la clave");
				String clavesal = LeeCadena();
				System.out.println("Proporciona el nombre");
				String nombre = LeeCadena();
				Salon nuevo = new Salon(clavesal, nombre);
				System.out.println(UtileriasSalones.registraSalon(nuevo));
				break;

			case 2:
				System.out.println("\nSeleccionó eliminar un salon");
				System.out.println("Proporciona clave a eliminar");
				clavesal = LeeCadena();
				System.out.println(UtileriasSalones.eliminarSalon(clavesal));
				
				break;
			case 3:
				System.out.println("\nSeleccionó consultar un salon");
				System.out.println("Proporciona la clave");
				clavesal = LeeCadena();
				Salon recuperado = UtileriasSalones.obtieneSalon(clavesal);
				System.out.println("\nDatos del salon encontrado");
				System.out.println(recuperado.toString());
				break;

			case 4:
				System.out.println("\n Listado de todos los salones");
				List<Salon> lista = UtileriasSalones.recuperaSalones();
				UtileriasSalones.imprimeLista(lista);
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

