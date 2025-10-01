package Main.Java.State;

public class Cancelado implements EstadoInscripcion{
    @Override
    public void cambiarEstado(Inscripcion inscripcion) {
        System.out.println("Se cancelo la inscripción, finalizo el cambio de estado");
    }

    @Override
    public String getNombre() {
        return "Cancelado";
    }
}
