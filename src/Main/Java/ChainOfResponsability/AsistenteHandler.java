package Main.Java.ChainOfResponsability;

public class AsistenteHandler implements Handler {
    private Handler next;

    @Override
    public void setNext(Handler next) {
        this.next = next; }

    @Override
    public void handle(Solicitud s) {
        if (s.getNivel() == 1) {
            System.out.println("Asistente gestiona la solicitud: " + s.getMotivo());
        } else if (next != null) {
            next.handle(s); } }
}
