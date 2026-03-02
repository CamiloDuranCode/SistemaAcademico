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
    static ArrayList<Estudiante> estudiantes = new ArrayList<>();
    static ArrayList<Nota> notas = new ArrayList<>();
    
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
    
    public static void registrarNota() {
        
        System.out.println("\n    REGISTRO DE NOTAS    ");

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
   
    public static void listarNotas() {
       
       System.out.println("\n    LISTA DE NOTAS    ");
       
        if (notas.isEmpty()) {
            System.out.println("No hay notas registradas");
            return;
        }

        for (Nota n : notas) {
            System.out.println("-------------------------");
            System.out.println(n);
        }
    }
   
    public static void buscarNota() {
       
        System.out.println("\n    BUSCAR NOTA    ");
       

        System.out.print("Código del estudiante: ");
        String codEst = sc.nextLine();

        for (Nota n : notas) {
            if (n.getEstudiante().getCodigo().equals(codEst)) {
                System.out.println(n);
                return;
            }
        }

        System.out.println("Nota no encontrada");
    }
   
    public static void actualizarNota() {
       
        System.out.println("\n    ACTUALIZAR NOTA    ");

        System.out.print("Código del estudiante: ");
        String codEst = sc.nextLine();

        for (Nota n : notas) {
            if (n.getEstudiante().getCodigo().equals(codEst)) {

                System.out.print("Nuevo valor de la nota: ");
                double nuevoValor = sc.nextDouble();
                sc.nextLine();

                System.out.print("Nuevo periodo: ");
                String nuevoPeriodo = sc.nextLine();

                n.setValor(nuevoValor);
                n.setPeriodo(nuevoPeriodo);

                System.out.println("Nota actualizada");
                return;
            }
        }

        System.out.println("Nota no encontrada");
    }
   
    public static void eliminarNota() {
       
        System.out.println("\n    ELIMINAR NOTA    ");

        System.out.print("Código del estudiante: ");
        String codEst = sc.nextLine();

        for (int i = 0; i < notas.size(); i++) {
            if (notas.get(i).getEstudiante().getCodigo().equals(codEst)) {
                notas.remove(i);
                System.out.println("Nota eliminada");
                return;
            }
        }

        System.out.println("Nota no encontrada");
    }
   
    public static Estudiante buscarEstudiantePorCodigo(String codigo) {
    for (Estudiante e : estudiantes) {
        if (e.getCodigo().equalsIgnoreCase(codigo)) {
            return e;
        }
    }
    return null;
}
    public static Asignatura buscarAsignaturaPorCodigo(String codigo) {
    for (Asignatura a : asignaturas) {
        if (a.getCodigo().equalsIgnoreCase(codigo)) {
            return a;
        }
    }
    return null;
}

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
        for (Estudiante e : estudiantes) {
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
        estudiantes.add(nuevo);

        System.out.println("Estudiante registrado correctamente.");
    }
    
    public static void listarEstudiantes() {

        System.out.println("\n--- LISTA DE ESTUDIANTES ---");

        if (estudiantes.isEmpty()) {
            System.out.println("No hay estudiantes registrados.");
            return;
        }

        for (Estudiante e : estudiantes) {
            System.out.println("----------------------------");
            System.out.println(e);
        }
    }
    
    public static void buscarEstudiante() {

        sc.nextLine(); // limpiar buffer

        System.out.println("\n--- BUSCAR ESTUDIANTE ---");
        System.out.print("Ingrese el código: ");
        String codigo = sc.nextLine();

        for (Estudiante e : estudiantes) {
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

        for (Estudiante e : estudiantes) {

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

        for (int i = 0; i < estudiantes.size(); i++) {

            if (estudiantes.get(i).getCodigo().equalsIgnoreCase(codigo)) {

                estudiantes.remove(i);
                System.out.println("Estudiante eliminado correctamente.");
                return;
            }
        }

        System.out.println("No se encontró un estudiante con ese código.");
    }
    
    public static void menuAsignaturas() {
        int opcion;

        do {
            System.out.println("\n--- GESTIÓN DE ASIGNATURAS ---");
            System.out.println("1. Registrar");
            System.out.println("2. Listar");
            System.out.println("3. Buscar");
            System.out.println("4. Actualizar");
            System.out.println("5. Eliminar");
            System.out.println("6. Volver");

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1: registrarAsignatura(); break;
                case 2: listarAsignaturas(); break;
                case 3: buscarAsignatura(); break;
                case 4: actualizarAsignatura(); break;
                case 5: eliminarAsignatura(); break;
            }

        } while (opcion != 6);
    }
    
    public static void menuNotas() {
        int opcion;

        do {
            System.out.println("\n--- GESTIÓN DE NOTAS ---");
            System.out.println("1. Registrar");
            System.out.println("2. Listar");
            System.out.println("3. Buscar");
            System.out.println("4. Actualizar");
            System.out.println("5. Eliminar");
            System.out.println("6. Volver");

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1: registrarNota(); break;
                case 2: listarNotas(); break;
                case 3: buscarNota(); break;
                case 4: actualizarNota(); break;
                case 5: eliminarNota(); break;
            }

        } while (opcion != 6);
    }
}