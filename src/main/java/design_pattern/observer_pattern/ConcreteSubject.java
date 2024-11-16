package design_pattern.observer_pattern;

/**
 * 具体目标
 */
public class ConcreteSubject extends Subject{

    @Override
    protected void doSomething() {
        System.out.println("被观察者发生改变");
        super.notifyObservers();
    }

}
