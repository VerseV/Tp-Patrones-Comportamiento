package Main.Java.State;

public interface EstadoInscripcion {
    void cambiarEstado(Inscripcion inscripcion); //Tenemos una inscripción que puede estar en Inscripto, EnEspera o Cancelado
    //Cuando se llame a cambiarEstado, el metodo recibe la inscripción para cambiar su atributo estado
    String getNombre();
}
