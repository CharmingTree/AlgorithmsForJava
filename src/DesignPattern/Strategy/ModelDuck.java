package DesignPattern.Strategy;

public class ModelDuck extends Duck {

    public ModelDuck() {
        setQuackBehavior(new Quack());
        setFlyBehavior(new FlyNoWay());
    }

    @Override
    public void display() {
        System.out.println("I am Model Duck");
    }
}
