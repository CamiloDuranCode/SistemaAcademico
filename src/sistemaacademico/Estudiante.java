/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemaacademico;

/**
 *
 * @author Wilberto
 */
public class Estudiante {    
    
    private String codigo;
    private String nombre;
    private String apellido;
    private int edad;
    private int semestre;
    
    // Constructor
    public Estudiante(String codigo, String nombre, String apellido, int edad, int semestre) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.semestre = semestre;
    }

    // Getters
    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getEdad() {
        return edad;
    }

    public int getSemestre() {
        return semestre;
    }

    // Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }
    
    // toString
    @Override
    public String toString() {
        return "Código: " + codigo +
               "\nNombre: " + nombre +
               "\nApellido: " + apellido +
               "\nEdad: " + edad +
               "\nSemestre: " + semestre;
    }

}
    