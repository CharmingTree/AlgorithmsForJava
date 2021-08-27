package DesignPattern.ObserverWithJava;

public class WeatherSimular {

    public static void main(String[] args) {

        WeatherData provider = new WeatherData();

        CurrentConditionDisplay observer = new CurrentConditionDisplay(provider);

        provider.setMeasurements(0.1f, 2.4f, 3.1f);
    }
}
