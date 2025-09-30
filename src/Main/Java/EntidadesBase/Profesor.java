package Main.Java.EntidadesBase;

import Main.Java.Mediator.ChatMediator;

public class Profesor extends Usuario {

    private ChatMediator chatMediator;

    public void setChatMediator(ChatMediator chatMediator) {
        this.chatMediator = chatMediator;
    }

    public void enviarMensaje(String msg) {
        if (chatMediator != null) {
            chatMediator.enviar(msg, this);
        }
    }

    public void recibirMensaje(String msg, Usuario from) {
        System.out.println(nombre + " (Profesor) recibio mensaje de " + from.getNombre() + ": " + msg);
    }

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
