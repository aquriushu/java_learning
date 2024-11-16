package design_pattern.observer_pattern;

public class TestClient {

    public static void main(String[] args) {
        ConcreteSubject subject = new ConcreteSubject();

        subject.addObserver(new ConcreteObserver1("具体观察者1"));
        subject.addObserver(new ConcreteObserver1("具体观察者2"));

        subject.doSomething();
    }

}
