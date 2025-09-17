package Main.java.EntidadesBase;

import Main.java.Observer.Observer;
import Main.java.Observer.Subject;

import java.util.ArrayList;
import java.util.List;

public class Curso implements Subject {



    public Long id;
    public String titulo;
    private List<Observer> observadores = new ArrayList<>(); //Para el patrón observer



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

    @Override
    public String toString() {
        return "Curso{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                '}';
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
}
