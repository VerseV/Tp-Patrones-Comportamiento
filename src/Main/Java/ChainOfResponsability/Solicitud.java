package Main.java.ChainOfResponsability;

public class Solicitud {
    private String motivo;
    private int nivel; // 1 = Asistente, 2 = Profesor, 3 = Coordinador

    public Solicitud(String motivo, int nivel) {
        this.motivo = motivo;
        this.nivel = nivel;}

    public String getMotivo() {
        return motivo;}

    public int getNivel() {
        return nivel; }
}
