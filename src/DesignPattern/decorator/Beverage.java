package DesignPattern.decorator;

public abstract class Beverage {
    String description = "제목 없음";

    public String getDescription() {
        return this.description;
    }

    public abstract double cost();
}
