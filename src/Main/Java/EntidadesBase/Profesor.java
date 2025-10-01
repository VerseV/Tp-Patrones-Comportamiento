package Main.Java.EntidadesBase;

import Main.Java.ChainOfResponsability.Handler;
import Main.Java.ChainOfResponsability.Solicitud;
import Main.Java.Mediator.ChatMediator;

public class Profesor extends Usuario implements Handler {

    private ChatMediator chatMediator;
    private Handler next;

    // ==== Métodos del Mediator ====
    public void setChatMediator(ChatMediator chatMediator) {
        this.chatMediator = chatMediator;
    }

    public void enviarMensaje(String msg) {
        if (chatMediator != null) {
            chatMediator.enviar(msg, this);
        }
    }

    public void recibirMensaje(String msg, Usuario from) {
        System.out.println(nombre + " (Profesor) recibió mensaje de " + from.getNombre() + ": " + msg);
    }

    // ==== Métodos de Chain of Responsibility ====
    @Override
    public void setNext(Handler next) {
        this.next = next;
    }

    @Override
    public void handle(Solicitud s) {
        if (s.getNivel() == 2) {
            System.out.println("Profesor gestiona la solicitud: " + s.getMotivo());
        } else if (next != null) {
            next.handle(s);
        }
    }

    // ==== toString ====
    @Override
    public String toString() {
        return "Profesor{" +
                "nombre='" + nombre + '\'' +
                ", apellidos='" + apellido + '\'' +
                ", edad=" + edad +
                ", id=" + id +
                '}';
    }
}

