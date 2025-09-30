package Main.Java.EntidadesBase;

import Main.Java.Observer.Observer;
import Main.java.Strategy.CalculoNota;
import Main.Java.Iterator.CursoIterator;
import Main.Java.Iterator.AlumnoCursoIterator;
import Main.Java.Mediator.ChatMediator;
import Main.Java.Visitor.Visitor;


import java.util.ArrayList;
import java.util.List;

public class Alumno extends Usuario implements Observer {

    public int Legajo;

    private CalculoNota estrategia; //Atributo para el patron Strategy

    // Template Method para el manejo de notas
    private List<Integer> notas = new ArrayList<>(); //Lo utiliza Strategy tambien

    // Para Iterator
    private List<Curso> cursosInscritos = new ArrayList<>();

    // Para Mediator
    private ChatMediator chatMediator;

    public void agregarNota(int nota) {
        notas.add(nota);
    }

    public List<Integer> getNotas() {
        return notas;
    }

    public double getPromedio() {
        if (notas.isEmpty()) return 0.0;
        return notas.stream().mapToInt(Integer::intValue).average().orElse(0.0);
    }

    // Iterator: cursos
    public void inscribirCurso(Curso c) {
        cursosInscritos.add(c);
    }

    public List<Curso> getCursosInscritos() {
        return cursosInscritos;
    }

    public CursoIterator iterator() {
        return new AlumnoCursoIterator(cursosInscritos);
    }

    // Mediator: asignar chat
    public void setChatMediator(ChatMediator chatMediator) {
        this.chatMediator = chatMediator;
    }

    // Mediator: enviar mensaje via mediator
    public void enviarMensaje(String msg) {
        if (this.chatMediator != null) {
            this.chatMediator.enviar(msg, this);
        }
    }

    // Mediator: recibir mensaje (el mediador llamará a este método)
    public void recibirMensaje(String msg, Usuario from) {
        System.out.println(nombre + " recibio mensaje de " + from.getNombre() + ": " + msg);
    }

    //GETTERS Y SETTERS
    public int getLegajo() {
        return Legajo;
    }

    public void setLegajo(int Legajo) {
        this.Legajo = Legajo;
    }

    //Strategy para cambiar de tipo de calculo en ejecución
    public void setEstrategia(CalculoNota estrategia) {
        this.estrategia = estrategia;
    }

    //DELEGO EL CALCULO A LA ESTRATEGIA
    public double calcularNotaFinal(){
        if (estrategia == null) return getPromedio();
        return estrategia.calcular(notas);
    }
    public void aceptar(Visitor v) {
        // Por defecto no hace nada, será sobrescrito en AlumnoRegular y AlumnoBecado
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "Legajo=" + Legajo +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellido + '\'' +
                ", edad=" + edad +
                ", id=" + id +
                '}';
    }

    @Override
    public void update(String msg) {
        System.out.println(nombre + " recibio notificacion: " + msg);
    }
}
