package Main.Java.EntidadesBase;

import Main.Java.Observer.Observer;
import Main.Java.Observer.Subject;

import java.util.ArrayList;
import java.util.List;

public class Curso implements Subject {



    public Long id;
    public String titulo;
    private List<Observer> observadores = new ArrayList<>(); //Para el patrón observer
    private int cupoMaximo; // para evaluar si se Inscribe o se Cancela

    //GETTERS Y SETTERS
    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getCupoMaximo() {
        return cupoMaximo;
    }

    public void setCupoMaximo(int cupoMaximo) {
        this.cupoMaximo = cupoMaximo;
    }

    @Override
    public String toString() {
        return "Curso{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' + ", Cupo Maximo= " + cupoMaximo + ", inscriptos= " + alumnos.size() +
                '}';
    }

    // TEMPLATE METHOD
    private List<Alumno> alumnos = new ArrayList<>();

    // MÉTODOS PARA MANEJAR ALUMNOS
    public void agregarAlumno(Alumno a) {
        alumnos.add(a);
    }

    public List<Alumno> getAlumnos() {
        return alumnos;
    }

    public double getPromedioCurso() {
        if (alumnos.isEmpty()) return 0.0;
        return alumnos.stream().mapToDouble(Alumno::getPromedio).average().orElse(0.0);
    }


    //MÉTODOS PARA EL PATRÓN OBSERVER
    @Override
    public void addObserver(Observer o) {
        observadores.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observadores.remove(o);
    }

    @Override
    public void notifyObservers(String mensaje) {
        for (Observer o : observadores) {
            o.update(mensaje);
        }
    }

    public void cambiarHorario(String nuevoHorario) {
        notifyObservers(" Nuevo horario: " + nuevoHorario);
    }

    //Evaluamos cupo del Curso
    public boolean tieneCupo() {
        return alumnos.size() < cupoMaximo;
    }
}
