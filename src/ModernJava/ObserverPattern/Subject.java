package ModernJava.ObserverPattern;

public interface Subject {
    void registerObserver(Observer o);
    void notifyObservers(String tweet);
}
