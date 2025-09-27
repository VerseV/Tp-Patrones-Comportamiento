package Main.java.State;

import Main.Java.EntidadesBase.Alumno;
import Main.Java.EntidadesBase.Curso;
import Main.java.State.EstadoInscripcion;

public class Inscripcion {
    //Cada inscripción tiene un alumno y un curso!
    private Alumno alumno;
    private Curso curso;
    private EstadoInscripcion estado; //Guardamos el estado actual

//Constructor de la clase Inscripción, recordemos que debemos referenciar los atributos de la clase q vamos a crear para poder asignarle valores en el main
    public Inscripcion(Alumno alumnoP, Curso cursoP){
        this.alumno = alumnoP;
        this.curso = cursoP;
        estado = new EnEspera();
        //Alumno y Curso vienen de otro paquete, se los pasamos desde afuera
        //Asignamos a la variable estado, el estado inicial de la inscripción
        //Estado no viene de afuera, se define en esta clase para tener un punto de inicio
    }

 //Setteamos(para poder MODIFICARLO) el estado, y el que tiene el metodo de cambiar estado es EstadoInscripcion
    // que lo declaramos como atributo de esta clase, entonces el valor que vamos a modificar en el main es estadoI que lo seteamos a estado

    public void setEstado(EstadoInscripcion estadoI){
        this.estado = estadoI;
    }
//le da la logica al estado actual
    public void cambiarEstado(){
        estado.cambiarEstado(this);
    }

    public Curso getCurso() {
        return curso;
    }

    //Para ver el alumno, con su curso y estado hay que imprimir
    public void mostrarEstado(){
        System.out.println("Alumno: " + alumno.getLegajo() + " - Curso: " + curso.getTitulo() + " - Estado: " + estado.getNombre());
    }
}