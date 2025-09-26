package Main.java.State;

import Main.Java.EntidadesBase.Alumno;
import Main.Java.EntidadesBase.Curso;
import Main.java.State.EstadoInscripcion;

public class Inscripcion {
    //Cada inscripción tiene un alumno y un curso!
    private Alumno alumno;
    private Curso curso;
    private EstadoInscripcion estado; //Guardamos el estado actual

//Constructor de la clase Inscripción
    public Inscripcion(){
        estado = new EnEspera(); //Asignamos a la variable estado, el estado inicial de la inscripción
    }
 //Setteamos(para poder MODIFICARLO) el estado, y el que tiene el metodo de cambiar estado es EstadoInscripcion
    // que lo declaramos como atributo de esta clase, entonces el valor que vamos a modificar en el main es estadoI que lo seteamos a estado

    public void setEstado(EstadoInscripcion estadoI){
        this.estado = estadoI;
    }

}