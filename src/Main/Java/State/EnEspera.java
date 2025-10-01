package Main.Java.State;

public class EnEspera implements EstadoInscripcion{
    @Override
// --- CAMBIAMOS ESTADO EnEspera A OTRO ESTADO ---

    //Como el nombre lo dice, estamos llamando al metodo setEstado para cambiarEstado de Inscripcion
    public void cambiarEstado(Inscripcion inscripcion) { //Inscripcion inscripcion --> Inscripcion indica que el metodo espera recibir un OBJETO de la clase Inscripcion y inscripcion es solo el nombre del parametro(variable local), representa referencia al objeto Inscripcion que pasan al llamar
        if (inscripcion.getCurso().tieneCupo()){
            inscripcion.setEstado(new Inscripto());//cuando setteamos le traemos entre parentesis lo que quiere modificar, en este caso modifico el estado con uno nuevo -->
            System.out.println("La inscripción pasó de EnEspera a Inscripto.");
        }else{
            inscripcion.setEstado(new Cancelado());
            System.out.println("La inscripción pasó de EnEspera a Cancelado.");
        }

    }

    @Override
    public String getNombre() {
        return "En Espera";
    }
}
