package DesignPattern.Strategy;

public class MallardDuck extends Duck {

    public MallardDuck() {
        setQuackBehavior(new Quack());
        setFlyBehavior(new FlyWithWings());
    }

    public void display() {
        System.out.println("I'm MallardDuck");
    }
}
