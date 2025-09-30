package Main.Java.Memento;

import java.util.ArrayList;
import java.util.List;

public class Examen {

    private List<String> respuestas = new ArrayList<>();

    public void responder(String respuesta) {
        respuestas.add(respuesta);
    }

    public List<String> getRespuestas() {
        return respuestas;
    }

    // Crear un memento con el estado actual
    public Memento save() {
        return new Memento(new ArrayList<>(respuestas));
    }

    // Restaurar estado desde un memento
    public void restore(Memento m) {
        this.respuestas = new ArrayList<>(m.getRespuestas());
    }

    public void mostrarRespuestas() {
        System.out.println("Respuestas actuales: " + respuestas);
    }
}
