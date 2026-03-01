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
    
    static ArrayList<Estudiante> estudiantes = new ArrayList<>();
    static ArrayList<Asignatura> asignaturas = new ArrayList<>();
    static ArrayList<Nota> notas = new ArrayList<>();
    
   public static void registrarNota() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Código del estudiante: ");
        String codEst = sc.nextLine();

        Estudiante est = buscarEstudiantePorCodigo(codEst);
        if (est == null) {
            System.out.println("Estudiante no encontrado");
            return;
        }

        System.out.print("Código de la asignatura: ");
        String codAsig = sc.nextLine();

        Asignatura asig = buscarAsignaturaPorCodigo(codAsig);
        if (asig == null) {
            System.out.println("Asignatura no encontrada");
            return;
        }

        System.out.print("Valor de la nota: ");
        double valor = sc.nextDouble();
        sc.nextLine();

        System.out.print("Periodo: ");
        String periodo = sc.nextLine();

        Nota nota = new Nota(est, asig, valor, periodo);
        notas.add(nota);

        System.out.println("Nota registrada correctamente");
}
   
}
