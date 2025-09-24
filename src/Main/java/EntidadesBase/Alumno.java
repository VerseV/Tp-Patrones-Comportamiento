package Main.Java.EntidadesBase;

import Main.Java.Observer.Observer;

import java.util.ArrayList;
import java.util.List;

public class Alumno extends Usuario implements Observer {

    public int Legajo;

    // Template Method para el manejo de notas
    private List<Integer> notas = new ArrayList<>();

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

    //GETTERS Y SETTERS
    public int getLegajo() {
        return Legajo;
    }

    public void setLegajo(int Legajo) {
        this.Legajo = Legajo;
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
