package org.example.sample.domain;

public class Component {
    private final String name;
    private final double temperature;

    public Component(final String name,
                     final double temperature) {
        this.name = name;
        this.temperature = temperature;
    }

    public String getName() {
        return name;
    }

    public double getTemperature() {
        return temperature;
    }
}
