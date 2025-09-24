package Main.Java.EntidadesBase;

import Main.java.Observer.Observer;

public class Alumno extends Usuario implements Observer {

    public int Legajo;



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
