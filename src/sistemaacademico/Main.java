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
    
}
