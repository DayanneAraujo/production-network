package org.example.sample.domain;

public class Component {
    private final String name;
    private final double distance;
    private final double temperature;

    public Component(final String name,
                     final double distance,
                     final double temperature) {
        this.name = name;
        this.distance = distance;
        this.temperature = temperature;
    }

    public String getName() {
        return name;
    }

    public double getDistance() {
        return distance;
    }

    public double getTemperature() {
        return temperature;
    }
}
