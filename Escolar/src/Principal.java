import java.util.List;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
	
		int opc = 0;
		
		do {
			System.out.println(" *******************Consultor*******************");
			System.out.println("1. Consultar  Alumnos");
			System.out.println("2. Consultar  Profesores");
			System.out.println("3. Consultar  Materias");
			System.out.println("4. Consultar  salones");
			System.out.println("5. Finalizar el programa");
			System.out.println("***********ELIJA UNA OPCION**********************");
			
			opc = LeeInt();
			
			switch(opc) {
			case 1:
				List <Alumno> listaAlumnos = UtileriasAlumnos.recuperaAlumnos();
				UtileriasAlumnos.imprimeLista(listaAlumnos);
				break;
			case 2:
				List<Profesor> listaProfesores = UtileriasProfesores.recuperaProfesores();
				UtileriasProfesores.imprimeLista(listaProfesores);
				break;
			case 3:
				List<Materia> listaMaterias = UtileriasMaterias.recuperaMaterias();
				UtileriasMaterias.imprimeLista(listaMaterias);
				break;
			case 4:
				List<Salon> listaSalones = UtileriasSalones.recuperaSalones();
				UtileriasSalones.imprimeLista(listaSalones);
				break;
			}
		} while (opc !=5);		
	}
	public static String LeeCadena() {
		Scanner teclado = new Scanner (System.in);
		String cadena = teclado.nextLine();
		return cadena;
	}
	public static int LeeInt() {
		Scanner scan = new Scanner(System.in);
		int numero = scan.nextInt();
		return numero;	
	}
	public static float LeeFloat() {
		Scanner scan = new Scanner(System.in);
		float numero = scan.nextFloat();
		return numero;	
	}
	}
