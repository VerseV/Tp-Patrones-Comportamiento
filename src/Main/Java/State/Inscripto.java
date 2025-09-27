package Main.java.State;

public class Inscripto implements EstadoInscripcion{

    @Override
    public void cambiarEstado(Inscripcion inscripcion) {
        System.out.println("Se confirmo la inscripción, finalizo el cambio de estado");
    }

    @Override
    public String getNombre() {
        return "Inscripto";
    }
}
