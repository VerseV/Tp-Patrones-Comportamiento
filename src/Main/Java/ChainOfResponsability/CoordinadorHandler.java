package Main.Java.ChainOfResponsability;

public class CoordinadorHandler implements Handler {

    private Handler next;

    @Override
    public void setNext(Handler next) {
        this.next = next;
    }

    @Override
    public void handle(Solicitud s) {
        if (s.getNivel() == 3) {
            System.out.println("Coordinador gestiona la solicitud: " + s.getMotivo());
        } else if (next != null) {
            next.handle(s);
        } else {
            System.out.println("Solicitud no pudo ser gestionada.");
        }
    }
}

