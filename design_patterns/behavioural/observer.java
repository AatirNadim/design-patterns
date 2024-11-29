package design_patterns.behavioural;

import java.util.ArrayList;
import java.util.List;

// Subject interface
interface WeatherStation {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}

// Concrete subject class
class ConcreteWeatherStation implements WeatherStation {
    private List<Observer> observers;
    private double temperature;
    private double humidity;
    private double windSpeed;

    public ConcreteWeatherStation() {
        this.observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(temperature, humidity, windSpeed);
        }
    }

    public void setMeasurements(double temperature, double humidity, double windSpeed) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.windSpeed = windSpeed;
        notifyObservers();
    }
}

// Observer interface
interface Observer {
    void update(double temperature, double humidity, double windSpeed);
}

// Concrete observer classes
class CurrentConditionsDisplay implements Observer {
    private double temperature;
    private double humidity;

    @Override
    public void update(double temperature, double humidity, double windSpeed) {
        this.temperature = temperature;
        this.humidity = humidity;
        display();
    }

    public void display() {
        System.out.println("Current conditions: " + temperature + "F degrees and " + humidity + "% humidity");
    }
}

class ForecastDisplay implements Observer {
    private double currentPressure;
    private double lastPressure;

    public ForecastDisplay() {
        lastPressure = 29.92; // Default value
    }

    @Override
    public void update(double temperature, double humidity, double pressure) {
        lastPressure = currentPressure;
        currentPressure = pressure;

        display();
    }

    public void display() {
        System.out.print("Forecast: ");
        if (currentPressure > lastPressure) {
            System.out.println("Watch out for cooler, rainy weather");
        } else if (currentPressure == lastPressure) {
            System.out.println("More of the same");
        } else if (currentPressure < lastPressure) {
            System.out.println("Improving weather on the way!");
        }
    }
}

// Client code
class WeatherStationSimulator {
    public static void main(String[] args) {
        WeatherStation weatherStation = new ConcreteWeatherStation();

        Observer currentConditionsDisplay = new CurrentConditionsDisplay();
        Observer forecastDisplay = new ForecastDisplay();

        weatherStation.registerObserver(currentConditionsDisplay);
        weatherStation.registerObserver(forecastDisplay);

        ((ConcreteWeatherStation) weatherStation).setMeasurements(80, 65, 30.4);
        ((ConcreteWeatherStation) weatherStation).setMeasurements(82, 70, 29.2);
        ((ConcreteWeatherStation) weatherStation).setMeasurements(78, 90, 29.2);
    }
}