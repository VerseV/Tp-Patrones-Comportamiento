package Main.Java.Mediator;

import Main.Java.EntidadesBase.Usuario;
import Main.Java.EntidadesBase.Alumno;
import Main.Java.EntidadesBase.Profesor;

import java.util.ArrayList;
import java.util.List;

public class ChatRoom implements ChatMediator {

    private final List<Usuario> usuarios = new ArrayList<>();

    @Override
    public void enviar(String msg, Usuario u) {
        for (Usuario user : usuarios) {
            if (user != u) {
                if (user instanceof Alumno) {
                    ((Alumno) user).recibirMensaje(msg, u);
                } else if (user instanceof Profesor) {
                    ((Profesor) user).recibirMensaje(msg, u);
                }
            }
        }
    }

    // Método para que alumnos/profesores se registren en la sala
    public void registrarUsuario(Usuario u) {
        usuarios.add(u);
    }
}
