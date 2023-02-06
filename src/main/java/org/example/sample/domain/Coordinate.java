package org.example.sample.domain;

import java.util.Objects;

public class Coordinate {
    private final double distance;
    private final double temperature;

    public Coordinate(final double distance, final double temperature) {
        this.distance = distance;
        this.temperature = temperature;
    }

    public double getDistance() {
        return distance;
    }

    public double getTemperature() {
        return temperature;
    }

    @Override
    public String toString() {
        return "Coordinates{" +
                "distance=" + distance +
                "m, temperature=" + temperature + "}\n";
    };

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinate that = (Coordinate) o;
        return Double.compare(that.distance, distance) == 0 && Double.compare(that.temperature, temperature) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(distance, temperature);
    }
}
