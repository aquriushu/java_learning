package design_pattern.observer_pattern;

import java.util.Vector;

/**
 * 目标
 */
public abstract class Subject {

    private Vector<Observer> observers = new Vector<>();

    public void addObserver(Observer observer) {
        this.observers.add(observer);
    }

    public void delObserver(Observer observer) {
        this.observers.remove(observer);
    }

    protected void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }

    protected abstract void doSomething();

}
