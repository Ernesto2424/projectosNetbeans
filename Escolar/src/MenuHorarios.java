import java.util.Scanner;

public class MenuHorarios 
{
	public static void main(String[] args) 
	{
		int opc = 0;
		do {
			System.out.println("1. Registro de horario");
			System.out.println("2. Eliminación de horario");
			System.out.println("3. Consulta de horario");
			System.out.println("4. Listado de los horarios");
			System.out.println("5. Salir");
			System.out.println("Selecciona una opcion");

			opc = LeeInt();

			switch (opc) 
			{
			case 1:
				System.out.println("\nSeleccionó registrar un horario");
				System.out.println("Proporciona la clave del horario");
				String clavehorario = LeeCadena();
				System.out.println("Proporciona las horas");
				String horas = LeeCadena();
				System.out.println("Proporciona los dias");
				String dias = LeeCadena();
				System.out.println("Proporciona la clave de la materia");
				String clavemat = LeeCadena();
				System.out.println("Proporciona la clave del salon");
				String clavesal = LeeCadena();
				System.out.println("Proporciona el num economico del profesor");
				String  numecopro = LeeCadena();
				Horario nuevo = new Horario(clavehorario, horas, dias, clavemat, clavesal, numecopro);
				String resultado = UtileriasHorarios.registraHorario(nuevo);
				System.out.println(resultado);
				
				break;

			case 2:
				System.out.println("\nSeleccionó eliminar un horario");
				System.out.println("Proporciona la clave de horario a eliminar");
				clavehorario = LeeCadena();
				resultado = UtileriasHorarios.eliminarHorario(clavehorario);
				System.out.println(resultado);
				break;
				
			case 3:

				System.out.println("\nSeleccionó consultar un horario");
				System.out.println("Proporciona la clave de horario");
				clavehorario = LeeCadena();
				Horario recuperado = UtileriasHorarios.obtieneHorario(clavehorario);
				Profesor prof = UtileriasHorarios.obtieneProfesor(recuperado.getNumEcopro());
				Materia mat = UtileriasHorarios.obtieneMateria(recuperado.getClaveMat());
				System.out.println("\n====================================");
				System.out.println("Datos del horario encontrado");
				System.out.println("====================================");
				System.out.println("Clave: " + recuperado.getClaveHorario());
				System.out.println("Horas: " + recuperado.getHoras());
				System.out.println("Dias: " + recuperado.getDias());
				System.out.println("Salon: " + recuperado.getClaveSal());
				System.out.println("Profesor: " + prof.getNombre());
				System.out.println("Materia: " + mat.getNombre());
				System.out.println("Creditos: " + mat.getCreditos());
				System.out.println("====================================\n");
				break;
			case 4:
				System.out.println("\nListado de todos los horarios\n");
				UtileriasHorarios.imprimeHorarios();
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
