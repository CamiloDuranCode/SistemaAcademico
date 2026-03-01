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
static ArrayList<Asignatura> asignaturas = new ArrayList<>();
static Scanner sc = new Scanner(System.in);
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public static void registrarAsignatura() {

    System.out.println("\n    REGISTRAR ASIGNATURA    ");

    System.out.print("Codigo: ");
    String codigo = sc.nextLine();

    System.out.print("Nombre: ");
    String nombre = sc.nextLine();

    System.out.print("Creditos: ");
    int creditos = sc.nextInt();
    sc.nextLine(); 

    System.out.print("Docente: ");
    String docente = sc.nextLine();

    Asignatura nueva = new Asignatura(codigo, nombre, creditos, docente);

    asignaturas.add(nueva);

    System.out.println("Asignatura registrada correctamente.");
}
    
    
    
    
    
    public static void listarAsignaturas() {

    System.out.println("\n    LISTA DE ASIGNATURAS    ");

    if (asignaturas.isEmpty()) {
        System.out.println("No hay asignaturas registradas.");
        return;
    }

    for (Asignatura a : asignaturas) {
        System.out.println("-------------------------");
        System.out.println(a);
    }
}
    
    
    
    
    public static void buscarAsignatura() {

    System.out.println("\n    BUSCAR ASIGNATURA    ");

    if (asignaturas.isEmpty()) {
        System.out.println("No hay asignaturas registradas.");
        return;
    }

    System.out.print("Ingrese el codigo de la asignatura: ");
    String codigoBuscado = sc.nextLine();

    for (Asignatura a : asignaturas) {
        if (a.getCodigo().equalsIgnoreCase(codigoBuscado)) {
            System.out.println("\nAsignatura encontrada:");
            System.out.println(a);
            return;
        }
    }

    System.out.println("No se encontró una asignatura con ese codigo.");
}
    
    
    
    public static void actualizarAsignatura() {

    System.out.println("\n    ACTUALIZAR ASIGNATURA    ");

    if (asignaturas.isEmpty()) {
        System.out.println("No hay asignaturas registradas.");
        return;
    }

    System.out.print("Ingrese el codigo de la asignatura a actualizar: ");
    String codigoBuscado = sc.nextLine();

    for (Asignatura a : asignaturas) {

        if (a.getCodigo().equalsIgnoreCase(codigoBuscado)) {

            System.out.println("Asignatura encontrada:");
            System.out.println(a);

            System.out.print("Nuevo nombre: ");
            String nuevoNombre = sc.nextLine();

            System.out.print("Nuevos creditos: ");
            int nuevosCreditos = sc.nextInt();
            sc.nextLine();

            System.out.print("Nuevo docente: ");
            String nuevoDocente = sc.nextLine();

            a.setNombre(nuevoNombre);
            a.setCreditos(nuevosCreditos);
            a.setDocente(nuevoDocente);

            System.out.println("Asignatura actualizada correctamente.");
            return;
        }
    }

    System.out.println("No se encontró una asignatura con ese codigo.");
}
    
    
    
    
    public static void eliminarAsignatura() {

    System.out.println("\n    ELIMINAR ASIGNATURA    ");

    if (asignaturas.isEmpty()) {
        System.out.println("No hay asignaturas registradas.");
        return;
    }

    System.out.print("Ingrese el codigo de la asignatura a eliminar: ");
    String codigoBuscado = sc.nextLine();

    for (int i = 0; i < asignaturas.size(); i++) {

        if (asignaturas.get(i).getCodigo().equalsIgnoreCase(codigoBuscado)) {

            System.out.println("Asignatura encontrada:");
            System.out.println(asignaturas.get(i));

            asignaturas.remove(i);

            System.out.println("Asignatura eliminada correctamente.");
            return;
        }
    }

    System.out.println("No se encontró una asignatura con ese codigo.");
}
    
        
}
