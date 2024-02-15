/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import domain.Alumno;
import implementacion.SeparadorDosPuntos;
import implementacion.SeparadorEspacio;
import interfaces.Formato;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Ernesto F.
 */
// Clase principal del programa
public class Test {

    /**
     * @param args the command line arguments
     */
    // TODO code application logic here
    private static final String CONFIG_FILE = "lista.conf";
    private static final String TAB_FORMAT_CLASS = "SeparadorTab";
    private static final String DOS_PUNTOS_FORMAT_CLASS = "SeparadorDosPuntos";

    private List<Alumno> listaAlumnos;
    private Formato adaptadorArchivo;

    public Test() {
        listaAlumnos = new ArrayList<>();
    }

    public void agregarAlumno(Alumno alumno) {
        listaAlumnos.add(alumno);
    }

    public void mostrarListaAlumnos() {
        for (Alumno alumno : listaAlumnos) {
            System.out.println(alumno);
        }
    }

    public void cargarConfiguracion() throws IOException {
        try (Scanner scanner = new Scanner(new File(CONFIG_FILE))) {
            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine();
                if (linea.startsWith("formato.archivo")) {
                    String[] partes = linea.split("=");
                    String formatoArchivo = partes[1].trim();
                    if (formatoArchivo.equals(TAB_FORMAT_CLASS)) {
                        adaptadorArchivo = new SeparadorEspacio();
                    } else if (formatoArchivo.equals(DOS_PUNTOS_FORMAT_CLASS)) {
                        adaptadorArchivo = new SeparadorDosPuntos();
                    }
                    break;
                }
            }
        }
    }

    public void guardarListaAlumnos(String nombreArchivo) throws IOException {
        List<String> lineas = new ArrayList<>();
        for (Alumno alumno : listaAlumnos) {
            String linea = alumno.getNombre() + adaptadorArchivo + alumno.getMatricula()
                    + adaptadorArchivo + alumno.getNotaFinal();
            lineas.add(linea);
        }
        adaptadorArchivo.escribirArchivo(nombreArchivo, lineas);
    }

    public void cargarListaAlumnos(String nombreArchivo) throws IOException {
        List<String> lineas = adaptadorArchivo.leerArchivo(nombreArchivo);
        for (String linea : lineas) {
            String[] partes = linea.split(adaptadorArchivo.equals(TAB_FORMAT_CLASS) ? SeparadorEspacio.SEPARADOR : SeparadorDosPuntos.SEPARADOR);
            String nombre = partes[0].trim();
            String matricula = partes[1].trim();
            double notaFinal = Double.parseDouble(partes[2].trim());
            Alumno alumno = new Alumno(nombre, matricula, notaFinal);
            listaAlumnos.add(alumno);
        }
    }

    public static void main(String[] args) {
        Test gestionAlumnos = new Test();
        try {
            gestionAlumnos.cargarConfiguracion();
        } catch (IOException e) {
            System.out.println("Error al cargar la configuración del archivo.");
            return;
        }

        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("Menú:");
                System.out.println("1. Añadir alumno");
                System.out.println("2. Visualizar lista de alumnos");
                System.out.println("3. Salir");
                System.out.print("Ingrese la opción: ");
                int opcion = scanner.nextInt();

                switch (opcion) {
                    case 1:
                        System.out.print("Ingrese el nombre del alumno: ");
                        String nombre = scanner.next();
                        System.out.print("Ingrese la matrícula del alumno: ");
                        String matricula = scanner.next();
                        double notaFinal = 11;
                        while (notaFinal < 0 || notaFinal > 10) {
                            System.out.print("Ingrese la nota final del alumno: ");
                            notaFinal = scanner.nextDouble();
                            if (notaFinal < 0 || notaFinal > 10) {
                                System.out.println("Valor invalido, intente de nuevo.");
                            }
                        }
                        Alumno alumno = new Alumno(nombre, matricula, notaFinal);
                        gestionAlumnos.agregarAlumno(alumno);
                        break;
                    case 2:
                        gestionAlumnos.mostrarListaAlumnos();
                        break;
                    case 3:
                       
                        return;
                    default:
                        System.out.println("Opción inválida.");
                }
            }
        } catch (Exception e) {
            System.out.println("Error en la entrada/salida.");
        }
    }
}
