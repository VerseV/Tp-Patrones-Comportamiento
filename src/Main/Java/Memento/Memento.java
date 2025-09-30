package Main.Java.Memento;

import java.util.List;

public class Memento {
    private final List<String> respuestas;

    public Memento(List<String> respuestas) {
        this.respuestas = respuestas;
    }

    public List<String> getRespuestas() {
        return respuestas;
    }
}
