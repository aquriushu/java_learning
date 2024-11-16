package design_pattern.observer_pattern;

/**
 * 具体观察者
 */
public class ConcreteObserver1 implements Observer {

    private String observerName;

    public ConcreteObserver1(String observerName) {
        this.observerName = observerName;
    }

    @Override
    public void update() {
        System.out.println(observerName + " 监听到被观察者变化，做了数据修改...");
    }

}
