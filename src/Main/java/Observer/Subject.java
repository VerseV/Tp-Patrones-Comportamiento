package Main.java.Observer;

public interface Subject {

    public void addObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers(String mensaje);
}
