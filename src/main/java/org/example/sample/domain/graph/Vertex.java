package org.example.sample.domain.graph;

import org.example.sample.domain.Component;

import java.util.Objects;

public class Vertex extends Component {
    public Vertex(final String name, final double temperature) {
        super(name, temperature);
    }

    public String getName() {
        return super.getName();
    }

    public double getTemperature() {
        return super.getTemperature();
    }

    @Override
    public String toString() {
        return "Vertex{" +
                "name='" + this.getName() + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertex vertx = (Vertex) o;
        return Objects.equals(this.getName(), vertx.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getName());
    }
}
