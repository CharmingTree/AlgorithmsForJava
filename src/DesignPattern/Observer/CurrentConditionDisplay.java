package DesignPattern.Observer;

public class CurrentConditionDisplay implements Observer, DisplayElement {

    private float temperture;
    private float humidity;
    private Subject weatherData;

    public CurrentConditionDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void update(float temperature, float humidity, float pressure) {
        this.temperture = temperature;
        this.humidity = humidity;
        display();
    }

    @Override
    public void display() {
        System.out.println("Current conditions : "  + temperture + "F degrees and " + humidity + "% humidity");
    }


}
