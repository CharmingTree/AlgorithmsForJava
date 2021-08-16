package DesignPattern.Strategy;

public class FlyRocketPowered implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("Flying in a Rocket");
    }
}
