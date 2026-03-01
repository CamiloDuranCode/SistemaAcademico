/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemaacademico;

import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author camil
 */
public class Main {
    static ArrayList<Estudiante> listaEstudiantes = new ArrayList<>();
    static ArrayList<Asignatura> listaAsignaturas = new ArrayList<>();
    static ArrayList<Nota> listaNotas = new ArrayList<>();

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        mostrarMenu();
    }

    public static void mostrarMenu() {
        int opcion;

        do {
            System.out.println("\n===== SISTEMA ACADÉMICO =====");
            System.out.println("1. Gestión de Estudiantes");
            System.out.println("2. Gestión de Asignaturas");
            System.out.println("3. Gestión de Notas");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    menuEstudiantes();
                    break;
                case 2:
                    menuAsignaturas();
                    break;
                case 3:
                    menuNotas();
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        }
        while (opcion != 4);
    }
    
    public static void menuEstudiantes() {
        int opcion;

        do {
            System.out.println("\n--- GESTIÓN DE ESTUDIANTES ---");
            System.out.println("1. Registrar");
            System.out.println("2. Listar");
            System.out.println("3. Buscar");
            System.out.println("4. Actualizar");
            System.out.println("5. Eliminar");
            System.out.println("6. Volver");

            opcion = sc.nextInt();

            switch (opcion) {
                case 1: registrarEstudiante(); break;
                case 2: listarEstudiantes(); break;
                case 3: buscarEstudiante(); break;
                case 4: actualizarEstudiante(); break;
                case 5: eliminarEstudiante(); break;
            }

        } while (opcion != 6);
    }
    
    public static void registrarEstudiante() {

        sc.nextLine(); // limpiar buffer

        System.out.println("\n--- REGISTRAR ESTUDIANTE ---");

        System.out.print("Código: ");
        String codigo = sc.nextLine();

        // Verificar si ya existe
        for (Estudiante e : listaEstudiantes) {
            if (e.getCodigo().equalsIgnoreCase(codigo)) {
                System.out.println("Ya existe un estudiante con ese código.");
                return;
            }
        }

        System.out.print("Nombre: ");
        String nombre = sc.nextLine();

        System.out.print("Apellido: ");
        String apellido = sc.nextLine();

        System.out.print("Edad: ");
        int edad = sc.nextInt();

        System.out.print("Semestre: ");
        int semestre = sc.nextInt();

        Estudiante nuevo = new Estudiante(codigo, nombre, apellido, edad, semestre);
        listaEstudiantes.add(nuevo);

        System.out.println("Estudiante registrado correctamente.");
    }
    
    public static void listarEstudiantes() {

        System.out.println("\n--- LISTA DE ESTUDIANTES ---");

        if (listaEstudiantes.isEmpty()) {
            System.out.println("No hay estudiantes registrados.");
            return;
        }

        for (Estudiante e : listaEstudiantes) {
            System.out.println("----------------------------");
            System.out.println(e);
        }
    }
    
    public static void buscarEstudiante() {

        sc.nextLine(); // limpiar buffer

        System.out.println("\n--- BUSCAR ESTUDIANTE ---");
        System.out.print("Ingrese el código: ");
        String codigo = sc.nextLine();

        for (Estudiante e : listaEstudiantes) {
            if (e.getCodigo().equalsIgnoreCase(codigo)) {
                System.out.println("Estudiante encontrado:");
                System.out.println("----------------------------");
                System.out.println(e);
                return;
            }
        }
        System.out.println("No se encontró un estudiante con ese código.");
    }
    
    public static void actualizarEstudiante() {

        sc.nextLine(); // limpiar buffer

        System.out.println("\n--- ACTUALIZAR ESTUDIANTE ---");
        System.out.print("Ingrese el código del estudiante: ");
        String codigo = sc.nextLine();

        for (Estudiante e : listaEstudiantes) {

            if (e.getCodigo().equalsIgnoreCase(codigo)) {

                System.out.println("Estudiante encontrado. Ingrese los nuevos datos:");

                System.out.print("Nuevo nombre: ");
                String nuevoNombre = sc.nextLine();
                e.setNombre(nuevoNombre);

                System.out.print("Nuevo apellido: ");
                String nuevoApellido = sc.nextLine();
                e.setApellido(nuevoApellido);

                System.out.print("Nueva edad: ");
                int nuevaEdad = sc.nextInt();
                e.setEdad(nuevaEdad);

                System.out.print("Nuevo semestre: ");
                int nuevoSemestre = sc.nextInt();
                e.setSemestre(nuevoSemestre);

                System.out.println("Estudiante actualizado correctamente.");
                return;
            }
        }

        System.out.println("No se encontró un estudiante con ese código.");
    }
    
    public static void eliminarEstudiante() {

        sc.nextLine(); // limpiar buffer

        System.out.println("\n--- ELIMINAR ESTUDIANTE ---");
        System.out.print("Ingrese el código del estudiante: ");
        String codigo = sc.nextLine();

        for (int i = 0; i < listaEstudiantes.size(); i++) {

            if (listaEstudiantes.get(i).getCodigo().equalsIgnoreCase(codigo)) {

                listaEstudiantes.remove(i);
                System.out.println("Estudiante eliminado correctamente.");
                return;
            }
        }

        System.out.println("No se encontró un estudiante con ese código.");
    }
    
    public static void menuAsignaturas() {
        
    }
    
    public static void menuNotas() {
        
    }
}
